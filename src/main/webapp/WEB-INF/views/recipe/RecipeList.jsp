<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
<body>
	<div class="container px-5">

		<h1 class="fw-bolder">레시피</h1>

			<p>
				<a class="btn btn-outline-success" href="javascript:logincheck();">레시피 등록</a>
			  	<a class="btn btn-outline-info" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">카테고리</a>  
			</p>
			<form id="Recipefrm" method="post" action="recipelist.do">
			<div class="row">
				<div class="col">
			    	<div class="collapse multi-collapse" id="multiCollapseExample1">
			        	<div class="card card-body">
			        		<th>종류별</th>							
						   		<select name="j_no"  id="j_no">
						        	<option value="cook1" selected>전체</option>
						          	<option value="cook2">밑반찬</option>
						          	<option value="cook3">메인반찬</option>
						          	<option value="cook4">국/탕/찌개</option>
						          	<option value="cook5">면/만두</option>
						          	<option value="cook6">밥/죽/떡</option>
						          	<option value="cook7">디저트</option>
						          	<option value="cook8">양식</option>
						          	<option value="cook9">차/음료/술</option>
						          	<option value="cook10">기타</option>
						   		</select>
						   	<br>
						   	<th>재료별</th>				   	
						   		<select name="g_no"  id="g_no">
						        	<option value="cook21" selected>전체</option>
						          	<option value="cook22">소고기</option>
						          	<option value="cook23">돼지고기</option>
						          	<option value="cook24">닭고기</option>
						          	<option value="cook25">해물류</option>
						          	<option value="cook26">달걀/유제품</option>
						          	<option value="cook27">쌀</option>
						          	<option value="cook28">밀가루</option>
						          	<option value="cook29">버섯류</option>
						          	<option value="cook30">과일류</option>
						          	<option value="cook31">곡류</option>
						          	<option value="cook32">기타</option>
						   		</select>
						   	<br>
						   	<th>방법별</th>
						   		<select name="s_no"  id="s_no">
						        	<option value="cook41" selected>전체</option>
						          	<option value="cook42">볶음</option>
						          	<option value="cook43">끓이기</option>
						          	<option value="cook44">부침</option>
						          	<option value="cook45">조림</option>
						          	<option value="cook46">무침</option>
						          	<option value="cook47">비빔</option>
						          	<option value="cook48">찜</option>
						          	<option value="cook49">튀김</option>
						          	<option value="cook50">삶기</option>
						          	<option value="cook51">굽기</option>
						          	<option value="cook52">회</option>
						          	<option value="cook53">기타</option>
						   		</select>
						</div>
						<input type="submit" value="검색"  class="btn btn-outline-info"/>
					</div>
				</div>				
            </div>
            </form>

            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        		<c:forEach var="dto" items="${list}">
					<div class="col mb-5">
						<div class="card h-100">
							<img class="card-img-top" src="../storage/${dto.r_photo}" width="100%" height="40%">
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">${dto.r_name}</h5>
								</div>
							</div>

							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="d-flex align-items-center">
									<img class="rounded-circle me-3" src="../storage/${dto.m_img}" width="40px" height="40px"/>
									<div class="small">                                
										<div class="fw-bold">${dto.m_nick}</div>
										<div class="text-muted">${dto.h_star}</div>
									</div>
								</div>
							</div>
							<a class="btn btn-outline-success mt-auto" href="reciperead.do?r_code=${dto.r_code}">상세보기</a>
						</div>
					</div>
				</c:forEach>
			</div>
		<br>
	</div>

<script>
function logincheck() {
	 if (${sessionScope.s_m_mail==guest}) {            
		 alert("로그인을 해주세요!");	        
	    } else {	    	
	    	location.href="insert.do";	    	
	    }
}
</script>

</body>
<%@ include file="../footer.jsp" %>
