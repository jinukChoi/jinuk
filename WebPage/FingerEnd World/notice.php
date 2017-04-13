<?php
  require("lib/lib.php");
  require("lib/simple_html_dom.php");
 ?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>손 끝으로 보는 세상</title>

  </head>
  <body>

    <div class="row" id="title" onload="div.title.focus;">
      <div class="back">
        <button type="button" title="뒤로가기" class="btn btn-primary btn-lg" onclick="location.href='/index.php'" onfocus="onfocus_event(this.title);">뒤로가기</button>
      </div>
    </div>

    <?php
      $query="location.href='/result.php?query=";
      $html=file_get_html('http://www.kbuwel.or.kr/Board/Notice/List');
      $keyword=array();
      $index=0;
      echo '<div class="row">';
      foreach ($html->find('table[class=board]') as $article) {
        foreach ($article->find('a') as $op) {
            $title[$index] = $op->innertext;
            $keyword[$index] = $op->herf;
            echo '<div class="col-md-5 col-md-offset-2">';
            echo '<button onclick="'.$query.$keyword[$index]."'".
            '"'.'type="button" title="'.$title[$index].
            '" style="font-size:15pt;" class="btn btn-primary btn-lg btn-block"
            onfocus="onfocus_event(this.title);">'.$title[$index].'</button></div>';
            $index++;
        }
      }
      echo '</div>';
    ?>
  </body>
</html>
