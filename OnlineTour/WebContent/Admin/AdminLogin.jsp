<%@ include file="../Assest/Properties/Header.jsp" %>
<form action ="../AdminLoginController" method="post">

<input type="hidden" name="task" value="login">

<label>Enter the email</label>
<input type="email" name="email">

<label>Enter the Passsword</label>
<input type="password" name="password">

<button type="submit">Submit</button>

</form>
<%@ include file="../Assest/Properties/Footer.jsp" %>

