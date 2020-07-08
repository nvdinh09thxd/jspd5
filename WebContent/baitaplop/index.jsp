<%@page import="model.bean.BaiHat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Trang tin VinaEnter Edu</title>
<meta charset="utf-8" />
<link href="<%=request.getContextPath()%>/baitaplop/reset.css"
	type="text/css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/baitaplop/style.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Tên</th>
				<th>Hình ảnh</th>
			</tr>
		</thead>
		<tbody>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<BaiHat> listSongs = (ArrayList<BaiHat>) session.getAttribute("arSongs");
				if (listSongs != null && listSongs.size() > 0) {
					for (BaiHat song : listSongs) {
			%>
			<tr>
				<td><strong><%=song.getId()%></strong></td>
				<td><%=song.getName()%></td>
				<td><img src="<%=request.getContextPath() %>/uploads/<%=song.getPicture() %>" alt="" width="140px;" /></td>
			</tr>
			<%
				}
				}
			%>
		</tbody>
	</table>

</body>
</html>