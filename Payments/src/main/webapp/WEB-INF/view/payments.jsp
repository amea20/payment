<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>Payments</title>
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
<div id="sortResults">
<label for="sortPayments">Sort by:</label>
<select onchange="sortPayments()" id="sortPayments">
	<option value="default">All</option>
	<option value="date">Date</option>
	<option value="amount">Amount</option>
</select>
</div>
<div id="tablesort">
<table class="table table-bordered table-hover">
    <thead>
      <tr>
        <th>Amount</th>
        <th>Currency</th>
		<th>Date added</th>
        <th>Account number (From)</th>
		<th>Account number (To)</th>
      </tr>
    </thead>
    <c:forEach var="payment" items="${paymentForm.payments}">
    <tbody>
      <tr>
        <td>${payment.amount}</td>
		<td>${payment.currency}</td>
        <td><fmt:formatDate value="${payment.paymentDate}" pattern="dd/MM/yyyy" /></td>
		<td>${payment.srcAccountNumber}</td>
		<td>${payment.destAccountNumber}</td>
      </tr>
     </tbody>
     </c:forEach>
  </table>
  </div>
</div>
<!--End of container-->
</div>
<!--End of pagecontainer-->
</body>
</html>