<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="main2.css">
  </head>


<body>
<form style="border:1px solid #ccc">
  <div class="container">
    <h1>Golf Score Card</h1>
    <p>Please use this to keep track of your score.</p>
    <hr>

    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstname" placeholder="Your name">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname" placeholder="Your last name">
    
    <label for="pScore">Enter your score:</label>
    <input type="text" placeholder:"Enter your score" name="score" style="margin-bottom:15px" required>
    
    <label for="par">Enter Par:</label>
    <input type="text" placeholder:"Par Number" name="parN" style="margin-bottom:15px" required>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="submitbtn">Submit score</button>
    </div>
  </div>
</form>

</body>
</html>

