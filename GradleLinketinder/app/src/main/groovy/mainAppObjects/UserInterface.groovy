package mainAppObjects

import mainAppObjects.App

class UserInterface {

    UserInterface(){
    }

    void startLoop(App linkeTinder){
        def scanner = new Scanner(System.in)

        def opcao = 0
        while (opcao != 10) {
            println "Escolha uma opção:"
            println "1. Mostrar empresas"
            println "2. Mostrar candidatos"
            println "3. Adicionar candidatos"
            println "4. Adicionar Empresas"
            println "5. Adicionar Competencia-Candidato"
            println "6. Adicionar Vaga"
            println "7. Adicionar Competencia-Vaga"
            println "10. Fechar o programa"

            try {
                opcao = scanner.nextInt()
            } catch (Exception e) {
                println "Opção inválida! Escolha novamente."
                scanner.nextLine() // Limpe o buffer da linha inválida
                continue
            }

            switch (opcao) {
                case 1:
                    linkeTinder.mostrarEmpresas()
                    break
                case 2:
                    linkeTinder.mostrarCadidatos()
                    break
                case 3:
                    linkeTinder.pedirCandidato()
                    break
                case 4:
                    linkeTinder.pedirEmpresa()
                    break
                case 5:
                    linkeTinder.pedirCompetencias()
                    break
                case 6:
                    linkeTinder.pedirVaga()
                    break
                case 7:
                    linkeTinder.pedirCompetenciasVaga()
                    break
                case 10:
                    println "Fechando o programa..."
                    break
                default:
                    println "Opção inválida! Escolha novamente."
                    break
            }
        }

        scanner.close()
    }
}