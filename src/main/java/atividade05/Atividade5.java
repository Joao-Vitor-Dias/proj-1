package atividade05;

import atividade05.model.Comida;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Atividade5 {

    static HashMap<Integer, Comida> comidasLoja = new HashMap<>();

    static {

        comidasLoja.put(1,new Comida("Pizza", 30.0));
        comidasLoja.put(2,new Comida("Hambúrguer", 20.0));
        comidasLoja.put(3,new Comida("Salada", 15.0));
        comidasLoja.put(4,new Comida("Suco", 8.0));

    }

    static double valorTotal = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> comidasEscolhidas = new ArrayList<>();
        boolean querAdicionarComida = true;
        boolean querContinuarParaPagamento = false;

        do {

            while (querAdicionarComida){

                System.out.println("=== Cardápio ===");

                System.out.println("1 - Pizza R$ 30.0");
                System.out.println("2 - Hambúrguer R$ 20.0");
                System.out.println("3 - Salada R$ 15.0");
                System.out.println("4 - Suco R$ 8.0");

                System.out.println("Selecione oque deseja: ");
                int op = sc.nextInt();

                Comida comida = comidasLoja.get(op);
                comidasEscolhidas.add(comida.getNome());
                valorTotal += comida.getValor();

                System.out.println("Deseja adicionar algo a mais? s/n");
                String escolhaContinuar = sc.next();
                if (!(escolhaContinuar.equalsIgnoreCase("s"))){
                    querAdicionarComida = false;
                }

            }

            System.out.println("Deseja continuar para o pagamento? s/n");
            System.out.println(comidasEscolhidas);
            String escolhaContinuar = sc.next();
            if (escolhaContinuar.equalsIgnoreCase("s")){
                querContinuarParaPagamento = true;
            }else {

                System.out.println("Deseja Cancelar o pedido ou Remover algo da lista? c/r ");
                String removerCancelarPedido = sc.next();
                if (removerCancelarPedido.equalsIgnoreCase("c")){
                    System.exit(0);
                }else {
                    System.out.println("Oque deseja remover da Lista? ");
                    System.out.println(comidasEscolhidas);
                    String nomeComidaRemover = sc.next();
                    removerItemLista(comidasEscolhidas,nomeComidaRemover);
                }

            }

        }while (!(querContinuarParaPagamento));

        System.out.println("=== Seu pedido final ===");
        System.out.println(comidasEscolhidas);
        System.out.println(valorTotal);

    }

    public static String removerAcento(String str){
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static void removerItemLista(List<String> nomesComidasEscolhidas, String nomeComida){

        String nomeComidaFormatadaParaRemover = removerAcento(nomeComida);

        for (Comida comida: comidasLoja.values()){
            if (removerAcento(comida.getNome()).equalsIgnoreCase(nomeComidaFormatadaParaRemover)){
                nomesComidasEscolhidas.remove(comida.getNome());
                valorTotal -= comida.getValor();

            }
        }

    }

}
