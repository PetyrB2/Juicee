
"use strict";

// Global variable for the possible datalists
let datalists = [];
let activeDatalist;
let readMethod = true; // true if read all(default) : false if read by
let readVisible = true;

// Runs on init
function init() {
  // Hide the read by options on load
  document.getElementById("read-by-container").style.display = "none";
  showOrHideDeleteButton();
  readAll();
}

// De-activates the read-by container and enables the read all select box
function activateReadAll() {
  readMethod = true;
  document.getElementById("read-all-container").style.display = "block";
  document.getElementById("read-by-container").style.display = "none";
  document.getElementById("read-all-select").value = "read-all";
  readAll();
}

// De-activates the read-all container and enables the read by options
function activateReadBy() {
  readMethod = false;
  document.getElementById("read-all-container").style.display = "none";
  document.getElementById("read-by-container").style.display = "block";
  document.getElementById("read-by-select").value = "read-by";
}

// function getCheckboxIds() {
//   let carCheckboxes = document.getElementsByClassName(`car-checkbox`);
//   let activeBoxes = [...carCheckboxes].filter((checkbox) => checkbox.checked);
//   return activeBoxes.length > 0
//     ? activeBoxes.map((box) => box.id.split(`-`)[1])
//     : [];
// }

// function showOrHideDeleteButton() {
//   let deleteButton = document.getElementById(`delete-button`);
//   getCheckboxIds().length > 0
//     ? (deleteButton.style.display = "block")
//     : (deleteButton.style.display = "none");
// }

// function showOrHideRead(data) {
//   if (data.length == 0) {
//     document.getElementById(`read-container`).style.display = "none";
//     document.getElementById(`no-items-message`).style.display = "block";

//     readVisible = false;
//   }
//   if (data.length > 0) {
//     document.getElementById(`read-container`).style.display = "block";
//     document.getElementById(`no-items-message`).style.display = "none";
//     readVisible = true;
//   }
//   console.log("Length " + data.length + " Visible " + readVisible);
// }

// function clearInput() {
//   document.getElementById("sub-options-value").value = ``;
// }

// Reads all cars and updates global make and model arrays
function readAll() {
  fetch(`http://localhost:8085/Ingredients/read`)
    .then((response) => {
      if (response.status !== 200) {
        console.error(`status: ${response.status}`);
        return;
      }
      response.json().then((data) => {
        addListItems(data);
        /*global*/ datalists = generateDatalists(data);
        changeDatalist(activeDatalist);
        showOrHideRead(data);
      });
    })
    .catch((error) => console.error(`Request failed: ${error}`));
}

// Create Ingredient function
function createIngredient() {
  let make = document.getElementById(`get-item`).value;
  let model = document.getElementById(`get-description`).value;
  let cost = document.getElementById(`get-imgUrl`).value;
  fetch(`http://localhost:8085/Ingredients/create`, {
    method: `post`,
    headers: { "Content-type": "application/json" },
    body: JSON.stringify({ item: item, description: description, imgUrl: imgUrl }),
  })
    .then((response) => response.json())
    .then((data) => readAll())
    .catch((error) => console.error(`Request failed: ${error}`));
}

function deleteIngredients() {
  let ids = getCheckboxIds();
  let proceed = confirm(
    `Are you sure you want to delete Ingredient(s) ${ids
      .join(`, `)
      .replace(/, ([^,]*)$/, " and $1")}`
  );

  // TODO make sure confirm is confirmed before continuing

  fetch(`http://localhost:8085/Ingredients/delete/${ids}`, {
    method: "delete",
  })
    .then(() => (readMethod ? readAll() : readBy()))
    .catch((error) => console.error(`Request failed: ${error}`));
}

