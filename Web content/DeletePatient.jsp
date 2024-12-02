<!DOCTYPE html>
<html>
<head>
    <title>Delete Patient</title>
</head>
<body>
    <h1>Delete Patient</h1>
    <p>Are you sure you want to delete this patient record?</p>
    <form action="main" method="get">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
        <button type="submit">Yes, Delete</button>
    </form>
    <br>
    <a href="main?action=view">No, Go Back</a>
</body>
</html>
