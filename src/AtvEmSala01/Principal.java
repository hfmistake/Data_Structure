package AtvEmSala01;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ControlaAgenda agenda = new ControlaAgenda(50);
        Scanner input = new Scanner(System.in);
        int opcao = -1;
        agenda.mostrarMenu();
        while (opcao != 0) {
            System.out.print("Para exibir o menu novamente insira [8]\nInsira a opção desejada: ");
            opcao = Integer.parseInt(input.nextLine());
            switch (opcao) {
                case 1 -> agenda.adicionarContato(agenda.GerarContatoPrompt());
                case 2 -> agenda.adicionarContatoPos(agenda.PosicaoPrompt(), agenda.GerarContatoPrompt());
                case 3 -> agenda.excluirContato(agenda.NomePrompt());
                case 4 -> agenda.quantidadeContatos();
                case 5 -> agenda.buscarContato(agenda.NomePrompt());
                case 6 -> agenda.imprimirTodosContatos();
                case 7 -> agenda.imprimirContatos(agenda.LetraPrompt());
                case 8 -> agenda.mostrarMenu();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
