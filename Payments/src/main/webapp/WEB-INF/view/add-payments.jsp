<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="/resources/images/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="/resources/css/payment.css">
<link rel="stylesheet" href="/resources/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/bootstrap-datepicker.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="/resources/js/payment.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>Add payment</title>
</head>
<body>
<!--Start of pagecontainer-->
<div id="pagecontainer">
<!--Start of header-->
<div id="header">
</div>
<!--End of header-->
<!--Start of container-->
<div id="container">
<p>Please add the payments in the following section below:</p>
<hr>

<form:form class="form-horizontal" method="post" modelAttribute="paymentForm">
<div id="errors"><form:errors path="*" cssClass="has-error"/></div>
<c:forEach varStatus="counter" begin="0" end="4">
<p>Payment <c:out value="${counter.count}"/>:</p>
<form:hidden path="payments[${counter.index}].id" value="${counter.count}" />
<div class="row">
<div class="col">
<form:label path="payments[${counter.index}].amount" class="control-label col-sm-3">Amount:</form:label>
<div class="col-sm-3"><form:input type="text" path="payments[${counter.index}].amount" class="form-control"></form:input></div>
</div>
<div class="col">
<form:label path="payments[${counter.index}].currency" class="control-label col-sm-3">Currency:</form:label>
<div class="col-sm-3"><form:input type="text" path="payments[${counter.index}].currency" class="form-control" ></form:input></div>
</div>
</div>
<div class="row">
<div class="col">
<form:label path="payments[${counter.index}].paymentDate" class="control-label col-sm-3">Date added:</form:label>
<div class="col-sm-3"><form:input type="text" id="datepicker" path="payments[${counter.index}].paymentDate" class="form-control" ></form:input></div>
</div>
<div class="col">
<form:label path="payments[${counter.index}].srcAccountNumber" class="control-label col-sm-3">Account number (From):</form:label>
<div class="col-sm-3"><form:input path="payments[${counter.index}].srcAccountNumber" type="text" class="form-control"></form:input></div>
</div>
<div class="col">
<form:label path="payments[${counter.index}].destAccountNumber" class="control-label col-sm-3">Account number (To):</form:label>
<div class="col-sm-3"><form:input path="payments[${counter.index}].destAccountNumber" type="text" class="form-control"></form:input></div>
</div>
</div>
<hr>
</c:forEach>
<div class="form-group"><button id="listpayments" class="btn btn-default" type="submit">List payments</button></div>
</form:form>
</div>
<!--End of container-->
</div>
<!--End of pagecontainer-->
</body>
</html>