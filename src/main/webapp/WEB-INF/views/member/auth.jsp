<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- auth.jsp --%>
<%-- 로그인 상태 정보 확인 --%>
<%
	String s_m_mail="";
	String s_m_passwd="";
	String s_m_class="";
	String s_m_code="";
	String s_m_nick="";
	String s_m_img="";
	
	
	if(session.getAttribute("s_m_mail")==null ||
		session.getAttribute("s_m_passwd")==null || 
		session.getAttribute("s_m_class")==null ||
		session.getAttribute("s_m_code")==null ||
		session.getAttribute("s_m_nick")==null ||
		session.getAttribute("s_m_img")==null){
	//로그인 하지 않았다면
		s_m_mail="guest";
		s_m_passwd="guest";
		s_m_class="guest";
		s_m_code="guest";
		s_m_nick="guest";
		s_m_img="guest";
	}else{
		s_m_mail    =(String)session.getAttribute("s_m_mail");
		s_m_passwd  =(String)session.getAttribute("s_m_passwd");
		s_m_class   =(String)session.getAttribute("s_m_class");
		s_m_code    =(String)session.getAttribute("s_m_code");
		s_m_nick    =(String)session.getAttribute("s_m_nick");
		s_m_img     =(String)session.getAttribute("s_m_img");
	
	}
%>