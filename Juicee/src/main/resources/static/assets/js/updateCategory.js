// A Javascript for POSTING User Registration Data back to the mySQL
const rootElement = document.getElementsByClassName('root')[0];
const button = document.querySelector('#submit');

const button2 = document.querySelector('#refresh');


// Refresh Page

function refreshPage(){
    window.location.reload();
} 

button2.addEventListener('click', () => {
    refreshPage()
   
});



// Button Event Listener & refresh page 
button.addEventListener('click', () => {
    postData(catid.value, cats.value)
   
})



// Function to POST to the db

    let postData = (id) => {
// Our Variables
        const catid = document.querySelector("#catid").value;
        const cats = document.querySelector("#cats").value;


//Fetch command to POST 
fetch(`http://localhost:8080/Category/update/${id}`,{//location of db
        method: 'put', // our method
        headers: {
        "Content-type": "application/json" //content type to post
        },
    body: JSON.stringify({
        id: catid,
        name: cats,  
    }),
})
.then((res) => console.log(res))
.catch((err) => console.log(err));




}


//=============THIS BREAKS MY ADD !!!!!!!==============================REFESH PAGE BEGINS

//===========================================REFESH PAGE ENDS


//Then read the result and other data.
// Function to GET CATEGORIES from the db
function fetchData() {
    fetch('http://localhost:8080/Category/read')
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
        const hr = document.createElement('hr');
        const br = document.createElement('br');


        p.append(document.createTextNode(`ID: ${data[i][`id`]} `));
        p.append(br);
        p.append(document.createTextNode(`Name: ${data[i][`name`]}`));
        p.append(hr);

        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);
    }
}
fetchData();
// showAllFacts();
