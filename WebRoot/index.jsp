<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body  style="background-color:#F2EEF0;"><center>
    <table border=1 style=" margin-top:350px;font-size:24;">
    	<form action="login?dataBase=people_information&tableName=reg" method=post>
    		<tr><td>用户名：</td><td><input type="text" name = "UserName"/></td></tr>
    		<tr><td>密     码：</td><td><input type="password" name = "PassWord"/></td></tr>
    		<tr><td><input style="font-size:22px;" type="submit" value="登录"></td>
    	</form>
    		<td><center><a href="reg.jsp"><input  style="font-size:22px;" type="button"  value = "注册"/></a></center></td></tr>
    </table>
    </center>
  </body>
</html>