function readBy() {
  let mainSelect = document.getElementById(`main-options`);
  let mainOption = mainSelect.options[mainSelect.selectedIndex].value;
  let subOption = document.getElementById(`sub-options-value`).value;

  fetch(`http://localhost:8085/Ingredients/readBy/${mainOption}:${subOption}`)
    .then((response) => {
      if (response.status !== 200) {
        console.error(`status: ${response.status}`);
        return;
      }
      response.json().then((data) => {
        addListItems(data);
        /*global*/ datalists = generateDatalists(data);
        changeDatalist(activeDatalist);
      });
    })
    .catch((error) => console.error(`Request failed: ${error}`));
}

function addListItems(data) {
  let newTableBody = document.createElement(`tbody`);
  newTableBody.id = `car-table-body`;
  for (let i in data) {
    let tableRow = document.createElement(`tr`);
    newTableBody.appendChild(tableRow);
    tableRow.id = `row${data[i][`id`]}`;
    // First add a checkbox to the item
    let checkBox = document.createElement(`input`);
    checkBox.type = `checkbox`;
    checkBox.id = `car-${data[i][`id`]}`;
    checkBox.classList.add(`car-checkbox`);
    checkBox.addEventListener("change", () => showOrHideDeleteButton());

    tableRow.appendChild(checkBox);
    // Then iterate over the data and add data to the table
    for (let d in data[i]) {
      let tableData = document.createElement(`td`);
      if (d !== `cost`) {
        tableData.appendChild(document.createTextNode(`${data[i][d]}`));
      } else {
        tableData.appendChild(document.createTextNode(`${data[i][d]}`));
      }
      tableRow.appendChild(tableData);
    }
  }
  let oldTableBody = document.getElementById(`car-table-body`);
  oldTableBody.parentNode.replaceChild(newTableBody, oldTableBody);
}

function changeDatalist() {
  // Clear any user inputs
  document.getElementById(`sub-options-value`).value = ``;
  // Select the user's option from the DOM
  let select = document.getElementById(`main-options`);
  let option = select.options[select.selectedIndex].value;
  if (activeDatalist !== option) {
    /*global*/ activeDatalist = option;
    let oldDatalist = document.getElementById(`sub-options`);
    let datalistDestination = oldDatalist.parentElement;
    let newDatalist = datalists[option];
    oldDatalist.remove();
    datalistDestination.appendChild(newDatalist);
  }
}

// Function generates a list of datalists based on json options
function generateDatalists(data) {
  // Create possible datalists
  let idDatalist = document.createElement(`datalist`);
  let makeDatalist = document.createElement(`datalist`);
  let modelDatalist = document.createElement(`datalist`);

  // Give datalists an id
  idDatalist.id = `sub-options`;
  makeDatalist.id = `sub-options`;
  modelDatalist.id = `sub-options`;

  for (let i in data) {
    let idOption = document.createElement(`option`);
    idOption.value = `${data[i][`id`]}`;
    idOption.appendChild(document.createTextNode(`${data[i][`id`]}`));
    idDatalist.appendChild(idOption);
  }
  for (let item of getItems(data)) {
    let itemOption = document.createElement(`option`);
    itemOption.value = `${item}`;
    itemOption.appendChild(document.createTextNode(`${item}`));
    itemDatalist.appendChild(itemOption);
  }
//   for (let model of getModels(data)) {
//     let modelOption = document.createElement(`option`);
//     modelOption.value = `${model}`;
//     modelOption.appendChild(document.createTextNode(`${model}`));
//     modelDatalist.appendChild(modelOption);
//   }
  return {
    id: idDatalist,
    item: itemDatalist,
//    description: descriptionDatalist,
  };
}


function getitem(data) {
  let items = [];
  for (let i in data) {
    let item = data[i][`item`];
    if (!items.includes(item)) {
      items.push(item);
    }
  }
  return items;
}

// function getModels(data) {
//   let models = [];
//   for (let i in data) {
//     let model = data[i][`model`];
//     if (!models.includes(model)) {
//       models.push(model);
//     }
//   }
//   return models;
// }

(function () {
  document.addEventListener("DOMContentLoaded", init);
})();