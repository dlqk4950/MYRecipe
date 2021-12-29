<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../header.jsp"%>

<!--본문시작 -->

            <!-- About section one-->
            <section class="py-5 bg-light" id="scroll-target">
            
                <div class="container px-5 my-5"></div>
                <h5>요리 소개</h5>
                
                
                    <div class="row gx-5 align-items-center">
                        <div class="col-lg-6"><img class="img-fluid rounded mb-5 mb-lg-0" src="../storage/${dto.l_photo}" style="width: 100%" ></div>
                        <div class="col-lg-6">
                            <h2 class="fw-bolder">${dto.l_title}</h2>
                            <p class="lead fw-normal text-muted mb-0">${dto.l_contents}</p>
                        <div><br><br><br><br><br><br><br><br><br>
                            조회수 : ${dto.l_views} 
                            닉네임 : ${dto.m_nick}
                        </div>    
                        </div>
                                                
                    </div>
                <c:if test="${s_m_code==dto.g_code}">   
                <div class="col-lg-6"><br><br>
                	<a class="btn btn-outline-success" href="update.do?l_code=${dto.l_code}">수정</a>         			
         			<a class="btn btn-outline-success" href="javascript:deleteCheck()">삭제</a>         			
                </div>                    
				</c:if>
				<c:if test="${s_m_code!=dto.g_code}">   
                <div class="col-lg-6"><br><br>
                	<a class="btn btn-outline-success" href="subscribepay.do?g_code=${dto.g_code}">구독하기</a>
                </div>                    
				</c:if>
				
                
            </section>
            <section class="py-5">
            <c:choose>
					<c:when test="${!empty cdto or s_m_code==dto.g_code}">            
            <!-- About section two-->
            
                <div class="container px-5 my-5">
                    <div class="row gx-5 align-items-center">
                        <div class="col-lg-6 order-first order-lg-last">
                        <div class="col-lg-6">
                            <h2 class="fw-bolder">강의 영상</h2>
                            <video src="../storage/${dto.l_tumbsup}"width="1000px" controls></video>
                        </div>
                    </div>
                </div>
               </div>
         
         </c:when>
         <c:when test="${empty cdto}">
         		<h5>구독시 영상을 볼수있습니다</h5>
         </c:when>
         </c:choose>
      </section>
<script>
function deleteCheck(){	  
    if (confirm("사진,영상도 삭제됩니다. 계속 하시겠습니까?")) {            
        return location.href='delete.do?l_code=${dto.l_code}';
    } else {
    	alert("삭제가 취소되었습니다");
        return false;
    }    
}



</script>
<!--본문 끝 -->
<%@ include file="../footer.jsp"%>
