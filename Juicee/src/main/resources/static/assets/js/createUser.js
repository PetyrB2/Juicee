// A Javascript for POSTING User Registration Data back to the mySQL
const rootElement = document.getElementsByClassName('root')[0];
const button = document.querySelector('#submit');

// Refresh Page
function refreshPage(){
    window.location.reload();
} 


button.addEventListener('click', () => {
    postData()
   refreshPage()
    
})

// Function to POST to the db
function postData() {

// Our Variables
        const email = document.querySelector("#email").value;
        const password = document.querySelector("#password").value;
        const firstName = document.querySelector("#firstName").value;
        const lastName = document.querySelector("#lastName").value;
//Fetch command to POST 
    fetch("http://localhost:8080/Users/create", { //location of db
        method: 'post', // our method
        headers: {
        "Content-type": "application/json" //content type to post
        },
    body: JSON.stringify({
        email: email,
        password: password,
        firstName: firstName,
        lastName: lastName
    }),
})
.then((res) => console.log(res))
.catch((err) => console.log(err));




}




//Then read the result and other data.
// Function to GET CATEGORIES from the db
function fetchData() {
    fetch('http://localhost:8080/Users/read')
        .then((resp) => {
            if (resp.status != 200) console.error(resp.status);
            resp.json().then((data) => {
                console.log(data)
                showAllFacts(data)
            })
        });
}

function showAllFacts(data) {
    console.table(data)
    const rootElement = document.getElementsByClassName('root')[0];
    for (let i = 0; i < data.length; i++) {
        const newDiv = document.createElement('div');
        const p = document.createElement('p');
        const br = document.createElement('br');
        const br2 = document.createElement('br');
        const br3 = document.createElement('br');
        const hr = document.createElement('hr');



        // p.append(document.createTextNode(`ID: ${data[i][`id`]} Email: ${data[i][`email`]}  First Name: ${data[i][`firstName`]}  Last Name: ${data[i][`lastName`]}  `));
        p.append(document.createTextNode(` ID: ${data[i][`id`]} `));
        p.append(br);
        p.append(document.createTextNode(` Email: ${data[i][`email`]}  `));
        p.append(br2);
        p.append(document.createTextNode(` First Name: ${data[i][`firstName`]}  `));
        p.append(br3);
        p.append(document.createTextNode(` Last Name: ${data[i][`lastName`]}  `));
        p.append(hr);


        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);
    }
}
fetchData();
// showAllFacts();
