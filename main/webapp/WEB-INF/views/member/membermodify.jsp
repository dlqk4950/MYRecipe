<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!-- 본문시작 membermodify.jsp -->
	<div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
        <div class="text-center mb-5">
        </div>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-8 col-xl-6">
                <h1 class="fw-bolder">회원정보수정</h1>
                <form id="contactForm" data-sb-form-api-token="API_TOKEN" method="post" action="modify.do" enctype="multipart/form-data" onsubmit="return modifyCheck()">
                    <input type="hidden" id="m_mail" name="m_mail" value="${sessionScope.s_m_mail}" />
                    <input type="hidden" id="m_code" name="m_code" value="${s_m_code}">
                    <div class="form-floating mb-3">
                        <input class="form-control" id="m_passwd" name="m_passwd" type="password" placeholder="비밀번호" />
                        <label for="password">비밀번호</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input class="form-control" id="m_repasswd" name="m_repasswd" type="password" placeholder="비밀번호" />
                        <label for="password">비밀번호 확인</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input class="form-control" id="m_nick" name="m_nick" value="${dto.m_nick}" type="text" placeholder="닉네임" />
                        <label for="text">닉네임</label>
                    </div>
                    <div class="form-floating mb-3">
				        남자 <input type="radio" id="m_gen" name="m_gen" value="Man" checked>
				        여자 <input type="radio" id="m_gen" name="m_gen" value="Woman">
				    </div>
				    <br>
				    <div>
					    회원 이미지
					    <input type="file" name="m_imgmf" id="m_imgmf">
					    <img class="img-fluid rounded-circle mb-4 px-4" src="../storage/${dto.m_img}" width="130px" height="130px" > 
					</div>  
				    <br> 
				    
				    <input type="submit" value="회원정보수정"  class="btn btn-outline-info"/>
		        	<input type="reset"  value="취소"      class="btn btn-outline-danger"/>
                </form>
            </div>
        </div>
    </div>		
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>