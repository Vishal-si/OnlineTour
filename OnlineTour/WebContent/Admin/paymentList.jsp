<%@page import="java.util.List"%>
<%@page import="Model.PaymentModel"%>
<%@page import="Service.AdminService"%>
<%@ include file="../Assest/Properties/Header.jsp" %>
 
<div class="container-fluid">
<%@ include file="../Assest/Properties/AdminNavBar.jsp" %>
<%
String admin_email = (String)session.getAttribute("admin_email");
if(admin_email==null || admin_email == "")
{
	response.sendRedirect("AdminLogin.jsp");
}


%>


<table class="table">
<thead class="bg-danger text-white text-center">
<tr>
<th>Payment Id</th>
<th>User Id</th>
<th>Tour Id</th>
<th>Payment Type</th>
<th>Amount</th>
</tr>
</thead>
<%
AdminService asobj = new AdminService();
List<PaymentModel> plist = asobj.paymentList();
for(PaymentModel pmobj:plist)
{%>

<tbody class="bg-white">
<tr>
<td><%=pmobj.getPayId() %></td>
<td><%=pmobj.getUserId() %></td>
<td><%=pmobj.getTourId() %></td>
<td><%=pmobj.getPaymentType() %></td>
<td><%=pmobj.getAmount() %></td>
</tr>
</tbody>


<%} %>
</table>
</div>
<%@ include file="../Assest/Properties/Footer.jsp" %>