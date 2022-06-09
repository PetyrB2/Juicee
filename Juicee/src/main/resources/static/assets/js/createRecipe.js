// A Javascript for POSTING User Registration Data back to the mySQL
const rootElement = document.getElementsByClassName('root')[0];
const button = document.querySelector('#submit');

// Refresh after Add
function refreshPage(){
    window.location.reload();
} 

button.addEventListener('click', () => {
    postData()
    refreshPage()
})

// Function to POST to the db
function postData() {


// Our Variables        const name = document.querySelector("#name").value;

        const name = document.querySelector("#name").value;
        const description = document.querySelector("#description").value;
        const howto = document.querySelector("#howto").value;
        const imgUrl = document.querySelector("#imgUrl").value;
        

//Fetch command to POST 
    fetch("http://localhost:8080/Recipe/create", { //location of db
        method: 'post', // our method
        headers: {
        "Content-type": "application/json" //content type to post
        },
    body: JSON.stringify({
        name: name,
        description: description,
        howto: howto,
        imgUrl: imgUrl
    }),
})
.then((res) => console.log(res))
.catch((err) => console.log(err));




}




//Then read the result and other data.
// Function to GET CATEGORIES from the db
function fetchData() {
    fetch('http://localhost:8080/Recipe/read')
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
        const Image = document.createElement('img');
        
        p.append(document.createTextNode(`ID: ${data[i][`id`]} Name: ${data[i][`name`]}  Description: ${data[i][`description`]}  Preparation: ${data[i][`howto`]}  Image URL: ${data[i][`imgUrl`]}  `));
        img.append(document.createElement())

        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);
    }
}
fetchData();
// showAllFacts();
