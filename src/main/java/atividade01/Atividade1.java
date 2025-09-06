package atividade01;

public class Atividade1 {

    public static void main(String[] args) {

        System.out.println("Aulas operadores");

        for (int i = 0; i <= 100; i++) {

            if (!(verificarSeMultiplo(3, i) || verificarSeMultiplo(5, i))) {
                continue;
            }

            verificarFizz(i);
        }

    }

    public static boolean verificarSeMultiplo(int numBase, int num) {

        return num % numBase == 0;

    }


    public static void verificarFizz(int i) {

        if (verificarSeMultiplo(5, i) && verificarSeMultiplo(3, i)) {
            System.out.println(i);
            System.out.println("FizzBuzz");
            System.out.println("============");
            return;
        }

        if (verificarSeMultiplo(3, i)) {
            System.out.println(i);
            System.out.println("Fizz");
            System.out.println("============");
        } else if (verificarSeMultiplo(5, i)) {
            System.out.println(i);
            System.out.println("Buzz");
            System.out.println("============");
        }


    }

}
