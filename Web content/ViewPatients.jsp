<!DOCTYPE html>
<html>
<head>
    <title>View Patients</title>
</head>
<body>
    <h1>Patient Records</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Medical Condition</th>
            <th>Actions</th>
        </tr>
        <%
            List<Patient> patientList = (List<Patient>) request.getAttribute("patientList");
            if (patientList != null) {
                for (Patient patient : patientList) {
        %>
        <tr>
            <td><%= patient.getId() %></td>
            <td><%= patient.getName() %></td>
            <td><%= patient.getAge() %></td>
            <td><%= patient.getMedicalCondition() %></td>
            <td>
                <a href="main?action=edit&id=<%= patient.getId() %>">Edit</a> |
                <a href="main?action=delete&id=<%= patient.getId() %>">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">No patient records found.</td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <a href="main?action=add">Add New Patient</a>
</body>
</html>
