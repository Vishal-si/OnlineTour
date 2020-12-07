<%@ include file="../Assest/Properties/Header.jsp" %>
<div class="container-fluid mt-2">

<div class="jumbotron">

</div>
<form action ="../AdminLoginController" method="post">

<div class="form-group">
<input type="hidden" name="task" value="login" class="form-control">

<label for="email">Email</label>
<input type="email" name="email"  id="email" class="form-control" placeholder="Email" required>

<label for="password">Passsword</label>
<input type="password" name="password" id="password" class="form-control" placeholder="Password" required><br>

<button type="submit" class="btn btn-primary">Submit</button>
</div>

</form>
</div>
<%@ include file="../Assest/Properties/Footer.jsp" %>

