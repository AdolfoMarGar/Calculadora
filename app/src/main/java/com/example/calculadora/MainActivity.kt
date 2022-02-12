package com.example.calculadora

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger

class MainActivity : AppCompatActivity() {

    private var num1 = ""
    private var num2 = ""
    private var operador = ""
    private var modo = "dec"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (modo=="dec"&& resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE) {
            bA.isClickable = false
            bB.isClickable = false
            bC.isClickable = false
            bD.isClickable = false
            bE.isClickable = false
            bF.isClickable = false
        }
        //if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){}
    }


    fun modo(view: android.view.View) {
        val boton = view as Button
        Toast.makeText(
            applicationContext,
            "Modo cambiado.",
            Toast.LENGTH_SHORT
        ).show()

        when(boton.id){
            (b_decimal.id)->{


                if(modo=="bin"){
                    if (txt_historial.text.isNotEmpty()){
                        println("hist not empty")
                        if (txt_historial.text.length<19){
                            num1 = binToDec(num1.toLong()).toString()
                            txt_historial.text = num1
                        }else{
                            Toast.makeText(
                                applicationContext,
                                "Error: Numero demasiado largo.",
                                Toast.LENGTH_SHORT
                            ).show()
                            cfuncion()
                        }
                    }

                    if(txt_resultado.text.isNotEmpty()){
                        println("main not empty")
                        println(txt_resultado.text.toString())

                        if (txt_resultado.text.length<19){
                            num2 = binToDec(txt_resultado.text.toString().toLong()).toString()
                            txt_resultado.text = num2
                        }else{
                            Toast.makeText(
                                applicationContext,
                                "Error: Numero demasiado largo.",
                                Toast.LENGTH_SHORT
                            ).show()
                            cfuncion()
                        }
                    }
                }
                if(modo=="hex"){
                    if(txt_historial.text.isNotEmpty()){
                        num1 = hexToDec(num1).toString()
                        txt_historial.text = num1
                    }
                    if(txt_resultado.text.isNotEmpty()){
                        num2 = hexToDec(txt_resultado.text.toString()).toString()
                        txt_resultado.text = num2
                    }
                }


                modo = "dec"
                txt_modo.text= "Modo: Decimal."
                bA.isClickable = false
                bB.isClickable = false
                bC.isClickable = false
                bD.isClickable = false
                bE.isClickable = false
                bF.isClickable = false
                b2.isClickable = true
                b3.isClickable = true
                b4.isClickable = true
                b5.isClickable = true
                b6.isClickable = true
                b7.isClickable = true
                b8.isClickable = true
                b9.isClickable = true
                b_punto.isClickable = true
            }

            (b_bin.id)->{
                if (modo=="dec"){
                    if (txt_historial.text.isNotEmpty()){
                        num1=decToBin(num1.toInt())
                        txt_historial.text = num1
                    }
                    if(txt_resultado.text.isNotEmpty()){
                        num2=decToBin(txt_resultado.text.toString().toInt())
                        txt_resultado.text = num2
                    }
                }
                if(modo=="hex"){
                    if (txt_historial.text.isNotEmpty()){
                        num1=hexToDec(num1).toString()
                        num1=decToBin(num1.toInt())
                        txt_historial.text = num1
                    }
                    if(txt_resultado.text.isNotEmpty()){
                        println(num2)
                        num2=hexToDec(txt_resultado.text.toString()).toString()
                        println(num2)
                        num2=decToBin(num2.toInt())
                        println(num2)
                        txt_resultado.text = num2
                    }
                }

                modo = "bin"
                txt_modo.text= "Modo: Binario."
                bA.isClickable = false
                bB.isClickable = false
                bC.isClickable = false
                bD.isClickable = false
                bE.isClickable = false
                bF.isClickable = false
                b2.isClickable = false
                b3.isClickable = false
                b4.isClickable = false
                b5.isClickable = false
                b6.isClickable = false
                b7.isClickable = false
                b8.isClickable = false
                b9.isClickable = false
                b_punto.isClickable = false
            }

            (b_hexadecimal.id)->{
                if(modo=="dec"){
                    if(txt_historial.text.isNotEmpty()){
                        num1 = decToHex(num1.toInt()).toUpperCase()
                        txt_historial.text = num1
                    }
                    if(txt_resultado.text.isNotEmpty()){
                        num2 = decToHex(txt_resultado.text.toString().toInt()).toUpperCase()
                        txt_resultado.text = num2
                    }
                }

                if(modo=="bin"){
                    if (txt_historial.text.isNotEmpty()){
                        println("hist not empty")
                        if (txt_historial.text.length<19){
                            num1 = binToDec(num1.toLong()).toString()
                            num1 = decToHex(num1.toInt())
                            txt_historial.text = num1
                        }else{
                            Toast.makeText(
                                applicationContext,
                                "Error: Numero demasiado largo.",
                                Toast.LENGTH_SHORT
                            ).show()
                            cfuncion()
                        }
                    }

                    if(txt_resultado.text.isNotEmpty()){
                        println("main not empty")
                        println(txt_resultado.text.toString())

                        if (txt_resultado.text.length<19){
                            num2 = binToDec(txt_resultado.text.toString().toLong()).toString()
                            num2 = decToHex(num2.toInt())
                            txt_resultado.text = num2
                        }else{
                            Toast.makeText(
                                applicationContext,
                                "Error: Numero demasiado largo.",
                                Toast.LENGTH_SHORT
                            ).show()
                            cfuncion()
                        }
                    }
                }


                modo = "hex"
                txt_modo.text= "Modo: Hexadecimal."
                bA.isClickable = true
                bB.isClickable = true
                bC.isClickable = true
                bD.isClickable = true
                bE.isClickable = true
                bF.isClickable = true
                b2.isClickable = true
                b3.isClickable = true
                b4.isClickable = true
                b5.isClickable = true
                b6.isClickable = true
                b7.isClickable = true
                b8.isClickable = true
                b9.isClickable = true
                b_punto.isClickable = false
            }
        }
    }

    fun c(view: android.view.View) {
        txt_resultado.text=""
        txt_historial.text=""
        num1=""
        num2=""
        operador=""
    }

    //Para poder llamarlo desde otro metodo sin tener que pasarle una view
    fun cfuncion(){
        txt_resultado.text=""
        txt_historial.text=""
        num1=""
        num2=""
        operador=""
    }

    fun del(view: android.view.View) {
        if (txt_resultado.text.isNotEmpty()){
            val strAux= txt_resultado.text.substring(0,txt_resultado.text.length-1)
            txt_resultado.text = strAux
        }
    }

    fun num(view: android.view.View) {
        val boton = view as Button
        var txt_main = txt_resultado.text.toString()
        println("Boton presionado: " + boton.text.toString())
        if (modo=="dec"||modo=="hex"){
            when (boton.id) {
                b0.id -> {
                    txt_main += b0.text.toString()
                }
                b1.id -> {
                    txt_main += b1.text.toString()
                }
                b2.id -> {
                    txt_main += b2.text.toString()
                }
                b3.id -> {
                    txt_main += b3.text.toString()
                }
                b4.id -> {
                    txt_main += b4.text.toString()
                }
                b5.id -> {
                    txt_main += b5.text.toString()
                }
                b6.id -> {
                    txt_main += b6.text.toString()
                }
                b7.id -> {
                    txt_main += b7.text.toString()
                }
                b8.id -> {
                    txt_main += b8.text.toString()
                }
                b9.id -> {
                    txt_main += b9.text.toString()
                }
                b_punto.id -> {
                    var anadir = true
                    if (txt_main.isNotEmpty()) {
                        for (char in txt_main) {
                            if (char == '.') {
                                anadir = false
                            }
                        }
                        if (anadir) {
                            txt_main += "."
                        }
                    }
                }
            }
            txt_resultado.text = txt_main
        }
        if (modo=="bin"){
            when (boton.id) {
                b0.id->{
                    txt_main += b0.text.toString()
                }
                b1.id->{
                    txt_main += b1.text.toString()
                }
            }
            txt_resultado.text = txt_main

        }
        if (modo=="hex"){
            when (boton.id) {
                bA.id->{
                    txt_main += bA.text.toString()
                }
                bB.id->{
                    txt_main += bB.text.toString()
                }
                bC.id->{
                    txt_main += bC.text.toString()
                }
                bD.id->{
                    txt_main += bD.text.toString()
                }
                bE.id->{
                    txt_main += bE.text.toString()
                }
                bF.id->{
                    txt_main += bF.text.toString()
                }

            }
            txt_resultado.text = txt_main

        }
    }

    fun operacion(view: android.view.View) {
        val boton = view as Button

        if (modo == "dec") {
            if (txt_historial.text.isEmpty()){
                when(boton.id){
                    b_div.id ->{
                        operador = "/"
                    }
                    b_mul.id ->{
                        operador = "*"
                    }
                    b_sum.id ->{
                        operador = "+"
                    }
                    b_res.id ->{
                        operador = "-"
                    }
                }
                num1 = txt_resultado.text.toString()
                val strAux = num1+operador
                txt_historial.text = strAux
                txt_resultado.text=""
            }

            if (txt_historial.text.isNotEmpty()&&txt_resultado.text.isEmpty()){
                var strAux=txt_historial.text.substring(0,txt_historial.text.length-1)
                when(boton.id){
                    b_div.id ->{
                        operador = "/"
                    }
                    b_mul.id ->{
                        operador = "*"
                    }
                    b_sum.id ->{
                        operador = "+"
                    }
                    b_res.id ->{
                        operador = "-"
                    }
                }
                strAux += operador
                txt_historial.text = strAux
            }

            if (txt_historial.text.isNotEmpty() && !txt_resultado.text.equals("")) {

                num2 = txt_resultado.text.toString()
                var res = 0.0
                print(num1)
                print(operador)
                print(num2)
                when (operador) {
                    "-" -> {
                        res = num1.toDouble() - num2.toDouble()
                        txt_historial.text = res.toString()
                    }
                    "*" -> {
                        res = num1.toDouble() * num2.toDouble()
                        txt_historial.text = res.toString()
                    }
                    "/" -> {
                        if (num2.toDouble() == 0.0) {
                            Toast.makeText(
                                applicationContext,
                                "Error: No se puede dividir entre 0.",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            res = num1.toDouble() / num2.toDouble()
                            txt_historial.text = res.toString()
                        }
                    }
                    "+" -> {
                        res = num1.toDouble() + num2.toDouble()
                        txt_historial.text = res.toString()
                    }
                }
                var txt_hist = txt_historial.text.toString()
                when (boton.id) {
                    b_div.id -> {
                        operador = "/"
                        txt_hist += operador
                    }
                    b_mul.id -> {
                        operador = "*"
                        txt_hist += operador
                    }
                    b_sum.id -> {
                        operador = "+"
                        txt_hist += operador
                    }
                    b_res.id -> {
                        operador = "-"
                        txt_hist += operador
                    }
                }
                txt_historial.text = txt_hist

                txt_resultado.text = ""
                num1 = res.toString()
                num2 = ""
            }
        }
        if (modo=="bin"){

        }
        if (modo=="hex"){

        }

    }

    fun igual(view: android.view.View) {
        if (modo=="dec") {
            num2 = txt_resultado.text.toString()
            if (txt_resultado.text.isNotEmpty() && txt_historial.text.isNotEmpty()) {
                var res: Double
                println(operador)

                when (operador) {
                    "-" -> {
                        res = num1.toDouble() - num2.toDouble()
                        txt_resultado.text = res.toString()
                    }
                    "*" -> {
                        res = num1.toDouble() * num2.toDouble()
                        txt_resultado.text = res.toString()
                    }
                    "/" -> {
                        if (num2.toDouble() == 0.0) {
                            Toast.makeText(
                                applicationContext,
                                "Error: No se puede dividir entre 0.",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            res = num1.toDouble() / num2.toDouble()
                            txt_resultado.text = res.toString()
                        }
                    }
                    "+" -> {
                        res = num1.toDouble() + num2.toDouble()
                        txt_resultado.text = res.toString()
                    }
                }
                txt_historial.text = ""
                num1 = ""
                num2 = ""
            }
        }
        if (modo=="bin"){

        }
        if (modo=="hex"){

        }
    }

    fun binToDec(num: Long): Int {
        var num = num
        var res = 0
        var i = 0
        var resto: Long
        while (num.toInt() != 0) {
            resto = num % 10
                    num /= 10
            res += (resto * Math.pow(2.0, i.toDouble())).toInt()
            ++ i
        }
        return res
    }

    fun decToBin(num:Int):String{
        val bin = Integer.toBinaryString(num)
        return bin
    }

    fun decToHex(num:Int):String{
        val hexString = java.lang.Integer.toHexString(num)
        return hexString
    }

    fun hexToDec(hex: String): Long {
        var dec: Long = 0
        var potencia = 0
        for (x in hex.length - 1 downTo 0) {
            val valor: Int = LHexToDec(hex[x])
            val elevado = Math.pow(16.0, potencia.toDouble()).toLong() * valor
            dec += elevado
            potencia++
        }
        return dec
    }

    fun LHexToDec(caracter: Char): Int {
        return when (caracter) {
            'A' -> 10
            'B' -> 11
            'C' -> 12
            'D' -> 13
            'E' -> 14
            'F' -> 15
            else -> caracter.toString().toInt()
        }
    }
}
