<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>index</title>     
      
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        
        <!-- -->
        <link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all">
        <script src="js/jquery-1.7.2.min.js"></script>
        <!--[if lt IE 9]><script src="js/modernizr.custom.js"></script><![endif]-->
        <script src="js/jquery.flexslider-min.js"></script>
        <script src="js/functions.js"></script>
        
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container px-5">
                    <a class="navbar-brand" href="home.do">모두의 레시피</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item"><a class="nav-link" href="index.do">추천</a></li>
                            <li class="nav-item"><a class="nav-link" href="about.html">분류</a></li>
                            <li class="nav-item"><a class="nav-link" href="contact.html">랭킹</a></li>
                            <li class="nav-item"><a class="nav-link" href="class/classlist.do">클래스</a></li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">마이페이지</a>
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
                               <li><a class="dropdown-item" href="member/login.do">로그인/로그아웃</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">레시피</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">요리후기</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">강의평</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">클래스</a></li>
                                    <li><a class="dropdown-item" href="member/modify.do?m_code=${s_m_code}">회원정보 수정</a></li>
                                    <li><a class="dropdown-item" href="member/delete.do">회원탈퇴</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Header-->
            <header class="bg-dark py-0">
                <div class="container px-5">
                    <div class="row gx-0 align-items-center justify-content-center">
                        <div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-3 text-center text-xl-start">
                                <h1 class="display-5 fw-bolder text-white mb-2"></h1>
                                <form class="d-flex">
                                    <input class="form-control me-sm-2" type="text"
                                       placeholder="Search">
                                    <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                                 </form>
                            </div>
                        </div>
                    </div>
                </div>             
            </header>

        <!-- 테스트 시작 -->   
        <div class="shell">
            <div class="slider-holder"> <span class="slider-shadow"></span>
              <div class="slider flexslider" style="overflow: hidden;">
                <ul class="slides" style="transition-duration: 0s; width: 1000%; transform: translate3d(-900px, 0px, 0px);">
                
            	<c:forEach var="dto" items="${dto}">
                <li class="clone" style="width: 900px; float: left; display: block;"> <img src="/storage/${dto.l_photo}" alt="">
                    <div class="slide-cnt">
                      <h3>${dto.l_title}</h3>
                      <p>${dto.l_contents}</p>
                      <a href="class/read.do?l_code=${dto.l_code}" class="slider-btn">강의 듣기</a> </div>
                  </li>
                 </c:forEach>
                
          
                  
                  
                  </ul>
              </div>
            <ul class="flex-direction-nav"><li><a class="prev" href="#">Previous</a></li><li><a class="next" href="#">Next</a></li></ul></div>
          </div>
