<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">

$(document).ready(function(){
  $("#ReadMore").click(function(){
    $.ajax({
    	url:"SampleAjaxRequest.action",
    	type:"post",
    	dataType: 'json',
    	success:onSuccess
    });
  });
});
function onSuccess(json,textStatus,jqXHR){
	alert(json.message);
	
	$("#readMoreSpan").html(json.message);
	
}
</script>
</head>
<body>
<div class="banner">
		<div class="banner-contant">
			<h3>Welcome to Hotel</h3>
			<div>
				<img src="images/banner1.jpg" alt="" style="float:left;" />
				<img src="images/banner2.jpg" alt="" />
			</div>
			<div style="padding:5px;"><strong>Overview</strong><br />
				<span id="readMoreSpan">welcome to hotel</span> 
			<div class="readmore"><a href="JavaScript:void(0)" id="ReadMore">Read More</a></div>
			</div>
		</div>
	</div>
<div class="workzone">
		<div style="padding:0px 5px 0px 5px;">
			<div class="workzone-left">
				<div class="searchzone">
					<div class="searchtxt">Search</div>
					<div class="searchbox">
		      			<input type="text" name="textfield3" style="height:15px;" />
	    			</div>
					<div class="searchbutton"><input type="image" src="images/search.jpg" /></div>
				</div>
				<div class="clear">
				<img src="images/booking-img.jpg" alt="" class="booking-img" />
				<h1>Booking</h1>
			    ing elit. Curabitur et libero eu orci viverra dictum. Nulla commodo ipsum a arcu. Quisque nulla. Mauris eleifend ante sed nunc. 
				<div class="clear"></div>
				</div>
		  </div>
			<div class="workzone-right">
				<h2>Photography Gallery</h2>
				<div class="imgzone">
					<div class="img"><a href="#"><img src="images/img1.jpg" alt="" border="0" /></a></div>
					<div class="img"><a href="#"><img src="images/img2.jpg" alt="" border="0" /></a></div>
					<div class="img"><a href="#"><img src="images/img3.jpg" alt="" border="0" /></a></div>
					<div class="img"><a href="#"><img src="images/img4.jpg" alt="" border="0" /></a></div>
					<div class="img"><a href="#"><img src="images/img5.jpg" alt="" border="0" /></a></div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>

</body>
</html>