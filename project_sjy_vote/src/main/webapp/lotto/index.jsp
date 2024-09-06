<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>LOTTO</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
  rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
  integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <style>
    header {
      padding-bottom: 30px; 
    }
    .footer {
      position: fixed;
      bottom: 0;
      left: 0;
      width: 100%;
      background-color: black;
      text-align: center;
      padding-top: 10px;
      padding-bottom: 5px;
      color: white;
      font-size:15px;
    }
    .navbar {
      padding: 20px 0; 
    }
    
    
    .navb                                                                                                                                                                                                                                   ar-nav .nav-link {
      color: white; 
    }
  </style>
</head>
<body>
<!--부트스트랩-->
 <header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">로또 추첨</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul id="navbar" class="navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3">
             <li class="nav-item">
                  <a class="nav-link me-4" href="#">HOME</a>
                </li>
        </div>
      </div>
    </nav>
  </header>
  <br>
<!--로또 추첨-->
    <div class="text-center">
        <h1 class="my-2 display-4">로또</h1>
        <p class="lead">아래 버튼 클릭시 45개 번호 중 6개가 추첨됩니다</p>
        <button class="btn btn-success btn-lg" onclick="drawLottery()">추첨</button>
        <button class="btn btn-warning btn-lg" onclick="eraseHistory()">초기화</button>
    </div>
    <br>
    <br>
    <div class="alert alert-success text-center" role="alert" id="resultSection"></div>   
    <div class="alert alert-warning text-center" role="alert" id="ResetSection"></div>
    <script>
        function drawLottery() {
            let drawnNumbers = [];
            for (let i = 0; i < 6; i++) {
                let number;
                do {
                    number = Math.floor(Math.random() * 45) + 1;
                } while (drawnNumbers.includes(number));
                drawnNumbers.push(number);
            }
            drawnNumbers.sort((a, b) => a - b);

            let resultSection = document.getElementById('resultSection');
            resultSection.innerHTML = '당첨 번호 : ' + drawnNumbers.join('  ');

            let historySection = document.getElementById('ResetSection');
            historySection.innerHTML += '이전 당첨 번호 : ' + drawnNumbers.join('  ') + '<br>';
        }
        function eraseHistory() {
            let resultSection = document.getElementById('resultSection');
            let historySection = document.getElementById('ResetSection');
            resultSection.innerHTML = ''; 
            historySection.innerHTML = '';  
        }
    </script>
 
    <footer class="footer">
      <p>&copy COPYRIGHT 2024 FIVE CODING</p>
    </footer>
</body>
</html>
