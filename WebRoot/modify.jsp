<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body font-size = 3><center>
  <h3>修改密码界面</h3>
   <table border=0>
    	<form action="modify?dataBase=people_information&tableName=reg" method=post>
    		<tr><td>请输入用户名：</td><td><input type="text" name = "UserName"/></td></tr>
    		<tr><td>请输入原密码：</td><td><input type="password" name = "PassWord"/></td></tr>
    		<tr><td>请输入新密码：</td><td><input type="password" name = "Pass"/></td></tr>
    		<tr><td><input type="submit" value="修改"></td>
    	</form>
    		<td><center><input type="button" value = "重置"/></center></td></tr>
    </table>
    </center>
  </body>
</html>
