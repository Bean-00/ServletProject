<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import= "session.SessionRepository" %>
<%@page import= "java.util.*" %>
	<%
	String sessionId = SessionRepository.getSessionId(request.getCookies());
	
	if (Objects.nonNull(sessionId) && SessionRepository.containsSession(sessionId)) {
		SessionRepository.removeSession(sessionId);
	}
	
	response.sendRedirect("/views/login.jsp");
	%>