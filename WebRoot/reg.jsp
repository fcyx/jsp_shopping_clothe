<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%request.setCharacterEncoding("utf-8");%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
  	<h2>请完成注册页面所要填写的内容</h2>
    <table border=1>
    	<form action="reg?dataBase=people_information&tableName=reg" method=post>
    		<tr><td>用户名：</td><td><input type="text" name ="UserName"/></td></tr>
    		<tr><td>密    码：</td><td><input type="password" name ="PassWord"/></td></tr>
    		<tr><td>姓    名：</td><td><input type="text" name = "Name"/></td></tr>
    		<tr><td>性    别：</td><td><input type="text" name = "sex"/></td></tr>
    		<tr><td>地    址：</td><td><input type="text" name = "address"/></td></tr>
    		<tr><td>电    话：</td><td><input type="text" name = "Tel"/></td></tr>
    		<tr><td>邮政编码：</td><td><input type="text" name = "youzhen"/></td></tr>
    		<tr><td>邮    箱：</td><td><input type="text" name = "post"/></td></tr>
    		<tr><td>注册时间：</td><td><input type="text" name = "RegisterTIme"/></td></tr>
    		<tr><td>爱    好：</td><td><input type="text" name = "hobby"/></td></tr>
    		<tr><td>出生时间：</td><td><input type="text" name = "BirthTime"/></td></tr>
    		<tr><td><input type="submit" value="注册"></td>
    	</form>
    		
    </table>
    </center>
  </body>
</html>
