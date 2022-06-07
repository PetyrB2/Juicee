// A Javascript for POSTING User Registration Data back to the mySQL


const rootElement = document.getElementsByClassName('root')[0];


// Function to POST to the db
function postData(event) {

event.preventDefault();

// Our Variables
        const name = document.querySelector("name").value;

//Fetch command to POST 
    fetch("http://localhost:8080/Category/create", { //location of db
        method: 'post', // our method
        headers: {
        "Content-type": "application/json" //content type to post
        },
    body: JSON.stringify({
        name: name,  
    }),
})
.then((res) => console.log(res))
.catch((err) => console.log(err));

//Button for SUBMIT 
const button = document.querySelectorAll('#submit');

button.addEventListener('click', (event) => {
    postData(event)
})

}



