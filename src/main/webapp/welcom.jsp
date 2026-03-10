<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<%
    HttpSession mySession = request.getSession(false);

    if (mySession != null && mySession.getAttribute("username") != null) {
        String username = (String) mySession.getAttribute("username");
%>

    <div class="container">
        <h1>Welcome, <%= username %>!</h1>
        <p>We're delighted to have you on our platform. 🌟</p>
        <h3>Explore, learn, and connect with our vibrant community! 🚀</h3>
        <p>Feel free to stay as long as you like, and when you're ready,
            you can <a href="logout.jsp">LOGOUT</a> securely.
        </p>
    </div>

<%
    } else {
        response.sendRedirect("index.jsp");
        return;
    }
%>

</body>
</html>