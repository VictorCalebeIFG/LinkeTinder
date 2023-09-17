import { getData } from "./GoogleSheetDataBase.js";
import { appendRow } from "./GoogleSheetDataBase.js";
export const url = "https://script.google.com/macros/s/AKfycbwvNd0cLSh10QPaoVD9KIfqwzeAOjXWHo9Egk8DcbDrwTZE_nCLhbvca-AJ3KiBB9Rz/exec";
const globalCandidatosData = getData(url, "candidates");
const urlParams = new URLSearchParams(window.location.search);
const user = urlParams.get('username');
var vagaPos = 0;
const likebutton = document.getElementById('like');
const closeButton = document.getElementById('close');
if (likebutton && closeButton) {
    likebutton.addEventListener('click', proximaVaga);
    closeButton.addEventListener('click', ignoreVaga);
}
function ignoreVaga() {
    vagaPos += 1;
    if (vagaPos >= globalCandidatosData.length) {
        vagaPos = 0;
    }
    loadHtmlNextJob();
}
function proximaVaga() {
    vagaPos += 1;
    appendRow([globalCandidatosData[vagaPos][2], user], url, "EmpresaLike");
    if (vagaPos >= globalCandidatosData.length) {
        vagaPos = 0;
    }
    loadHtmlNextJob();
}
function loadHtmlNextJob() {
    const skills = document.getElementById("skills");
    const desc = document.getElementById("descricao");
    skills.innerHTML = globalCandidatosData[vagaPos][6].replace("$", ",");
    desc.innerHTML = globalCandidatosData[vagaPos][7];
}
loadHtmlNextJob();
