package atividade05;

import atividade05.model.Comida;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Atividade5 {

    static HashMap<Integer, Comida> comidasLoja = new HashMap<>();

    static {

        comidasLoja.put(1,new Comida("Pizza", 30.0));
        comidasLoja.put(2,new Comida("Hambúrguer", 20.0));
        comidasLoja.put(3,new Comida("Salada", 15.0));
        comidasLoja.put(4,new Comida("Suco", 8.0));

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> comidasEscolhidas = new ArrayList<>();
        double valorTotal = 0;
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
                System.out.println("Deseja cancelar o pedido? s/n");
                String removerPedido = sc.next();
                if (removerPedido.equalsIgnoreCase("s")){
                    System.exit(0);
                }else {
                    System.out.println("Oque deseja remover da Lista? ");
                    System.out.println(comidasEscolhidas);
                    String nomeComidaRemover = sc.next();
                    String nomeComidaRemoverFormatada = removerAcento(nomeComidaRemover);

                    for(Comida comida: comidasLoja.values()){

                        if (comida.getNome().equalsIgnoreCase(nomeComidaRemoverFormatada)){
                            comidasEscolhidas.remove(comida.getNome());
                            valorTotal -= comida.getValor();
                            break;
                        }

                    }

                }

            }

        }while (!(querContinuarParaPagamento));

        System.out.println("=== Seu pedido final ===");
        System.out.println(comidasEscolhidas);
        System.out.println(valorTotal);

    }

    public static String removerAcento(String str){
        return Normalizer.normalize(str, Normalizer.Form.NFD).replace("[^\\p{ASCII}]", "");
    }

}
