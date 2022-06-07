// A Javascript for GETTING Ingredients Data back to the mySQL

// Function to GET INGREDIENTS from the db
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
        // String to beautify the data
        p.append(document.createTextNode(`ID: ${data[i][`id` ]}  Name: ${data[i][`name` ]}  Description: ${data[i][`description` ]}  Preparation: ${data[i][`howto` ]} Image Url: ${data[i][`imgUrl` ]} `));
        // Append a p and a div for each field and new entry.
        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);
    }
}
fetchData();
// showAllFacts();
