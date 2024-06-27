<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="ARTICLE MODIFY" />
<%@ include file="../../common/head.jsp" %>

		<script>
			const modifyForm_onSubmit = function(form) {
				form.title.value = form.title.value.trim();
				form.body.value = form.body.value.trim();
				
				if (form.title.value.length == 0) {
					alert('제목을 입력해주세요');
					form.title.focus();
					return;
				}
				
				if (form.body.value.length == 0) {
					alert('내용을 입력해주세요');
					form.body.focus();
					return;
				}
				
				form.submit();
			}
		</script>
	
		<section class="mt-8 text-lg">
			<div class="container mx-auto px-3">
				<form action="doModify" method="post" onsubmit="modifyForm_onSubmit(this); return false;">
					<input type="hidden" name="id" value="${article.id }" />
					<div class="table-box-type">
						<table class="table talbe-lg">
							<tr>
								<th>번호</th>
								<td>${article.id }</td>
							</tr>
							<tr>
								<th>작성일</th>
								<td>${article.updateDate.substring(2, 16) }</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${article.writerName }</td>
							</tr>
							<tr>
								<th>제목</th>
								<td><input type="text" name="title" vlaue="${article.title }" /></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><td><input type="text" name="title" vlaue="${article.body }" /></td></td>
							</tr>
					</table>	
				</div>
			</form>
			
			<div class="mt-3 text-sm">
				<button class="btn btn-active btn-sm" onclick="history.back();">뒤로가기</button>
			</div>
		</div>
	</section>
<%@ include file="../../common/foot.jsp" %>