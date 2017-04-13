<%@ page import="db.beans.*,java.sql.*,java.util.*,java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="EUC-KR"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean" />
<jsp:setProperty name="QueryBean" property="*" />
<%

   response.setHeader("Cache-Control","no-store");
   response.setHeader("Pragma","no-cache");
   response.setDateHeader("Expires",0);
   
   request.setCharacterEncoding("UTF-8");
   QueryBean.getConnection();
   System.out.println("getConnectopn");
   
   ArrayList resArr=new ArrayList();
   
   try
   {
      resArr=QueryBean.getUserInfo();
   }
   catch(Exception e)
   {
      out.print(e.toString());
   }
   finally
   {
      QueryBean.closeConnection();
   }
   
   out.println("{");
   out.println("\"datas\":[");
   
   if(resArr.size()==0){
	   
	   out.println("]");
	   out.println("}");
   }
   else{
	  	  out.print("{ ");
	      out.print("\"BOOKID\": \""         +(String)resArr.get(0)+"\",");        
	      out.print("\"BOOKNAME\": \""         +(String)resArr.get(1)+"\",");
	      out.print("\"PUBLISH\": \""         +(String)resArr.get(2)+"\",");
	      out.print("\"PRICE\": \""         +(String)resArr.get(3)+"\"");
	      out.print("} ");   
	      
   		for(int i=4;i<resArr.size();i+=4){
     	  out.print(",");
     	  out.print("{ ");
   	      out.print("\"BOOKID\": \""         +(String)resArr.get(i)+"\",");        
   	      out.print("\"BOOKNAME\": \""         +(String)resArr.get(i+1)+"\",");
   	      out.print("\"PUBLISH\": \""         +(String)resArr.get(i+2)+"\",");
   	      out.print("\"PRICE\": \""         +(String)resArr.get(i+3)+"\"");     		
   	      out.print("} ");
 		}

  		 out.println("]");
  		 out.println("}");
   }
%>