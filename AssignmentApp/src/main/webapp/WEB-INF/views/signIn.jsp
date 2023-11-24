<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="outbox">
				<div class="form">
					<h3 class="mb-3">Login</h3>
					<%-- <% String err_message = (String) session.getAttribute("err_message"); %>
					<% if (err_message != null) { %>
			    		<p class="success"><%= err_message %></p>
			    	<% } %> --%>
					<form action="signin" method="post" class="form-controll">
						<div class="mb-3">
							<label class="form-label">Member ID</label>
							<input type="number" min="0" name="member_id" class="form-control" maxlength="8">
						</div>
						<div class="mb-3">
							<label class="form-label">Password</label>
							<input type="password" name="password" class="form-control">
						</div>
						<input type="submit" value="Login" class="btn btn-dark submit w-100">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>