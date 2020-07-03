<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mua hoa</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/muahoa2" method="post">
		<label>ID Hoa:</label><input type="text" name="idhoa" /><br />
		<br /> <label>Tên Hoa:</label><input type="text" name="tenhoa" /><br />
		<br /> <label>Giá bán:</label><input type="text" name="giaban" /><br />
		<br /> <label>Số lượng:</label><input type="text" name="soluong" /><br />
		<br /> <input type="submit" value="Mua" />
	</form>
	<a href="<%=request.getContextPath() %>/muahoa2?load=0" title="">Danh sách các hoa</a><br />
	<a href="<%=request.getContextPath() %>/muahoa2?load=1" title="">Danh sách các hoa có số lượng > 10</a><br />
	<a href="<%=request.getContextPath() %>/muahoa2?load=2" title="">Danh sách các hoa có giá < 10000</a>

</body>
</html>