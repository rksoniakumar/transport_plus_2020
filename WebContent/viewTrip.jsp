<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transport Plus - View Trip </title>

<!--css--> 
<style type="text/css"> 
.form-style{ 
max-width: 500px; 
padding: 10px 20px; 
background: #f4f7f8; 
margin: 10px auto; 
padding: 20px; 
background: #f4f7f8; 
border-radius: 8px; 
font-family: Georgia, "Times New Roman", Times, serif; 
} 
.form-style fieldset{ 
border: none; 
} 
.form-style legend { 
font-size: 1.4em; 
margin-bottom: 10px; 
} 
.form-style label { 
display: block; 
margin-bottom: 8px; 
} 
.form-style input[type="text"], 
.form-style input[type="date"], 
.form-style input[type="datetime"], 
.form-style input[type="email"], 
.form-style input[type="number"], 
.form-style input[type="search"], 
.form-style input[type="time"], 
.form-style input[type="url"], 
.form-style select { 
font-family: Georgia, "Times New Roman", Times, serif; 
background: rgba(255,255,255,.1); 
border: none; 
border-radius: 4px; 
font-size: 16px; 
margin: 0; 
outline: 0; 
padding: 7px; 
width: 50%; 
box-sizing: border-box; 
-webkit-box-sizing: border-box; 
-moz-box-sizing: border-box; 
background-color: #e8eeef; 
color:#8a97a0; 
-webkit-box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset; 
box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset; 
margin-bottom: 30px; 
} 
.form-style input[type="text"]:focus, 
.form-style input[type="date"]:focus, 
.form-style input[type="datetime"]:focus, 
.form-style input[type="email"]:focus, 
.form-style input[type="number"]:focus, 
.form-style input[type="search"]:focus, 
.form-style input[type="time"]:focus, 
.form-style input[type="url"]:focus, 
.form-style select:focus{ 
background: #d2d9dd; 
} 
.form-style select{ 
-webkit-appearance: menulist-button; 
height:35px; 
} 
.form-style .number { 
background: #1abc9c; 
color: #fff; 
height: 30px; 
width: 30px; 
display: inline-block; 
font-size: 0.8em; 
margin-right: 4px; 
line-height: 30px; 
text-align: center; 
text-shadow: 0 1px 0 rgba(255,255,255,0.2); 
border-radius: 15px 15px 15px 0px; 
} 
.form-style input[type="submit"], 
.form-style input[type="button"] 
{ 
position: relative; 
display: block;  
color: #FFF; 
margin-right: 4px; 
background: #1abc9c; 
font-size: 14px; 
font-family: Georgia, "Times New Roman", Times, serif; 
text-align: center;  
width: 10%; 
border: none; 
border-radius: 4px;
outline: 0; 
padding: 7px; 
width: 14%; 

} 
.form-style input[type="submit"]:hover, 
.form-style input[type="button"]:hover 
{ 
background: #109177; 
} 
.header {
  padding: 15px;
  height: 35px;
  text-align: center;
  background: #1abc9c;
  color: white;
  font-size: 16px;
  font-family: Georgia, "Times New Roman", Times, serif; 
  }
.dropbtn {
  background-color:  #1abc9c;
  color: white;
  padding: 15px;
  font-size: 16px;
  font-family: Georgia, "Times New Roman", Times, serif; 
  border-radius: 15px;
}
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 120px;
  border-radius: 15px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 12px;
  text-decoration: none;
  font-size: 14px;
  font-family: Georgia, "Times New Roman", Times, serif; 
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;
border-radius: 15px;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #12876f;}
</style>
<!--css--> 
</head>
<!--htmlcode--> 


 <body>

<div class="form-style"> 
  <div class="header">
  <h2>Trans Plus</h2>

</div>
<div class="dropdown">
  <button class="dropbtn">Trip</button>
  <div class="dropdown-content">
    <a href="index.jsp">Create Trip</a>
    <a href="#">View Trip</a>
  </div>
 </div>

<div class="dropdown">
  <button class="dropbtn">Expense</button>
  <div class="dropdown-content">
    <a href="#">Create Expense</a>
    <a href="#">View Expense</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">Report</button>
  <div class="dropdown-content">
    <a href="#">Trip Report</a>
    <a href="#">Expense Report</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">Admin</button>
  <div class="dropdown-content">
  <a href="#">Manage Driver</a>
    <a href="#">Manage Expense</a>
    <a href="#">Manage Trip</a>
  </div>
</div>



 <form action = "viewTrip" method = "post"> 
<fieldset> 
<!--  <legend><span class="header">Create Trip</span> </legend> -->
 <h3>View Trip </h3>
 

<label for="tripid">Trip ID:</label> 
<input type="text" name="tripid" id ="tripid" placeholder=" "> 

<input type="submit"  value="Search" /> 
</fieldset> 

<c:if test="${not empty tripDetails}">
<h3>Trip Details </h3>
<c:forEach var="getTrip" items= "${tripDetails}">

 <p>Trip ID :   ${getTrip.trip_id} </p>
 <p>From Location :   ${getTrip.from_loc} </p>
 <p>To Location :   ${getTrip.to_loc} </p>
 <c:forEach var="getDriver" items= "${getTrip.driver}">
 <p>Driver ID :   ${getDriver.driverId} </p>
 <p>Driver First Name :   ${getDriver.driverFirstName} </p>
 <p>Driver Last Name :   ${getDriver.driverLastName} </p>
  <p>Email ID :   ${getDriver.emailId} </p>
 <p>Contact Number :   ${getDriver.contactNo} </p>
 </c:forEach> 
</c:forEach> 
</c:if>



</form> 

 
</div> 
<!--htmlcode--> 
</body>
</html>