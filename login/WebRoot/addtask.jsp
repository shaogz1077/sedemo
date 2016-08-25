<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布任务</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="AddTaskServlet" method="post">
   标题:<input type="text" name="title"/><br><br>
   排序方式:<br><br>
   地区:<input type="text" name="address"/><br><br>
   最小价格:<input type="text" name="minprice"/><br>
   最大价格:<input type="text" name="maxprice"/><br><br>
   是否收藏：<input type="text" name="add"><br><br>
   加入购物车:<input type="text" name="shopping"><br><br>
   <input type="submit" value="submit">
   </form>
  </body>
</html>
