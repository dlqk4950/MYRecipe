<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문시작 read.jsp -->
<div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
        <div class="text-center mb-5">
        </div>
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-8 col-xl-6">
                <h1 class="fw-bolder">회원정보</h1>
				<table class="table">	
					<tr>
						<td><img class="img-fluid rounded-circle mb-4 px-4" src="../storage/${dto.m_img}" width="130px" height="130px" ></td>
					</tr>
					<tr>	
						<th class="success">이메일</th>
						<td>${dto.m_mail}</td>
					</tr>
					<tr>
						<th class="success">닉네임</th>
						<td>${dto.m_nick}</td>
					</tr>
					<tr>
						<th class="success">성별</th>	
						<td>${dto.m_gen}</td>
					</tr>
					<tr>	
						<th class="success">생년월일</th>	
						<td>${dto.m_birth}</td>
					</tr>
				</table>
       <a class="btn btn-outline-success" href="/member/modify.do?m_code=${s_m_code}">회원정보 수정</a></li>
	   <a class="btn btn-outline-danger" href="/member/delete.do">회원탈퇴</a></li>
			</div>
        </div>
                  
</div>		
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>