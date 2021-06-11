package br.com.zup.edu

import io.grpc.ManagedChannelBuilder

fun main(){
    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()


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
    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
   val response =  client.cadastrar(request)
    println(response)
}