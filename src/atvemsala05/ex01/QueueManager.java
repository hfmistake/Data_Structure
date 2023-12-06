package atvemsala05.ex01;

class Pessoa {
    String nome;
    int idade;
    boolean PNE;

    public Pessoa(String nome, int idade, boolean PNE) {
        this.nome = nome;
        this.idade = idade;
        this.PNE = PNE;
    }
}

abstract class Queue {
    private Node head;
    private Node tail;
    String tipo;

    public String getTipo() {
        return tipo;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void printQueue() {
        StringBuilder str = new StringBuilder(String.format("Fila %s| Atendimento<---[", getTipo()));
        Node aux = this.getHead();
        while (aux.next != null) {
            str.append(aux.value.nome).append(", ");
            aux = aux.next;
        }
        str.append(aux.value.nome).append("] <---Fim da fila");
        System.out.println(str);
    }

    public void serve() {
        System.out.println("Cliente atendido: " + this.getHead().value.nome);
        if (this.getHead() == this.getTail()) {
            this.setTail(null);
        }
        this.setHead(this.getHead().next);
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }
}

class Node {
    Pessoa value;
    Node next = null;

    public Node(Pessoa value) {
        this.value = value;
    }

    public boolean isPNE() {
        return value.PNE;
    }
}

class QueueNormal extends Queue {
    String tipo = "Normal";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTail(Node tail) {
        if (tail == null) {
            super.setTail(null);
            return;
        }
        if (tail.isPNE()) {
            System.out.println("Erro: Uma pessoa PNE não pode entrar nessa fila.");
            return;
        }
        super.setTail(tail);
    }

    @Override
    public void setHead(Node head) {
        if (head == null) {
            super.setHead(null);
            return;
        }
        if (head.isPNE()) {
            System.out.println("Erro: Uma pessoa PNE não pode entrar nessa fila.");
            return;
        }
        super.setHead(head);
    }

}

class QueuePNE extends Queue {
    String tipo = "PNE";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTail(Node tail) {
        if (tail == null) {
            super.setTail(null);
            return;
        }
        if (!tail.isPNE()) {
            System.out.println("Erro: Uma pessoa Normal não pode entrar nessa fila.");
            return;
        }
        super.setTail(tail);
    }

    @Override
    public void setHead(Node head) {
        if (head == null) {
            super.setHead(null);
            return;
        }
        if (!head.isPNE()) {
            System.out.println("Erro: Uma pessoa Normal não pode entrar nessa fila.");
            return;
        }
        super.setHead(head);
    }
}

public class QueueManager {
    boolean pneSwitch = true;
    int normalServes = 0;

    QueueNormal normalQueue = new QueueNormal();
    QueuePNE pneQueue = new QueuePNE();

    public void insert(Node newNode) {
        Queue insertQueue;
        if (newNode.isPNE()) {
            insertQueue = pneQueue;
        } else {
            insertQueue = normalQueue;
        }
        if (insertQueue.getHead() == null && insertQueue.getTail() == null) {
            insertQueue.setHead(newNode);
        } else {
            Node aux = insertQueue.getHead();
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
        }
        insertQueue.setTail(newNode);
    }


    public void serve() {
        if (normalQueue.isEmpty() && pneQueue.isEmpty()) {
            System.out.println("Não há ninguem para ser atendido.");
            return;
        }
        if (pneQueue.isEmpty()) {
            pneSwitch = false;
        }
        if (normalQueue.isEmpty()) {
            pneSwitch = true;
        }
        if (!pneSwitch) {
            normalQueue.serve();
            normalServes++;
            if (normalServes == 3) {
                pneSwitch = true;
            }
        } else {
            pneSwitch = false;
            normalServes = 0;
            pneQueue.serve();
        }
    }
}
