<html>
<body>
	<%@ page import="dke.pr.g3.bean.*"%>
	<%@ page import="java.util.ArrayList"%>
	<%
		IndexBeanAndi bean = new IndexBeanAndi();
	%>
	<%=bean.init()%>
	<br> Vielleicht machen wir das mittel Kontext zuerst anklicken
	<br>

	<%
		ArrayList<String> rules = bean.getRulesAsArrayList();
	%>
	Select the rule you want to modify:
	<br>
	<select>
		<%
			for (int i = 0; i < rules.size(); i++) {
				String option = (String) rules.get(i);
		%>
		<option value="<%=option%>"><%=option%></option>
		<%
			}
		%>
	</select>
	<br>
	<br> Enter new Rule:
	<input type="text" name="name" />
</body>
</html>
<br>
<br>
</body>
</html>
