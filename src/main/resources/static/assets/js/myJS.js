$(function () {
  var articleTypes = $(".d-inline-block");
  for (var i = 0; i < articleTypes.length; i++) {
    var jqObj = $(articleTypes[i]);
    var value = parseInt(jqObj.text());
    console.log("_" + value + "_");
    switch (value) {
      case 0:
        jqObj.text("Whatever");
        jqObj.addClass("text-primary");
        break;
      case 1:
        jqObj.text("Opinion");
        jqObj.addClass("text-danger");
        break;
      case 2:
        jqObj.text("Movies&Books");
        jqObj.addClass("text-info");
        break;
      case 3:
        jqObj.text("Animals&Plants");
        jqObj.addClass("text-success");
        break;
      case 4:
        jqObj.text("EnglishLearning");
        jqObj.addClass("text-warning");
        break;
      case 5:
        jqObj.text("Health");
        jqObj.addClass("text-success");
        break;
      case 6:
        jqObj.text("Design");
        jqObj.addClass("text-info");
        break;
      case 7:
        jqObj.text("Travel");
        jqObj.addClass("text-secondary");
        break;
      default:
        jqObj.text("没有标签……");
        jqObj.addClass("text-link");
    }
  }


});

function selectArticleType(obj) {
  var x = $(obj);
  x.attr("href", "/articles?articleType=" + x.attr("data"));
}

$("#btnLogin").on('click', function () {
  console.log("in login html");
  $.ajax({
    url: "/login",
    type: "post",
    data: {
      username: $("#username").val(),
      password: $("#password").val()
    },
    success: function (data) {
      console.log(data);
      if (data == '1')
        window.location.href = "/index";
      else
        alert("wrong!");
    }
  });
  return false;
});