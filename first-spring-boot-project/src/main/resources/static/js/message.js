document.addEventListener("DOMContentLoaded", function(event) {
  var messageLinks = document.getElementsByClassName("message-link");
  for (var i = 0; i < messageLinks.length; i++) {
    messageLinks[i].addEventListener("click", function(event) {
      event.preventDefault();
      var message = this.previousElementSibling.innerHTML;
      showMessage(message);
    });
  }

  function showMessage(message) {
    var messageDiv = document.createElement("div");
    messageDiv.innerHTML = message;
    messageDiv.className = "message";
    document.body.appendChild(messageDiv);
    setTimeout(function() {
      messageDiv.parentNode.removeChild(messageDiv);
    }, 3000);
  }
});
