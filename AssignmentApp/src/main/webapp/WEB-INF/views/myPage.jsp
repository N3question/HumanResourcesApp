<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.HumanResourcesBeans"%>
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
				<div class="mypage">
					<% 
					HumanResourcesBeans userInfo = (HumanResourcesBeans)request.getAttribute("userInfo");
					%>
					<div class="d-flex justify-content-between">
						<h3 class="mb-3">My page</h3>
						<% if (userInfo.getJobTitle() >= 2) { %>
							<h3>
								<a href="main" class="back-icon">
									<i class="bi bi-backspace"></i>
								</a>
							</h3>
						<% } %>
					</div>
					<% String message = (String)request.getAttribute("message"); %>
					<% if (message != null) { %>
			    		<p class="success"><%= message %></p>
			    	<% } %>
					<table class="table table-borderless">
						<tr>
							<td>ID</td>
							<td><%= userInfo.getId() %></td>
						</tr>
						<tr>
							<td>Member ID</td>
							<td><%= userInfo.getMemberId() %></td>
						</tr>
						<tr>
							<td>Name</td>
							<td><%= userInfo.getName() %></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><%= userInfo.getEmail() %></td>
						</tr>
						<tr>
							<td>Gender</td>
							<td><%= userInfo.getGender() %></td>
						</tr>
						<tr>
							<td>Affiliation</td>
							<td><%= userInfo.getAffiliation() %></td>
						</tr>
						<tr>
							<td>Job Title</td>
							<td><%= userInfo.getJobTitle() %></td>
						</tr>
					</table>
					<% if (userInfo.getJobTitle() < 2) { %>
			    		<a href="logout" class="btn btn-dark w-100 mt-5">Logout</a>
			    	<% } else {%>
					<a href="info_change?id=<%= userInfo.getId() %>" class="btn btn-dark w-100 mt-5">Edit info</a>
					<% } %>
				</div>
			</div>
		</div>
	</div>
</body>
</html>