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

