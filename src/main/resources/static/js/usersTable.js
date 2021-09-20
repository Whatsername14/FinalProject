// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
    $('#userTable').DataTable();
});

async function loadUsers(){
      const request = await fetch('api/users', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const users = await request.json();

      console.log(users);

      let userList ='';

      for(let user of users){
        let btnEdit = '<a href="#" onclick=('+user.id+') class="btn btn-warning btn-circle btn-sm"><i class="fas fa-edit"></i></a>';
        let btnDelete = '<a href="#" onclick="deleteUser('+user.userId+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let userTr ='<tr>'+
                        '<td>'+user.name+'</td>'+
                        '<td>'+user.email+'</td>'+
                        '<td>'+user.phone+'</td>'+
                        '<td>'+user.address+'</td>'+
                        '<td>'+
                            btnEdit +
                        '</td>'+
                        '<td>'+
                            btnDelete +
                        '</td>'+
                    '</tr>';
        userList += userTr;
      }


      document.querySelector('#userTable tbody').outerHTML = userList;

}

    async function deleteUser(id){

        if(!confirm('Do you wish to delete this user?')){
            return;
        }
       const request = await fetch('api/users/'+id, {
               method: 'DELETE',
               headers: {
                 'Accept': 'application/json',
                 'Content-Type': 'application/json'
               }
             });
       location.reload();
    }

    async function editUser(id){
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

          location.reload();
   }

   async function saveUser(){
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

         location.reload();


   }
