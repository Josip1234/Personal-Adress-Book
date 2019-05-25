function removeForms(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="none";
  document.getElementById('deleteSex').style.display="none";
}
function addNewSex(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="initial";
  document.getElementById('deleteSex').style.display="none";
}
function updateSex(){
  document.getElementById('updateSex').style.display="initial";
  document.getElementById('insertSex').style.display="none";
  document.getElementById('deleteSex').style.display="none";
}
function deleteSex(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="none";
  document.getElementById('deleteSex').style.display="initial";
}
function abort(){
removeForms();
}
