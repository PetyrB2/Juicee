// A Javascript for DELETING A CATEGORY

//===========================FETCH THE DATA=====================
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


//===========================SHOW THE DATA=====================
function showAllFacts(data) {
  console.table(data)
  const rootElement = document.getElementsByClassName('root')[0];
  for (let i = 0; i < data.length; i++) {
      const newDiv = document.createElement('div');
      const p = document.createElement('p');
      const br = document.createElement('br');
      const br2 = document.createElement('br');
      const br3 = document.createElement('br');
      const br4 = document.createElement('br');
      const img = document.createElement('img');
      img.src = data[i]['imgUrl'];
      const hr = document.createElement('hr');

// ============================ CREATE A WAY TO DISPLAY THE DATA  ======================

      // p.append(document.createTextNode(`ID: ${data[i][`id`]} Name: ${data[i][`name`]}  Description: ${data[i][`description`]}  Image URL: ${data[i][`imgUrl`]}  Category: ${data[i][`category_id`]}`));
      newDiv.appendChild(img);
      p.append(document.createTextNode(`ID: ${data[i][`id`]}  `));
      p.append(br);
      p.append(document.createTextNode(` Name: ${data[i][`name`]}  `));
      p.append(br2);
      p.append(document.createTextNode(` Description: ${data[i][`description`]}  `));
      p.append(br3);
      // p.append(document.createTextNode(` Image URL: ${data[i][`imgUrl`]} `));
      p.append(br4);
      p.append(document.createTextNode(` Category: ${data[i][`category_id`]}  `));
      p.append(document.createTextNode(` Category: ${data[i][`category_name`]}  `));
      p.append(hr);



      newDiv.appendChild(p);
      rootElement.appendChild(newDiv);
  }
}





// ================== DELETE FUNCTION =======================

const IdInput = document.getElementById("IdInput");
const ButtonId = document.getElementById("ButtonId");


let deleteCat = (id) => {
  fetch(`http://localhost:8080/Ingredients/delete/${id}`, {
    method: 'DELETE'

  })

}


ButtonId.onclick = () => deleteCat(IdInput.value)

fetchData();
//===========================DELETE ENDS =====================



