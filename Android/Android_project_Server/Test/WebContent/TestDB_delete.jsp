<%@ page import="db.beans.*,java.sql.*,java.util.*,java.io.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean" />
<jsp:setProperty name="QueryBean" property="*" />
<%

   response.setHeader("Cache-Control","no-store");
   response.setHeader("Pragma","no-cache");
   response.setDateHeader("Expires",0);
   
   request.setCharacterEncoding("UTF-8");
   
   String BOOKID=request.getParameter("BOOKID")==null ?"":request.getParameter("BOOKID").trim();

   System.out.println("삭제할 아이디는: "+BOOKID);
   
   QueryBean.getConnection();
   
   int res=0;
   
   try{
	   res=QueryBean.deleteUserInfo(BOOKID);
   }
   catch(Exception e)
   {
	   out.print(e.toString());
   }
   finally{
	   QueryBean.closeConnection();
   }
   out.print("[");
   out.print("{");
   out.print("\"RESULT_OK\" \""+res+"\" ");
   out.print("}");
   out.print("]");
   
   System.out.println("res: "+res);
   
%>