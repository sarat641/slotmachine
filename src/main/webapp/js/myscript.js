
function deleteRow(row, id) {
    var i = row.parentNode.parentNode.rowIndex;

    $.ajax({
        type: "DELETE",
        contentType: "application/json; charset=utf-8",
        url: "image/rest/api/" + id,
        success: function (resp) {
            document.getElementById('fileUploads').deleteRow(i);
        },
        error: function (e) {
            alert('Error occure while deleting: ' + e);
        }
    });
}
function validation() {
    var fileName = document.getElementById("fileName").value;
    var price = document.getElementById("price").value;
    var logo = document.getElementById("logo").value;
    var value = Number(price);
    var ext = logo.substring(logo.lastIndexOf('.') + 1);
    if (fileName.length < 1) {
        alert("Please enter File Name");
        return false;
    } else if (price.length < 1) {
        alert("Please enter price");
        return false;
    }

    else if (!(Math.floor(value) == value)) {
        alert("Price value must be integer");
        return false;
    }

    else if (ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG")
    {
        return true;
    }
    else
    {
        alert("Upload Gif,Png or Jpg images only");
        return false;
    }
}
function editValidation() {
    var fileName = document.getElementById("fileName").value;
    var price = document.getElementById("price").value;
    var logo = document.getElementById("logo").value;
    var value = Number(price);
    var ext = logo.substring(logo.lastIndexOf('.') + 1);
    if (fileName.length < 1) {
        alert("Please enter File Name");
        return false;
    } else if (price.length < 1) {
        alert("Please enter price");
        return false;
    }

    else if (!(Math.floor(value) == value)) {
        alert("Price value must be integer");
        return false;
    }
    else if (logo.length == 0) {
        return true;
    }
    else if (ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG")
    {
        return true;
    }
    else
    {
        alert("Upload Gif,Png or Jpg images only");
        return false;
    }
}
var interval;
function startTimer() {
    interval = setInterval(myrefresh, 1000);
}
function myrefresh() {
    $.ajax({
        type: "GET",
        contentType: "application/json; charset=utf-8",
        url: "image/rest/api",
        success: function (resp) {
            var result = resp.split(":");
            var fieldNameElement = document.getElementById('show1');

            var imageText1 = "<img src=\"http://localhost:8084/SpringMVC/myImage/imageDisplay?id=" + result[0] + "\"/>";
            var imageText2 = "<img src=\"http://localhost:8084/SpringMVC/myImage/imageDisplay?id=" + result[1] + "\"/>";
            var imageText3 = "<img src=\"http://localhost:8084/SpringMVC/myImage/imageDisplay?id=" + result[2] + "\"/>";
            fieldNameElement.innerHTML = imageText1 + imageText2 + imageText3;
            if (result[0] == result[1] && result[1] == result[2] && result[2] == result[0]) {
                clearTimer();
            }
        },
        error: function (e) {
            alert('Error occure while deleting: ' + e);
        }
    });
}
function clearTimer() {
    clearInterval(interval);
    document.getElementById('myLinkID').click();
}
$(document).ready(function () {
    $(".modalbox").fancybox();
    $("#contact").submit(function () {
        return false;
    });

    $("#send").on("click", function () {
        var email = $("#email").val();
        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (!filter.test(email)) {
            alert('Please provide a valid email address');
            return;
        }

        var JSONObject = {"recipient": email};
        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: "image/rest/api/sendMail",
            dataType: "json",
            data: JSON.stringify(JSONObject),
            success: function (resp) {
                alert("Mail Send succuess")
                $.fancybox.close();
            },
            error: function (e) {
                alert(e);
            }
        });
    });
});
