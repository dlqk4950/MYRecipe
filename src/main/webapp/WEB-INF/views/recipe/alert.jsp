<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alertPage</title>
</head>
<body>	
	<script type="text/javascript">
		var message = "${msg}";
		var url = "?r_code=${r_code}"; //만일 로그인 실패했을 경우 m_code변수에 어떤 값이 들어가면 되나요?
		alert(message);		           //guest값을 넣고싶습니다
		document.location.href = 'reciperead.do'+url;		
	</script>
</body>
</html>