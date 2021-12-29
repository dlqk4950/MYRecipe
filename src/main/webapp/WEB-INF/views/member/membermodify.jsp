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
                <form id="contactForm" data-sb-form-api-token="API_TOKEN" method="post" action="modify.do" enctype="multipart/form-data" onsubmit="return modifyCheck() ">
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
                        <br>
                        <input type="button" value="닉네임 중복확인" id="btn_m_nick" class="btn btn-outline-success" >
                        <span id="panel2"></span><!-- 아이디 중복 관련 메세지 -->
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
                <script>
	                $(function(){
						$.removeCookie("checkID2");
					});
		
					$("#btn_m_nick").click(function(){
						var m_nick="m_nick=" + $("#m_nick").val().trim();
						$.post("duplecatem_nick.do", m_nick, checkID2, "json");
					});//click() end
				
		
					function checkID2(result){
						var count=eval(result.count);
						if(count==0){									
							$("#panel2").css("color", "blue");
							$("#panel2").text("사용 가능한 닉네임 입니다");
							$.cookie("checkID2", "PASS");	
							
						}else{
							$("#panel2").css("color", "red");
							$("#panel2").text("중복된 닉네임 입니다");
							$("#m_nick").focus(); 
						}//if end
					}//checkID2() end
                </script>
            </div>
        </div>
    </div>		
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>