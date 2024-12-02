<!DOCTYPE html>
<html>
<head>
    <title>Add Patient</title>
</head>
<body>
    <h1>Add New Patient</h1>
    <form action="main" method="post">
        <input type="hidden" name="action" value="add">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age" required><br><br>

        <label for="medicalCondition">Medical Condition:</label><br>
        <textarea id="medicalCondition" name="medicalCondition" required></textarea><br><br>

        <button type="submit">Add Patient</button>
    </form>
    <br>
    <a href="main?action=view">Back to Patient List</a>
</body>
</html>
