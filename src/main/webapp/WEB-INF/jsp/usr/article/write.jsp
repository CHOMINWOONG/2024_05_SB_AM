<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="ARTICLE WRITE" />
<%@ include file="../../common/head.jsp" %>

		<script>
			const writeForm_onSubmit = function(form) {
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
				<form action="doWrite" method="post" onsubmit="writeForm_onSubmit(this); return false;">
					<input type="hidden" name="id" value="${article.id }" />
					<div class="table-box-type">
						<tr>
							<th>게시판</th>
								<td>
									<div class="flex">
										<div>
											<label class="flex items-center">
												<input class="radio radio-sm" type="radio" name="boardId" value="1" checked />
												&nbsp;&nbsp;공지사항
											</label>
										</div>
										<div class="w-20"></div>
										<div>
											<label class="flex items-center">
												<input class="radio radio-sm" type="radio" name="boardId" value="2" />
												&nbsp;&nbsp;자유
											</label>
										</div>
									</div>
								</td>
							</tr>
							
						<div class="form-control">
			          			<label class="label">
			            			<span class="label-text">제목</span>
			          			</label>
			          	<input type="text" name="title" placeholder="제목을 입력해주세요" class="input input-bordered" required />
			       		</div>	
			       		<div class="form-control">
			          		<label class="label">
			            		<span class="label-text">내용</span>
			          		</label>
		          		<input type="text" name="body" placeholder="내용을 입력해주세요" class="input input-bordered" required />
		       			</div>
					</div>
					
					<div class="mt-3 text-sm">
						<button class="btn btn-active btn-sm" onclick="history.back();">뒤로가기</button>
					</div>
				</form>
			</div>
		</section>
<%@ include file="../../common/foot.jsp" %>