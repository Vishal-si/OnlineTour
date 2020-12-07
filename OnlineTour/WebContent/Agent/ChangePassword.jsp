<%@ include file="../Assest/Properties/Header.jsp" %>
<div class="container-fluid">
<%@ include file="../Assest/Properties/AgentNavBar.jsp" %>
<div class="jumbotron bg-danger mt-2">

</div>

<%
String agent_email=(String)session.getAttribute("agent_email");
if(agent_email == null || agent_email=="")
{
	response.sendRedirect("AgentLogin.jsp");
}



%>
<div class="container mt-5">
<div class="card m-auto" style="width:400px; height:400px">
<div>
<h6 class="text-center text-danger">Password Change</h6>
</div>
<div class="card-body">
<form action="../ChangePassword" method="post" class="form-group">
<input type="hidden" name="task" value="agentPassword">

<input type="hidden" value=<%=agent_email %> name="email">

<label for="old_password">Old Password</label>
<input  type="password" name="old_password" id="old_password" class="form-control">

<label for="new_password">New Password</label>
<input  type="password" name="new_password" id="new_password" class="form-control">

<label for="confirm_password">Confirm Password</label>
<input type="password" name="confirm_password" id="confirm_password" class="form-control">


<div class="container text-center mt-2">
<button type="submit" class="btn btn-primary">Submit</button>
</div>

</form>
</div>
</div>
</div>


</div>
<%@ include file="../Assest/Properties/Footer.jsp" %>
