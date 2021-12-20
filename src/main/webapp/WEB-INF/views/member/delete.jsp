<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문시작 template.jsp -->
<div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
        <div class="text-center mb-5">
        </div>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-8 col-xl-6">	
	
	            	<h1 class="fw-bolder">회원탈퇴</h1>
	            	
	            	<form id="memfrm" data-sb-form-api-token="API_TOKEN" method="post" action="delete.do" onsubmit="return deleteCheck()">		
	            			<input type="hidden" id="m_mail" name="m_mail" value="${sessionScope.s_m_mail}" />
	            		<div class="form-floating mb-3">
	                        <input class="form-control" id="m_passwd" name="m_passwd" type="password" placeholder="비밀번호" />
	                        <label for="password">비밀번호</label>
	                        <br>
	                        <input type="submit" value="회원탈퇴"  class="btn btn-outline-danger"/>
			        		<input type="Javascript:history back"  value="취소"     class="btn btn-outline-warning"/>
	                	</div>
	                </form>

            </div>
        </div>
    </div>		
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>