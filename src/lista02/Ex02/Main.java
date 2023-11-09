package lista02.Ex02;

import java.util.Scanner;

class ItemDeCompra {
    String nome;
    String categoria;
    double preco;
    ItemDeCompra next;

    public ItemDeCompra(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.next = null;
    }
}

class ListaDeCompras {
    private ItemDeCompra head;

    public ListaDeCompras() {
        head = null;
    }

    public void adicionarItem(String nome, String categoria, double preco) {
        ItemDeCompra newItem = new ItemDeCompra(nome, categoria, preco);
        if (head != null) {
            newItem.next = head;
        }
        head = newItem;
    }

    public void imprimirValorFinalCompra() {
        double total = 0;
        ItemDeCompra current = head;
        while (current != null) {
            total += current.preco;
            current = current.next;
        }
        System.out.println("Valor Final da Compra: R$" + total);
    }

    public boolean buscaItemLista(String nomeItem) {
        ItemDeCompra current = head;
        while (current != null) {
            if (current.nome.equalsIgnoreCase(nomeItem)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void maiorValorItemLista() {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        ItemDeCompra current = head;
        ItemDeCompra itemMaiorValor = head;
        while (current != null) {
            if (current.preco > itemMaiorValor.preco) {
                itemMaiorValor = current;
            }
            current = current.next;
        }

        System.out.println("Item com Maior Valor: " + itemMaiorValor.nome + " - R$" + itemMaiorValor.preco);
    }

    public void listaItensCategoria(String categoriaDesejada) {
        ItemDeCompra current = head;
        System.out.println("Itens na Categoria '" + categoriaDesejada + "':");
        while (current != null) {
            if (current.categoria.equalsIgnoreCase(categoriaDesejada)) {
                System.out.println(current.nome + " - R$" + current.preco);
            }
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDeCompras listaDeCompras = new ListaDeCompras();

        listaDeCompras.adicionarItem("Maçã", "Frutas", 2.5);
        listaDeCompras.adicionarItem("Banana", "Frutas", 3.0);
        listaDeCompras.adicionarItem("Arroz", "Grãos", 4.0);
        listaDeCompras.adicionarItem("Leite", "Laticínios", 3.0);
        listaDeCompras.adicionarItem("Carne", "Carnes", 10.0);

        listaDeCompras.imprimirValorFinalCompra();

        System.out.println("Digite o nome de um item para verificar se está na lista:");
        String nomeItem = scanner.nextLine();
        if (listaDeCompras.buscaItemLista(nomeItem)) {
            System.out.println(nomeItem + " está na lista.");
        } else {
            System.out.println(nomeItem + " não está na lista.");
        }

        listaDeCompras.maiorValorItemLista();

        System.out.println("Digite a categoria para listar os itens:");
        String categoriaDesejada = scanner.nextLine();
        listaDeCompras.listaItensCategoria(categoriaDesejada);

        scanner.close();
    }
}
