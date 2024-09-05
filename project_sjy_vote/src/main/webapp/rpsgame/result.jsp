<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게임 결과</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container">
        <h1 class="text-center my-4">가위바위보 결과</h1>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body text-center">
                        <%
                        	request.setCharacterEncoding("UTF-8");
                            String userChoice = request.getParameter("userChoice");
                            String[] options = { "scissor", "rock", "paper" };
                            int randomIndex = (int) (Math.random() * 3);
                            String computerChoice = options[randomIndex];
                            String result = "";

                            if (userChoice.equals(computerChoice)) {
                                result = "무승부!";
                            } else if ((userChoice.equals("scissor") && computerChoice.equals("paper")) ||
                                       (userChoice.equals("rock") && computerChoice.equals("scissor")) ||
                                       (userChoice.equals("paper") && computerChoice.equals("rock"))) {
                                result = "사용자 승리!";
                            } else {
                                result = "컴퓨터 승리!";
                            }
                        %>
                        <h2>사용자 선택: <%= userChoice %></h2>
                        <img src="${pageContext.request.contextPath}/resource/images/<%= userChoice %>.png" alt="<%= userChoice %>" style="width: 100px;">
                        <h2>컴퓨터 선택: <%= computerChoice %></h2>
                        <img src="${pageContext.request.contextPath}/resource/images/<%= computerChoice %>.png" alt="<%= computerChoice %>" style="width: 100px;">
                        <h2 class="mt-4"><%= result %></h2>
                        <a href="index.jsp" class="btn btn-primary mt-4">다시 하기</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>


