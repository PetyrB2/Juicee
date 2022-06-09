// A Javascript for POSTING User Registration Data back to the mySQL
// ===============================================================================


const rootElement = document.getElementsByClassName('root')[0];
const button = document.querySelector('#submit');


function refreshPage(){
    window.location.reload();
} 


button.addEventListener('click', () => {
    postData()
    refreshPage()
})

// ===============================================================================
// Function to POST to the db
function postData() {


    // Our Variables        const name = document.querySelector("#name").value;

    const name = document.querySelector("#name").value;
    const description = document.querySelector("#description").value;
    const imgUrl = document.querySelector("#imgUrl").value;
    const category_id = document.querySelector("#category_id").value;

    //Fetch command to POST 
    fetch("http://localhost:8080/Ingredients/create", { //location of db
        method: 'post', // our method
        headers: {
            "Content-type": "application/json" //content type to post
        },
        body: JSON.stringify({
            name: name,
            description: description,
            imgUrl: imgUrl,
            category_id: category_id
        }),
    })
        .then((res) => console.log(res))
        .catch((err) => console.log(err));
}

// ===============================================================================
//
//  GET THE CATEGORY TABLE FOR THE DROPDOWN 

// Function to GET CATEGORIES from the db
function fetchCats() {
    fetch('http://localhost:8080/Category/read')
        .then((resp) => {
            if (resp.status != 200) console.error(resp.status);
            resp.json().then((data) => {
                console.log(data)
                showAllCats(data)
            })
        });
}

function showAllCats(data) {
    console.table(data)
    const rootElement = document.getElementById('catlist')[0];
    
    for (let i = 0; i < data.length; i++) {

        const option = document.createElement('option');
        
        option.appendChild(` ${data[i][`name`]}`);


        // const newDiv = document.createElement('div');
        // const p = document.createElement('p');
        // const hr = document.createElement('hr');
        // const br = document.createElement('br');

        // p.append(document.createTextNode(` ${data[i][`id`]}`));
    
        //p.append(document.createTextNode(` ${data[i][`name`]}`));
        //p.append(hr);


          //newDiv.appendChild(p);
        //  rootElement.appendChild(p);
    }
}


// ===============================================================================




//Then read the result and other data.
// Function to GET INGREDIENTS from the db
function fetchData() {
    fetch('http://localhost:8080/Ingredients/read')
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
        const br4 = document.createElement('br');
        const img = document.createElement('img');
        img.src = data[i]['imgUrl'];
        const hr = document.createElement('hr');


        // p.append(document.createTextNode(`ID: ${data[i][`id`]} Name: ${data[i][`name`]}  Description: ${data[i][`description`]}  Image URL: ${data[i][`imgUrl`]}  Category: ${data[i][`category_id`]}`));
        newDiv.appendChild(img);
        p.append(document.createTextNode(`ID: ${data[i][`id`]}  `));
        p.append(br);
        p.append(document.createTextNode(` Name: ${data[i][`name`]}  `));
        p.append(br2);
        p.append(document.createTextNode(` Description: ${data[i][`description`]}  `));
        p.append(br3);
        // p.append(document.createTextNode(` Image URL: ${data[i][`imgUrl`]} `));
        p.append(br4);
        p.append(document.createTextNode(` Category: ${data[i][`category_id`]}  `));
        p.append(document.createTextNode(` Category: ${data[i][`category_name`]}  `));
        p.append(hr);



        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);
    }
}
fetchData()
fetchCats()






;

