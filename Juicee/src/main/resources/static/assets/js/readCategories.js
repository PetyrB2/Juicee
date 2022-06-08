// A Javascript for POSTING User Registration Data back to the mySQL

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

        p.append(document.createTextNode(`ID: ${data[i][`id`]}`));
        p.appendChild(br);
        p.append(document.createTextNode(`Name: ${data[i][`name`]}`));
        p.appendChild(hr);


        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);
    }
}
fetchData();
// showAllFacts();
