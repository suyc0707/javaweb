
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="model.UserInfo"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.UserinfoDao" %>
<html>
<head>
<title>用户管理</title>
<jsp:useBean id="dao" class="dao.UserinfoDao" scope="request" />
</head>
<body>
	<%
		//List<UserInfo> list = dao.listAll();
	    List<UserInfo> list=new UserinfoDao().listAll();
	%>

	<table border="1" bgcolor="#e0ffff">
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>角色</th>
			<th>状态</th>
			<th>删除</th>
		</tr>
		<%
			for (UserInfo user : list) {
		%>
		<tr>
			<td><a href="editUser.jsp?uid=<%=user.getUserId()%>"><%=user.getUserId()%>
			</a></td>
			<td><%=user.getUserName()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=user.getRole()%></td>
			<td><%=user.getStatus()%></td>
			<td><a href="deleteUser?uid=<%=user.getUserId()%>"
				onclick="return confirm('提示:确定删除此用户？')">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<table bgcolor=lightgrey>
		<tr>
			<td><a href="addUser.jsp">添加用户</a></td>
		</tr>
	</table>

</body>
</html>
