<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>영화목록</h2>
	<hr>
	<table>
		<tr>
			<th>영화번호</th>
			<th>영화제목</th>
			<th>영화감독</th>
			<th>영화장르</th>
			<th>영화상영시간</th>
		</tr>
		<c:forEach items="${list }" var="movie">
			<tr>
				<td>${ movie.id}</td>
				<td>${ movie.title}</td>
				<td>${ movie.director}</td>
				<td>${ movie.genre}</td>
				<td>${ movie.runningTime}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>