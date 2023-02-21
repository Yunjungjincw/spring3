<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${articleList}" var="list"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>resultView.jsp 페이지다</h3>
	*전체 게시물 수 : ${totalCnt}<br>
	*전체 게시물 : ${list}
	<c:choose >
	<c:when test="${empty articleList}" >
		<table border="1">
			<tr>
				<td>게시물이 없습니다. 게시물을 등록해주세요.</td>
			</tr>
		</table>
	</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<td>글 번호</td>
					<td>제목</td>
					<td>내용</td>
					<td>글 작성일</td>
					<td>작성자</td>
				</tr>
			<c:forEach items="${articleList}" var="list">
				<tr>
					<td>${list.articleNo}</td>
					<td><a href="<%=request.getContextPath()%>/article/content?articleNo=${list.articleNo}">${list.title}</a></td>
					<td>${list.content}</td>
					<td>${list.writeDate}</td>
					<td>${list.writerid}</td>
				</tr>
			</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
		
</body>
</html>