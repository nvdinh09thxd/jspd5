<%@page import="model.bean.Xe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý loại xe</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/Xe/templates/css/bootstrap.min.css">
<script src="<%=request.getContextPath() %>/Xe/templates/js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/Xe/templates/js/bootstrap.min.js"></script>
<style type="text/css">
	table{
		width: 500px !important;
	}
	.wrapper{
		text-align: center;
	    margin: 20px auto;
	    background: khaki;
	    width: 600xp;
	    color: navy;
	    font-weight: bold;
	    font-family: monospace;
	    font-size: 15px;
	}	
	h1{
		padding	-bottom: 20px;
	}
	button{
		width: 100%;
	    color: yellow;
	    font-size: 23px;
	    font-weight: bold;
	    background: teal;
	    border: 7px solid paleturquoise;
	}
</style>
</head>
<body style="background: khaki">
		<div class="wrapper">
			<form action="<%=request.getContextPath() %>/XeController" method="post">
				<h1>Quản lý các loại xe</h1>
				<table class="table table-striped" align="center">
					<thead class="thead-dark fixtb">
						<tr> 
							<th  scope="col">Id</th>
							<th  scope="col">Loại xe</th>
							<th  scope="col">Sort</th>
						</tr>
					</thead>
					<tbody>
					
					<%
					if(request.getAttribute("listXe")!=null){
						ArrayList<Xe> listXe = (ArrayList<Xe>) request.getAttribute("listXe");
						if(listXe.size()>0){
							for(Xe objXe: listXe){
					%>
					<tr> 
						<td><%=objXe.getId() %></td>
						<td><%=objXe.getName() %></td>
						<td>
							<span><%=objXe.getSort() %></span>
							<input type="number" name="loaixe" value=""/>
							<input type="hidden" name="idxe" value="<%=objXe.getId() %>"/>
						</td>
					</tr>
					<%
					}}}
					%>
					
					<tr> 
						<td colspan="3">
							<button type="submit" class="btn btn-default" style="width: 100%">Cập nhật sắp xếp</button>
						</td>
					</tr>
					<tbody>
				</table>
			</form>
		</div>
</body>
</html>