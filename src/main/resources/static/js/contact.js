// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadContacts();
    $('#contactTable').DataTable();
});

async function loadContacts(){
      const request = await fetch('api/contacts', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const contacts = await request.json();

      console.log(contacts);

      let contactList ='';

      for(let contact of contacts){
        let btnEdit = '<a href="#" onclick="editContact('+contact.contactId+')" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-edit"></i></a>';
        let btnDelete = '<a href="#" onclick="deleteContact('+contact.contactId+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let contactTr ='<tr>'+
                        '<td>'+contact.name+'</td>'+
                        '<td>'+contact.phone+'</td>'+
                        '<td>'+contact.email+'</td>'+
                        '<td>'+contact.message+'</td>'+
                        '<td>'+
                            btnEdit +
                        '</td>'+
                        '<td>'+
                            btnDelete +
                        '</td>'+
                    '</tr>';
        contactList += contactTr;
      }


      document.querySelector('#contactTable tbody').outerHTML = contactList;

}


async function deleteContact(id){

        if(!confirm('Do you wish to delete this contact?')){
            return;
        }
       const request = await fetch('api/contacts/'+id, {
               method: 'DELETE',
               headers: {
                 'Accept': 'application/json',
                 'Content-Type': 'application/json'
               }
             });
       location.reload();
    }

    async function saveContact(){
        let data = {};
        data.name = document.getElementById('ctcName').value;
        data.phone = document.getElementById('ctcPhone').value;
        data.email = document.getElementById('ctcEmail').value;
        data.message = document.getElementById('ctcMessage').value;
        data.userId = 4;

        console.log(data);
          const request = await fetch('api/contacts', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
          });

        location.reload();
    }

    async function editContact(id){
        let data = {};
        data.name = $(this).
        data.phone = document.getElementById('ctcPhone').value;
        data.email = document.getElementById('ctcEmail').value;
        data.message = document.getElementById('ctcMessage').value;
        data.userId = 4;
    }
