<%@page import="java.util.List"%>
<%@page import="Model.PaymentModel"%>
<%@page import="Service.AdminService"%>
<%@ include file="../Assest/Properties/Header.jsp" %>
<table>
<thead>
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

<tbody>
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
<%@ include file="../Assest/Properties/Footer.jsp" %>