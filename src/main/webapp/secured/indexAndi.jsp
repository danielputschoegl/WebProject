<html>
<body>
	<%@ page import="dke.pr.g3.bean.*"%>
	<%@ page import="java.util.ArrayList"%>
	<%
		IndexBeanAndi bean = new IndexBeanAndi();
	%>
	<%=bean.init()%>
	<br>
	<br>
	<%=bean.getCtxs()%>

	<%
		ArrayList<String> al = bean.getRulesAsArrayList();
	%>

	<select>
		<%
			for (int i = 0; i < al.size(); i++) {
				String option = (String) al.get(i);
		%>
		<option value="<%=option%>"><%=option%></option>
		<%
			}
		%>
	</select>
</body>
</html>
<br>
<br>
</body>
</html>
