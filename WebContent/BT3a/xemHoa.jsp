<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="BT1.Hoa"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Hiển thị danh sách hoa</title>
	</head>
	<body>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Hoa> listHoa = (ArrayList<Hoa>) session.getAttribute("listHoa");
			if (listHoa!=null && listHoa.size()>0) {
		%>
		<table border="2px">
			<tr>
				<th>ID Hoa</th>
				<th>Tên hoa</th>
				<th>Giá bán</th>
				<th>Số lượng</th>
				<th>Thành tiền</th>
			</tr>
			<%
				float tongTien = 0;
					for (Hoa objHoa : listHoa) {
						tongTien += objHoa.getGiaBan() * objHoa.getSoLuong();
			%>
			<tr>
				<td><%=objHoa.getId()%></td>
				<td><%=objHoa.getTenHoa()%></td>
				<td><%=objHoa.getGiaBan()%></td>
				<td><%=objHoa.getSoLuong()%></td>
				<td><%=objHoa.getGiaBan() * objHoa.getSoLuong()%></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="4">Tổng tiền</td>
				<td><%=tongTien%></td>
			</tr>
	
		</table>
		<%
			} else {
		%>
		<p>Danh sách trống</p>
		<%
			}
		%>
	</body>
</html>