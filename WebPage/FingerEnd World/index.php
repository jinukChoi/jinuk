<?php
  require("lib/script.php");
 ?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>심청넷</title>
    <link rel="shortcut icon" href="/sim.ico">
    <!-- Bootstrap -->
    <link href="/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/style.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>

    <audio src="" class="speech" hidden rel="noreferrer"></audio>

    <br>
    <br>

    <!-- 한줄 공백 만들기 -->
    <div class="row text-center" id="title" onload="div.title.focus;">
      <img src="/title.jpg" class="img-rounded" width=450px; onfocus="blur">
    </div>

    <br>

    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <button type="button" style="font-size:20pt;" title="검색하기" class="btn btn-primary btn-lg btn-block" onclick="location.href='/search.php'" onfocus="onfocus_event(this);">1. 검색하기</button>
      </div>
      <div class="col-md-4 col-md-offset-4">
        <button type="button" style="font-size:20pt;" class="btn btn-primary btn-lg btn-block">2. *</button>
      </div>
      <div class="col-md-4 col-md-offset-4">
        <button type="button" style="font-size:20pt;" class="btn btn-primary btn-lg btn-block">3. *</button>
      </div>
      <div class="col-md-4 col-md-offset-4">
        <button type="button" style="font-size:20pt;" class="btn btn-primary btn-lg btn-block">4. *</button>
      </div>
    </div>

  </body>
</html>
