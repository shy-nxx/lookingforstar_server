<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../../bootstrap/css/carousel.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>

#choiceList ol {
	float: left;
	list-style: none;
	margin: 0px;
	padding: 0px;
	max-width: 900px;
	width: 100%;
	text-transform: uppercase;
}

#choiceList li {
	float: left;
	list-style: none;
	margin: 2px;
}

#choiceList li a {
	display: block;
	width: 150px;
	height: 40px;
	background: #ffffff;
	color: #000000; border1px solid blue;
	font-size: 12px;
	text-align: center;
	padding-top: 10px;
	text-decoration: none;
}

#choiceList li a:hover {
	background: #2F6FF6;
	text-decoration: none;
}
</style>

</head>
<body>
	<!-- !PAGE CONTENT! -->
	<!-- youtube -->
	<div class="w3-container w3-center" id="youtube" style="margin-left:83px; margin-right:80px" >
		<div id="choiceList" class = "w3-right">
			<ol>
					<li ><a id = "musicvideo"
					href='/youtube?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>&select=musicvideo'>뮤직비디오
					</a></li>
					<li ><a id = "broadcast"
					href='/youtube?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>&select=broadcast'>방송
					</a></li>
					<li ><a id = "mnet"
					href='/youtube?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>&select=mnet'>엠넷
					</a></li>
					<li ><a id = "musicbank"
					href='/youtube?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>&select=musicbank'>뮤직뱅크
					</a></li>
					<li ><a id = "popularmusic"
					href='/youtube?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>&select=popularmusic'>인기가요
					</a></li>
					
				</ol>
			<%-- <ol>
				<c:forEach items="${names }" var="name">
					<li><a
						href='/photo?choice=<c:out value="${choice}"/>&select=<c:out value="${name}"/>'>
							${name}</a></li>
				</c:forEach>
			</ol> --%>
		</div>
	

		
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status" begin="0"
				end="1">		
				<iframe width="593" height="333" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status" begin="2"
				end="4">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status" begin="5"
				end="7">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="8" end="10">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="11" end="13">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="14" end="16">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="17" end="19">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="20" end="22">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="23" end="25">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
	</div>
	
</body>

</html>