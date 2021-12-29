<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5" id="scroll-target">            	
	<div class="card h-100">
		<div style="text-align : center;">
			<img src="../storage/${kdto.r_photo}" style="width: 50%">
			<br>
			<img class="rounded-circle me-3" src="../storage/${kdto.m_img}" width="40px" height="40px"/><font color="green">${kdto.m_nick}</font>
			<br><br>	
			<h2 class="fw-bolder">${kdto.r_name}</h2>
			<p class="lead fw-normal text-muted mb-0">${kdto.r_intro}</p>
			<br><br><br>
			<div class="inner">
				<div style="float: left; width: 45%;">				
					&nbsp;&nbsp;<img class="rounded-circle me-3" src="../storage/re2.png" width="30px" height="30px"/>
					<br>
					<h7>${kdto.ci_per}</h7>
				</div>
				<div style="float: left; width: 10%;">
					&nbsp;&nbsp;<img class="rounded-circle me-3" src="../storage/re1.png" width="30px" height="30px"/>
					<br>
					<h7>${kdto.ci_time}</h7>
				</div>
				<div style="float: left; width: 45%;">
					&nbsp;&nbsp;&nbsp;<img class="rounded-circle me-3" src="../storage/re3.png" width="30px" height="30px"/>
					<br>
					<h7>${kdto.ci_diff}</h7>
				</div>
			</div>	
			<br><br><br>	
		</div>

	</div>
	<br>	
	
	<div class="card h-100"> 
		<div class= "contaner">
		<br>
			<p class="lead fw-normal text-muted mb-0">재료</p>
			<c:forEach var="kdto2" items="${kdto2}">
				<table class="table">	
					<tr>
						<td>
							<h7>[${kdto2.r_kind}]</h7>
						</td>
					</tr>
					<tr>	
						<th>
							<h7>${kdto2.r_tname}</h7>
							<h7>${kdto2.r_mea}</h7>
						</th>
					</tr>
				</table>	
			</c:forEach>			
		</div>
			<p class="lead fw-normal text-muted mb-0">조리순서</p>
		<br>
		<c:forEach var="kdto3" items="${kdto3}">
			<div class="row">	      
		        <div style="text-align : left;">
		        	<img src="../storage/${kdto3.r_img}" width="300px" height="200px"/>&nbsp;&nbsp; 
		        	${kdto3.r_seq}&nbsp;
		        	${kdto3.r_explan}
		        </div>
		    </div>
		    <br>
	    </c:forEach>	
	</div>	
	<br>
	<div class="card h-100">	
		<br>
		<p class="lead fw-normal text-muted mb-0">요리후기</p>
		<br>
		<c:forEach var="kdto4" items="${kdto4}">
			<div class="inner">		
				<div style="float: left; width: 90%;">	
					<img class="rounded-circle me-3" src="../storage/${kdto4.m_img}" width="50px" height="50px"/>
					<font color="green"><h7>${kdto4.m_nick}</h7></font>
					<h7>${kdto4.h_date}</h7>
					<h7>${kdto4.h_star}</h7>
					<br>
					<div style="text-indent: 70px;">
						<h7>${kdto4.h_postcon}</h7>
					</div>
					<br>
				</div>
				<div style="float: left; width: 10%;">
					<img src="../storage/${kdto4.h_photo}" width="60px" height="60px"/>
				</div>
			</div>
		</c:forEach>
		<form data-sb-form-api-token="API_TOKEN" method="post" action="script.do" enctype="multipart/form-data" onsubmit="return scriptCheck()">
			<div style="float: left; width: 70%;">
				&nbsp;<h7>후기작성</h7>
			   	<br>
		    	&nbsp;<textarea cols="90" rows="2" maxlength="200" id="h_postcon" name="h_postcon"></textarea>
		    </div>
		    <div style="float: left; width: 30%;">
		   		<input type="file" name="h_photomf" id="h_photomf">
		   		<input type="hidden" name="m_nick" id="${dto.m_nick}">
		   		<input type="hidden" name="m_img" id="${dto.m_img}">
		   		<input type="hidden" name="r_code" id="${kdto.r_code}">
		   		#${dto.m_nick}#
		   		<br><br>
		   		<div style="float: left; width: 60%;">
		   		<h7>별점</h7>
		   			<select class="all_star" name="h_star"  id="h_star">
			        	<option class="star_1 fa" value="1">&#xf005</option>
			          	<option class="star_2 fa" value="2">&#xf005&#xf005</option>
			          	<option class="star_3 fa" value="3">&#xf005&#xf005&#xf005</option>
			          	<option class="star_4 fa" value="4">&#xf005&#xf005&#xf005&#xf005</option>
			          	<option class="star_5 fa" value="5" selected>&#xf005&#xf005&#xf005&#xf005&#xf005</option>
					</select>
				</div>	
				<div style="float: left; width: 40%;">
					<input type="submit" value="후기작성"  class="btn btn-outline-info"/> 
		   		</div>
		   	</div>
		</form> 
		
	</div>           
</section>

<%@ include file="../footer.jsp" %>