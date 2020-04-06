<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  	<head>
	    <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	    <link href="<c:url value='/css/bootstrap-theme.css' />" rel="stylesheet">
	    
	    <!-- Bootstrap JS -->
	    <link href="<c:url value='/js/bootstrap.js' />">

	    <title>Hello, world!</title>
		<!-- 
		<style>
			body {
			  padding-top: 70px;
			  padding-bottom: 30px;
			}
		</style> -->

	</head>

	<body>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    	
		<script type="text/javascript">
			function check() {
				  if(fr.theme1.value == "장소 선택") {
				    alert("장소를 선택해주세요.");
				    return false;
				  } 
				  else{
					  return true;
				  }
				}
		</script>
		
		<article>	
			<div class="container" role="main">
				<h2>장소 선택</h2>		
				<div class="row">
					<form action="<c:url value='/board/writeTitle' />" name="fr" id="fr" role="form" method="post"  onsubmit="return check()">
					<div class="mb-3">	
						<select class="form-control" name="theme1" id="theme1">
							<option value="장소 선택">장소 선택</option>
							<option value="술">술</option>
							<option value="식사">식사</option>
							<option value="놀이">놀이</option>
							<option value="실외">실외</option>
							<option value="디저트">디저트</option>								
						</select>
					</div>
					<div class="mb-3">
						<input type="hidden" name="sido" value="${sido }">
						<input type="hidden" name="gugun" value="${gugun }">
						<input class="btn btn-info" type="submit" value="다음">					
					</div>
				</form>
				</div>		
				
			</div>
		</article>
	</body>
</html>


