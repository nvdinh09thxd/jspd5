<%@page import="bean.TheSong"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Trang tin VinaEnter Edu</title>
		<meta charset="utf-8" />
		<link href="<%=request.getContextPath()%>/baitaplop/reset.css" type="text/css" rel="stylesheet" />
		<link href="<%=request.getContextPath()%>/baitaplop/style.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<TheSong> arSongs = (ArrayList<TheSong>) session.getAttribute("arSongs");
			if (arSongs != null && arSongs.size() > 0) {
		%>
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
				for (TheSong song : arSongs) {
			%>
				<tr>
					<td><strong><%=song.getId()%></strong></td>
					<td><%=song.getName()%></td>
					<td><img src="<%=request.getContextPath() %>/uploads/<%=song.getPicture() %>" alt="" width="140px;" /></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
				<%
					} else {
				%>
			<p>Không có danh sách bài hát!</p>
				<%} %>
	
	</body>
</html>