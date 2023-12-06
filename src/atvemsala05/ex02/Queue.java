package atvemsala05.ex02;


class Node {
    char value;
    Node next;

    public Node(char value) {
        this.value = value;
    }
}

class Queue {
    private Node head;
    private Node tail;

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

    public char enqueue(char value) {
        Node newNode = new Node(value);
        if (this.getHead() == null && this.getTail() == null) {
            this.setHead(newNode);
        } else {
            Node aux = this.getHead();
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
        }
        this.setTail(newNode);
        return value;
    }

    public char dequeue() {
        char value = this.getHead().value;
        if (this.getHead() == this.getTail()) {
            this.setTail(null);
        }
        this.setHead(this.getHead().next);
        return value;
    }

    public void print() {
        StringBuilder str = new StringBuilder("Fila | Atendimento <---[");
        Node aux = this.getHead();
        while (aux.next != null) {
            str.append(aux.value).append(", ");
            aux = aux.next;
        }
        str.append(aux.value).append("] <---Fim da fila");
        System.out.println(str);
    }
}
