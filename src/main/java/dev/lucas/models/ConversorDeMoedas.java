package dev.lucas.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorDeMoedas {

    private String brlDlrUrl = "https://api.invertexto.com/v1/currency/BRL_USD?token=15737%7CjnJmzXyfI83BURI9J3qFfHFHkrxyDQWA";
    private String brlEurUrl = "https://api.invertexto.com/v1/currency/BRL_EUR?token=15737%7CjnJmzXyfI83BURI9J3qFfHFHkrxyDQWA";
    private String brlJpyUrl = "https://api.invertexto.com/v1/currency/BRL_JPY?token=15737%7CjnJmzXyfI83BURI9J3qFfHFHkrxyDQWA";
    private String dlrBrlUrl = "https://api.invertexto.com/v1/currency/USD_BRL?token=15737%7CjnJmzXyfI83BURI9J3qFfHFHkrxyDQWA";
    private String dlrEurUrl = "https://api.invertexto.com/v1/currency/USD_EUR?token=15737%7CjnJmzXyfI83BURI9J3qFfHFHkrxyDQWA";
    private String dlrJpyUrl = "https://api.invertexto.com/v1/currency/USD_JPY?token=15737%7CjnJmzXyfI83BURI9J3qFfHFHkrxyDQWA";
    private HttpClient client = HttpClient.newHttpClient();
    private Gson gson = new Gson();
    Scanner scanner = new Scanner(System.in);

    public void converterRealParaDolar(){
        HttpRequest request = HttpRequest.newBuilder(URI.create(brlDlrUrl)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moeda moeda = gson.fromJson(response.body(), Moeda.class);
            System.out.println("Digite o valor de Reais que você quer converter para Dólar:");
            Double valor;
            Boolean repetir = true;
            while(repetir)
                try{
                    valor = scanner.nextDouble();
                    Double valorTotal = valor * moeda.getBrlDlr().getValor();
                    System.out.printf("Neste exato momento o valor convertido de %.2fR$, é %.2f$ Dólares!", valor,valorTotal) ;
                    repetir = false;

                }catch(InputMismatchException e){
                    System.out.println("Insira apenas números quando for passar os valores!");
                    valor = 0.0;
            }
        }catch(IOException | InterruptedException e){
            System.out.println("Erro na requisição!");
        }
    }
    public void converterRealParaEuro(){
        HttpRequest request = HttpRequest.newBuilder(URI.create(brlEurUrl)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moeda moeda = gson.fromJson(response.body(), Moeda.class);
            System.out.println("Digite o valor de Reais que você quer converter para Euro:");
            Double valor;
            Boolean repetir = true;
            while(repetir)
                try{
                    valor = scanner.nextDouble();
                    Double valorTotal = valor * moeda.getBrlEur().getValor();
                    System.out.printf("Neste exato momento o valor convertido de %.2fR$, é %.2f$ Euros!", valor,valorTotal) ;
                    repetir = false;
                }catch(InputMismatchException e){
                    System.out.println("Insira apenas números quando for passar os valores!");
                    valor = 0.0;
                }
        }catch(IOException | InterruptedException e){
            System.out.println("Erro na requisição!");
        }
    }
    //usei CHAT GPT porque essa moeda estava bugada
    public void converterRealParaJpy(){
        HttpRequest request = HttpRequest.newBuilder(URI.create(brlJpyUrl)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.body() != null) {
                Moeda moeda = gson.fromJson(response.body(), Moeda.class);

                if (moeda != null && moeda.getBrlJpy() != null) {
                    System.out.println("Digite o valor de Reais que você quer converter para Yens Japoneses:");
                    Double valor;
                    Boolean repetir = true;

                    while(repetir) {
                        try {
                            valor = scanner.nextDouble();
                            Double valorTotal = valor * moeda.getBrlJpy().getValor();
                            System.out.printf("Neste exato momento o valor convertido de %.2fR$, é %.2f$ Yens Japoneses!%n", valor, valorTotal);
                            repetir = false;
                        } catch(InputMismatchException e) {
                            System.out.println("Insira apenas números quando for passar os valores!");
                            valor = 0.0;
                        }
                    }
                } else {
                    System.out.println("Dados de conversão não disponíveis.");
                }
            } else {
                System.out.println("Resposta da API está vazia.");
            }
        } catch(IOException | InterruptedException e) {
            System.out.println("Erro na requisição!");
        }
    }
    public void converterDolarParaReal(){
        HttpRequest request = HttpRequest.newBuilder(URI.create(dlrBrlUrl)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moeda moeda = gson.fromJson(response.body(), Moeda.class);
            System.out.println("Digite o valor de Dolares que você quer converter para Reais:");
            Double valor;
            Boolean repetir = true;
            while(repetir)
                try{
                    valor = scanner.nextDouble();
                    Double valorTotal = valor * moeda.getDlrBrl().getValor();
                    System.out.printf("Neste exato momento o valor convertido de %.2f$, é %.2fR$ Reais!", valor,valorTotal) ;
                    repetir = false;
                }catch(InputMismatchException e){
                    System.out.println("Insira apenas números quando for passar os valores!");
                    valor = 0.0;
                }
        }catch(IOException | InterruptedException e){
            System.out.println("Erro na requisição!");
        }
    }
    public void converterDolarParaEuro(){
        HttpRequest request = HttpRequest.newBuilder(URI.create(dlrEurUrl)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moeda moeda = gson.fromJson(response.body(), Moeda.class);
            System.out.println("Digite o valor de Dolares que você quer converter para Euros:");
            Double valor;
            Boolean repetir = true;
            while(repetir)
                try{
                    valor = scanner.nextDouble();
                    Double valorTotal = valor * moeda.getDlrEur().getValor();
                    System.out.printf("Neste exato momento o valor convertido de %.2f$, é %.2f$ Euros!", valor,valorTotal) ;
                    repetir = false;

                }catch(InputMismatchException e){
                    System.out.println("Insira apenas números quando for passar os valores!");
                    valor = 0.0;
                }
        }catch(IOException | InterruptedException e){
            System.out.println("Erro na requisição!");
        }
    }

    public void converterDolarParaJpy(){
        HttpRequest request = HttpRequest.newBuilder(URI.create(dlrJpyUrl)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moeda moeda = gson.fromJson(response.body(), Moeda.class);
            System.out.println("Digite o valor de Dolares que você quer converter para Yens Japoneses:");
            Double valor;
            Boolean repetir = true;
            while(repetir)
                try{
                    valor = scanner.nextDouble();
                    Double valorTotal = valor * moeda.getDlrJpy().getValor();
                    System.out.printf("Neste exato momento o valor convertido de %.2f$, é %.2f$ Yens Japoneses!", valor,valorTotal) ;
                    repetir = false;

                }catch(InputMismatchException e){
                    System.out.println("Insira apenas números quando for passar os valores!");
                    valor = 0.0;
                }
        }catch(IOException | InterruptedException e){
            System.out.println("Erro na requisição!");
        }
    }


}

