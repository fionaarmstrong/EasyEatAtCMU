<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

</head>

<body>
<form name="calc" method="post" action="enternewpost.action">
user name: <input id="n" name="n"><br>
password: <input id="m" name="m"><br>
<input type="submit" id="doit" value="submit"><br>
</form>
<%-- <s:property value="result"/> --%>
<div id="result"></div>
</body>
</html>