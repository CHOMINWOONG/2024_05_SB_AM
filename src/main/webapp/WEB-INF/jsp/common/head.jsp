<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle }</title>
<!-- 테일윈드 -->
<script src="https://cdn.tailwindcss.com"></script>
<!-- 폰트어썸 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"></script>
<!-- 제이쿼리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- 공통 css -->
<link rel="stylesheet" href="/resource/common.css" />
</head>
<body>
	<div class="menu-con">
		<div class="logo-bar grow"><a href="/"><span>로고</span></a></div>
		
		<ul>
			<li class="hover:underline"><a href="/"><span>HOME</span></a></li>
			<li class="hover:underline"><a href="/usr/article/list"><span>LIST</span></a></li>
		</ul>
	</div>
	
	<section>
		<div class="text-3xl">
			<div class="text-xl">${pageTitle }&nbsp;PAGE</div>
		</div>
	</section>
</body>
</html>