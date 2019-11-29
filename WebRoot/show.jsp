<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:useBean id="resultBean" 
     class="java_bean.java_bean" scope="request"/>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
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
    <script src="js/jquery.min-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </head>
  
  <body bgcolor= #DEEFF9><font size=6>
<center>
	<a href =index.jsp>返回登录界面</a>
	<a href =reg.jsp>进入注册界面</a>
	<a href =modify.jsp>进入修改密码界面</a>
  <table border=1>
  <%  String []columnName=resultBean.getTableZidun();
  %>
      <tr>
  <%  for(String s:columnName) {
  %>    <th><%= s %></th>
  <%  }
  %>  </tr>
  <%  String [][] record = resultBean.getTableRecord();
      for(int i=0;i<record.length;i++) {
  %>    <tr>
  <%     for(int j=0;j<record[i].length;j++) {
  %>        <td><%= record[i][j] %> </td>
  <%     }
  			
  %>    <td><a href="delete?dataBase=people_information&tableName=reg&id=<%= record[i][0] %>">删除</a></td>
  
  </tr>
  <%  }
  %>
  </table>
</font>
</body>
</html>
