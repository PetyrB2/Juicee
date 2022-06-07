// A Javascript file to GET User Data
// ==============================================
// New Function to FETCH USERS from the db

function fetchData() {
    fetch('http://localhost:8080/Users/read')

    .then((resp) => resp.json())
    .then((data) => (data))
}

// A Javascript for showing the User Data

function showData(data) {
    const rootElement = document.getElementsByClass('root')[0];
    for (let fact of data) {
        const newDiv = document.createElement('div');
        const p = document.createElement('p');

        p.append(document.createTextNode(fact.fact));
        newDiv.appendChild(p);
        rootElement.appendChild(newDiv);
    }
}
const button = document.querySelector('submit');

button.addEventListener('click', () = > {
    showData();
})
;
fetchData();
showData();


// ==============================================
// Add a Delete function with checkboxes next to Users if possible.
// ==============================================
// function deleteData(data) {
//     let id = 1; // change to a select the ID
//     fetch("http://localhost:8080/Users/read/"+id, {  //2
//         method: 'delete'  // method 
//       })
//       .then((data) => {
//         console.log(`Request succeeded with JSON response ${data}`);
//        // refresh page and display that delete has completed
//       })
//       .catch((error) => {
//         //some function to execute if error
//       });

// }