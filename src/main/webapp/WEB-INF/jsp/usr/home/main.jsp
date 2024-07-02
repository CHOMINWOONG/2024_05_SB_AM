<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="pageTitle" value="MAIN"/>

<%@ include file="../../common/head.jsp" %>

	<script>
		$(document).ready(function(){
			$.ajax({
				url : "/usr/article/list", // 요청을 보낼 URL
				type : "GET", // HTTP 메서드(GET, POST, PUT, DELETE 등)
				data : { // 서버로 전송할 데이터
					key1 : "relTypeCode",
					key2 : "relId",
				},
				dataType : "json" , // 서버에서 응답 받을 데이터의 타입
				success : function(response) {
					
				},
				error : function(xhr, status, error){
					console.log(error);
				}
			})
		})
	</script>
	<section class="mt-8">
		<div class="container mx-auto">
			<div>조민웅의 SB 게시물 </div>
			<div>안녕하세요</div>
		</div>
	</section>

 <%@ include file="../../common/foot.jsp" %>