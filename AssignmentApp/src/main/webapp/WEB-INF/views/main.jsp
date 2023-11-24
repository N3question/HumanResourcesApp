<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.util.List, model.bean.HumanResourcesBeans"%>
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
		<div class="row mt-5">
			<div class="col-lg-11 mx-auto">
				<div class="mb-5">
					<h1>index</h1>
					<% String message = (String)request.getAttribute("message"); %>
					<% if (message != null) { %>
			    		<p class="success"><%= message %></p>
			    	<% } %>
					<nav>
						<ul class="m-0 p-0">
							<li>
								<a href="mypage">My page</a>
							</li>
							</li>
							<li>
								<a href="logout">Logout</a>
							</li>
							<li>
								<a href="info_create" class="btn btn-sm px-3" style="background-color: limegreen; color: white; border-radius: 40px;">
									<i class="bi bi-plus"></i>Create Member
								</a>
							</li>
						</ul>
					</nav>
					<%-- <% String message = (String)request.getAttribute("message"); %>
					<% if (message != null) { %>
			    		<p class="success"><%= message %></p>
			    	<% } %> --%>
		    	</div>
				<table class="table">
					<tr>
						<th>ID</th>
						<th>Member ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Gender</th>
						<th>Affiliation</th>
						<th>Job Title</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
					<!-- Beansで定義しているメソッド()の引数があるかないかを覚えておく。 -->
					<% 
				      ArrayList<HumanResourcesBeans> HRList = (ArrayList)request.getAttribute("HRList");
				    %>
					<% 
				      for (HumanResourcesBeans HR : HRList) {
				    %>
						<tr>
							<td><%= HR.getId() %></td>
						    <td><%= HR.getMemberId() %></td>
						    <td><%= HR.getName() %></td>
						    <td><%= HR.getEmail() %></td>
						    <td><%= HR.getGender() %></td>
						    <td><%= HR.getAffiliation() %></td>
						    <td><%= HR.getJobTitle() %></td>
						    <td>
						    	<a href='info_change?id=<%= HR.getId() %>'>
						    		<i class="bi bi-pencil-square"></i>
						    	</a>
							</td>
						    <td>
						    	<% if (HR.getId() != 1) { %>
						    	<a href="info_destroy_confirm?id=<%= HR.getId() %>">
						    		<i class="bi bi-trash delete"></i>
						    	</a>
						    	<% } %>
						    </td>
						</tr>
					<% } %>
				</table>
			</div>
		</div>
    </div>
</body>
</html>