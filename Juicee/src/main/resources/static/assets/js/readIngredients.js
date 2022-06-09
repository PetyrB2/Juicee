// A Javascript for GETTING Ingredients Data back to the mySQL

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
        const hr = document.createElement('hr');
        const br = document.createElement('br');
        const img = document.createElement('img');
        // img.src = imgUrl;
                
        // String to beautify the data
        p.append(document.createTextNode(`ID: ${data[i][`id`]}`));
        p.appendChild(hr);
        p.append(document.createTextNode(`Name: ${data[i][`name`]}`));
        p.appendChild(br);
        p.append(document.createTextNode(`Description: ${data[i][`description`]}`));
        p.appendChild(br);
        p.append(document.createTextNode(`Image URL: ${data[i][`imgUrl`]}`));
        p.appendChild(br);
        p.append(document.createTextNode(`Category: ${data[i][`category_id`]}`));
        // Append a p and a div and an hr to separatefor each field and new entry.
        newDiv.appendChild(p);
        newDiv.appendChild(hr);
        rootElement.appendChild(newDiv);
//        rootElement.appendChild(img);
    }
}
fetchData();
// showAllFacts();
