package java_servlet;
import java_bean.java_bean;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java_bean.clothe_bean;
import javax.servlet.*;
import javax.servlet.http.*;
public class login_severlet extends HttpServlet implements Serializable{
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
		     
		     String dataBase = request.getParameter("dataBase");
		     String tableName = request.getParameter("tableName"); 
		     String UserName = request.getParameter("UserName");
		     String Password = request.getParameter("PassWord");
		    
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
		          String condition ="SELECT PassWord FROM "+tableName+" where UserName = "+UserName;
		          HttpSession session = request.getSession(true);
		          ArrayList<clothe_bean> clother=new ArrayList<clothe_bean>();
		          rs=sql.executeQuery(condition);
		          rs.next();
		          if(Password.equals(rs.getString(1))){
		        	  rs=sql.executeQuery("SELECT * FROM clothe_information;");
			          ResultSetMetaData metaData = rs.getMetaData();
			          while(rs.next()){
			        	clothe_bean c=new clothe_bean();
			  			c.setClotheId(rs.getInt("ClotheId"));
			  			c.setClothefactoryAddress(rs.getString("clothefactoryAddress"));
			  			c.setClotheImg(rs.getString("clotheImg"));
			  			c.setClotheName(rs.getString("clotheName"));
			  			c.setClothePrice(rs.getDouble("clothePrice"));
			  			c.setClothetype(rs.getString("clothetype"));
			  			clother.add(c);
			  		}
			          System.out.println("--------------------->"+clother);
			          session.setAttribute("clother",clother);
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
			          response.sendRedirect("clothe_scan.jsp");
			         
		          }
		          else{
		        	  response.setContentType("text/html;charset=GB2312");
		        	  PrintWriter out = response.getWriter();
		        	  out.println("<html><body><center>");
		        	  out.println("<h2>��½ʧ�ܣ���ѡ������ѡ��</h2>");
		        	  out.println("<a href =index.jsp>���ص�¼����</a>");
		        	  out.println("<a href =reg.jsp>����ע�����</a>");
		        	  out.println("<a href =modify.jsp>�����޸��������</a></center>");
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
