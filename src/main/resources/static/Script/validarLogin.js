

var botao = document.getElementById("botaoValidar").addEventListener("click", function validar(){

    var nomeProduto = document.getElementsByName("nomeProduto").value;
    var fornecedorProduto = document.getElementsByName("fornecedorProduto").value;
    var valorProduto = document.getElementsByName("valorProduto").value;

    if(nomeProduto == "" && fornecedorProduto == "" && valorProduto == ""){
        console.log("Preencher");
    }

});