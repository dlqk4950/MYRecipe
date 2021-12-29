<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../member/auth.jsp" %>
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>

<!-- 본문시작 template.jsp -->

<div class="container px-5 my-5">


	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" data-toggle="tab"
			href="#id1">구독하기</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="#id2">구독권 선물하기</a></li>
		
	</ul>
	<div class="tab-content">
		<div class="tab-pane fade show active" id="id1">
			<!--  -->
			<div class="text-center mb-5">
				<h1 class="fw-bolder">구독 하기</h1>
			</div>

			<div class="row gx-5 justify-content-center">
				<!-- Pricing card free-->
				<div class="col-lg-6 col-xl-4">
					<div class="card mb-5 mb-xl-0">
						<div class="card-body p-5">
							<div class="small text-uppercase fw-bold text-muted">1개월</div>
							<div class="mb-3">
								<span class="display-5 fw-bold" id="p_price">₩5000</span>
							</div>
							<ul class="list-unstyled mb-4">

								<li class="text-muted"><i class="bi bi-x"></i> Monthly
									status reports</li>
							</ul>
							<div class="d-grid">
								<form id="subfrm" method="post" action="insertsubscribe.do">
									 <input type="hidden" name="p_price" value="5000">
									 <input type="hidden" name="p_count" value="1"> 
									 <input type="hidden" name="g_code"  value="${g_code}"> 
									  
									 <input type="submit" id='apibtn' style="width: 100%" class="btn btn-primary" value="구독하기">
								</form>
							</div>

						</div>
					</div>
				</div>
				<!-- Pricing card pro-->
				<div class="col-lg-6 col-xl-4">
					<div class="card mb-5 mb-xl-0">
						<div class="card-body p-5">
							<div class="small text-uppercase fw-bold text-muted">6개월</div>
							<div class="mb-3">
								<span class="display-5 fw-bold" id="p_price">₩30000</span>
							</div>
							<ul class="list-unstyled mb-4">

								<li class="text-muted"><i class="bi bi-x"></i> Monthly
									status reports</li>
							</ul>
							<div class="d-grid">
								<form id="subfrm" method="post" action="insertsubscribe.do">
									 <input type="hidden" name="p_price" value="30000">
									 <input type="hidden" name="p_count" value="6"> 
									 <input type="hidden" name="g_code" value="${g_code}"> 
									  
									 <input type="submit" id='apibtn' style="width: 100%" class="btn btn-primary" value="구독하기">
								</form>
							</div>

						</div>
					</div>
				</div>
				<!-- Pricing card free-->
				<div class="col-lg-6 col-xl-4">
					<div class="card mb-5 mb-xl-0">
						<div class="card-body p-5">
							<div class="small text-uppercase fw-bold text-muted">12개월</div>
							<div class="mb-3">
								<span class="display-5 fw-bold" id="p_price">₩60000</span>
							</div>
							<ul class="list-unstyled mb-4">

								<li class="text-muted"><i class="bi bi-x"></i> Monthly
									status reports</li>
							</ul>
							<div class="d-grid">
								<form id="subfrm" method="post" action="insertsubscribe.do">									 
									<input type="hidden" name="p_price" value="60000"> 
									<input type="hidden" name="p_count" value="12">
									<input type="hidden" name="g_code" value="${g_code}"> 
									
									<input type="submit" id='apibtn' style="width: 100%" class="btn btn-primary" value="구독하기">
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="tab-pane fade" id="id2">
			<div class="text-center mb-5">
				<h1 class="fw-bolder">구독권 선물하기</h1>
			</div>

			<div class="row gx-5 justify-content-center">
				<!-- Pricing card free-->
				<div class="col-lg-6 col-xl-4">
					<div class="card mb-5 mb-xl-0">
						<div class="card-body p-5">
							<div class="small text-uppercase fw-bold text-muted">1개월</div>
							<div class="mb-3">
								<span class="display-5 fw-bold" id="p_price">₩5000</span>
							</div>
							<ul class="list-unstyled mb-4">

								<li class="text-muted"><i class="bi bi-x"></i> Monthly
									status reports</li>
							</ul>
							<div class="d-grid">
								<form id="subfrm" method="post" action="presentsubscribe.do" onsubmit="return nullcheck()"> 
									<input type="text"   name="m_nick" id="m_nick" size="30" style="width: 100%" class="form-control"	placeholder="닉네임을 적어주세요"> 
									<input type="hidden" name="p_price" value="5000">
									<input type="hidden" name="p_count" value="1"> 
									<input type="hidden"name="g_code" value="${g_code}"> 
									 
									<input type="submit" style="width: 100%" class="btn btn-primary" value="선물하기" onclick="kakao(this.form)">
								</form>
							</div>

						</div>
					</div>
				</div>
				<!-- Pricing card pro-->
				<div class="col-lg-6 col-xl-4">
					<div class="card mb-5 mb-xl-0">
						<div class="card-body p-5">
							<div class="small text-uppercase fw-bold text-muted">6개월</div>
							<div class="mb-3">
								<span class="display-5 fw-bold" id="p_price">₩30000</span>
							</div>
							<ul class="list-unstyled mb-4">

								<li class="text-muted"><i class="bi bi-x"></i> Monthly
									status reports</li>
							</ul>
							<div class="d-grid">
								<form id="subfrm" method="post" action="presentsubscribe.do" onsubmit="return nullcheck()">
									<input type="text"   name="m_nick" id="m_nick" size="30" style="width: 100%" class="form-control"	placeholder="닉네임을 적어주세요"> 
									<input type="hidden" name="p_price" value="30000"> 
									<input type="hidden" name="p_count" value="6"> 
									<input type="hidden"name="g_code" value="${g_code}"> 
								 
									<input type="submit" style="width: 100%" class="btn btn-primary" value="선물하기" onclick="kakao(this.form)">
								</form>
							</div>

						</div>
					</div>
				</div>
				<!-- Pricing card free-->
				<div class="col-lg-6 col-xl-4">
					<div class="card mb-5 mb-xl-0">
						<div class="card-body p-5">
							<div class="small text-uppercase fw-bold text-muted">12개월</div>
							<div class="mb-3">
								<span class="display-5 fw-bold" id="p_price">₩60000</span>
							</div>
							<ul class="list-unstyled mb-4">

								<li class="text-muted"><i class="bi bi-x"></i> Monthly
									status reports</li>
							</ul>
							<div class="d-grid">
								<form id="subfrm" method="post" action="presentsubscribe.do" onsubmit="return nullcheck()" >
									<input type="text" name="m_nick" id="m_nick" size="30" style="width: 100%" class="form-control"	placeholder="닉네임을 적어주세요"> 
									<input type="hidden" name="p_price" value="60000"> 
									<input type="hidden" name="p_count" id="p_count" value="12">
									<input type="hidden" name="g_code" id="g_code" value="${g_code}">
									<!-- <input type="hidden" name="suburl" id="suburl" value="presentsubscribe.do"> --> 
									<input type="submit" style="width: 100%" class="btn btn-primary" value="선물하기"> <!-- onclick="kakao(this.form)" --><!-- this.form 현재 버튼이 있는 폼자체를 가리킴 -->
								</form>
							</div>	

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
function nullcheck(){
	var m_nick=document.getElementById("m_nick").value;
	m_nick=m_nick.trim();
	if (m_nick==null{
		alert("선물 할사람의 닉네임을 적어주세요")
		document.getElementById("m_passwd").focus();
		return false;
	}//if end
	return true;
}
/*
function kakao(f){ //넘겨온 폼을 받음
		
	f.action="kakaopay.do"; //이런씩으로 코딩하면 액션도 다양하게 배분할수 있어요~
	f.submit();
	
}//kakao() end
*/

/*
$(function(){	
	$('button').click(function(){
		var params = $('#subfrm').serialize();
		$.ajax({			
			url:'kakaopay.do',
			type : "post",
			data : params,
			dataType:'json',	
			async: false,
			success:function(data){
				//data=eval(data);
				var box = data.next_redirect_pc_url;
				alert("결제창으로 이동합니다.");
				var suburl = $("#suburl").val().trim();
				var g_code = $("#g_code").val().trim();
				
				window.open(box,'kakaowin','width=300,height=500');				
				opener.location.replace(suburl+"?g_code="+g_code);
				self.close();
				//location.href = suburl;
				//location.href = box;
		
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
 
<%@ include file="../footer.jsp" %>