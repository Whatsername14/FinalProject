// Call the dataTables jQuery plugin
$(document).ready(function() {
    //On ready
});

async function registerUser(){
    let data = {};
    data.name = document.getElementById('usrName').value;
    data.phone = document.getElementById('usrPhone').value;
    data.email = document.getElementById('usrEmail').value;
    data.address = document.getElementById('usrAddress').value;
    data.password = document.getElementById('usrPass').value;

    if(document.getElementById('usrPass').value != document.getElementById('confirmPass').value){
        alert("Passwords doesn't match");
        return;
    }

      const request = await fetch('api/users', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });

      window.location.href = 'users.html';


}
