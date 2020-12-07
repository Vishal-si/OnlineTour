<%@ include file="../Assest/Properties/Header.jsp" %>

<form action="../UserServlet" method="post" class="login-form">
<input type="hidden" name="task" value="login" required>

<label>Email</label>
<input type="email" name="email" id="email" required>
<span id="msgemail"></span>

<label>Password</label>
<input type="password" name="password" id="password" required>
<span id="msgpassword"></span>

<button type="submit">Submit</button>
<a href="createAccount.jsp"><i>Create New Account</i></a>

</form>

<%@ include file="../Assest/Properties/Footer.jsp" %>
