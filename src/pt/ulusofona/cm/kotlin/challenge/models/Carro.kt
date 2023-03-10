package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Carro(identificador: String, private var motor: Motor) : Veiculo(identificador), Ligavel {

    override fun moverPara(x: Int, y: Int) {
        if (posicao.x == x && posicao.y == y) {
            throw AlterarPosicaoException(" movimento para a posição onde já te encontras.")
        }

        if (!motor.estaLigado()) {

            motor.ligar()
            posicao.alterarPosicaoPara(x, y)
            motor.desligar()

        } else {
            posicao.alterarPosicaoPara(x, y)
            motor.desligar()
        }
    }

    override fun requerCarta(): Boolean {
        return true
    }

    override fun ligar() {

        if (motor.estaLigado()) {
            throw VeiculoLigadoException("O veiculo já se encontra ligado")
        }

        motor.ligar()
    }

    override fun desligar() {

        if (!motor.estaLigado()) {
            throw VeiculoDesligadoException("O veiculo já se encontra desligado")
        }

        motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }

    override fun toString(): String {
        return "Carro | $identificador | ${DateFormat.getDate(dataDeAquisicao)} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }

}
