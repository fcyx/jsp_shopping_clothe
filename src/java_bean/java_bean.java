package java_bean;

public class java_bean {
	   String [] tableZidun;       //存放表字段名
	   String [][] tableRecord;   //存放查询到的记录
	   public void setTableZidun(String [] a){
	      tableZidun=a;
	   }
	   public String [] getTableZidun(){
	      return tableZidun;
	   }
	   public void setTableRecord(String [][] b){
	      tableRecord=b;
	   }
	   public String [][] getTableRecord(){
	      return tableRecord;
	   }
	}
