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

public class delete_servlet  extends HttpServlet{
	   public void init(ServletConfig config) throws ServletException{
		      super.init(config);
		   }
		   public void doPost(HttpServletRequest request,HttpServletResponse response)
		               throws ServletException,IOException{
			   java_bean resultBean=null;
		      try{  resultBean=(java_bean)request.getAttribute("resultBean");
		            if(resultBean==null){
		                resultBean=new java_bean(); //����Javabean����
		                request.setAttribute("resultBean",resultBean);
		            }
		      }
		      catch(Exception exp){
		            resultBean=new java_bean();  //����Javabean����
		            request.setAttribute("resultBean",resultBean);
		      } 
		     try{  Class.forName("com.mysql.jdbc.Driver");
		     }
		     catch(Exception e){} 
		     System.out.printf("------------------------------>123");
		     request.setCharacterEncoding("utf-8");
		     String dataBase = request.getParameter("dataBase");
		     String tableName = request.getParameter("tableName");
		     String Id=request.getParameter("id");
		     int id = Integer.parseInt(Id);
		     String condition = "DELETE FROM "+tableName+" where ID ="+ id+";";
		     Connection con;
		     Statement sql; 
		     ResultSet rs;
		     try{ 
		          String uri="jdbc:mysql://127.0.0.1/"+dataBase+"?"+
		                      "user=root&password=&characterEncoding=gb2312";
		          con=DriverManager.getConnection(uri);
		          sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                                 ResultSet.CONCUR_READ_ONLY);
		          sql.executeUpdate(condition);
		          rs=sql.executeQuery("SELECT * FROM "+tableName);
		          ResultSetMetaData metaData = rs.getMetaData();
		          int columnCount = metaData.getColumnCount(); //�õ������������
		          String []columnName = new String[columnCount];
		          for(int i=0;i<columnName.length;i++) {
		             columnName[i] = metaData.getColumnName(i+1); //�õ�����
		          }
		          resultBean.setTableZidun(columnName);   //����Javabean����ģ��
		          rs.last();
		          int rowNumber=rs.getRow();  //�õ���¼��
		          String [][] tableRecord=resultBean.getTableRecord();
		          tableRecord = new String[rowNumber][columnCount];
		          rs.beforeFirst();
		          int i=0;
		          while(rs.next()){
		            for(int k=0;k<columnCount;k++) 
		              tableRecord[i][k] = rs.getString(k+1);
		            i++; 
		          }
		          resultBean.setTableRecord(tableRecord); //����Javabean����ģ��
		          con.close();
		          RequestDispatcher dispatcher=
		          request.getRequestDispatcher("show.jsp");
		          dispatcher.forward(request,response);
		     }
		     catch(SQLException e){
		          System.out.println(e);
		          fail(request,response,"��Ӽ�¼ʧ��:"+e.toString());
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
		         out.println("����");
		         out.println("<a href =example7_3.jsp>�����¼</a>");
		         out.println("</body></html>");
		        }
		        catch(IOException exp){} 
		    }
		}
