<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 명부</title>
</head>
<body>
	<c:forEach items="${memberList}" var="member">
		아이디 : ${member.mid }<br>
		비빌번호 : ${member.mpw }<br>
		이름 : ${member.mname }<br>
		이메일 : ${member.memail }<br>
		가입일 : ${member.mdate }<br>
		<br>
	</c:forEach>
</body>
</html>