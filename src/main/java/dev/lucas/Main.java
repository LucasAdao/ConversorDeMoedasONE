package dev.lucas;

import dev.lucas.models.ConversorDeMoedas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConversorDeMoedas conversorDeMoedas = new ConversorDeMoedas();
        Boolean rodar = true;
        Scanner scanner = new Scanner(System.in);
        while(rodar){
            System.out.println("\n1-Real para Dólar\n2-Real para Euro\n3-Real para Yens Japoneses\n4-Dólar para Real\n5-Dólar para Euro\n6-Dólar para Yens Japoneses\n7-Sair");
            int opcao;
            Boolean repetir = true;
            while(repetir)
            try{
                 opcao = scanner.nextInt();
                 scanner.nextLine();
                 switch(opcao){
                     case 1:
                         conversorDeMoedas.converterRealParaDolar();
                         break;
                     case 2:
                         conversorDeMoedas.converterRealParaEuro();
                         break;
                     case 3:
                         conversorDeMoedas.converterRealParaJpy();
                         break;
                     case 4:
                         conversorDeMoedas.converterDolarParaReal();
                         break;
                     case 5:
                         conversorDeMoedas.converterDolarParaEuro();
                         break;
                     case 6:
                         conversorDeMoedas.converterDolarParaJpy();
                         break;
                     case 7:
                         System.out.println("Programa finalizado!!");
                         rodar = false;
                         break;
                     default:
                         System.out.println("Insira um valor valido!");
                         break;
                 }
                 break;
            }catch(InputMismatchException e){
                System.out.println("Digite apenas números!");
            }
        }
    }
}