<%--
  User: Ranga Reddy
  Date: 09/05/2015
  Time: 6:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Ranga Reddy">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add track</title>
    <!-- Bootstrap CSS -->
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
   }​
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
	                <div class="inner"style="margin-right: 660px;"><b>Add track Details</b></div>
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
            <div class="panel-body">
                <form:form id="campusmindform" cssClass="form-horizontal" modelAttribute="ot"  method="post" action="savetrack">
    
    				<div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="trackName" >Track Name</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="trackName" value="${otObject.trackName}"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="savetrack" class="btn btn-primary" value="Save" onclick="return submitTrackForm();"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>
    
                </form:form>
            </div>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
        function submitTrackForm() {             
         
            var trackName = $('#tracknName').val().trim();
            if(tracName.length ==0) {
                alert('Please enter Track Name');
                $('#trackName').focus();
                return false;
            }
            return true;
        };  
    </script>
</body>
</html>