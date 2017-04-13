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
    <title>심청넷 검색하기</title>
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

    <div class="row" id="title" onload="div.title.focus;">
      <div class="back">
        <button type="button" title="뒤로가기" class="btn btn-primary btn-lg" onclick="location.href='/index.php'" onfocus="onfocus_event(this);">뒤로가기</button>
      </div>
    </div>

    <div class="row">
      <div class="col-md-4 col-md-offset-5">
        <br><br>
        <form class="form-inline" action="/result.php">
            <div class="form-group">
              <div class="input-group">
                <input type="text" class="form-control" style="font-size:20pt; height:70px;" title="검색어를 입력 후 엔터키를 누르세요" name="text" onfocus="onfocus_event(this);" placeholder="검색어를 입력하세요.">
              </div>
            </div>
            <button type="submit" style="height:70px;" class="btn btn-primary">검색</button>
        </form>

      </div>
    </div>
  </body>
</html>
