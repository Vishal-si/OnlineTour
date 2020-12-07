<%@page import="Model.UserModel"%>
<%@page import="Model.RequestTourModel"%>
<%@page import="Model.PaymentModel"%>
<%@page import="Model.BookingModel"%>
<%@page import="Model.AgentModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.AdminService"%>
<%@ include file="../Assest/Properties/Header.jsp" %>

<div class="container-fluid">
<%@ include file="../Assest/Properties/AdminNavBar.jsp" %>

<div class="jumbotron mt-2 bg-danger">


</div>


<%
AdminService asobj = new AdminService();
int totalAgent=0;
int totalBooking=0;
int totalPayment=0;
int totalRequest=0;
int totalTour=0;
int totalUser=0;

List<AgentModel> alist = asobj.agentList();
for(AgentModel amobj:alist)
{
	amobj.getId();
	totalAgent++;
}

List<BookingModel> blist = asobj.bookingList();
for(BookingModel bmobj:blist)
{
	bmobj.getBooking_id();
	totalBooking++;
}

List<PaymentModel> plist = asobj.paymentList();
for(PaymentModel pmobj:plist)
{
	pmobj.getPayId();
	totalPayment++;
}

List<RequestTourModel> rlist = asobj.reqTourList();
for(RequestTourModel rmobj:rlist)
{
	rmobj.getReq_id();
	totalRequest++;
}

List<RequestTourModel> tlist = asobj.tourList();
for(RequestTourModel rmobj2:tlist)
{
	rmobj2.getId();
	totalTour++;
}

List<UserModel> ulist = asobj.userList();
for(UserModel umobj:ulist)
{
	umobj.getId();
	totalUser++;
}

%>
<%
String admin_email = (String)session.getAttribute("admin_email");
if(admin_email==null || admin_email == "")
{
	response.sendRedirect("AdminLogin.jsp");
}


%>



<!--Total Agent  -->
<div class="container">
<div class="jumbotron" style="background-image: url(../Assest/SetImage/150800.jpg);
background-repeat: no-repeat;
background-size: cover;
background-position: center;

">

<div class="row">

<div class="card mt-2 ml-5 mb-2 " style="width:300px; height:400px">
<div class="card-header bg-danger text-uppercase text-center"><h4 class="text-white">Agent</h4></div>
<div class="card-body">
<div class="container text-center">
<img src="../Assest/SetImage/travelAgent.jpeg" class="img-thumbnail " alt="image.jpg" style="width:200px; height:150px"/>
<p class="text-uppercase">number of total agent:<br><b><%=totalAgent%></b></p>
<a href="#" class="btn btn-primary"> CHECK</a>
</div>
</div>
<div class="card-footer bg-primary"></div>
</div>

<!--Total User  -->

<div class="card mt-2 ml-5 mb-2 " style="width:300px; height:400px">
<div class="card-header bg-danger text-uppercase text-center"><h4 class="text-white"> User</h4></div>
<div class="card-body">
<div class="container text-center">
<img src="../Assest/SetImage/user.png" class="img-thumbnail " alt="image.jpg" style="width:200px; height:150px"/>
<p class="text-uppercase">number of total user:<br><b><%=totalUser%></b></p>
<a href="#" class="btn btn-primary"> CHECK</a>
</div>
</div>
<div class="card-footer bg-primary"></div>
</div>

<!--Total Tour  -->

<div class="card mt-2 ml-5 mb-2 " style="width:300px; height:400px">
<div class="card-header bg-danger text-uppercase text-center"><h4 class="text-white">Tour</h4></div>
<div class="card-body">
<div class="container text-center">
<img src="../Assest/SetImage/india.jpg" class="img-thumbnail " alt="image.jpg" style="width:200px; height:150px"/>
<p class="text-uppercase">number of total tour:<br><b><%=totalTour%></b></p>
<a href="#" class="btn btn-primary"> CHECK</a>
</div>
</div>
<div class="card-footer bg-primary"></div>
</div>

<!--Total Booking With Process  -->

<div class="card mt-2 ml-5 mb-2" style="width:300px; height:400px">
<div class="card-header bg-danger text-uppercase text-center"><h4 class="text-white">Booking Process</h4></div>
<div class="card-body">
<div class="container text-center">
<img src="../Assest/SetImage/tourBooking.jpeg" class="img-thumbnail " alt="image.jpg" style="width:200px; height:150px"/>
<p class="text-uppercase">number of total booking process:<br><b><%=totalBooking%></b></p>
<a href="#" class="btn btn-primary"> CHECK</a>
</div>
</div>
<div class="card-footer bg-primary"></div>
</div>


<!--Total Payment  -->

<div class="card mt-2 ml-5 mb-2" style="width:300px; height:400px">
<div class="card-header bg-danger text-uppercase text-center"><h4 class="text-white">Payment</h4></div>
<div class="card-body">
<div class="container text-center">
<img src="../Assest/SetImage/payment.jpeg" class="img-thumbnail " alt="image.jpg" style="width:200px; height:150px"/>
<p class="text-uppercase">number of total payment:<br><b><%=totalPayment%></b></p>
<a href="#" class="btn btn-primary"> CHECK</a>
</div>
</div>
<div class="card-footer bg-primary"></div>
</div>

<!--Number Of Request Pending  -->

<div class="card mt-2 ml-5 mb-2 " style="width:300px; height:400px">
<div class="card-header bg-danger text-uppercase text-center"><h4 class="text-white">Request Pending</h4></div>
<div class="card-body">
<div class="container text-center">
<img src="../Assest/SetImage/req.jpeg" class="img-thumbnail " alt="image.jpg" style="width:200px; height:150px"/>
<p class="text-uppercase">number of request pending:<br><b><%=totalRequest%></b></p>
<a href="#" class="btn btn-primary"> CHECK</a>
</div>
</div>
<div class="card-footer bg-primary"></div>
</div>

</div>


</div>
</div>
</div>


<%@ include file="../Assest/Properties/Footer.jsp" %>
