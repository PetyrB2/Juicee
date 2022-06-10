//###################  A Javascript for DELETING A CATEGORY ####################

// ================= RETRIEVE THE CATEGORIES =====================
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



//===========================SHOW THE DATA=====================
function showAllFacts(data) {
  console.table(data)
  const rootElement = document.getElementsByClassName('root')[0];
  for (let i = 0; i < data.length; i++) {
      const newDiv = document.createElement('div');
      const p = document.createElement('p');
      const hr = document.createElement('hr');
      const br = document.createElement('br');
      //const myCheckBox = document.createElement('input type="checkbox"');
      
      p.append(document.createTextNode(`ID: ${data[i][`id`]}`));
      // p.appendChild(myCheckBox);
      p.appendChild(br);
      p.append(document.createTextNode(`Category: ${data[i][`name`]}`));
      p.appendChild(hr);


      newDiv.appendChild(p);
      newDiv.appendChild(hr);
      rootElement.appendChild(newDiv);
  }
}


fetchData()

// ================== DELETE FUNCTION =======================
const IdInput = document.getElementById("IdInput");
const ButtonId = document.getElementById("ButtonId");

let deleteCat = (id) => {
  fetch(`http://localhost:8080/Category/delete/${id}`,{
    method:'DELETE'
  
})

}

ButtonId.onclick = () => deleteCat(IdInput.value);
//===========================DELETE ENDS =====================







