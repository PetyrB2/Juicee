// A Javascript for POSTING User Registration Data back to the mySQL
const rootElement = document.getElementsByClassName('root');


// Function to POST to the db
function postData() {

    // Our Variables
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        const firstName = document.getElementById("firstName").value;
        const lastName = document.getElementById("lastName").value;


    fetch("localhost:8080/process-register", { //location of db
        method: 'post', //our method
        headers: {
        "Content-type": "application/json" //content type to post
        },
    body: JSON.stringify({
        email: email,
        password: password,
        firstName: firstName,
        lastName: lastName,    
    })
});
postData();

}

// To run the Post request

