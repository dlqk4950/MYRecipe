/**
 *  myscript.js
 */
 
function memberCheck(){ //ㅣ회원가입 유효성 검사
	
	//1)이메일 7글자 이상 인지?
		var m_mail=document.getElementById("m_mail").value; 
		m_mail=m_mail.trim(); //좌우 공백 제거하기
		if(m_mail.length<7){
			alert("이메일 7글자 이상 입력해 주세요");
			document.getElementById("m_mail").focus();
		return false; //전송하지 않음
		}//if end
		
  	//2)비밀번호 5~10글자 인지?
	  	var m_passwd=document.getElementById("m_passwd").value;
		m_passwd=m_passwd.trim();
		if (!(m_passwd.length>=5 && m_passwd.length<=10)){
			alert("비밀번호 5~10글자이내 입력해 주세요")
			document.getElementById("m_passwd").focus();
			return false;
		}//if end

  	//3)비밀번호와 비밀번호확인이 서로 일치하는지?
		var m_repasswd=document.getElementById("m_repasswd").value;
		m_repasswd=m_repasswd.trim();
		if (m_passwd!=m_repasswd){
			alert("비밀번호 2개를 똑같이 입력해주세요")
			document.getElementById("m_repasswd").focus();
			return false;
		}//if end		
			
  	//4)닉네임 두글자 이상 인지?
  		var m_nick=document.getElementById("m_nick").value; 
		m_nick=m_nick.trim(); //좌우 공백 제거하기
		if(m_nick.length<2){
			alert("닉네임 2글자 이상 입력해 주세요");
			document.getElementById("m_nick").focus();
		return false; //전송하지 않음
		}//if end
		
	 //5)생년월일 선택했는지?	
		var m_birth=document.getElementById("m_birth").value; 
		if(m_birth.length<1){
			alert("생년월일 선택해 주세요");
		return false; //전송하지 않음
		}//if end	
				
		return true;

}//memberCheck() end
			
function send(){								
	var checkID=$.cookie("checkID");								
	if(checkID=="PASS"){
		return true;
	}else{
		$("#panel").css("color", "green");
		$("#panel").text("이메일 중복확인 해주세요");
		$("#m_mail").focus();
		return false;
	}//if end
	
}//send() end			


function loginCheck(){
	//로그인 유효성검사(이메일,비번)
	//1)이메일 7글자이내인지 검사
	var m_mail=document.getElementById("m_mail").value;
	m_mail=m_mail.trim();
	if (m_mail.length<7){
		alert("이메일 확인해주세요")
		document.getElementById("m_mail").focus();
		return false;
	}//if end

	//2)비밀번호 5~10글자이내인지 검사
	var m_passwd=document.getElementById("m_passwd").value;
	m_passwd=m_passwd.trim();
	if (!(m_passwd.length>=5 && m_passwd.length<=10)){
		alert("비밀번호 확인해 주세요")
		document.getElementById("m_passwd").focus();
		return false;
	}//if end
	
	return true;
}//loginCheck()end

function deleteCheck(){ //회원탈퇴
	var m_passwd=document.getElementById("m_passwd").value;
		m_passwd=m_passwd.trim();
		if (!(m_passwd.length>=5 && m_passwd.length<=15)){
			alert("비밀번호가 일치하지 않습니다")
			document.getElementById("m_passwd").focus();
			return false;
		}//if end
		var message="회원탈퇴 됩니다\n계속 진행할까요?";
		if(confirm(message)){ //확인true, 취소false
			return true; //서버로 전송
		}else{
			return false;
		}//if end
}//deleteCheck()

function modifyCheck(){ //ㅣ회원가입 유효성 검사
	
  	//1)비밀번호 5~10글자 인지?
	  	var m_passwd=document.getElementById("m_passwd").value;
		m_passwd=m_passwd.trim();
		if (!(m_passwd.length>=5 && m_passwd.length<=10)){
			alert("비밀번호 5~10글자이내 입력해 주세요")
			document.getElementById("m_passwd").focus();
			return false;
		}//if end

  	//2)비밀번호와 비밀번호확인이 서로 일치하는지?
		var m_repasswd=document.getElementById("m_repasswd").value;
		m_repasswd=m_repasswd.trim();
		if (m_passwd!=m_repasswd){
			alert("비밀번호 2개를 똑같이 입력해주세요")
			document.getElementById("m_repasswd").focus();
			return false;
		}//if end		
			
  	//3)닉네임 두글자 이상 인지?
  		var m_nick=document.getElementById("m_nick").value; 
		m_nick=m_nick.trim(); //좌우 공백 제거하기
		if(m_nick.length<2){
			alert("닉네임 2글자 이상 입력해 주세요");
			document.getElementById("m_nick").focus();
		return false; //전송하지 않음
		}//if end
				
		return true;

}//modifyCheck() end

