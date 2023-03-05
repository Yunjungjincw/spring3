<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
img {
	width: 50px;
	height: 50px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
let count=1; 
$(document).ready(function(){
//<input type="button" value="파일삭제" id="btnDelFile"/>
  $("#btnDelFile").click(function(){ 
  	
  	if(count==1){ //유지해야하는 파일수보다 적다면
  		alert("반드시 한개는 있어야 합니다.");
  		return;
  	}
  	
  	let tr = $("#files"+count).parents("tr");
  	//id가 "i1"요소의 바로 앞에 위치한 형제(자매)를 삭제되는 것처럼 보인다
   //$(기준요소).remove();
   $(tr).remove();
  	count--; 
  });

//파일 업로드 
  $("#btnAddFile").click(function(){ 
	    count++;
	    
	    if(count==4){ //허용된 첨부파일수(3개)보다 크다면
	    	alert("첨부파일은 최대 3개까지 가능합니다.");
	    	count=3;
	    	return; //함수종료
	    }
	    let tr = "<tr><th>첨부파일</th><td>";
	     	tr+="<input type='file' name='file"+count+"' id='files"+count+"'/></td></tr>";
	    //id가 "i1"요소의 바로 앞에 위치한 형제(자매)붙인다
	    //$(기준요소).before(추가할요소);	
	    $("#i1").before(tr);	
	   });
	  
	 });

</script>
<title>Insert title here</title>
</head>
<body>
	<h3>product Page</h3>
	<img src="<c:url value='/image/test.png'/>">
	<img src="<c:url value='/image/test.png'/>">
	<form id="uploadFrm" action="${contextPath}/productAdd" enctype="multipart/form-data" method="post">
	 <table border="1">
			<input type="text" value="230" name="itemSize" id="itemSize"/><br>
			<input type="text" value="1" name="goods" id="goods"/><br>
			<input type="text" value="1" name="goodsGrade" id="goodsGrade"/><br>
			<input type="text" value="${sessionScope.AUTHUSER_ID}" name="id" id="id"/>
	 	<tr>
 		  <th>수량</th>
		 	<td><input type="number" id="quantity" name="quantity" placeholder="수량"/></td>
	  </tr> 
		<tr>
			<th>가격</th>
 		  <td><input type="text" id="desiredSellPrice" name="desiredSellPrice" pattern="[0-9]+" title="숫자만 입력해주세요." placeholder="숫자만 입력해주세요."></td>
		</tr> 
		<tr>
			<th>상품 등록 기간:</th>
		  <td>
        <select id="vailDate" name="vailDate" required>
		       <option value="none">--선택--</option>
		       <option value="3">3 days</option>
		       <option value="5">5 days</option>
		     </select>
 			</td>
		</tr>
		<tr>
     <th>파일첨부</th>
     <td>
       <input type="button" value="파일추가" id="btnAddFile"/>
   		<input type="button" value="파일삭제" id="btnDelFile"/>
     </td>
    </tr>
	  <tr>
      <th>첨부파일</th>
      <td><input type="file" name="file1" id="files1"/></td>
	  </tr>
	   <tr id="i1">
	 		 <td colspan="2" style="text-align:center;">
		 		 <input type="submit" value="첨부파일upload하기"/>
		 		 <input type="reset" id="btnReset" value="취소"/>
		 	 </td>	
	 		</tr>
	   </table>
	</form>
</body>
</html>