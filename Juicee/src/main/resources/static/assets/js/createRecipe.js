// A Javascript for POSTING User Registration Data back to the mySQL
// ===============================================================================

const rootElement = document.getElementById('catlist');
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
    
    const idAndName = document.querySelector("#catlist").value;
    const categories = idAndName.split(` `);
    const category_id = categories[0];
    const category_name = categories[1];
    
//   console.log(categories);

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
            
            category: {
                id: category_id,
                name: category_name
            }
        }),
    })
        .then((res) => console.log(res))
        .catch((err) => console.log(err));
}

// ===============================================================================
//
//  GET THE =====>>>>> CATEGORY TABLE  <<<<==== FOR THE DROPDOWN 

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
   
    
    for (let i = 0; i < data.length; i++) {

        // CONSTANTS
        const newDiv = document.createElement('div');
        const newOption = document.createElement('option');
        const optionText = document.createTextNode(((`${data[i][`id`]} ${data[i][`name`]}  `)));

        // For the Dropdown
        rootElement.appendChild(newOption);
        newOption.appendChild(optionText);
    }
}

// =============================>>>>> INGEDIENTS TABLE  <<<<=========================================
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
    
    for (let i = 0; i < data.length; i++) {

        const rootElement = document.getElementsByClassName('root')[0];
        const newDiv = document.createElement('div');
        const p = document.createElement('p');
        const br = document.createElement('br');
        const br2 = document.createElement('br');
        const br3 = document.createElement('br');
        const br4 = document.createElement('br');
        const br5 = document.createElement('br');
        const img = document.createElement('img');
        const hr = document.createElement('hr');     
        const hr2 = document.createElement('hr');     
    


        // p.append(document.createTextNode(`ID: ${data[i][`id`]} Name: ${data[i][`name`]}  Description: ${data[i][`description`]}  Image URL: ${data[i][`imgUrl`]}  Category: ${data[i][`category_id`]}`));
        
        img.src = data[i]['imgUrl'];
        p.append(hr);
        newDiv.appendChild(img);
        p.append(document.createTextNode(`ID: ${data[i][`id`]}  `));
        p.append(br);
        p.append(document.createTextNode(` Name: ${data[i][`name`]}  `));
        p.append(br2);
        p.append(document.createTextNode(` Description: ${data[i][`description`]}  `));
        p.append(br3);
        p.append(document.createTextNode(` Cat Id: ${data[i][`category_id`]}  `));
        p.append(br4);
        p.append(document.createTextNode(` Category: ${data[i][`category_name`]}  `));
        p.append(br5);
        
        // p.append(document.createTextNode(` Image URL: ${data[i][`imgUrl`]} `));
        p.append(hr2);
        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);
    }
}


// FETCH TO ADD CATS TO LIST

// // Function to GET CATEGORIES from the db
// function fetchMoreCats() {
//     fetch('http://localhost:8080/Category/read')
//         .then((resp) => {
//             if (resp.status != 200) console.error(resp.status);
//             resp.json().then((data) => {
//                 console.log(data)
//                 showAllMoreCats(data)

//             })
//         });
// }

// function showAllMoreCats(data) {
//     console.table(data)
   
    
//     for (let i = 0; i < data.length; i++) {

//         // CONSTANTS
//         const rootElement = document.getElementsByClassName('root')[0];
//         const newDiv = document.createElement('div');
//         const p = document.createElement('p');
//         const br = document.createElement('br');
//         const br2 = document.createElement('br');

//         p.append(document.createTextNode(`Category ID: ${data[i][`id`]}  `));
//         p.append(br);
//         p.append(document.createTextNode(`Category Name: ${data[i][`name`]}  `));
//         p.append(br2);


//         newDiv.appendChild(p);
//         rootElement.appendChild(newDiv);
//     }
// }
// ===================>>>>   RUN COMMANDS --- CAREFUL OF THE ORDER !!! <<<<=============================
fetchData()

fetchCats()

// fetchMoreCats()
;

