package atvemsala03;

class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class LinkedListManager {
    private Node head;
    private Node tail;
    private int size;

    public LinkedListManager() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void printList(){
        Node aux = head;
        while(aux != null){
            System.out.println(aux.getValue());
            aux = aux.getNext();
        }
    }

    public void addByPosition(int value, int position) {
        if (position < 0 || position > this.size) {
            System.out.println("Posição inválida!");
            return;
        }
        Node novo = new Node(value);
        if (this.size == 0) {
            head = novo;
            tail = novo;
        } else if (position == 0) {
            novo.setNext(head);
            head = novo;
        } else if(position == this.size) {
            tail.setNext(novo);
            tail = novo;
        } else {
            Node previous = head;
            for (int i = 0; i < position - 1; i++) {
                previous = previous.getNext();
            }
            novo.setNext(previous.getNext());
            previous.setNext(novo);
        }
        this.size++;
    }

    public void removeByPosition(int position) {
        if (this.size == 0) {
            System.out.println("Impossivel remover algum elemento pois a lista está vazia.");
            return;
        }
        if (position < 0 || position >= this.size) {
            System.out.println("Posição inválida.");
            return;
        }
        if (this.size == 1) {
            head = null;
            tail = null;
            this.size--;
            return;
        }
        if (position == 0) {
            head = head.getNext();

        } else {
            Node previous = head;
            for (int i = 0; i < position - 1; i++) {
                previous = previous.getNext();
            }
            previous.setNext(previous.getNext().getNext());
            if (position == this.size - 1) {
                tail = previous;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListManager list = new LinkedListManager();
        list.addByPosition(1,0);
        list.removeByPosition(0);
        list.printList();
        System.out.println(list.tail.getValue());
    }
}