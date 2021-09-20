// Call the dataTables jQuery plugin
$(document).ready(function() {
    //On ready
});

async function login(){
    let data = {};
    data.email = document.getElementById('loginEmail').value;
    data.password = document.getElementById('loginPassword').value;

      const request = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });
      const response = await request.text();

    if(response == 'OK'){
        window.location.href = 'users.html';
    }else{
        alert('Incorrect email or password. Try again!');
    }


}