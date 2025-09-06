package atividade03;

import java.util.Scanner;

public class Atividade3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um numero: ");
        int num = sc.nextInt();

        String resultado = verificarNumeroPrimo(num) ? "Numero é primo" : "Numero nao é primo";

        System.out.println(resultado);

    }

    public static boolean verificarNumeroPrimo(int num){

        int raizQuadradaParteInteira = (int)Math.sqrt(num);

        for (int i = 2; i <= raizQuadradaParteInteira; i++) {

            if (num % i == 0){
                return false;
            }

        }

        return true;

    }
}
