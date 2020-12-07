
<%@ include file="../Assest/Properties/Header.jsp" %>
<div class="container">

<div class="jumbotron mt-2">
<h3 class="display-4">Agent Sign In</h3>
</div>

<form action="../AgentLoginController" method="post" class="agent-login">
<div class="form-group">

<label for="email">Email</label>
<input type="email" name="email" id="email" class="form-control">
<span id="msgemail"></span>

<label for="password">Password</label>
<input type="password" name="password" id="password" class="form-control">
<span id="msgpassword"></span><br>

<button class="btn btn-success mt-auto" type="submit">Click</button> <br></br>
<a href="AgentAccount.jsp" class="btn btn-primary">Create New Account</a>
</div>
</form>
</div>
<%@ include file="../Assest/Properties/Footer.jsp" %>