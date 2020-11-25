<%@ include file="../Assest/Properties/Header.jsp" %>
<form action="../AgentLoginController" method="post" class="agent-login">

<label>Email</label>
<input type="email" name="email" id="email">
<span id="msgemail"></span>

<label>Password</label>
<input type="password" name="password" id="password">
<span id="msgpassword"></span>

<button type="submit">Click</button>
<a href="AgentAccount.jsp">Create New Account</a>


</form>
<%@ include file="../Assest/Properties/Footer.jsp" %>