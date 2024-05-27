<%-- 
    Document   : AddRegistrations
    Created on : May 27, 2024, 3:36:05 PM
    Author     : nguye
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Registration</title>
</head>
<body>
    <h2>Add Registration</h2>
    <form action="addRegistration" method="post">
        UserID: <input type="text" name="userID" /><br/>
        SubjectID: <input type="text" name="subjectID" /><br/>
        PackageID: <input type="text" name="packageID" /><br/>
        Total Cost: <input type="text" name="totalCost" /><br/>
        Status: <input type="text" name="status" /><br/>
        Valid From: <input type="text" name="validFrom" /><br/>
        Valid To: <input type="text" name="validTo" /><br/>
        Created At: <input type="text" name="createdAt" /><br/>
        <input type="submit" value="Add" />
    </form>
</body>
</html>
