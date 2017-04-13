package db.beans;

import java.sql.*;
import java.util.*;

public class QueryBean {
   Connection conn;
   Statement stmt;
   ResultSet rs;

   public QueryBean() {
      conn = null;
      stmt = null;
      rs = null;
   }

   public void getConnection() {
      try {
         conn = DBConnection.getConnection();
      } catch (Exception e1) {
         e1.printStackTrace();
      }

      try {
         stmt = conn.createStatement();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void closeConnection() {
      if (stmt != null) {
         try {
            stmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }

      if (conn != null) {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

   public ArrayList getUserInfo() throws SQLException {

      StringBuffer sb = new StringBuffer();

      sb.append("SELECT ");
      sb.append("BOOKID,BOOKNAME,PUBLISH,PRICE ");
      sb.append("FROM ");
      sb.append("BOOK_INFO ");
    
      rs = stmt.executeQuery(sb.toString());
      ArrayList res = new ArrayList();

   
         while (rs.next()) {
            res.add(rs.getString(1));
            res.add(rs.getString(2));
            res.add(rs.getString(3));
            res.add(rs.getString(4));
         }

      System.out.println(sb.toString());
      return res;
   }
   
   public int setUserInfo(String id, String name, String publish, String price) {
	   	  int result= 0;
	      StringBuffer sb = new StringBuffer();
	      PreparedStatement pstmt=null;

	      sb.append(" INSERT INTO ");
	      sb.append("	BOOK_INFO(BOOKID,BOOKNAME,PUBLISH,PRICE) ");
	      sb.append(" VALUES ");
	      sb.append("	('"+id+"', '"+name+"', '"+publish+"', '"+price+"')");
	      
	      System.out.println(sb.toString());
	    
	      try {
	    	  pstmt=conn.prepareStatement(sb.toString()); 
//	    	  pstmt.setString(1, id);
//	    	  pstmt.setString(2, name);
//	    	  pstmt.setString(3, phone);
//	    	  pstmt.setString(4, grade);
	          result = pstmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return result;
	   }
   
   public int updateUserInfo(String id, String name, String publish, String price, String USERID ) {
	   	  int result= 0;
	      StringBuffer sb = new StringBuffer();
	      PreparedStatement pstmt=null;

	      sb.append(" UPDATE ");
	      sb.append("	     BOOK_INFO SET");
	      sb.append(" 				  BOOKID='"+id+"',");
	      sb.append(" 				        BOOKNAME='"+name+"',");
	      sb.append(" 				        			PUBLISH='"+publish+"',");
	      sb.append(" 				        								PRICE='"+price+"'");
	      sb.append(" 				        								WHERE"+" BOOKID='"+USERID+"'");
	      System.out.println(sb.toString());
	    
	      try {
	    	  pstmt=conn.prepareStatement(sb.toString()); 
//	    	  pstmt.setString(1, id);
//	    	  pstmt.setString(2, name);
//	    	  pstmt.setString(3, phone);
//	    	  pstmt.setString(4, grade);
	          result = pstmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return result;
	   }
   
   public int deleteUserInfo(String id) {
	   	  int result= 0;
	      StringBuffer sb = new StringBuffer();
	      PreparedStatement pstmt=null;

	      sb.append(" DELETE ");
	      sb.append("		FROM ");
	      sb.append(" 			BOOK_INFO");
	      sb.append(" 		WHERE");
	      sb.append(" 			BOOKID="+id);

	      System.out.println(sb.toString());
	    
	      try {
	    	  
	    	  pstmt=conn.prepareStatement(sb.toString());  
//	    	  pstmt.clearParameters();
//	    	  pstmt.setString(1, id);
	    	  result=pstmt.executeUpdate();
//	    	  pstmt.setString(1, id);
//	    	  pstmt.setString(2, name);
//	    	  pstmt.setString(3, phone);
//	    	  pstmt.setString(4, grade);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally
	      {
	    	try
	    	{
	    		if(pstmt!=null)
	    		{
	    			pstmt.close();
	    		}
	    	}catch(Exception e){
		         e.printStackTrace();
	    	}
	      }
	      return result;
	   }
}