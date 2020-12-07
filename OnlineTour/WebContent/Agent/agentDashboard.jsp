<%@page import="Model.PaymentModel"%>
<%@page import="Model.BookingModel"%>
<%@page import="Model.RequestTourModel"%>
<%@page import="java.util.List"%>
<%@page import="Model.AgentModel"%>
<%@page import="Service.AgentService"%>
<%@include file="../Assest/Properties/Header.jsp" %>
<div class="container-fluid">
<%@include file="../Assest/Properties/AgentNavBar.jsp" %>

<%
String agent_email = (String)session.getAttribute("agent_email");
if(agent_email==null || agent_email=="")
{
	response.sendRedirect("AgentLogin.jsp");
}

%>

<%
int tourBooking =0;
int tourPayment=0;
int agentId=0;
int tourId=0;


AgentService asobj = new AgentService();
List<AgentModel> alist=asobj.getIdByEmail(agent_email);
for(AgentModel amobj : alist)
{
	agentId=amobj.getId();
}

List<RequestTourModel> rlist =  asobj.getDetailOfTourByAgengId(agentId);
for(RequestTourModel rmobj:rlist)
{
	rmobj.getId();
	tourId++;
} 

List<BookingModel> blist = asobj.getDetailOfBookingByTourId(tourId);
for(BookingModel bmobj:blist)
{
	bmobj.getTour_id();
	tourBooking++;
	
}

List<PaymentModel> plist = asobj.getDetailOfPaymentByTourId(tourId);
for(PaymentModel pmobj:plist)
{
	pmobj.getTourId();
	tourPayment++;
	
}
%>

<div class="jumbotron bg-danger mt-2">


</div>


<div class="jumbotron">
<div class="row">

<div class=" container mt-auto">
<div class="card bg-warning row  mr-3 " style="width:1150px; height:500px">
<div class="card mt-5 ml-5 mb-5 " style="width:300px; height:400px">
<div class="card-header bg-danger text-uppercase text-center"><h4 class="text-white">Tour</h4></div>
<div class="card-body">
<div class="container text-center">
<img src="../Assest/SetImage/india.jpg" class="img-thumbnail " alt="image.jpg" style="width:200px; height:150px"/>
<p class="text-uppercase">number of tour:<br><b><%=tourId%></b></p>
<a href="tourList.jsp?agentId=<%=agentId%>" class="btn btn-primary"> CHECK</a>
</div>
</div>
<div class="card-footer bg-primary"></div>
</div>



<!--Tour BOOKING  -->

<div class="card mt-5 ml-5 mb-5 " style="width:300px; height:400px">
<div class="card-header bg-danger text-uppercase text-center"><h4 class="text-white">Booking</h4></div>
<div class="card-body">
<div class="container text-center">
<img src="../Assest/SetImage/tourBooking.jpeg" class="img-thumbnail " alt="image.jpg" style="width:200px; height:150px"/>
<p class="text-uppercase">Tour Booking:<br><b><%=tourBooking%></b></p>
<a href="bookingList.jsp?tourId=<%=tourId%>" class="btn btn-primary"> CHECK</a>
</div>
</div>
<div class="card-footer bg-primary"></div>
</div>

<!--Payment  -->
<div class="card mt-5 ml-5 mb-5 " style="width:300px; height:400px">
<div class="card-header bg-danger text-uppercase text-center"><h4 class="text-white">Payment</h4></div>
<div class="card-body">
<div class="container text-center">
<img src="../Assest/SetImage/payment.jpeg" class="img-thumbnail " alt="image.jpg" style="width:200px; height:150px"/>
<p class="text-uppercase">Complete payment:<br><b><%=tourPayment%></b></p>
<a href="paymentList.jsp?tourId=<%=tourId%>" class="btn btn-primary"> CHECK</a>
</div>
</div>
<div class="card-footer bg-primary"></div>
</div>
</div>
</div>

</div>
</div>


</div>

<%@ include file="../Assest/Properties/Footer.jsp"%>