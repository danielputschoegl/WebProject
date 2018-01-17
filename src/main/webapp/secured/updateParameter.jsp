<html>
<body>
	<%@ page import="dke.pr.g3.bean.*"%>
	<%@ page import="java.util.ArrayList"%>
	<%
		IndexBeanAndi bean = new IndexBeanAndi();
	%>
	<%=bean.init()%>
	<br> vielleicht modify parameter, weil einheitlich
	<br> Parameters:
	<%=bean.getParameters()%>
	<br>
	<br> ParamterValues
	<%=bean.getParameterValues()%>
	<br>
	
	<br>
	<br> Enter new Parameter Value:
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
