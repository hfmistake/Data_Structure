package AtvEmSala01;

import java.util.Scanner;

class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.setNome(nome);
        this.setTelefone(telefone);
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

class ControlaAgenda {
    Scanner input = new Scanner(System.in);
    private final Contato[] agenda;

    String text = """
            [1]-Adicionar Contato
            [2]-Adicionar Contato por posição
            [3]-Excluir Contato
            [4]-Quantidade de contato existentes
            [5]-Buscar contato
            [6]-Mostrar Todos contatos
            [7]-Mostrar contatos pela inicial
            """;

    public ControlaAgenda(int capacidade) {
        this.agenda = new Contato[capacidade];
    }

    public void mostrarMenu() {
        System.out.println(text);
    }

    public void mostrarContato(Contato contato) {
        System.out.println("Nome: " + contato.getNome());
        System.out.println("Telefone: " + contato.getTelefone());
    }

    public char LetraPrompt() {
        System.out.print("Digite a letra: ");
        return input.nextLine().charAt(0);
    }

    public String NomePrompt() {
        System.out.print("Digite o nome do contato: ");
        return input.nextLine();
    }

    public int PosicaoPrompt() {
        System.out.print("Digite a posição do contato: ");
        return Integer.parseInt(input.nextLine());
    }

    public Contato GerarContatoPrompt() {
        System.out.print("Digite o nome do contato: ");
        String nome = input.nextLine();
        System.out.print("Digite o telefone do contato: ");
        String telefone = input.nextLine();
        return new Contato(nome, telefone);
    }

    public void adicionarContato(Contato contato) {
        for (int i = 0; i < this.agenda.length; i++) {
            if (this.agenda[i] == null) {
                this.agenda[i] = contato;
                System.out.println("Contato adicionado!");
                break;
            }
        }
    }


    public void adicionarContatoPos(int posicao, Contato contato) {
        if (this.agenda[posicao] == null) {
            this.agenda[posicao] = contato;
            System.out.println("Contato adicionado!");
        } else {
            System.out.println("Posição ocupada. O contato não foi adicionado");
        }
    }

    public void excluirContato(String nome) {
        boolean find = false;
        for (int i = 0; i < this.agenda.length; i++) {
            if (this.agenda[i] != null) {
                if (this.agenda[i].getNome().equals(nome)) {
                    this.agenda[i] = null;
                    System.out.println("Contato excluido");
                    find = true;
                    break;
                }
            }
        }
        if (!find) {
            System.out.println("O nome fornecido não foi encontrado");
        }
    }

    public void buscarContato(String nome) {
        boolean find = false;
        for (Contato contato : this.agenda) {
            if (contato != null) {
                if (contato.getNome().equals(nome)) {
                    System.out.println("Contato encontrado");
                    find = true;
                    mostrarContato(contato);
                }
            }
        }
        if (!find) {
            System.out.println("Contato não encontrado.");
        }
    }

    public void quantidadeContatos() {
        int cont = 0;
        for (Contato contato : this.agenda) {
            if (contato != null) {
                cont++;
            }
        }
        System.out.printf("Quantidade de contatos existentes: %d\n", cont);
    }

    public void imprimirTodosContatos() {
        for (Contato contato : this.agenda) {
            if (contato != null) {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Telefone: " + contato.getTelefone());
            }
        }
    }

    public void imprimirContatos(char letra) {
        boolean existe = false;
        for (Contato contato : this.agenda) {
            if (contato != null) {
                if (contato.getNome().charAt(0) == letra) {
                    System.out.println("Nome: " + contato.getNome());
                    System.out.println("Telefone: " + contato.getTelefone());
                    existe = true;
                }
            }
        }
        if (!existe) {
            System.out.println("Agenda não possui contatos que iniciam com a letra informada!");
        }
    }
}

public class Main {
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
