<html>
<body>
<%@ page import="dke.pr.g3.gui.*" %>
<% IndexBeanAndi bean = new IndexBeanAndi(); %>
<%= bean.init() %>
<br>
<br>
<%= bean.addContext() %>
<br>
<br>
<%= bean.getContext() %>
<br>
<br>
<%= bean.detUnusedParameterValues() %>
<br>
<br>
<%= bean.getContextHierarchy() %>
<br>
<br>"src/main/webapp/indexandi.jsp"
<%= bean.getParameterValues() %>
<br>
<br>
</body>
</html>
