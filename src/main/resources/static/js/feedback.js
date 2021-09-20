// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadFeedback();
    $('#feedbackTable').DataTable();
});

async function loadFeedback(){
      const request = await fetch('api/feedbacks', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const feedbacks = await request.json();

      console.log(feedbacks);

      let feedbackList ='';

      for(let feedback of feedbacks){
        let btnEdit = '<a href="#" onclick="editFeedback('+feedback.feedbackId+')" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-edit"></i></a>';
        let btnDelete = '<a href="#" onclick="deleteFeedback('+feedback.feedbackId+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let feedbackTr ='<tr>'+
                        '<td>'+feedback.name+'</td>'+
                        '<td>'+feedback.email+'</td>'+
                        '<td>'+feedback.feedback+'</td>'+
                        '<td>'+
                            btnEdit +
                        '</td>'+
                        '<td>'+
                            btnDelete +
                        '</td>'+
                    '</tr>';
        feedbackList += feedbackTr;
      }


      document.querySelector('#feedbackTable tbody').outerHTML = feedbackList;

}

    async function deleteFeedback(id){

        if(!confirm('Do you wish to delete this feedback?')){
            return;
        }
       const request = await fetch('api/feedbacks/'+id, {
               method: 'DELETE',
               headers: {
                 'Accept': 'application/json',
                 'Content-Type': 'application/json'
               }
             });
       location.reload();
    }

    async function saveFeedback(){
            let data = {};
            data.name = document.getElementById('fdbName').value;
            data.email = document.getElementById('fdbEmail').value;
            data.feedback = document.getElementById('fdbFeedback').value;
            data.userId = 4;

            console.log(data);
              const request = await fetch('api/feedbacks', {
                method: 'POST',
                headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
              });

            location.reload();
        }