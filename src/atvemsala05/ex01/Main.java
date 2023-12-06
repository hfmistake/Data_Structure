package atvemsala05.ex01;

public class Main {
    public static void main(String[] args) {
        QueueManager queue = new QueueManager();
        Pessoa pessoa1 = new Pessoa("Claudio",12,false);
        Pessoa pessoa2 = new Pessoa("José",15,false);
        Pessoa pessoa3 = new Pessoa("Alberto",61,true);
        queue.insert(new Node(pessoa1));
        queue.insert(new Node(pessoa2));
        queue.insert(new Node(pessoa3));
        queue.insert(new Node(new Pessoa("André",12,true)));

        queue.normalQueue.printQueue();
        queue.pneQueue.printQueue();
        queue.serve();
        queue.serve();
        queue.serve();
        queue.serve();
        queue.serve();
    }
}
