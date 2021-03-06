<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        
        <title>index</title>    
      
        
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />
        
        <!-- -->        
        <link rel="stylesheet" href="../css/style.css" type="text/css" media="all">
        <link rel="stylesheet" href="../css/flexslider.css" type="text/css" media="all">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
		<script src="../js/jquery-1.7.2.min.js"></script>
        <script src="../js/jquery.cookie.js "></script>
        
        <!--[if lt IE 9]><script src="js/modernizr.custom.js"></script><![endif]-->
        <script src="../js/jquery.flexslider-min.js"></script>
        <script src="../js/functions.js"></script>
        <script src="../js/myscript.js"></script>
        <script src="..js/scripts.js"></script>
        
 
                
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container px-5">
                    <a class="navbar-brand" href="../home.do">모두의 레시피</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item"><a class="nav-link" href="../index.do">추천</a></li>
                            <li class="nav-item"><a class="nav-link" href="../recipe/recipelist.do">분류</a></li>
                            <li class="nav-item"><a class="nav-link" href="contact.html">랭킹</a></li>
                           <li class="nav-item"><a class="nav-link" href="../class/classlist.do">클래스</a></li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">마이페이지</a>
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
                               <li><a class="dropdown-item" href="../member/login.do">로그인/로그아웃</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">레시피</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">요리후기</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">강의평</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">클래스</a></li>                                    
                                    <li><a class="dropdown-item" href="/class/subscribe.do?m_code=${s_m_code}">구독 목록</a></li>
                                </ul>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Header-->
            <header class="bg-dark py-10">
                <div class="container px-5">
                    <div class="row gx-0 align-items-center justify-content-center">
                        <div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-3 text-center text-xl-start">
                                <h1 class="display-5 fw-bolder text-white mb-2"></h1>
                                <form class="d-flex" action="serchList.do" onsubmit="return searchCheck()">
                                    <input class="form-control me-sm-2" type="text"
                                       placeholder="Search">
                                    <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                                 </form>                                 
                
                            </div>
                        </div>
                    </div>
                </div>             
            </header>
