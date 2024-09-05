<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>가위바위보 게임</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container">
        <h1 class="text-center my-4">가위바위보 게임</h1>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <form action="result.jsp" method="post" class="text-center">
                            <p class="mb-4">가위바위보를 선택하세요:</p>
                            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                <label class="btn btn-outline-primary">
                                    <input type="radio" name="userChoice" value="rock" required>
                                    <img src="${pageContext.request.contextPath}/resource/images/rock.png" alt="바위" style="width: 100px;">
                                </label>
                                <label class="btn btn-outline-primary">
                                    <input type="radio" name="userChoice" value="scissor">
                                    <img src="${pageContext.request.contextPath}/resource/images/scissor.png" alt="가위" style="width: 100px;">
                                </label>
                                <label class="btn btn-outline-primary">
                                    <input type="radio" name="userChoice" value="paper">
                                    <img src="${pageContext.request.contextPath}/resource/images/paper.png" alt="보" style="width: 100px;">
                                </label>
                            </div>
                            <div class="mt-4">
                                <button type="submit" class="btn btn-primary">결과 확인</button>
                            </div>
                        </form>
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


