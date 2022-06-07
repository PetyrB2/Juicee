







// Creates a Delete Link in the form of a Button thanks to Bootstrap styles. (see link above in head)
      var deleteLink = document.createElement("a");
      deleteLink.href = "#";
      deleteLink.className = "btn btn-sm btn-danger m-1 delete";   // Bootstrap Styles implemented here
      deleteLink.appendChild(
        document.createTextNode("Delete") 
      );