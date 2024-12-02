<!DOCTYPE html>
<html>
<head>
    <title>Update Patient</title>
</head>
<body>
    <h1>Update Patient Details</h1>
    <%
        Patient patient = (Patient) request.getAttribute("patient");
        if (patient != null) {
    %>
    <form action="main" method="post">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="<%= patient.getId() %>">
        
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" value="<%= patient.getName() %>" required><br><br>

        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age" value="<%= patient.getAge() %>" required><br><br>

        <label for="medicalCondition">Medical Condition:</label><br>
        <textarea id="medicalCondition" name="medicalCondition" required><%= patient.getMedicalCondition() %></textarea><br><br>

        <button type="submit">Update Patient</button>
    </form>
    <% } else { %>
    <p>Invalid patient details.</p>
    <% } %>
    <br>
    <a href="main?action=view">Back to Patient List</a>
</body>
</html>
