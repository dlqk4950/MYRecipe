<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../member/auth.jsp"%>
<%@ include file="../header.jsp"%>

<h3>레시피 등록</h3>

<form name="createfrm" method="post" action="recipelist.do" enctype="multipart/form-data" onsubmit="return createCheck()">
	<input type="hidden" name="m_code" value="${s_m_code}">
	<table class="table table-hover">
		<tr>
			<th class="success">레시피 제목</th>
			<td style="text-align: left"><input type="text" name="r_name"
				id="r_name" size="30"></td>
		</tr>
		
		<tr>
			<th class="success">요리소개</th>
			<td style="text-align: left"><textarea rows="5"  name="r_intro"
				id="r_intro"></textarea></td>
		</tr>
		
		<tr>
			<th class="success">동영상</th>
			<td style="text-align: left"><input type="text"  name="r_video"
				id="r_video" size="30"></td>
		</tr>

		<tr>
			<th class="success">카테고리</th>
			
			<td>
			<select id="j_no" name="j_no" size="1">
				<option>- 종류별 -</option>
				<option value="cook2">밑반찬</option>
				<option value="cook3" >메인반찬</option>
				<option value="cook4">국/탕/찌개</option>
				<option value="cook5">면/만두</option>
				<option value="cook6">밥/죽/떡</option>
				<option value="cook7">디저트</option>
				<option value="cook8">양식</option>
				<option value="cook9">차/음료/술</option>
				<option value="cook10">기타</option>
			</select>

			<select id="s_no" name="s_no" size="1">
				<option>- 방법별 -</option>
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

			<select id="g_no" name="g_no" size="1">
				<option>- 재료별 -</option>
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
			</td>
		</tr>

		<tr>
			<th class="success">요리정보</th>
			
			<td>
			<select id="ci_per" name="ci_per" size="1">
				<option>- 인원 -</option>
				<option value="per1">1인분</option>
				<option value="per2">2인분</option>
				<option value="per3">3인분</option>
				<option value="per4">4인분</option>
				<option value="per5">5인분</option>
				<option value="per6">6인분이상</option>
			</select>

			<select id="ci_time" name="ci_time" size="1">
				<option>- 시간 -</option>
				<option value="time1">5분이내</option>
				<option value="time2">10분이내</option>
				<option value="time3">15분이내</option>
				<option value="time4">20분이내</option>
				<option value="time5">30분이내</option>
				<option value="time6">60분이내</option>
				<option value="time7">90분이내</option>
				<option value="time8">2시간이내</option>
				<option value="time9">2시간이상</option>
			</select>

			<select id="ci_diff" name="ci_diff" size="1">
				<option>- 난이도 -</option>
				<option value="diff1">아무나</option>
				<option value="diff2">초급</option>
				<option value="diff3">중급</option>
				<option value="diff4">고급</option>
				<option value="diff5">신의경지</option>
			</select>
			</td>
		</tr>

		<tr>
			<th class="success">재료</th>
			<td>
				<input type="text" name="addText" id="addText" size="30">
				<input type="text" name="addText" id="addText" size="30"> 
				<input onclick="frmCheck();" type="button" value="삭제" name="button" />
				<input onclick="insRow()" style="CURSOR: pointer" type="button" value=" + 추가 " name="addButton" />
			</td>
		</tr>
		
		<tr>
			<th class="success">요리순서</th>
			<td>
				<textarea rows="5" name="order" id="order"></textarea>
				<input type="file" name="posterMF" id="posterMF">
				<input onclick="frmCheck();" type="button" value="삭제" name="button" />
				<input onclick="insRow()" style="CURSOR: pointer" type="button" value=" + 추가 " name="addButton" />
			</td>
		</tr>

		<tr>
			<th class="success">요리완성사진</th>
			<td style="text-align: left">
			<input type="file" name="posterMF" id="posterMF"></td>
		</tr>

		<tr>
			<th class="success">요리팁</th>
			<td style="text-align: left"><textarea rows="5"  name="r_tip"
				id="r_tip"></textarea></td>
		</tr>

		<tr>
			<td colspan="2">
				<input type="submit" value="레시피 등록" class="btn btn-success">
				<input type="reset" value="취소" class="btn btn-danger">
			</td>
		</tr>

	</table>
</form>
<%@ include file="../footer.jsp"%>
