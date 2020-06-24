<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.PhoneDao"%>
<%@ page import="com.javaex.vo.PersonVo"%>

<%
	request.setCharacterEncoding("UTF-8");
int person_id = Integer.parseInt(request.getParameter("person_id"));

PhoneDao pDao = new PhoneDao();
PersonVo pVo = pDao.getPerson(person_id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/pb2/pbc" method="get">
	이름 : <input type="text" name="name" value="<%=pVo.getName() %>"> <br>
	핸드폰 : <input type="text" name="hp" value="<%=pVo.getHp () %>"> <br>
	회사 : <input type="text" name="company" value="<%=pVo.getCompany() %>"> <br>
	<input type="hidden" name="person_id" value="<%=pVo.getPersonId() %>"> <br>
	<input type="hidden" name="action" value="update"> <br>
	<button type="submit">수정</button>
	</form>
</body>
</html>