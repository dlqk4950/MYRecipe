<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="../member/auth.jsp"%>




<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>

<!-- 본문시작 template.jsp -->

<div class="container px-5 my-5">


	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" data-toggle="tab"
			href="#id1">구독중인 쉐프</a></li>
		
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="#id3">만료된 구독</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane fade show active" id="id1">
			<!--  -->
			<div class="tab-pane fade show active" id="home" role="tabpanel"
				aria-labelledby="home-tab">
				<!-- 구독내역 탭 -->
				<c:choose>
					<c:when test="${empty sublist}">
						<div class="text-center mb-5">
							<br>
							<h1 class="fw-bolder">구독중인 쉐프가 없습니다</h1>
						</div>

						
					</c:when>
					<c:when test="${!empty sublist}">
						<br>
						<div
							class="row gx-4 gx-lg-6 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

							<c:forEach var="dto" items="${sublist}">
								<div class="col mb-5">
									<div class="card h-100">
										<!-- Product image-->
										<img class="card-img-top" src="../storage/${dto.m_img}"
											width="100%">
										<!-- Product details-->
										<div class="card-body p-4">
											<div class="text-center">
												<!-- Product name-->
												<h5 class="fw-bolder">${dto.m_nick}</h5>
												<!-- Product price-->
												${dto.m_mail}.
												<fmt:parseDate value='${dto.p_date}' var='p_date' pattern='yyyy-MM-dd'/>
												<fmt:formatDate value="${p_date}" pattern="yyyy-MM-dd"/>	
											</div>
										</div>
										<!-- Product actions-->
										<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
											<div class="text-center">
									<form name="subfrm" method="post" action="/class/updatesubscribe.do?g_code=${dto.g_code}" >
											<select name="p_count">
    											<option value="1">1개월</option>
											    <option value="6">6개월</option>
											    <option value="12">12개월</option>											    
											</select>
												<input type="submit" class="btn btn-outline-success mt-auto" value="구독연장">
									</form>
											</div>
					
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</c:when>
				</c:choose>
			</div>

		</div>
		
<div class="tab-pane fade" id="id3">
		
				<!-- 구독내역 탭 -->
				<c:choose>
					<c:when test="${empty sublist2}">
						<div class="text-center mb-5">
							<br>
							<h1 class="fw-bolder">만료된 구독이 없습니다</h1>
						</div>
					</c:when>
				
					<c:when test="${!empty sublist2}">
					<br>
						<div
							class="row gx-4 gx-lg-6 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

							<c:forEach var="dto" items="${sublist2}">
								<div class="col mb-5">
									<div class="card h-100">
										<!-- Product image-->
										<img class="card-img-top" src="../storage/${dto.m_img}"
											width="100%">
										<!-- Product details-->
										<div class="card-body p-4">
											<div class="text-center">
												<!-- Product name-->
												<h5 class="fw-bolder">${dto.m_nick}</h5>
												<!-- Product price-->
												${dto.m_mail}.
												<fmt:parseDate value='${now}' var='p_date' pattern='yyyy-MM-dd'/>
												<fmt:formatDate value="${p_date}" pattern="yyyy-MM-dd"/>	
											</div>
										</div>
										<!-- Product actions-->
										<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
											<div class="text-center">
									<form name="subfrm" method="post" action="/class/updatesubscribe.do?g_code=${dto.g_code}">
											<select name="p_count">
    											<option value="1">1개월</option>
											    <option value="6">6개월</option>
											    <option value="12">12개월</option>											    
											</select>
											<input type="submit" class="btn btn-outline-success mt-auto" value="구독연장">
									</form>
											</div>
					
										</div>
									</div>
								</div>
							</c:forEach>
						</div>					
					</c:when>
					
				</c:choose>
			</div>

	</div>
	</div>	





<script>

/*
$(function(){	
	$('#button').click(function(){alert();		
		$.ajax({			
			url:'kakaopay.do',
			type : "post",
			dataType:'json',			
			success:function(data){
				data=eval(data);
				var box = data.next_redirect_pc_url;
				alert(box);
				window.open(box,'kakaowin','width=300,height=500');
			
			},
			error:function(error){
				alert(error);
			}
		});
	});	
}); 
*/


</script>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>