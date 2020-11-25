<%@ include file="../Assest/Properties/Header.jsp" %>
<form action="../AgentController" method="post"  enctype="multipart/form-data">

<div>
<label>Name</label>
<input type="text" name="name" id="name">

<label>Email</label>
<input type="email" name="email" id="email">

<label>Password</label>
<input type="password" name="password" id="password">

<label>Confirm Password</label>
<input type="password" name="cpassword" id="cpassword">

<label>Age</label>
<input type="number" name="age" id="age">

<label>Phone Number</label>
<input type="text" name="phone" id="phone">

<label>Shop Name</label>
<input type="text" name="sname" id="sname">

<label>Shop Address</label>
<input type="text" name="saddress" id="saddess">

<label>Agent Photo</label>
<input type="file" name="sphoto" id="sphoto">

<button type="submit">Submit</button>

<a href="AgentLogin.jsp">Already Account</a>
</div>



</form>
<%@ include file="../Assest/Properties/Footer.jsp" %>
