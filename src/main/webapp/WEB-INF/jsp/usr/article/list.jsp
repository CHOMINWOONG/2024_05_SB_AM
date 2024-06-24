<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../../common/head.jsp" %>
	<section>
		<div>
			<div class="table-box-type">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
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
			</div>
		</div>
	</section>
<%@ include file="../../common/foot.jsp" %>