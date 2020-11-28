<%@ include file="../Assest/Properties/Header.jsp" %>

<div class="container">
<div class="jumbotron mt-2">
<h3 class="display-4">Agent Sign Up</h3>

</div>

<form action="../AgentController" method="post"  enctype="multipart/form-data">
<div class="form-group">

<label for="name">Name</label>
<input type="text" name="name" id="name" class="form-control">

<label for="email">Email</label>
<input type="email" name="email" id="email" class="form-control">

<label for="password">Password</label>
<input type="password" name="password" id="password" class="form-control">

<label for="cpassword">Confirm Password</label>
<input type="password" name="cpassword" id="cpassword" class="form-control">

<label for="age">Age</label>
<input type="number" name="age" id="age" class="form-control">

<label for="phone">Phone Number</label>
<input type="text" name="phone" id="phone" class="form-control">

<label for="sname">Shop Name</label>
<input type="text" name="sname" id="sname" class="form-control">

<label for="saddress">Shop Address</label>
<input type="text" name="saddress" id="saddress" class="form-control">


<label for="sphoto">Agent Photo</label>
<input type="file" name="sphoto" id="sphoto" class="form-control file-field"><br>

<button class="btn btn-success" type="submit">Submit</button>

<a href="AgentLogin.jsp">Already Account</a>
</div>



</form>
</div>
<%@ include file="../Assest/Properties/Footer.jsp" %>
