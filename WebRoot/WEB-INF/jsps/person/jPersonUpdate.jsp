<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
<sf:form id="p" action="saveOrUpdate.do" 
    method="post" 
    enctype="multipart/form-data"
    modelAttribute="person">


<h2>修改用户</h2>
    
<table border="1">
<tr>
    <td>id:</td>
    <td><sf:input path="id"/></td>
</tr>
<tr>
    <td>name:</td>
    <td><sf:input path="name"/><sf:errors path="name"/></td>
</tr>
<tr>
    <td>age:</td>
    <td><sf:input path="age"/><sf:errors path="age"/></td>
</tr>
<tr>
    <td>photo:</td>
    <td><input type="file" name="photo"/></td>
</tr>
<tr>
    <td><input type="submit"/></td>
</tr>

</table>

</sf:form>
  </body>
</html>