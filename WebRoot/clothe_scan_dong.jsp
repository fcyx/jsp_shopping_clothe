<%@ page language="java" import="java.util.*,java_bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'clote_scan.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-theme.css">
    <script src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </head>
  
  <body  bgcolor= #DEEFF9>
   
 <div class="dao">
    	<div class="container">
        	<div class="row">
                <div  class="col-lg-1">
                    <img width="50" height="40" style="margin-left:10px;" src="nanclotherImg/dao1_1.png">
                </div>
                <div  class="col-lg-4">
                    <h4><a href="#">切换账号</a>|<a href="#">注册</a></h4>
                
                </div>
                <div class="col-lg-2"></div>
            </div>
    	</div>
    
    </div>
    <div class="container">
    <div class="row">
    	<div class="col-lg-12">
        	<div id="myCarousel" class="carousel slide">
	<!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                    <li data-target="#myCarousel" data-slide-to="3"></li>
                </ol>   
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="nanclotherImg/nan1_1.jpg" alt="First slide">
                    </div>
                    <div class="item">
                        <img src="nanclotherImg/nan1_2.jpg" alt="Second slide">
                    </div>
                    <div class="item">
                        <img src="nanclotherImg/nan1_3.jpg" alt="Third slide">
                    </div>
                    <div class="item">
                        <img src="nanclotherImg/nan1_4.jpg" alt="Third slide">
                    </div>
                </div>
                <!-- 轮播（Carousel）导航 -->
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div> 
        </div>
    
    </div>
	<div class="row">
    	<div class="col-lg-12">
        	<ul class="nav nav-pills nav-justified">
                <li><a href="clothe_scan.jsp">全 部</a></li>
                <li ><a href="chun?dataBase=people_information&tableName=clothe_information">春装</a></li>
                <li><a href="xia?dataBase=people_information&tableName=clothe_information">夏装</a></li>
                <li><a href="qiu?dataBase=people_information&tableName=clothe_information">秋装</a></li>
                <li class="active"><a href="dong?dataBase=people_information&tableName=clothe_information">冬装</a></li>
                <li><a href="gu?dataBase=people_information&tableName=clothe_information">古装汉服</a></li>
            </ul>
        </div>
    </div>   
   	<div class="row">
   	 <%   ArrayList<clothe_bean> clother=(ArrayList)request.getAttribute("clother_dong");
   if(clother!=null){
      for(int i=0;i<clother.size();i++){%>
    
    	<div class="col-lg-3" style="margin-top:10px;">
        	<img width="280px;" height="380px;" src="<%=clother.get(i).getClotheImg() %>"> 
        	<div style="height:50px;"><h4><%= clother.get(i).getClotheName() %></h4></div>
        	<div style="height:30px;"><h3 style="color:#900">￥<%= clother.get(i).getClothePrice() %></h3></div>
        	<div style="height:50px;"><p><%=clother.get(i).getClothetype() %></p></div>
        </div>
         <% }
         }
  %>
    <div>
   
   </div>
  </body>
</html>
