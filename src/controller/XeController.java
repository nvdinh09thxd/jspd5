package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Xe;
import model.dao.XeDAO;

@WebServlet("/XeController")
public class XeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public XeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		XeDAO xeDao = new XeDAO();
		ArrayList<Xe> listXe = xeDao.getListXe();
		request.setAttribute("listXe", listXe);

		RequestDispatcher rd = request.getRequestDispatcher("/Xe/views/xe.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] arXe = request.getParameterValues("loaixe");
//		System.out.println(arXe.length);
//		System.out.println(Arrays.toString(arXe));
		int dem = 0;
		int number = 0;
		for (String objXe : arXe) {
			if (!objXe.equals(""))
				dem++;
			if (!objXe.equals(""))
				number = Integer.valueOf(objXe);
		}
		if (dem != 1) {
			response.sendRedirect(request.getContextPath() + "/Xe/views/xe.jsp?err=1");
			return;
		} else {
			XeDAO xeDao = new XeDAO();
			ArrayList<Xe> listXe = xeDao.getListXe();
			for (Xe objXe : listXe) {
				if (objXe.getSort() == number) {
					objXe.setSort(100);
					System.out.println(objXe.getSort());
				}
			}
			request.setAttribute("listXe", listXe);
			RequestDispatcher rd = request.getRequestDispatcher("/Xe/views/xe.jsp");
			rd.forward(request, response);
		}
		// System.out.println(dem);
		/*
		 * if() { // check is number integer } if(arXe.length>1) {
		 * //response.sendRedirect(request.getContextPath()+"/views/xe.jsp?err=1");
		 * System.out.println("Nhap lon hon 2"); return; }
		 * 
		 * }
		 */
	}
}
