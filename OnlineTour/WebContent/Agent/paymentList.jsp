<%@page import="Model.PaymentModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.AgentService"%>
<%@include file="../Assest/Properties/Header.jsp" %>

<div class="container-fluid">
<%@include file="../Assest/Properties/AgentNavBar.jsp" %>
<div class="jumbotron bg-danger mt-2">


</div>

<table class="table">
<thead class="text-center bg-danger text-white">
<tr>
<th>Payment Id</th>
<th>Tour Id</th>
<th>Amount</th>
<th>Payment Type</th>
</tr>
</thead>

<tbody class="text-center">
<%
int tourId = Integer.parseInt(request.getParameter("tourId"));
AgentService asobj = new AgentService();
List<PaymentModel> plist = asobj.getDetailOfPaymentByTourId(tourId);
for(PaymentModel pmobj:plist)
{
%>
<tr>
<td><%=pmobj.getPayId() %></td>
<td><%=pmobj.getTourId() %></td>
<td><%=pmobj.getAmount() %></td>
<td><%=pmobj.getPaymentType()%></td>
</tr>
<%}%>


</tbody>
</table>
</div>
<%@include file="../Assest/Properties/Footer.jsp" %>