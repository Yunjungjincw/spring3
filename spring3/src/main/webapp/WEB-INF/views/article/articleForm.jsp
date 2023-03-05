<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form1" name="form1" action="${contextPath}/article/insert" method="post" > 
		제목:<input type="text" name="title"><br>
		내용:<input type="text" name="content"><br>
		작성자:<input type="text" name="writerid"><br>
		<input type="submit" value="입력">
	</form>
</body>
</html>