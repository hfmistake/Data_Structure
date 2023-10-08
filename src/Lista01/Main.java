package Lista01;


class Aluno {

    String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }


}

class Vetor {

    Aluno[] alunos = new Aluno[2];
    int qtdAlunosVetor = 0;

    public void imprimir() {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {
                System.out.println("Pos: " + i + " Nome: " + alunos[i].nome);
            }
        }
    }

    public void inserirFinalVetor(Aluno a) {
        if (qtdAlunosVetor < 100) {
            alunos[qtdAlunosVetor] = a;
            qtdAlunosVetor++;
        } else {
            System.out.println("Vetor cheio!");
        }
    }

    public void tamanhoLista() {
        System.out.println("Tamanho: " + qtdAlunosVetor);
    }

    public boolean verificarAlunoLista(String nome) {
        for (int i = 0; i < qtdAlunosVetor; i++) {
            if (alunos[i].nome.equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public String buscarAlunoPorPosicao(int pos) {
        if (pos >= 0 && pos < qtdAlunosVetor) {
            return "Nome: " + alunos[pos].nome;
        } else {
            return "Posição inválida!";
        }
    }

    public void inserirAlunoPorPosicao(int pos, Aluno a) {
        if (pos == qtdAlunosVetor) {
            alunos[pos] = a;
            qtdAlunosVetor++;
            return;
        }
        if (pos >= 0 && pos < qtdAlunosVetor) {
            for (int i = qtdAlunosVetor; i > pos; i--) {
                alunos[i] = alunos[i - 1];
            }
            alunos[pos] = a;
            qtdAlunosVetor++;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public void removerAlunoPorPosicao(int pos) {
        if (pos >= 0 && pos < qtdAlunosVetor) {
            if (pos == qtdAlunosVetor - 1) {
                alunos[pos] = null;
            } else {
                for (int i = pos; i < qtdAlunosVetor - 1; i++) {
                    alunos[i] = alunos[i + 1];
                }
            }
            qtdAlunosVetor--;
        } else {
            System.out.println("Posição inválida!");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Vetor v = new Vetor();

        Aluno a1 = new Aluno("Davi");
        Aluno a2 = new Aluno("Daniel");

        v.inserirFinalVetor(a1);
        v.inserirFinalVetor(a2);
        v.imprimir();

        if (v.verificarAlunoLista("Ricardo")) {
            System.out.println("Aluno existe no vetor!");
        } else {
            System.out.println("Aluno não existe no vetor!");
        }

        System.out.println(v.buscarAlunoPorPosicao(1));
        v.removerAlunoPorPosicao(1);
        v.imprimir();
        v.tamanhoLista();
        v.inserirAlunoPorPosicao(1, new Aluno("Ricardo"));
        v.imprimir();
        v.tamanhoLista();

    }
}
