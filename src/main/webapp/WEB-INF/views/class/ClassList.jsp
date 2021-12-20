<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<%@ include file="../member/auth.jsp" %>
<!--본문시작 -->
<div class="container px-4 px-lg-5 mt-5">
	<h1>클래스   <a class="btn btn-outline-success" href="javascript:logincheck();">강의 작성</a></h1>	
	<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

		<c:choose>
			<c:when test="${empty list}">
    	    <p>강의가 없습니다.</p>
    	</c:when>
			<c:when test="${!empty list}">
				<c:forEach var="dto" items="${list}">
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<img class="card-img-top" src="../storage/${dto.l_photo}" width="100%" height="40%">
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">${dto.l_title}</h5>
									<!-- Product price-->
									${dto.l_contents}
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-success mt-auto" href="classread.do?l_code=${dto.l_code}">강의
										보기</a>
								</div>

							</div>
						</div>
					</div>
				</c:forEach>
			</c:when>
		</c:choose>





		



	</div>
</div>
<script>

function logincheck() {
	 if (${sessionScope.s_m_mail==guest}) {            
		 alert("로그인을 해주세요!");	        
	    } else {	    	
	    	location.href="create.do";	    	
	    }
}
</script>

<!--본문 끝 -->
<%@ include file="../footer.jsp"%>
