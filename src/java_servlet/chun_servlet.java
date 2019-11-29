package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java_bean.clothe_bean;
import java_bean.java_bean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class chun_servlet extends HttpServlet{
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
		          ArrayList<clothe_bean> clother_chun=new ArrayList<clothe_bean>();
		        	  rs=sql.executeQuery("SELECT * FROM clothe_information where Clothetype LIKE '%春装%'");
			          
			          while(rs.next()){
			        	clothe_bean c=new clothe_bean();
			  			c.setClotheId(rs.getInt("ClotheId"));
			  			c.setClothefactoryAddress(rs.getString("clothefactoryAddress"));
			  			c.setClotheImg(rs.getString("clotheImg"));
			  			c.setClotheName(rs.getString("clotheName"));
			  			c.setClothePrice(rs.getDouble("clothePrice"));
			  			c.setClothetype(rs.getString("clothetype"));
			  			clother_chun.add(c);
			  		}
			          request.setAttribute("clother_chun",clother_chun);
			          con.close();
			          RequestDispatcher dispatcher=
			          request.getRequestDispatcher("clothe_scan_chun.jsp");
			          dispatcher.forward(request,response);
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
