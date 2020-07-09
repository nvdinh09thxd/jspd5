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
				<td width='30%' style="color: red">&nbsp;${err}</td>
				  <td><input type="submit" name="submit" value="Thêm dữ liệu" /></td>
				</tr>
			  </tbody>
			</table>
		</form>
	</body>
</html>