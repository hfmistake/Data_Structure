package atvemsala05.ex02;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new Queue();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        queue.enqueue(stack.top());
        queue.enqueue(stack.top());
        queue.enqueue('D');
        stack.push(queue.dequeue());
        queue.enqueue(queue.dequeue());
        queue.enqueue(stack.pop());
        stack.push('E');
        queue.enqueue('E');
        stack.pop();

        queue.print();
        stack.print();
    }
}
