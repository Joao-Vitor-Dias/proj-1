package atividade04;

import java.util.Scanner;

public class Atividade4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======== Conversor Temperatura =======");
        System.out.println("1 - CELSIUS para FAHRENHEIT");
        System.out.println("2 - FAHRENHEIT para CELSIUS");

        System.out.println("Digite sua escolha: ");
        int op = sc.nextInt();

        System.out.println("Digite a temperatura");
        double temp = sc.nextDouble();

        fazerConversao(op,temp);

    }

    public static void fazerConversao(int op, double temp){

        if (op == 1){
            double resultado = 1.8 * temp + 32;
            System.out.printf("Temperatura em fahrenheit - %.1f%n\n",resultado);

        } else if (op == 2) {
            double resultado = (temp - 32) / 1.8;
            System.out.printf("Temperatura em celsius - %.1f%n\n", resultado);
        } else {
            System.out.println("Opção invalida");
        }

    }


}
