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
	<h3> 상세보기 페이지</h3>
		<p>${articleContent.articleNo}
		<p>${articleContent.title}
		<p>${articleContent.content}
		<p>${articleContent.writeDate}
		<p>${articleContent.writerid}
		<hr>
		<a href="${contextPath}/article/delete?num=${articleContent.articleNo}">글 삭제</a>
</body>
</html>