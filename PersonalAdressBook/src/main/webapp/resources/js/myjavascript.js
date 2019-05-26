function removeForms(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="none";
  document.getElementById('deleteSex').style.display="none";
  document.getElementById('insertCountry').style.display="none";
  document.getElementById('updateCountry').style.display="none";
  document.getElementById('deleteCountry').style.display="none";
}
function addNewSex(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="initial";
  document.getElementById('deleteSex').style.display="none";
    document.getElementById('insertCountry').style.display="none";
    document.getElementById('updateCountry').style.display="none";
    document.getElementById('deleteCountry').style.display="none";
}
function updateSex(){
  document.getElementById('updateSex').style.display="initial";
  document.getElementById('insertSex').style.display="none";
  document.getElementById('deleteSex').style.display="none";
  document.getElementById('insertCountry').style.display="none";
  document.getElementById('updateCountry').style.display="none";
  document.getElementById('deleteCountry').style.display="none";
}
function deleteSex(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="none";
  document.getElementById('deleteSex').style.display="initial";
  document.getElementById('insertCountry').style.display="none";
  document.getElementById('updateCountry').style.display="none";
  document.getElementById('deleteCountry').style.display="none";
}
function insertCountry(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="none";
  document.getElementById('deleteSex').style.display="none";
  document.getElementById('insertCountry').style.display="initial";
  document.getElementById('updateCountry').style.display="none";
  document.getElementById('deleteCountry').style.display="none";
}
function updateCountry(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="none";
  document.getElementById('deleteSex').style.display="none";
  document.getElementById('insertCountry').style.display="none";
  document.getElementById('updateCountry').style.display="initial";
  document.getElementById('deleteCountry').style.display="none";
}
function deleteCountry(){
  document.getElementById('updateSex').style.display="none";
  document.getElementById('insertSex').style.display="none";
  document.getElementById('deleteSex').style.display="none";
  document.getElementById('insertCountry').style.display="none";
  document.getElementById('updateCountry').style.display="none";
  document.getElementById('deleteCountry').style.display="initial";
}
function abort(){
removeForms();
}
