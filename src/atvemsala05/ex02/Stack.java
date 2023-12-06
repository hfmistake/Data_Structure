package atvemsala05.ex02;



public class Stack {
    Node top;

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public char top(){
        return top.value;
    }

    public char push(char value) {
        Node newNode = new Node(value);
        newNode.next = this.getTop();
        this.top = newNode;
        return value;
    }

    public char pop(){
        char value = this.top.value;
        this.top = this.top.next;
        return value;
    }

    public void print(){
        System.out.println("-----PILHA-----");
        Node aux = this.top;
        while (aux != null) {
            System.out.println(aux.value);
            aux = aux.next;
        }
    }
}
