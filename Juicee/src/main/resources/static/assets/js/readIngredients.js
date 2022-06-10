// A Javascript for <<<<<<<<<< READING >>>>>>>>>> INGREDIENTS 
// ===============================================================================

const rootElement = document.getElementById('catlist');

// ===============================================================================
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
        const optionText = document.createTextNode(((`${data[i][`id`]}  ${data[i][`name`]}  `)));

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
    

        //A Just in case -----delete B4 Production
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
// ===================>>>>   QUERY BELOW  <<<<=============================




// ===================>>>>   QUERY ABOVE <<<<=============================
// ===================>>>>   RUN COMMANDS --- CAREFUL OF THE ORDER !!! <<<<=============================
fetchData()
fetchCats();

