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
   
   String BOOKID=request.getParameter("BOOKID")==null ?"":request.getParameter("BOOKID").trim();
   String BOOKNAME=request.getParameter("BOOKNAME")==null ?"":request.getParameter("BOOKNAME").trim();
   String PUBLISH=request.getParameter("PUBLISH")==null ?"":request.getParameter("PUBLISH").trim();
   String PRICE=request.getParameter("PRICE")==null ?"":request.getParameter("PRICE").trim();
   String USERID=request.getParameter("USERID")==null ?"":request.getParameter("USERID").trim();

   
   System.out.println("BOOKID: "+BOOKID);
   System.out.println("BOOKNAME: "+BOOKNAME);
   System.out.println("PUBLISH: "+PUBLISH);
   System.out.println("PRICE: "+PRICE);
   System.out.println("USERID: "+USERID);
   
   QueryBean.getConnection();
   
   int res=0;
   
   try{
	   res=QueryBean.updateUserInfo(BOOKID, BOOKNAME, PUBLISH, PRICE,USERID);
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