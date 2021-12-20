<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- logout.jsp --%>
<%
	//세션변수 제거
	session.removeAttribute("s_m_mail");
	session.removeAttribute("s_m_passwd");
	session.removeAttribute("s_m_class");
	session.removeAttribute("s_m_code");
	
	//페이지 이동
	response.sendRedirect("login.do");
%>