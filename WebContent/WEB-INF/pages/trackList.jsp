<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Campus Minds</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <style type="text/css">
        .myrow-container {
        	width: 98%;
        	height:100%;
            margin: 20px;
        }
        
        .row {
  				width: 100%;
  				align: center;
  				color: white;
  				text-align: center; // center the content of the container
			}

		.block {
 				 width: 120px;
 				 margin: 20px; 
 				 display: inline-block; // display inline with abality to provide width/height
			}

		.lastBlock{
				 width: 120px;
				 margin: 10px;
				 display: inline-block;
		}
		
		.color {
			    background-color: #0a3536;
			    border-radius: 3px;
		}
		.inner {
				  display: table;
				  margin: 0 auto;
				}
				
				.dropbtn {
				    background-color: #34961e;
				    color: white;
				    border-radius: 4px;
				    height: 35px;
				    width: 120px;
				    font-size: 15px;
				    border: none;
				    cursor: pointer;
				    text-align: center;
				    display: inline-block;
}
.dropbtn:hover, .dropbtn:focus {
    background-color: #3e8e41;
    
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    overflow: auto;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown a:hover {background-color: #f1f1f1}

.show {display:block;}
				
		.rowTwo {
  				width: 100%;
  				align: center;
  				color: black;
  				background-color: #0a3536;
  				border-radius: 3px;
  				text-align: center; // center the content of the container
			}
			
			.field{
  				border-radius: 5px;
  				margin: 20px; // center the content of the container
			}
			
			.wrapper { display: flex; }
			.block2 { width: 50%; }
			
			.inputForm{
				  display: block;
			      border-radius: 3px;
			      align: center;
			     <%-- -moz-border-radius:5px;
			      -webkit-border-radius:5px; --%>
   }
   
   
​
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
     <div class = "color">
        <div class="panel-heading">
        
            <h3 class="panel-title">
            	<div class = "row">
            	  <form action="getallcampusminds">
            	   <div class=wrapper style="margin: 20px;">
            	     	<div align="right"><input formaction="getallcampusminds" class="btn btn-success" type='submit' value='Home'/></div> 
	                <div class="inner"style="margin-right: 665px;"><b>Orchard Details</b></div>
	               </div>
	              </form>
	                <form action="getallcampusminds">
	             		<div class="block"><input formaction="addcampusmind" class="btn btn-success" type='submit' value='Add Campus Mind'/></div>
	             		<div class="block"><input formaction="addtrack" class="btn btn-success" type='submit' value='Add Orchard Track'/></div>
	             		<div class="block"><input formaction="addlead" class="btn btn-success" type='submit' value='Add Lead Details'/></div>
	             	</form>
             	</div> 	
            </h3>
            </div>
        </div>
        <div class="panel-body" style="margin-top: 5px ;">
            <c:if test="${empty trackList}">
                No Tracks Data present!
            </c:if>
            <c:if test="${not empty trackList}">   
            
                <form action="getcampusminds">
                      <div class="col-md-6" style="border-radius: 10px; text-align: center; margin-top: -5px; margin-bottom: 10px; margin-left: -10px; width: 10px;"> <input placeholder= "Enter Lead Id"  class="inputForm" type="text" name="id" id="searchName"> </div>
                      <div class="col-md-4" style="margin-top: -10px; margin-bottom: 10px; margin-left: 170px;"><input class="btn btn-success" type='submit' value='Search'/></div>
						 
                </form>             
                 <div class="dropdown" style="margin-top:-10px ; margin-bottom: 10px; border-radius: 3px;">
                	<button onclick="myFunction()" class="dropbtn">Select</button>
						  <div id="myDropdown" class="dropdown-content">
						    <a href="getallleads">Leads</a>
						    <a href="getallcampusminds">Campus minds</a>
						    <a href="gettracks">Tracks</a>
						  </div>
						</div>
               
                
                <table class="table table-hover table-bordered">	
                    <thead style="background-color: #0a3536 ; color: #ffffff ;">
                    <tr>
                        <th>Track Id</th>
                        <th>Track Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${trackList}" var="tracks">
                        <tr>
                            <th><c:out value="${tracks.trackId}"/></th>
                            <th><c:out value="${tracks.trackName}"/></th>
                        <%--    <th><a href="editEmployee?id=<c:out value='${emp.id}'/>">Edit</a></th>
                            <th><a href="deleteEmployee?id=<c:out value='${emp.id}'/>">Delete</a></th>    --%>              
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
     
    <script type="text/javascript">
    function myFunction() {
        document.getElementById("myDropdown").classList.toggle("show");
    }

    // Close the dropdown if the user clicks outside of it
    window.onclick = function(event) {
      if (!event.target.matches('.dropbtn')) {

        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
          var openDropdown = dropdowns[i];
          if (openDropdown.classList.contains('show')) {
            openDropdown.classList.remove('show');
          }
        }
      }
    }
    </script>
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>