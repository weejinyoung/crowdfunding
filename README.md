<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>WEB1 - HTML</title>
<script src = "event.js"></script>
<input type = "button" value = "night" onclick = "clickButton.night_dayHandler(this);">
</head>
<style>
body{
  margin:0;
}
h1{
  font-size: 45px;
  text-align: center;
  border-bottom:1px solid gray;
  margin:0;
  padding:20px;
}
ol{
  border-right:1px solid gray;
  width:100px;
  margin:0;
  padding:20px;
}
#grid{
  display: grid;
  grid-template-columns: 150px 1fr;
}
#grid ol{
  padding-left:33px;
}
#grid #article{
  padding-left:25px;
}

</style>

<body>
  <h1><a href = "WEB.html">WEB</a></h1>
  <div id = "grid">
    <ol>
      <li><a href = "HTML.html">HTML</a></li>
      <li><a href = "CSS.html" >CSS</a></li>
      <li><a href = "JavaScript.html">JavaScript</a></li>
    </ol>
    <div id = "article">
      <h2>HTML</h2>
      <p>
      HTML is beautiful and fantastic and good
    </p>
    </div>
  </div>
</body>
</html>
