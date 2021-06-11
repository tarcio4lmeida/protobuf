package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main (){
    val request = FuncionarioRequest.newBuilder()
        .setNome("Tarcio Almeida")
        .setCpf("000.000.000-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua das tabajaras")
            .setCep("00000-000")
            .setComplemento("Casa 10")
            .build())
        .build()

    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val request2 = FuncionarioRequest.newBuilder().mergeFrom(FileInputStream("funcionario-request.bin"))
    request2.setCargo(Cargo.GERENTE).build()

    println(request2)
}