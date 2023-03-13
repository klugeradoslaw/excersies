
<%@ page import="pl.klugeradoslaw.ex05lottery.LotteryResultDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wynik losowania</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<main>
    <% LotteryResultDto result = (LotteryResultDto) request.getAttribute("lotteryResult"); %>
    <h2>Wynik losowania: <%= result.getLotteryNumbers() %></h2>
    <h2>Twoje liczby: <%= result.getUserNumbers() %></h2>
    <h2>Liczba trafień: <%= result.getWinnerNumbers().size() %></h2>
    <h2>Trafione liczby: <%= result.getWinnerNumbers() %></h2>
</main>
</body>
</html>