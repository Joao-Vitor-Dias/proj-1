package atividade02.utils;

import java.util.Scanner;

public class Calculadora {

    public double somar(int num1, int num2){

        return num1 + num2;

    }

    public double subtrair(int num1, int num2){

        return num1 - num2;

    }

    public double multiplicar(int num1, int num2){

        return num1 * num2;

    }

    public double dividir(int num1, int num2){

        return (double) num1 / num2;

    }

    public void exibirMenu() {

        Scanner sc = new Scanner(System.in);

        int op = 0;
        double resultado = 0;
        String simbolo = "";

        while (true) {

            System.out.println("======== Calculadora ========");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("5 - Sair");
            System.out.println("Insira oque deseja fazer: ");
            op = sc.nextInt();

            if (op == 5) {
                System.exit(0);
            }

            System.out.println("============================");
            System.out.println("Agora insira o primeiro numero: ");
            int num1 = sc.nextInt();
            System.out.println("Agora insira o segundo numero: ");
            int num2 = sc.nextInt();

            switch (op) {
                case 1:
                    resultado = somar(num1, num2);
                    simbolo = "+";
                    break;
                case 2:
                    resultado = subtrair(num1, num2);
                    simbolo = "-";
                    break;
                case 3:
                    resultado = multiplicar(num1, num2);
                    simbolo = "*";
                    break;
                case 4:
                    resultado = dividir(num1, num2);
                    simbolo = "÷";
                    break;
                default:
                    System.out.println("Opção invalida !!!!");
                    break;
            }

            System.out.println("===============");
            System.out.printf("O resultado foi de %d %s %d = %.1f%n\n", num1, simbolo, num2, resultado);
            System.out.println("Aberte 'enter' para continuar ....");
            sc.nextLine();
            sc.nextLine();


        }
    }
}