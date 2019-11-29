package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java_bean.java_bean;

public class reg_servlet  extends HttpServlet{
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
		     request.setCharacterEncoding("utf-8");
		     String dataBase = request.getParameter("dataBase");
		     String tableName = request.getParameter("tableName");
		     String YourName=request.getParameter("UserName");
		     String PassWord=request.getParameter("PassWord");
		     String Name=request.getParameter("Name");
		     String sex=request.getParameter("sex");
		     String address=request.getParameter("address");
		     String Tel=request.getParameter("Tel");
		     String youzhen=request.getParameter("youzhen");
		     String post=request.getParameter("post");
		     String RegisterTIme=request.getParameter("RegisterTIme");
		     String hobby=request.getParameter("hobby");
		     String BirthTime=request.getParameter("BirthTime");
		     String[] a = RegisterTIme.split("/");
		     String b="";
		     String[] c = BirthTime.split("/");
		     String d="";
		     for(int i=0;i<a.length;i++){
		    	 if(i!=a.length-1){
		    		 b = b + a[i] + "-";
		    	 }
		    	 else 
		    		 b = b + a[i];
		     }
		     System.out.println("-------------->"+b);
		     for(int i=0;i<c.length;i++){
		    	 if(i!=c.length-1){
		    		 d = d + c[i] + "-";
		    	 }
		    	 else
		    		 d = d + c[i];
		     }
		     String condition = "INSERT INTO "+tableName+"(YourName,PassWord,Name,sex,address,Tel,youzhen,post,RegisterTIme,hobby,BirthTime)"+" VALUES('"+YourName+"','"+PassWord+"','"
		    		 				+Name+"','"+sex+"','"+address+"','"+Tel+"','"+youzhen+"','"+post+"','"
		    		 			+b+"','"+hobby+"','"+d+"');";
		     Connection con;
		     Statement sql; 
		     ResultSet rs;
		     try{ 
		          String uri="jdbc:mysql://127.0.0.1/"+dataBase+"?"+
		                      "user=root&password=&characterEncoding=utf-8";
		          con=DriverManager.getConnection(uri);
		          sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                                 ResultSet.CONCUR_READ_ONLY);
		          sql.executeUpdate(condition);
		          
		          
		          response.setContentType("text/html; charset=UTF-8");   
	        	  PrintWriter out = response.getWriter();
	        	  out.println("<html ><body><center>");
	        	  out.println("<h2>登陆成功，请选择以下选项</h2>");
	        	  out.println("<a href =index.jsp>返回登录界面</a>");
	        	  out.println("<a href =reg.jsp>进入注册界面</a>");
	        	  out.println("<a href =modify.jsp>进入修改密码界面</a></center>");
		          RequestDispatcher dispatcher=
		          request.getRequestDispatcher("index.jsp");
		          dispatcher.forward(request,response);
		     }
		     catch(SQLException e){
		          System.out.println(e);
		          fail(request,response,"添加记录失败:"+e.toString());
		     }  
		   }
		   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
		           throws ServletException,IOException{
		       doPost(request,response);
		   }
		   public void fail(HttpServletRequest request,HttpServletResponse response,
		                      String backNews) {
		        response.setContentType("text/html;charset=GB2312");
		        try {
		         PrintWriter out=response.getWriter();
		         out.println("<html><body>");
		         out.println("<h2>"+backNews+"</h2>") ;
		         out.println("返回");
		         out.println("<a href =example7_3.jsp>输入记录</a>");
		         out.println("</body></html>");
		        }
		        catch(IOException exp){} 
		    }
		}
