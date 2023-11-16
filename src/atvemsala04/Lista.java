package atvemsala04;

class No {

    int valor;
    char cor;
    No prox = null;

    public No(int valor, char cor) {
        this.valor = valor;
        this.cor = cor;
    }
}

public class Lista {
    No primeiro = null;
    No ultimo = null;

    public Lista() {

    }


    void inserirNoFinal(No novo) {
        if (primeiro == null) {
            primeiro = novo;
        } else {
            ultimo.prox = novo;
        }
        ultimo = novo;
    }

    void inserirPrioridade(No novo) {
        No aux = primeiro;
        if (aux.cor == 'V') {
            novo.prox = aux;
            primeiro = novo;
            return;
        }
        while (aux.prox.cor != 'V') {
            aux = aux.prox;
        }
        novo.prox = aux.prox;
        aux.prox = novo;
    }

    void inserir(No novo) {
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            if (novo.cor == 'V') {
                inserirNoFinal(novo);
            } else {
                inserirPrioridade(novo);
            }
        }
    }

    void printList() {
        No aux = primeiro;
        while (aux != null) {
            System.out.println(aux.valor);
            aux = aux.prox;
        }
    }

    public static void main(String[] args) {
        Lista pacientes = new Lista();
        pacientes.inserir(new No(10,'V'));
        pacientes.inserir(new No(11,'V'));
        pacientes.inserir(new No(5,'A'));
        pacientes.inserir(new No(12,'V'));
        pacientes.inserir(new No(6,'A'));
        pacientes.printList();
    }
}
