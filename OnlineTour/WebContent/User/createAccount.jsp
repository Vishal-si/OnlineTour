<jsp:include page="../Assest/Properties/Header.jsp"></jsp:include>

<form action="../Authencitation" method="post" class="create-login">

<input type="hidden" name="task" value="create">

<label>Enter the name</label>
<input type="name" name="name" id="name">
<span id="msgname"></span>

<label>Enter the email</label>
<input type="email" name="email" id="email">
<span id="msgemail"></span>

<label>Enter the password</label>
<input type="password" name="password" id="password">
<span id="msgpassword"></span>

<label>Enter the conform password</label>
<input type="password" name="cpassword" id="cpassword">
<span id="msgcpassword"></span>

<label>Add date of birth</label>
<input type="date" name="date" id="date">
<span id="msgdate"></span>

<label>Add phone number</label>
<input type="text" name="phone" id="phone">
<span id="msgphone"></span>

<button type="submit">Submit</button>

<a href="index.jsp"><i>Already Account</i></a>

</form>
<jsp:include page="../Assest/Properties/Footer.jsp"></jsp:include>