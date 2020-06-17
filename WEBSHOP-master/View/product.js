function clic_moins(){
  var nbprod = document.getElementById("nbprod");
  var int_prod = parseInt(nbprod.value);
  if(int_prod>0){
    int_prod=int_prod-1;
  }
  nbprod.value=int_prod;
}

function clic_plus(){
  var nbprod = document.getElementById("nbprod");
  var int_prod = parseInt(nbprod.value);
  int_prod=int_prod+1;
  nbprod.value=int_prod;
}

function bloque_champ(champ){
  champ.blur();
}
