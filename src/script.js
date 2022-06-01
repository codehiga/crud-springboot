const BASE_URL = "http://localhost:8080";

//Funcoes globais
const verificaStatusRequest = (status) => {
    if(status === 200){
        window.location.reload();
    }
}

const fetchRequestInfo = (method, body) => {
    return {
        headers : {  
            "Content-Type" : "application/json",
            "Access-Control-Allow-Origin" : "*",
        },
        method,
        body : JSON.stringify(body),
    }
}

const init = () => {

    inserirLocadores();
}

//
//  Locador
//

// Referencias do formulario para criar locador
const formCriarLocador = document.getElementById("form_criar_locador");
const inputNomeLocador = document.getElementById("input_locador_nome");
const inputCPFLocador = document.getElementById("input_locador_cpf");

const btnFormLocador = document.getElementById("btn_form_locador");

const listaLocadores = document.getElementById("lista-locadores");

// Funcoes locador
const criarLocador = async (e) => {

    const data = {
        nome : inputNomeLocador.value,
        cpf : inputCPFLocador.value,
        usuarioAtivo : false
    };

    const response = await fetch(BASE_URL+"/locador", fetchRequestInfo('POST', data));

    verificaStatusRequest(response.status);
}

const inserirLocadores = async () => {
    const response = await fetch(BASE_URL+"/locador");
    const locadores = await response.json();

    locadores.map((locador) => {
        
        listaLocadores.innerHTML += locadorSpan(locador);
    })
}


const locadorSpan = (locador) => {
    let { id, cpf, nome, usuarioAtivo } = locador;

    return(
        `
        <span id="${id}" class="list-group-item list-group-item-action d-md-flex w-100 justify-content-between align-items-center" aria-current="true">
            <div>
                <div class="d-flex w-100">
                    <h5>${nome}</h5>
                </div>
                <p class="mb-1 d-flex align-items-center gap-2"><b>Usuário ativo: </b><span class="ball-${usuarioAtivo}"></span></p>
                <small><b>CPF:</b> ${cpf}</small>
            </div>

            <div class="d-flex w-md-100 justify-content-between mt-2 gap-2">
                <button class="btn btn-primary">Alterar status</button>
                <button onclick="alterarInfoLocador(${id})" class="btn btn-primary">Editar</button>
                <button onclick="deletarLocador(${id})" class="btn btn-danger">Excluir</button>
            </div>
        </span>
        `
    )
}

const alterarInfoLocador = async (id) => {
    
    const { nome, cpf } = await dadosLocadorPeloId(id);

    inputNomeLocador.value = nome;
    inputCPFLocador.value = cpf;

    btnFormLocador.innerHTML = `
        <button onclick="confirmarInfoLocador(${id})" class="btn btn-primary col-md-3">Confirmar</button>
        <button onclick="window.location.reload()" class="btn btn-danger col-md-3">Cancelar</button>
    `
}

const deletarLocador = async (id) => {

    const response = await fetch(BASE_URL+"/locador/"+id, fetchRequestInfo('DELETE'));

    verificaStatusRequest(response.status);
}

const confirmarInfoLocador = async (id) => {

    const data = {
        id,
        nome : inputNomeLocador.value,
        cpf : inputCPFLocador.value,
        usuarioAtivo : true,
    };

    console.log(data)

    const response = await fetch(BASE_URL+"/locador/"+id, fetchRequestInfo('PUT', data));

    verificaStatusRequest(response.status);
}

const dadosLocadorPeloId = async (id) => {

    let response = await fetch(BASE_URL+"/locador/"+id);
    return await response.json();
}



init();