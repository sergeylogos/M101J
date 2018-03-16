<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>${test}</h1>
    <hr>
    <form action="/saveGet" method="get">
        <input type="text" name="name">
        <input type="submit" name="">
    </form>
    <form action="/savePost" method="post">
        <input type="text" name="surname">
        <input type="submit" name="">
    </form>
    <a href="/path/variable">path varaible </a>
</body>
</html>