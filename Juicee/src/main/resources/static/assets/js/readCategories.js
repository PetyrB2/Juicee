// A Javascript for POSTING User Registration Data back to the mySQL


// Function to GET CATEGORIES from the db
function fetchData() {
    fetch("http://localhost:8080/Category/read")
    .then((resp) => resp.json())
    .then((data) => console.log(data))
    .then((data) => showAllCats(data))
}

function showAllCats({ data }) {
    const rootElement = document.getElementsByClassName('root')[0];
    for (let cat of data) {
        const newDiv = document.createElement('div');
        const p = document.createElement(`p`);

        p.append(document.createTextNode(cat));
        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);

    }

};

fetchData();

