package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BT1.Hoa;

public class MuaHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Hoa> listHoa = new ArrayList<>();

	public MuaHoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/BT3a/muaHoa.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("idhoa"));
		String tenHoa = request.getParameter("tenhoa");
		float giaBan = Float.parseFloat(request.getParameter("giaban"));
		int soLuong = Integer.parseInt(request.getParameter("soluong"));

		boolean check = false;
		if (listHoa.size() > 0) {
			for (Hoa itemHoa : listHoa) {
				if (itemHoa.getId() == id) {
					itemHoa.setSoLuong(soLuong + itemHoa.getSoLuong());
					check = true;
				}
			}
		}
		if (!check) {
			Hoa ObjHoa = new Hoa(id, tenHoa, giaBan, soLuong);
			listHoa.add(ObjHoa);
		}

		HttpSession session = request.getSession();
		session.setAttribute("listHoa", listHoa);

		response.sendRedirect(request.getContextPath() + "/BT3a/xemHoa.jsp");
	}

}