<!-- ----------------------------------------------------------------------------------------------------- -->
		  <br>
		  <br>
		  <br>
		  <hr>
		  <div class="container px-5 my-5">
              <h2 class="fw-bolder fs-5 mb-4">쉐프소개    <a href="#" class="btn btn-outline-success">More Chef</a>                 
                   </h2>
              <div class="row gx-5 row-cols-1 row-cols-sm-2 row-cols-xl-6 justify-content-center">
                  <a href="#!"><div class="col mb-5 mb-5 mb-xl-0">
                      <div class="text-center">
                          <img class="img-fluid rounded-circle mb-4 px-4" src="images/k5.png" width="130px" height="130px" alt="..." />
                          <h5 class="fw-bolder">닉네임</h5>
                      </div>
                  </div></a>
                  <div class="col mb-5 mb-5 mb-xl-0">
                     <a href="#!"><div class="text-center">
                          <img class="img-fluid rounded-circle mb-4 px-4" src="images/k5.png" width="130px" height="130px" alt="..." />
                          <h5 class="fw-bolder">닉네임</h5>
                      </div></a>
                  </div>
                  <div class="col mb-5 mb-5 mb-sm-0">
                     <a href="#!"><div class="text-center">
                          <img class="img-fluid rounded-circle mb-4 px-4" src="images/k5.png" width="130px" height="130px" alt="..." />
                          <h5 class="fw-bolder">닉네임</h5>
                      </div></a>
                  </div>
                  <div class="col mb-5">
                     <a href="#!"><div class="text-center">
                          <img class="img-fluid rounded-circle mb-4 px-4" src="images/k5.png" width="130px" height="130px" alt="..." />
                          <h5 class="fw-bolder">닉네임</h5>
                      </div></a>
                  </div>
                  <div class="col mb-5">
                     <a href="#!"><div class="text-center">
                          <img class="img-fluid rounded-circle mb-4 px-4" src="images/k5.png" width="130px" height="130px" alt="..." />
                          <h5 class="fw-bolder">닉네임</h5>
                      </div></a>
                  </div>
              </div>
        </div>
        
		<br>
        <div class="container px-5">
            <h2 class="fw-bolder fs-5 mb-4">소고기 레시피 베스트    <a href="#" class="btn btn-outline-success">More Recipe</a></h2>
            <div class="row gx-5">
                <div class="col-lg-4 mb-5">
                    <div class="card h-100 shadow border-0">
                        <img src="images/recipe.jpg" alt="" />
                        <div class="card-body p-4">
                            <a class="text-decoration-none link-dark stretched-link" href="#!"><div class="h5 card-title mb-3">레시피명</div></a>
                        </div>
                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                            <div class="d-flex align-items-end justify-content-between">
                                <div class="d-flex align-items-center">
                                     <img class="rounded-circle me-3" src="images/k5.png" width="40px" height="40px" alt="" />
                                    <div class="small">
                                        <div class="fw-bold">닉네임</div>
                                    </div>
                                </div> 
                            </div>
                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">조회수</div>
                            	<p class="card-text mb-0">별점</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-5">
                    <div class="card h-100 shadow border-0">
                        <img class="card-img-top" src="images/R1.jpg" alt="..." />
                        <div class="card-body p-4">
                            <a class="text-decoration-none link-dark stretched-link" href="#!"><div class="h5 card-title mb-3">레시피명</div></a>
                        </div>
                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                            <div class="d-flex align-items-end justify-content-between">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle me-3" src="images/k7.png" width="40px" height="40px" alt="..." />
                                    <div class="small">
                                        <div class="fw-bold">닉네임</div>
                                    </div>
                                </div>
                            </div>
                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">조회수</div>
                            <p class="card-text mb-0">별점</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-5">
                    <div class="card h-100 shadow border-0">
                        <img class="card-img-top" src="images/R2.jpg" alt="..." />
                        <div class="card-body p-4">
                            <a class="text-decoration-none link-dark stretched-link" href="#!"><div class="h5 card-title mb-3">레시피명</div></a>
                        </div>
                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                            <div class="d-flex align-items-end justify-content-between">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle me-3" src="images/k6.png" width="40px" height="40px" alt="..." />
                                    <div class="small">
                                        <div class="fw-bold">닉네임</div> 
                                    </div>
                                </div>
                            </div>
                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">조회수</div>
                            <p class="card-text mb-0">별점</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container px-5">
            <h2 class="fw-bolder fs-5 mb-4">돼지고기 레시피 베스트    <a href="#" class="btn btn-outline-success">More Recipe</a></h2>
            <div class="row gx-5">
                <div class="col-lg-4 mb-5">
                    <div class="card h-100 shadow border-0">
                        <img src="images/recipe.jpg" alt="" />
                        <div class="card-body p-4">
                            <a class="text-decoration-none link-dark stretched-link" href="#!"><div class="h5 card-title mb-3">레시피명</div></a>
                        </div>
                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                            <div class="d-flex align-items-end justify-content-between">
                                <div class="d-flex align-items-center">
                                     <img class="rounded-circle me-3" src="images/k5.png" width="40px" height="40px" alt="" />
                                    <div class="small">
                                        <div class="fw-bold">닉네임</div>
                                    </div>
                                </div> 
                            </div>
                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">조회수</div>
                            	<p class="card-text mb-0">별점</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-5">
                    <div class="card h-100 shadow border-0">
                        <img class="card-img-top" src="images/R1.jpg" alt="..." />
                        <div class="card-body p-4">
                            <a class="text-decoration-none link-dark stretched-link" href="#!"><div class="h5 card-title mb-3">레시피명</div></a>
                        </div>
                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                            <div class="d-flex align-items-end justify-content-between">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle me-3" src="images/k7.png" width="40px" height="40px" alt="..." />
                                    <div class="small">
                                        <div class="fw-bold">닉네임</div>
                                    </div>
                                </div>
                            </div>
                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">조회수</div>
                            <p class="card-text mb-0">별점</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-5">
                    <div class="card h-100 shadow border-0">
                        <img class="card-img-top" src="images/R2.jpg" alt="..." />
                        <div class="card-body p-4">
                            <a class="text-decoration-none link-dark stretched-link" href="#!"><div class="h5 card-title mb-3">레시피명</div></a>
                        </div>
                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                            <div class="d-flex align-items-end justify-content-between">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle me-3" src="images/k6.png" width="40px" height="40px" alt="..." />
                                    <div class="small">
                                        <div class="fw-bold">닉네임</div> 
                                    </div>
                                </div>
                            </div>
                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">조회수</div>
                            <p class="card-text mb-0">별점</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container px-5">
            <h2 class="fw-bolder fs-5 mb-4">닭고기 레시피 베스트    <a href="#" class="btn btn-outline-success">More Recipe</a></h2>
            <div class="row gx-5">
                <div class="col-lg-4 mb-5">
                    <div class="card h-100 shadow border-0">
                        <img src="images/recipe.jpg" alt="" />
                        <div class="card-body p-4">
                            <a class="text-decoration-none link-dark stretched-link" href="#!"><div class="h5 card-title mb-3">레시피명</div></a>
                        </div>
                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                            <div class="d-flex align-items-end justify-content-between">
                                <div class="d-flex align-items-center">
                                     <img class="rounded-circle me-3" src="images/k5.png" width="40px" height="40px" alt="" />
                                    <div class="small">
                                        <div class="fw-bold">닉네임</div>
                                    </div>
                                </div> 
                            </div>
                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">조회수</div>
                            	<p class="card-text mb-0">별점</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-5">
                    <div class="card h-100 shadow border-0">
                        <img class="card-img-top" src="images/R1.jpg" alt="..." />
                        <div class="card-body p-4">
                            <a class="text-decoration-none link-dark stretched-link" href="#!"><div class="h5 card-title mb-3">레시피명</div></a>
                        </div>
                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                            <div class="d-flex align-items-end justify-content-between">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle me-3" src="images/k7.png" width="40px" height="40px" alt="..." />
                                    <div class="small">
                                        <div class="fw-bold">닉네임</div>
                                    </div>
                                </div>
                            </div>
                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">조회수</div>
                            <p class="card-text mb-0">별점</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-5">
                    <div class="card h-100 shadow border-0">
                        <img class="card-img-top" src="images/R2.jpg" alt="..." />
                        <div class="card-body p-4">
                            <a class="text-decoration-none link-dark stretched-link" href="#!"><div class="h5 card-title mb-3">레시피명</div></a>
                        </div>
                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                            <div class="d-flex align-items-end justify-content-between">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle me-3" src="images/k6.png" width="40px" height="40px" alt="..." />
                                    <div class="small">
                                        <div class="fw-bold">닉네임</div> 
                                    </div>
                                </div>
                            </div>
                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">조회수</div>
                            <p class="card-text mb-0">별점</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
            
        </main>
        <!-- Footer-->
        <footer class="bg-dark py-4 mt-auto">
            <div class="container px-5">
                <div class="row align-items-center justify-content-between flex-column flex-sm-row">
                    <div class="col-auto"><div class="small m-0 text-white">Copyright &copy; Your Website 2021</div></div>
                    <div class="col-auto">
                        <a class="link-light small" href="#!">Privacy</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="#!">Terms</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="#!">Contact</a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>