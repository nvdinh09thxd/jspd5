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

import bean.TheSong;

@WebServlet("/add-song")
@MultipartConfig
public class AddSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "uploads";
	private static final ArrayList<TheSong> arSongs = new ArrayList<>();

	public AddSongController() {
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
		if ("".equals(idStr)) {
			request.setAttribute("err", "Vui lòng nhập ID bài hát!");
			request.getRequestDispatcher("/baitaplop/add.jsp").forward(request, response);
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
			if (id <= 0)
				throw new Exception();
		} catch (Exception e) {
			request.setAttribute("err", "ID bài hát phải là một số nguyên dương!");
			request.getRequestDispatcher("/baitaplop/add.jsp").forward(request, response);
			return;
		}
		for (TheSong song : arSongs) {
			if (song.getId() == id) {
				request.setAttribute("err", "ID bài hát đã tồn tại!");
				request.getRequestDispatcher("/baitaplop/add.jsp").forward(request, response);
				return;
			}
		}
		if ("".equals(name)) {
			request.setAttribute("err", "Vui lòng nhập tên bài hát!");
			request.getRequestDispatcher("/baitaplop/add.jsp").forward(request, response);
			return;
		}
		Part filePart = request.getPart("picture");
		String fileName = filePart.getSubmittedFileName();
		if ("".equals(fileName)) {
			request.setAttribute("err", "Vui lòng chọn hình ảnh!");
			request.getRequestDispatcher("/baitaplop/add.jsp").forward(request, response);
			return;
		}
		String fileType = filePart.getContentType();
		if (!fileType.startsWith("image")) {
			request.setAttribute("err", "File bạn chọn không phải là file ảnh!");
			request.getRequestDispatcher("/baitaplop/add.jsp").forward(request, response);
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
		TheSong song = new TheSong(id, name, fileName);
		arSongs.add(song);
		session.setAttribute("arSongs", arSongs);
		response.sendRedirect(request.getContextPath() + "/baitaplop/index.jsp");
	}

}
