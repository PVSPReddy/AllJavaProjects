<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<a href="first">FirstPageOnCurrentController</a>
<br>
<button onclick="buttonCLicked()">FirstPageOnCurrentController1</button>
<button onclick="window.location.href ='first'">FirstPageOnCurrentController2</button>
<script>
function buttonCLicked()
{
	window.location.href = "first";
}
</script>
</body>
</html>