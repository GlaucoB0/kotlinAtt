import java.time.Year

fun main() {

    val questaoUm = somaLista(listOf(1,2,3,4))
    val questaoDois = palavraRepetida("zé",listOf("zé", "Glauco", "Pedro", "zé", "Paulo"))
    val questaoTres = verificaSenha("Abc12345")
    val questaoQuatro = retornaLista(listOf("12345", "123","123456","1234567","1234"))
    val questaoCinco = verificaDesconto(110.00)
    val questaoSeis = maiorNumPrimo(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13))
    val questaoSete = somaMultiplos(listOf(1,2,3,4,5,6,7,8,9,10))
    val questaoOito = ordenarListaAlfabetica(listOf("z", "g", "h", "abb", "abc", "aab", "aaa", "b"))
    val questaoNove = calcularHorasTrabalhadas("18:30", "20:30")
    val questaoDez = paresImpares(mutableListOf(1,2,3,4,5,6))
    val questaoOnze = inverteNumero(listOf(1,2,3,4,5))
    val questaoDoze = verificaBissexto(2016)
    val questaoTreze = calculaIMC(1.80, 70.00)
    val questaoCatorze = contaPalavrasDeUmaFrase("olá eu sou 17 e tenho aerton anos")
    val questaoQuinze = mediaSemRepeticao(listOf(1,1,2,2,3,3,4,4))


    // Coloque a questão aqui para testar
    // EX : println(questaoUm)
    println()
}

//1
fun somaLista(lista: List<Int>): Int {
    return lista.reduce { acc, num -> acc + num }
}

//2
fun palavraRepetida(busca: String, lista: List<String>): Int {
    return lista.count { it === busca }
}

//3
fun verificaSenha(senha: String): Boolean {
    val verifica = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}\$")
    if(verifica.matches(senha)) return true else return false
}

//4
fun retornaLista(lista: List<String>): List<String> {
    val novaLista = lista.filter { it.matches(Regex("^.{6,}\$")) }
    return novaLista
}

//5
fun verificaDesconto(valor: Double): Double {
    if (valor > 100) {
        return valor * 0.90
    }
    return valor
}

//6
fun maiorNumPrimo(lista: List<Int>): Int? {
    var i = 0
    val primos = mutableListOf<Int>()

    for (num in lista) {
        for (numero in num downTo 1) {
            if (num % numero == 0) {
                i += 1
            }
        }
        if (i == 2) {
            primos.add(num)
        }
        i = 0
    }
    return primos.maxOrNull()
}

//7
fun somaMultiplos(nums: List<Int>): Int {
    val soma = nums.filter { it % 3 == 0 || it % 5 == 0 }.reduce { acc, int -> acc + int }
    return soma
}

//8
fun ordenarListaAlfabetica(lista: List<String>): List<String> {
    return lista.sorted()
}

//9
fun calcularHorasTrabalhadas(entrada: String, saida: String): Int {
    //desconsiderei os segundos rsrs

    val horaEntrada = entrada.split(':')[0].toInt()
    val horaSaida = saida.split(':')[0].toInt()

    return horaSaida - horaEntrada
}

//10
fun paresImpares(argLista: MutableList<Int>): MutableList<Int> {
    val lista = mutableListOf<Int>();
    argLista.map { acc -> if (acc % 2 == 0) lista.add(0, acc) else lista.add(acc) }

    return lista
}

//11
fun inverteNumero(nums: List<Int>): List<Int> {
    return nums.reversed()
}

//12
fun verificaBissexto(ano: Int): Boolean {
    val data = Year.of(ano).length()
    if (data === 365) {
        return false
    }
    return true
}

//13
fun calculaIMC(altura: Double, peso: Double): Double {
    return peso / (altura * altura)
}

//14
fun contaPalavrasDeUmaFrase(frase: String): Int {
    return frase.trim().split(" ").count()
}

//15
fun mediaSemRepeticao(nums: List<Int>): Int {
    val listaSemRepeticao = nums.distinct()
    val soma = listaSemRepeticao.reduce { acc, int -> acc + int }

    return soma / listaSemRepeticao.count()
}