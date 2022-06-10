// A Javascript for POSTING User Registration Data back to the mySQL
const rootElement = document.getElementsByClassName('root')[0];
const button = document.querySelector('#submit');

button.addEventListener('click', () => {
    postData()
    
})

// Function to POST to the db
function postData() {

// Our Variables
        const name = document.querySelector("#name").value;

//Fetch command to POST 
    fetch("http://localhost:8080/Roles/create", { //location of db
        method: 'post', // our method
        headers: {
        "Content-type": "application/json" //content type to post
        },
    body: JSON.stringify({
        name: name
    }),
})
.then((res) => console.log(res))
.catch((err) => console.log(err));




}




//Then read the result and other data.
// Function to GET CATEGORIES from the db
function fetchData() {
    fetch('http://localhost:8080/Roles/read')
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
        p.append(document.createTextNode(`ID: ${data[i][`id`]} Role: ${data[i][`name`]} `));

        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);
    }
}
fetchData();
// showAllFacts();
