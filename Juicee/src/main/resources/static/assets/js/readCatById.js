const IdInput = document.getElementById("IdInput")
const IdButton = document.getElementById("IdButton")
const CatList = document.getElementById("CatList")


let search = (id) => {
    fetch('http://localhost:8080/Category/read/${id}')

    .then(
        (response) => {
            if (response.status != 200) {
            console.error(`status: ${response.status}`);
            return;
            }
            resp.json().then((data) => {
                console.log(response.status);
                console.table(data);
                addItem(JSON.parse(data));
            });
        }).catch((error) => console.error(`Request failed: ${error}`));
    }

    //ADD 
    function additem(data) {
        for (i in data) {
            let child = document.createElement(li);
            child.appendChild(document.createTextNode{`${data[i]}`})
            CatList.appendChild
        }
    }
