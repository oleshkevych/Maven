<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/style.css">
<script src="css/jquery-3.1.1.min .js"></script>

</head>
<body>


	<div style="text-align: center; margin-top: 20%">

		<c:forEach var="comm" items="${commodities}">
		${comm.name}<a href="del/${comm.id}">delete</a>
			<br>
		</c:forEach>
		<%-- ${commodities} --%>
		<br>
		<sf:form action="selectGet" method="post">
			<select name="formSelect">
				<c:forEach var="comm" items="${commodities}">
					<option>${comm.name}</option>
				</c:forEach>
			</select>
			<button>select</button>
		</sf:form>

		<%-- <form action="newCommodity" method="post">
			<input name="nameCommodity" placeholder="commodity name"/>
			<br>
			<br>
			<input name="priceCommodity" placeholder="commodity price"/>
			<br>
			<br>
			<button>save Commodity</button>
		</form> --%>

		<sf:form modelAttribute="commodity" action="newCommodity"
			method="post">
			<sf:input path="name" placeholder="commodity name" />
			<br>
			<br>

			<sf:input path="price" placeholder="commodity price" />
			<br>
			<br>
			<button>save Commodity</button>
		</sf:form>


		<input type="hidden" name="csrf_name" value="${_csrf.parameterName}" />
		<input type="hidden" name="csrf_value" value="${_csrf.token}" /> 
		
		
		<input id="nameCommodity"/>
		<input id="namePrice"/>
		<button id="save">select</button>
		<script type="text/javascript">

			$("#save").click(function() {
				console.log("Click")
				alert($("#namePrice").val() );
				var commodity1 = {
					name : $("#nameCommodity").val(),
					price : $("#namePrice").val() 
				}
			
			console.log(commodity1)
			console.log("Click1")
			$.ajax({
				url : "newCommodity?"+$("input[name=csrf_name]").val()+"="+$("input[name=csrf_value]").val(),
				contentType : "application/json",
				type : "POST",
				data : JSON.stringify(commodity1),
				success : function(res){
					alert(res);
				}
			})
			});
		</script>
	</div>
</body>
</html>