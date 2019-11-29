package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java_bean.java_bean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class modify_servlet extends HttpServlet implements Serializable{
	   public void init(ServletConfig config) throws ServletException{
		      super.init(config);
		   }
		   public void doPost(HttpServletRequest request,HttpServletResponse response)
		               throws ServletException,IOException{
		      java_bean resultBean=null;
		      try{  resultBean=(java_bean)request.getAttribute("resultBean");
		            if(resultBean==null){
		                resultBean=new java_bean(); //创建Javabean对象
		                request.setAttribute("resultBean",resultBean);
		            }
		      }
		      catch(Exception exp){
		            resultBean=new java_bean();  //创建Javabean对象
		            request.setAttribute("resultBean",resultBean);
		      } 
		     try{  Class.forName("com.mysql.jdbc.Driver");
		     }
		     catch(Exception e){} 
		     
		     String dataBase = request.getParameter("dataBase");
		     String tableName = request.getParameter("tableName"); 
		     String UserName = request.getParameter("UserName");
		     String Password = request.getParameter("Pass");
		    
		     Connection con;
		     Statement sql; 
		     ResultSet rs;
		     try{ 
		    	  String user = "root";
		    	  String password = "";
		          String uri="jdbc:mysql://127.0.0.1/"+dataBase;
		          con=DriverManager.getConnection(uri,user,password);
		          sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                                 ResultSet.CONCUR_READ_ONLY);
		          String condition1 ="update "+tableName+" set PassWord="+Password+" where YourName = '"+UserName+"';";
		          sql.execute(condition1);
		          String condition ="SELECT PassWord FROM "+tableName+" where YourName = "+UserName;
		          rs=sql.executeQuery(condition);
		          rs.next();
		          if(Password.equals(rs.getString(1))){
		        	  response.setContentType("text/html; charset=UTF-8");   
		        	  PrintWriter out = response.getWriter();
		        	  out.println("<html><body>");
		        	  out.println("<h2>修改成功，请选择以下选项</h2>");
		        	  out.println("<a href =index.jsp>返回登录界面</a>");
		        	  out.println("<a href =reg.jsp>进入注册界面</a>");
		        	  out.println("<a href =modify.jsp>进入修改密码界面</a>");
		          }
		          else{
		        	  response.setContentType("text/html;charset=GB2312");
		        	  PrintWriter out = response.getWriter();
		        	  out.println("<html><body>");
		        	  out.println("<h2>修改失败失败，请选择以下选项</h2>");
		        	  out.println("<a href =index.jsp>返回登录界面</a>");
		        	  out.println("<a href =reg.jsp>进入注册界面</a>");
		        	  out.println("<a href =modify.jsp>进入修改密码界面</a>");
		          }
		          
		     }
		     catch(SQLException e){
		          System.out.println(e);
		     }  
		   }
		   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
		           throws ServletException,IOException{
		       doPost(request,response);
		   }
		}
