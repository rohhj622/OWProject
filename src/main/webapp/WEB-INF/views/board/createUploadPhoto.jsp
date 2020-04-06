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
				  if(fr.file1.value == "") {
				    alert("사진을 업로드해주세요.");
				    return false;
				  } 
				  else{
					  return true;
				  }
				}
		</script>
		
		<article>	
			<div class="container" role="main">
				<h2>사진 업로드</h2>		
				<div class="row">
				<form action="<c:url value='/board/writeContent' />"
					name="fr" id="fr" role="form" method="post"  onsubmit="return check()" enctype="multipart/form-data">

				    <div class="mb-3">
				        <input  class="btn btn-primary" multiple="multiple" type="file" name="file1" />
				    </div>
				    
					<div class="mb-3">
						<input type="hidden" name="sido" value="${sido }">
						<input type="hidden" name="gugun" value="${gugun }">
						<input type="hidden" name="theme" value="${theme }">
						<input type="hidden" name="title" value="${title }">
						<input class="btn btn-info" type="submit" value="다음">					
					</div>
				</form>
				</div>		
				
			</div>
		</article>
	</body>
</html>


