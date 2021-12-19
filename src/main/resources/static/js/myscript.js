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

function classCheck(){			
			
	var l_title=document.getElementById("l_title").value;
	l_title=l_title.trim();                               
	if(l_title.length<2){
	    alert("제목 2글자 이상 입력해 주세요");
    	document.getElementById("l_title").focus();     
    	return false;                                 
	}//if end
	var l_contents=document.getElementById("l_contents").value;
	l_contents=l_contents.trim();                               
	if(l_contents.length<2){
	    alert("제목 2글자 이상 입력해 주세요");
    	document.getElementById("l_contents").focus();     
    	return false;                                 
	}//if end
	//첨부파일
	//확장명 이미지 파일(png, jpg, gif 인지 확인하시오)	
	var posterMF=document.getElementById("posterMF").value;
	posterMF=posterMF.trim();
	//확장자명 확인
	if(posterMF.length==0){
		alert("첨부파일 선택하시오");
		return false;
	}else{
		var dot=posterMF.lastIndexOf(".");
		var ext=posterMF.substr(dot+1);
		ext=ext.toLowerCase();
		if(!(ext=="png"||ext=="jpg"||ext=="gif")){					
			alert("이미지파일만 업로드 가능합니다");
			return false;
		}
	}
	//확장명 영상 파일(mp4, avi, mov 인지 확인하시오)
	var filenameMF=document.getElementById("filenameMF").value;
	filenameMF=filenameMF.trim();
	//확장자명 확인
	if(filenameMF.length==0){
		alert("첨부파일 선택하시오");
		return false;
	}else{
		var dot=filenameMF.lastIndexOf(".");
		var ext1=filenameMF.substr(dot+1);
		ext1=ext1.toLowerCase();
		if(ext1=="mp4"||ext1=="avi"||ext1=="mov"||ext1=="mkv"||ext1=="wmv"){
			return true;
			}else{
			alert("영상파일만 업로드 가능합니다");
			return false;
		}
	}
}//Check() end
