// A Javascript for GETTING Ingredients Data back to the mySQL

// Function to GET INGREDIENTS from the db
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
        const hr = document.createElement('hr');
        
        // String to beautify the data
        p.append(document.createTextNode(`ID: ${data[i][`id`]}  `));
        p.append(document.createTextNode(`Name: ${data[i][`name`]}  `));
        // Append a p and a div for each field and new entry.
        newDiv.appendChild(p);
        newDiv.appendChild(hr);
        rootElement.appendChild(newDiv);
    }
}
fetchData();
// showAllFacts();


