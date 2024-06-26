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
							<th>제목</th>
							<td>${article.title }</td>
						</tr>
						<tr>
							<th>내용</th>
							<td></td>
						</tr>
					</thead>
					<tbody>
							<tr>
								<th>${article.title }</th>
								<th>${article.body }</th>
							</tr>
					</tbody>
				</table>	
			</div>
		</div>
	</section>
<%@ include file="../../common/foot.jsp" %>