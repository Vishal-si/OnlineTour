<%@ include file="../Assest/Properties/Header.jsp" %>

<form action="PaymentController" method="post">
<h2>Payment Page</h2>

<%
String email = (String)session.getAttribute("uemail");
out.println(email);
if((email == null) || (email==""))
{
	response.sendRedirect("login.jsp");
}
%>

<%
float amount = Float.parseFloat(request.getParameter("amount"));
int userId = Integer.parseInt(request.getParameter("userId"));
int tourId = Integer.parseInt(request.getParameter("tourId"));

%>

<input type="hidden" name="task" value="payment">
<label>Amount</label>
<input type="text" value=<%=amount %> name="amount">

<input type="text" value=<%=userId %> name="userId">

<input type="text" value=<%=tourId %> name="tourId">

<ul>
<label>Case of Delivery</label>
<ins><input type="radio" name="payment" value="caseofdelivery"></ins><br>

<label>Credit Card</label>
<ins><input type="radio" name="payment" value="creditcard"></ins><br>

<label>Debit Card</label>
<ins><input type="radio" name="payment" value="debitcard"></ins><br>
</ul>

<a href="#">Net Banking</a>
<input type="text" name="payment">

<button type="submit">Submit</button>

</form>
<%@ include file="../Assest/Properties/Footer.jsp" %>
