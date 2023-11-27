<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.HumanResourcesBeans, java.util.ArrayList, java.util.List, model.map.JobTitleMap, model.map.AffiliationMap, model.map.GenderMap"%>
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
		<div class="row my-2">
			<div class="outbox">
				<div class="form2">
					<div class="d-flex justify-content-between mb-4">
						<h3>Info Edit</h3>
						<h3>
						<a href="main" class="back-icon">
							<i class="bi bi-backspace"></i>
						</a>
						</h3>
						
					</div>
					<% 
					HumanResourcesBeans HRinfo = (HumanResourcesBeans)session.getAttribute("HRinfo");
					%>
					<form action="info_change?id=<%= HRinfo.getId() %>" method="post" class="form-controll">
						<table class="table table-borderless">
							<tr>
								<td>ID</td>
								<td><%= HRinfo.getId() %></td>
							</tr>
							<tr>
								<td>Member ID</td>
								<td><%= HRinfo.getMemberId() %></td>
							</tr>
							<tr>
								<td>Name</td>
								<td>
									<input type="text" name="name" class="form-control" value="<%= HRinfo.getName() %>">	
								</td>
							</tr>
							<tr>
								<td>Email</td>
								<td>
									<input type="email" name="email" class="form-control" value="<%= HRinfo.getEmail() %>">	
								</td>
							</tr>
							<tr>
								<td>Gender</td>
								<td>
									<select name="gender" class="form-control">
									<%
									ArrayList<Integer> genderList = (ArrayList<Integer>) request.getAttribute("genderList");
									%>
									<%
									for (Integer beans : genderList) {
									%>
										<%
										if (beans == HRinfo.getGender()) {
										%>
											<option selected value="<%= beans %>">
												<%= GenderMap.getGender(beans) %>
											</option>
										<%
										} else {
										%>
											<option value="<%= beans %>">
												<%= GenderMap.getGender(beans) %>
											</option>
										<%
										}
										%>
									<%
									}
									%>
									</select> 
								</td>
							</tr>
							<tr>
								<td>Affiliation</td>
								<td>
									<select name="affiliation" class="form-control">
									<%
									ArrayList<Integer> affiliationList = (ArrayList<Integer>) request.getAttribute("affiliationList");
									%>
									<%
									for (Integer beans : affiliationList) {
									%>
										<%
										if (beans == HRinfo.getAffiliation()) {
										%>
											<option selected value="<%= beans %>">
												<%= AffiliationMap.getAffiliation(beans) %>
											</option>
										<%
										} else {
										%>
											<option value="<%= beans %>">
												<%= AffiliationMap.getAffiliation(beans) %>
											</option>
										<%
										}
										%>
									<%
									}
									%>
									</select>
								</td>
							</tr>
							<tr>
								<td>Job Title</td>
								<td>
									<select name="job_title" class="form-control">
									<%
									ArrayList<Integer> jobTitleList = (ArrayList<Integer>) request.getAttribute("jobTitleList");
									%>
									<%
									for (Integer beans : jobTitleList) {
									%>
										<%
										if (beans == HRinfo.getJobTitle()) {
										%>
											<option selected value="<%= beans %>">
												<%= JobTitleMap.getJobTitle(beans) %>
											</option>
										<%
										} else {
										%>
											<option value="<%= beans %>">
												<%= JobTitleMap.getJobTitle(beans) %>
											</option>
										<%
										}
										%>
									<%
									}
									%>
									</select>
								</td>
							</tr>
						</table>
						<input type="submit" value="Edit" class="btn btn-dark submit w-100">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>