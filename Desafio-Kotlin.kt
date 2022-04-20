import kotlin.system.exitProcess

fun main(){
    introducao()
    pegarEVerificarNotas()
    miniMenu()
}

fun introducao() {
    println("Bem-vinde. Vamos calcular médias? :]")
    println("--------------------------------------------")
}

fun pegarEVerificarNotas(){
    val vetorNotas = DoubleArray(4)

    println("--------------------------------------------")
    for(contador in 1..4){
        print("Insira a $contador° nota: ")
        vetorNotas[contador - 1] = readln().toDouble()

        while (vetorNotas[contador - 1] < 0 || vetorNotas[contador - 1] > 10){
            println("-----------------------------------")
            println("Número inválido! Tente novamente.")
            println("-----------------------------------")
            print("Insira a $contador° nota: ")
            vetorNotas[contador - 1] = readln().toDouble()
        }
    }
    println("--------------------------------------------")

    calculaMedia(vetorNotas)
}

fun calculaMedia(vetorNotas : DoubleArray){
    val mediaAluno : Double
    var soma = 0.0

    for (contador in 1..4){
        soma += vetorNotas[contador - 1]
    }

    mediaAluno = soma / 4

    mostrarNotasEMedia(mediaAluno, vetorNotas)
}

fun mostrarNotasEMedia(media : Double, vetorNotas: DoubleArray){
    println("--------------------------------------------")
    for (contador in 1..4){
        println("Nota do $contador° Bimestre: ${vetorNotas[contador - 1]}")
    }

    println("--------------------------------------------")
    println("A média anual do aluno é: $media")
    println("--------------------------------------------\n")
}

fun miniMenu(){
    println("--------------------MENU--------------------\n")
    println("-------------------OPÇÕES-------------------")
    println("* Se deseja calcular uma nova média, digite 1")
    println("* Se deseja sair, digite 2")
    println("--------------------------------------------")
    val escolha = readln().toInt()

    escolhaMenu(escolha)
}

fun escolhaMenu(escolha : Int){
    when(escolha){
        1 -> {
            pegarEVerificarNotas()
            miniMenu()
        }
        2 -> exitProcess(0)
        else -> {
                println("-----------------------------------")
                println("Número inválido! Tente novamente.")
                println("-----------------------------------")
                miniMenu()
        }
    }
}


