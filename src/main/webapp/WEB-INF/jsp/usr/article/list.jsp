<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>LIST</title>
</head>
<body>
	<h1>Article List</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>��ȣ</th>
				<th>����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articles}" >
				<tr>
					<th>${article.id }</th>
					<th>${article.title }</th>
					<th>${article.memberId }</th>
					<th>${article.updateDate }</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</body>
</html>
