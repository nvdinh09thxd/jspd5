<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Mua hoa</title>
	</head>
	<body>
		<form method="post">
			<label>ID Hoa:</label> 
			<input type="text" name="idhoa" /><br /><br /> 
			<label>Tên Hoa:</label>
			<input type="text" name="tenhoa" /><br /><br /> 
			<label>Giá bán:</label>
			<input type="text" name="giaban" /><br /><br /> 
			<label>Số lượng:</label>
			<input type="text" name="soluong" /><br /><br /> 
			<input type="submit" value="Mua" />
		</form>
	</body>
</html>