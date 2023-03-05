<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		var actionForm = $("#actionForm");
		$(".paginate_button a").on("click", function(e) {
			
		e.preventDefault();
		
		console.log('click');
		
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
		});
		
	});
</script>
<style type="text/css">

.container {width:98%;}

table {width:100%;}
</style>
<title>Insert title here</title>
</head>
<body>
<form id="actionForm" action="${contextPath}/productList" method="get">
	<div class="container">
  <h2>Bordered Table</h2>
  <table class="table table-bordered">
    <thead>
      <tr>
				<td>판매등록번호</td>
				<td>모델명</td>
				<td>판매희망가</td>
				<td>사이즈</td>
				<td>수량</td>
				<td>제품상태</td>
				<td>회원ID</td>
				<td>경매유효기간</td>
				<td>경매시작날짜</td>
				<td>경매종료날짜</td>
			</tr>
    </thead>
    <tbody>
      <c:forEach var="list" items="${list}">
				<tr>
					<td><a href="${contextPath}/productDetail?sellNo=${list.sellNo}
																&pageNum=${pageMaker.cri.pageNum}
																&amount=${pageMaker.cri.amount}">${list.sellNo}</a></td>
					<td>${list.goods}</td>
					<td>${list.desiredSellPrice}</td>
					<td>${list.itemSize}</td>
					<td>${list.quantity}</td>
					<td>${list.goodsGrade}</td>
					<td>${list.id}</td>
					<td>${list.vailDate}</td>
					<td>${list.startTime}</td>
					<td>${list.endTime}</td>
				</tr>
			</c:forEach>
    </tbody>
  </table>
</div>
	<div class='pull-right'>
		<ul class="pagination">
			
			<c:if test="${pageMaker.prev}">
				<li class="paginate_button a"><a href="${pageMaker.startPage -1}">Previous</a>
				</li>
			</c:if>
				
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active':''} ">
					<a href="${num}">${num}</a>
				</li>
			</c:forEach>
		
				
			<c:if test="${pageMaker.next}">
				<li class="paginate_button a">
					<a href="${pageMaker.endPage +1}">Next</a>
				</li>
			</c:if>
		</ul>
	</div>
	<!-- end Pagination -->
		<input type="text" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="text" name="amount" value="${pageMaker.cri.amount}">
	</form>
	</body>
</html>











