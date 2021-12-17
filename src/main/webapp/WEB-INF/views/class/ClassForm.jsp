<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../header.jsp"%>
<!--본문시작 -->
<h3>강의 등록</h3>
<p>
	<a href="classlist.do">[목록]</a>
</p>

<form name="classfrm" method="post" action="create.do" enctype="multipart/form-data" onsubmit="return classCheck()">
	<input type="hidden" name="m_code" value="${m_code}">
	<table class="table table-hover">
		<tr>
			<th class="success">강의명</th>
			<td style="text-align: left"><input type="text" name="l_title"
				id="l_title" size="30" ></td>
		</tr>
		
		<tr>
			<th class="success">강의소개</th>
			<td style="text-align: left"><textarea rows="5"  name="l_contents" id="l_contents"></textarea></td>
		</tr>
		<tr>
			<th class="success">요리이미지</th>
			<td style="text-align: left">
			<input type="file" name="posterMF" id="posterMF"></td>
		</tr>
		<tr>
			<th class="success">강의영상</th>
			<td style="text-align: left">
				<input type="file" name="filenameMF" id="filenameMF">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="강의 작성" class="btn btn-success">
				<input type="reset" value="취소" class="btn btn-danger">
			</td>
		</tr>
	</table>
</form>
<!--본문 끝 -->
<%@ include file="../footer.jsp"%>
