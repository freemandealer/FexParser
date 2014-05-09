<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>FexParser</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-inverse" role="navigation">
  		 <a class="navbar-brand title" href="#">FexParser</a>
	</nav>
	<div class="container">
		<div class="row">
		<%out.write(request.getAttribute("htmlcodes").toString()); %>
			<div class="col-xs-offset-5">
				<button type="button" class="btn btn-info">Download html</button>
				<button type="button" class="btn btn-success">Download PDF</button>
			</div>
		</div>	
	</div>
			<nav class="navbar navbar-inverse footer" role="navigation">
				&copy;&nbsp;<a href="http://freemandealer.github.io">Freeman Zhang</a><br>
		FexParser is Freeman's Tex Parser, a Course Design for JavaEE@NUIST
		</nav>
	
</body>
	<script src="js/bootstrap.min.js"></script>
</html>
