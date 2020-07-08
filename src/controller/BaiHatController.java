package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.BaiHat;

@WebServlet("/BaiHatController")
@MultipartConfig
public class BaiHatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "uploads";
	private static final ArrayList<BaiHat> arSongs = new ArrayList<>();

	public BaiHatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/baitaplop/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		request.setAttribute("id", idStr);
		request.setAttribute("name", name);
		if ("".equals(idStr) || "".equals(name)) {
			request.getRequestDispatcher("/baitaplop/add.jsp?err=0").forward(request, response);
			return;
		}
		try {
			int id = Integer.parseInt(idStr);
			for (BaiHat song : arSongs) {
				if (song.getId() == id) {
					request.getRequestDispatcher("/baitaplop/add.jsp?err=3").forward(request, response);
					return;
				}
			}
			Part filePart = request.getPart("picture");
			String fileName = filePart.getSubmittedFileName();
			if("".equals(fileName)) {
				request.getRequestDispatcher("/baitaplop/add.jsp?err=4").forward(request, response);
				return;
			}
			String fileType = filePart.getContentType();
			if (!fileType.startsWith("image")) {
				request.getRequestDispatcher("/baitaplop/add.jsp?err=1").forward(request, response);
				return;
			}
			String contextRoot = request.getServletContext().getRealPath("");
			String dirUpload = contextRoot + DIR_UPLOAD;
			File saveDir = new File(dirUpload);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			String portal = fileName.split("\\.")[0];
			String extra = fileName.split("\\.")[1];
			long timeNow = System.currentTimeMillis();
			fileName = portal + "_" + timeNow + "." + extra;
			String filePath = dirUpload + File.separator + fileName;
			filePart.write(filePath);
			BaiHat bh = new BaiHat(id, name, fileName);
			arSongs.add(bh);
			session.setAttribute("arSongs", arSongs);
			response.sendRedirect(request.getContextPath() + "/baitaplop/index.jsp");
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("/baitaplop/add.jsp?err=2").forward(request, response);
		}
	}

}
