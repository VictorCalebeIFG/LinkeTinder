import { getData } from  "./GoogleSheetDataBase.js";

const url = "https://script.google.com/macros/s/AKfycbwvNd0cLSh10QPaoVD9KIfqwzeAOjXWHo9Egk8DcbDrwTZE_nCLhbvca-AJ3KiBB9Rz/exec"


document.addEventListener("DOMContentLoaded", () => {
    const botao = document.getElementById("logar");
    if (botao) {
      botao.addEventListener("click", logarEmpresa);
    }
  });

  function logarEmpresa(): void {
    const datanotfound = true;
    var senha;
    var cnpj;

    const CNPJ = document.getElementById("CNPJ") as HTMLInputElement;
    const SENHA = document.getElementById("Senha") as HTMLInputElement;

    const data = getData(url, "candidates");

    console.log(data);

    data.forEach((element: any) => {
      senha = element[8];
      cnpj = element[2];
      
      if ('x'+CNPJ.value == cnpj && SENHA.value == senha) {
        window.location.href = "../Hub/candidato_hub.html?username=" + cnpj ;
        console.log("Logou")
      }
    })

    console.log(cnpj,senha);


}

