<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!-- 본문시작 loginform.jsp -->
<div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
	
    <div class="text-center mb-5">
    </div>
    <div class="row gx-5 justify-content-center">
        <div class="col-lg-8 col-xl-6">
        	<c:choose>
				<c:when test="${sessionScope.s_m_mail==guest || sessionScope.s_m_passwd==guest || sessionScope.s_m_class==guest || sessionScope.s_m_code==guest}">
					<%
						//쿠키---------------------------------------------------
						//사용자 PC에 모든 쿠키값 가져오기
						Cookie[] cookies=request.getCookies(); 
						String c_m_mail="";
						if(cookies!=null){ //쿠키가 존재하는지?
							for(int i=0; i<cookies.length; i++){
								Cookie cookie=cookies[i]; //쿠키 하나씩 가져오기
								if(cookie.getName().equals("c_m_mail")==true){
									c_m_mail=cookie.getValue(); //쿠키변수값 가져오기
								}//if end
							}//for end
						}//if end
					//------------------------------------------------------				 
					%>  
					<h1 class="fw-bolder">로그인</h1>
	            	<form id='frm' name='frm' method="post" action="login.do" onsubmit="return loginCheck()">
	
		                <div class="form-floating mb-3">
		                    <input class="form-control" id="m_mail" name="m_mail" value="<%=c_m_mail%>" type="email" placeholder="이메일" />
		                    <label for="email">이메일</label>
		                </div> 
		                <div class="form-floating mb-3">
		                    <input class="form-control" id="m_passwd" name="m_passwd" type="password" placeholder="비밀번호" />
		                    <label for="password">비밀번호</label>
		                </div>
		                <div class="d-grid"><input type="submit" value="로그인" class="btn btn-outline-success"></div>
		                <br>
		                <span id="panel"></span><!-- 로그인 관련 메세지 -->
		            	<div>
		            		<label><input type="checkbox" name="c_m_mail" value="SAVE" <%if(!c_m_mail.isEmpty()) {out.print("checked");}%>>아이디 저장</label>
		             		<a href="member.do" class="btn btn-outline-info" type="submit">회원가입</a>
		                </div>
		                <br>
	            	</form>
	            </c:when>	
							
				<c:when test="${sessionScope.s_m_mail!=guest && sessionScope.s_m_passwd!=guest && sessionScope.s_m_class!=guest && sessionScope.s_m_code!=guest}">
						<div>
							${sessionScope.s_m_mail}
							
						</div>
						<br><br>	
						<a href='read.do?m_code=${s_m_code}' class="btn btn-outline-success">회원정보</a>
					 	<a href='logout.do' class="btn btn-outline-warning">로그아웃</a>
						<br><br>			
				</c:when>
           	</c:choose> 
      
         </div>
    </div>
</div>
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>