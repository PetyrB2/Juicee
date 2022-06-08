// ==================== A Javascript for UPDATING CATEGORY =====================

const rootElement = document.getElementsByClassName('root')[0];

//================  READ PART OF JAVASCRIPT ===========================BEGINS

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
//================  READ PART OF JAVASCRIPT ===========================ENDS
// ==================== CREATE / UPDATE FUNCTION ==========================BEGINS
// Function to POST to the db
// Our Variables

const idInput = document.getElementById("idInput");
const IdButton = document.getElementById("IdButton");
const catname = document.getElementById("#catname");
const button = document.querySelector('#submit');

//Fetch command to PUT 

let updateCat = (id) => {
    fetch(`http://localhost:8080/Category/delete/` + id, {
        method: 'PUT', // our method
        headers: {
            "Content-type": "application/json" //content type to post
        },
        body: JSON.stringify({
            id: id,
            name: catname,
        }),
    })
        .then((res) => console.log(res))
        .catch((err) => console.log(err));
}

// Button Event Listener
IdButton.onclick = () => updateCat(idInput.value);

// ==================== CREATE / UPDATE FUNCTION ======================ENDS
