package atvemsala02;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Davi");
        lista.add("Ricardo");
        lista.add("Alessandro");
        lista.add("Viviane");
        lista.add("Alexandre");
        lista.add(0, "Lynwood");
        lista.add(0, "Thiane");
        lista.add(0, "Maurilio");
        System.out.println("Tamanho da lista: " + lista.size());
        lista.remove(lista.size() - 1);
        lista.remove(0);
        System.out.println("Posição do professor Alessandro: " + lista.indexOf("Alessandro"));
        lista.set(0, "Davi Taveira");
        System.out.println(lista);
        System.out.println("Informe uma posição: ");
        Scanner sc = new Scanner(System.in);
        int posicao = sc.nextInt();
        System.out.println("Professor na posição " + posicao + ": " + lista.get(posicao));
        System.out.println("Informe uma letra: ");
        String letra = sc.next();
        boolean achou = false;
        for (String nome : lista) {
            if (nome.startsWith(letra)) {
                System.out.println(nome);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Lista não possui professores que iniciam com a letra informada!");
        }
    }
}
