<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
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
		List<Hoa> listHoa = (List<Hoa>) session.getAttribute("listHoa");
		if (listHoa.size()>0) {
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
			int tongTien = 0;
				for (Hoa itemHoa : listHoa) {
					tongTien += itemHoa.getGiaBan() * itemHoa.getSoLuong();
		%>
		<tr>
			<td><%=itemHoa.getId()%></td>
			<td><%=itemHoa.getTenHoa()%></td>
			<td><%=itemHoa.getGiaBan()%></td>
			<td><%=itemHoa.getSoLuong()%></td>
			<td><%=itemHoa.getGiaBan() * itemHoa.getSoLuong()%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="4">Tổng tiền</td>
			<td><%=tongTien%></td>
		</tr>

	</table>
	<a href="<%=request.getContextPath() %>/ShowMuaHoa2Controller" title="">Mua hoa</a>
	<%
		} else {
	%>
	<p>Danh sách trống</p>
	<a href="<%=request.getContextPath() %>/ShowMuaHoa2Controller" title="">Mua hoa</a>
	<%
		}
	%>
</body>
</html>