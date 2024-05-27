<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registrations</title>
    </head>
    <body>
        <h1>Registrations</h1>
        <table border="1">
            <tr>
                <th>RegisterID</th>
                <th>UserID</th>
                <th>SubjectID</th>
                <th>PackageID</th>
                <th>Total Cost</th>
                <th>Status</th>
                <th>Valid From</th>
                <th>Valid To</th>
                <th>Created At</th>
            </tr>

            <tr>
                <c:forEach items="${registrations}" var="o">

                    <td>${o.registerID}</td>
                    <td>${o.userID}</td>
                    <td>${o.subjectID}</td>
                    <td>${o.packageID}</td>
                    <td>${o.totalCost}</td>
                    <td>${o.status}</td>           
                    <td>${o.validFrom}</td>
                    <td>${o.validTo}</td>
                    <td>${o.createdAt}</td>
                </tr>   
            </c:forEach>
        </table>
    </body>
</html>
