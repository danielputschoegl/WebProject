<html>
<body>
	<%@ page import="dke.pr.g3.bean.*"%>
	<%@ page import="java.util.ArrayList"%>
	<%
		IndexBeanAndi bean = new IndexBeanAndi();
	%>
	<%=bean.init()%>
	<br> 
	<br> Contexts:
	<%=bean.getCtxs()%>
	<br>
	<br> 
	<%//= bean.getCtxFile(ctx) %>
	<br>
	<br> Enter new Context Value:
	<input type="text" name="name" />
	<%
		//bean.updateDetParamValue(param, def);
	%>
</body>
</html>
<br>
<br>
</body>
</html>
