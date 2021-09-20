// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadCourses();
    $('#courseTable').DataTable();
});

async function loadCourses(){
      const request = await fetch('api/courses', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const courses = await request.json();

      console.log(courses);

      let courseList ='';

      for(let course of courses){
        let btnEdit = '<a href="#" onclick="editCourse('+course.courseId+')" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-edit"></i></a>';
        let btnDelete = '<a href="#" onclick="deleteCourse('+course.courseId+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let courseTr ='<tr>'+
                        '<td>'+course.courseName+'</td>'+
                        '<td>'+course.courseResource+'</td>'+
                        '<td>'+course.courseFee+'</td>'+
                        '<td>'+course.courseDescription+'</td>'+
                        '<td>'+
                            btnEdit +
                        '</td>'+
                        '<td>'+
                            btnDelete +
                        '</td>'+
                    '</tr>';
        courseList += courseTr;
      }


      document.querySelector('#courseTable tbody').outerHTML = courseList;

}


async function deleteCourse(id){

        if(!confirm('Do you wish to delete this course?')){
            return;
        }
       const request = await fetch('api/courses/'+id, {
               method: 'DELETE',
               headers: {
                 'Accept': 'application/json',
                 'Content-Type': 'application/json'
               }
             });
       location.reload();
    }

    async function saveCourse(){
        let data = {};
        data.courseName = document.getElementById('crsName').value;
        data.courseResource = document.getElementById('crsResource').value;
        data.courseFee = document.getElementById('crsFee').value;
        data.courseDescription = document.getElementById('crsDesc').value;

        console.log(data);
          const request = await fetch('api/courses', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
          });

        location.reload();
    }
