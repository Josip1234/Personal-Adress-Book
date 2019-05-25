function removeForms(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="none";
}
function addNewSex(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="initial";
}
function updateSex(){
  document.getElementById('updateSex').style.display="initial";
  document.getElementById('insertSex').style.display="none";
}
function abort(){
removeForms();
}
