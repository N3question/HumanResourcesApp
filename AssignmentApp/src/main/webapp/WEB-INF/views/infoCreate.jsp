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
		<div class="row my-1">
			<div class="outbox">
				<div class="form2">
					<div class="d-flex justify-content-between mb-4">
						<h3>Info Create</h3>
						<h3>
						<a href="main" class="back-icon">
							<i class="bi bi-backspace"></i>
						</a>
						</h3>
					</div>
					<form action="info_create" method="post" class="form-controll">
						<table class="table table-borderless">
							<tr>
								<td>Member ID</td>
								<td>
									<input type="number" name="member_id" class="form-control" max-length="8" placeholder="00000000">	
								</td>
							</tr>
							<tr>
								<td>Name</td>
								<td>
									<input type="text" name="name" class="form-control">	
								</td>
							</tr>
							<tr>
								<td>Email</td>
								<td>
									<input type="email" name="email" class="form-control">	
								</td>
							</tr>
							<tr>
								<td>Gender</td>
								<td>
									<select name="gender" class="form-control">
										<option hidden>Please choose</option>
										<option value="0">No answer</option>
										<option value="1">Female</option>
										<option value="2">Male</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>Affiliation</td>
								<td>
									<select name="affiliation" class="form-control">
										<option hidden>Please choose</option>
										<option value="0">Legal Deaprtment</option>
										<option value="1">Accounting Department</option>
										<option value="2">Marketing Department</option>
										<option value="3">Public Relations Department</option>
										<option value="4">Business Department</option>
										<option value="5">Human Resources Division</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>Job Title</td>
								<td>
									<select name="job_title" class="form-control">
										<option hidden>Please choose</option>
										<option value="0">No title</option>
										<option value="1">Supervisor</option>
										<option value="2">Section chief</option>
										<option value="3">Section manager</option>
									</select>
								</td>
							</tr>
							<input type="hidden" name="password" value="sample1">
							<input type="hidden" name="administrator_flag" value="false">
						</table>
						<input type="submit" value="Create" class="btn submit w-100" style="background-color: limegreen; color: white;">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>