<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./javascriptWithPoll.css" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="../../static/css/commons.css" />
  </head>
  <body>
    <%! int count = 0; %>
    <div class="container mt-5">
      <form action="/poll/PollServlet" method="get">
        <div>
          <button class="primary" name="order" id="prev" onclick="" value="<%= count = --count %>">Prevjsp</button>
          <button class="primary" name="order" id="next" onclick="" value="<%= count = ++count %>">Nextjsp</button>
        </div>
      </form>
      <!-- for question list -->
      <div></div>
      <!-- for answer list -->
      <div></div>
      <div id="statistics"></div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
