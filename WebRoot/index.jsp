<!doctype html>
<%@page import="com.freeman.fexparser.parser.simtex.Compiler"%>
<html lang="en">
<head>
<meta charset="ANSI">
<title>FexParser</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<%@ page import="com.freeman.fexparser.parser.simtex.*"%>
</head>

<%
	String str;
	str = request.getParameter("rawcodes");
	if (str != null) {
		str = Compiler.parse(str);
			if (true) {
			request.setAttribute("htmlcodes", str);
%>
<jsp:forward page="parseok.jsp"/>
<%
	}
	}

%>



<body>
	<nav class="navbar navbar-inverse" role="navigation">
		<a class="navbar-brand title" href="#">FexParser</a>
	</nav>
	<div class="container">
		<div class="row">
			<form role="form" name="form1" action="/FexParser/index.jsp">
				<div class="form-group code-input">
					<textarea class="form-control" name="rawcodes" rows="20"></textarea>
				</div>
				<div class="row">
					<div class="form-group col-xs-2 col-xs-offset-2">
						<select class="form-control">
							<option>SimTex</option>
							<option>MarkDown(not available)</option>
							<option>LaTex(not available)</option>
						</select>
					</div>
					<div class="form-group col-xs-offset-2">
						<button type="submit" class="btn btn-info">Parse</button>
						<button type="submit" class="btn btn-success">Save as
							draft</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<nav class="navbar navbar-inverse footer" role="navigation">
		&copy;&nbsp;<a href="http://freemandealer.github.io">Freeman Zhang</a><br>
		FexParser is Freeman's Tex Parser, a Course Design for JavaEE@NUIST
		</nav>

</body>
<script src="js/bootstrap.min.js"></script>
</html>
