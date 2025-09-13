package atividade05;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        nomes.add("Hebert");
        nomes.add("Richard");
        nomes.add("Flinstons");
        System.out.println(nomes);

        removerLista(nomes);

        System.out.println(nomes);


    }

    public static void removerLista(List<String> nomes){

        nomes.remove(1);

    }

}
