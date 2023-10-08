package Lista01.Ex01;

import java.util.Scanner;

class Node {
    double data;
    Node next;

    public Node(double data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(double data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public double calcularMedia() {
        if (size == 0) {
            return 0;
        }
        double soma = 0;
        Node current = head;
        while (current != null) {
            soma += current.data;
            current = current.next;
        }
        return soma / size;
    }

    public void antecessorSucessor(double numero) {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        Node current = head;
        Node antecessor = null;
        Node sucessor = null;

        while (current != null && current.data != numero) {
            antecessor = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Número não encontrado na lista.");
        } else {
            if (antecessor != null) {
                System.out.println("Antecessor: " + antecessor.data);
            } else {
                System.out.println("Não há antecessor.");
            }

            if (current.next != null) {
                sucessor = current.next;
                System.out.println("Sucessor: " + sucessor.data);
            } else {
                System.out.println("Não há sucessor.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList lista = new LinkedList();

        System.out.println("Informe os números (digite '0' para parar):");
        double numero;
        do {
            numero = scanner.nextDouble();
            if (numero != 0) {
                lista.add(numero);
            }
        } while (numero != 0);

        System.out.println("Média Aritmética: " + lista.calcularMedia());

        System.out.println("Informe um número para encontrar seu antecessor e sucessor:");
        double numeroBusca = scanner.nextDouble();
        lista.antecessorSucessor(numeroBusca);

        scanner.close();
    }
}
