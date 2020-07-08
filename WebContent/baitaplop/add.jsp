<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Trang tin VinaEnter Edu</title>
		<meta charset="utf-8" />
		<link href="<%=request.getContextPath() %>/baitaplop/reset.css" type="text/css" rel="stylesheet" />
		<link href="<%=request.getContextPath() %>/baitaplop/style.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
	<%
		String err = request.getParameter("err");
	%>
		<form action="<%=request.getContextPath() %>/BaiHatController" method="post" enctype="multipart/form-data">
			<table>
			  <tbody>
				<tr>
				  <td width="30%"><strong>ID: </strong></td>
				  <td><input type="text" name="id" value="${id}" /></td>
				</tr>
				<tr>
				  <td width="30%"><strong>Tên: </strong></td>
				  <td><input type="text" name="name" value="${name}" /></td>
				</tr>
				<tr>
				  <td width="30%"><strong>Hình ảnh: </strong></td>
				  <td><input type="file" name="picture" /></td>
				</tr>
				<tr>
				<%
					if("1".equals(err)) out.print("<td width='30%' style='color: red'>File bạn chọn không phải là file ảnh!</td>"); 
					else if("2".equals(err)) out.print("<td width='30%' style='color: red'>Nhập sai định dạng số!</td>");
					else if("3".equals(err)) out.print("<td width='30%' style='color: red'>ID bài hát đã tồn tại!</td>");
					else if("0".equals(err)) out.print("<td width='30%' style='color: red'>Vui lòng nhập dữ liệu đầy đủ vào!</td>");
					else if("4".equals(err)) out.print("<td width='30%' style='color: red'>Vui lòng chọn hình ảnh!</td>");
					else out.print("<td width='30%'>&nbsp;</td>");
				%>
				  <td><input type="submit" name="submit" value="Thêm dữ liệu" /></td>
				</tr>
			  </tbody>
			</table>
		</form>
	</body>
</html>