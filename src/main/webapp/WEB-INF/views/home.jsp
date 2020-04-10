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
    <title>Hello, world!</title>
    <!-- JS -->
  </head>
  <body class="container">
    <div class="jumbotron">
        <h1>Hello, world!</h1>
        <p>The time on the server is ${serverTime}.</p>
        
        <form action="<c:url value='/board/selectLoc' />">
        	<input type="submit" value="글쓰기"/>
        </form>
        <form action="<c:url value='/board/postList' />">
        	<input type="submit" value="게시판"/>
        </form>
    </div>
  </body>
</html>

