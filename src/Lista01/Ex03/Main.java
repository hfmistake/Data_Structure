package Lista01.Ex03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Boleto {
    String nomeDespesa;
    double valorDespesa;
    Date prazoEncerramento;
    int situacao;
    Boleto next;

    public Boleto(String nomeDespesa, double valorDespesa, Date prazoEncerramento, int situacao) {
        this.nomeDespesa = nomeDespesa;
        this.valorDespesa = valorDespesa;
        this.prazoEncerramento = prazoEncerramento;
        this.situacao = situacao;
        this.next = null;
    }
}

class ListaDeBoletos {
    private Boleto head;

    public ListaDeBoletos() {
        head = null;
    }

    public void adicionarBoleto(String nomeDespesa, double valorDespesa, String dataPrazoEncerramento, int situacao) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date prazoEncerramento = sdf.parse(dataPrazoEncerramento);
        Boleto newBoleto = new Boleto(nomeDespesa, valorDespesa, prazoEncerramento, situacao);
        if (head != null) {
            newBoleto.next = head;
        }
        head = newBoleto;
    }

    public int despesasCadastradasAteData(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataLimite = sdf.parse(data);
        int contador = 0;
        Boleto current = head;
        while (current != null) {
            if (current.prazoEncerramento.before(dataLimite)) {
                contador++;
            }
            current = current.next;
        }
        return contador;
    }

    public int despesasPagasAteData(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataLimite = sdf.parse(data);
        int totalDespesasPagas = 0;
        Boleto current = head;
        while (current != null) {
            if (current.situacao == 0 && current.prazoEncerramento.before(dataLimite)) {
                totalDespesasPagas++;
            }
            current = current.next;
        }
        return totalDespesasPagas;
    }

    public int totalDespesasCadastradas() {
        int contador = 0;
        Boleto current = head;
        while (current != null) {
            contador++;
            current = current.next;
        }
        return contador;
    }

public Boleto despesaNaoPagaProximaData(String data) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date dataLimite = sdf.parse(data);
    Boleto despesaProxima = null;
    Boleto current = head;
    long menorDistancia = Long.MAX_VALUE;

    while (current != null) {
        if (current.situacao == 1) {
            long distancia = Math.abs(current.prazoEncerramento.getTime() - dataLimite.getTime());
            if (distancia < menorDistancia) {
                despesaProxima = current;
                menorDistancia = distancia;
            }
        }
        current = current.next;
    }
    return despesaProxima;
}



}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDeBoletos listaDeBoletos = new ListaDeBoletos();

        try {
            listaDeBoletos.adicionarBoleto("Aluguel", 1500, "10/10/2023", 1);
            listaDeBoletos.adicionarBoleto("Internet", 100, "15/10/2023", 1);
            listaDeBoletos.adicionarBoleto("Energia", 200, "20/10/2023", 0);

            System.out.println("Digite uma data (dd/MM/yyyy) para verificar despesas cadastradas até essa data:");
            String dataCadastradas = scanner.nextLine();
            int despesasCadastradas = listaDeBoletos.despesasCadastradasAteData(dataCadastradas);
            System.out.println("Despesas cadastradas até " + dataCadastradas + ": " + despesasCadastradas);


            System.out.println("Digite uma data (dd/MM/yyyy) para verificar despesas pagas até essa data:");
            String dataPagas = scanner.nextLine();
            int despesasPagas = listaDeBoletos.despesasPagasAteData(dataPagas);
            System.out.println("Total de despesas pagas até " + dataPagas + ": " + despesasPagas);


            int totalDespesas = listaDeBoletos.totalDespesasCadastradas();
            System.out.println("Total de despesas cadastradas: " + totalDespesas);


            System.out.println("Digite uma data (dd/MM/yyyy) para encontrar a despesa não paga mais próxima:");
            String dataProxima = scanner.nextLine();
            Boleto despesaProxima = listaDeBoletos.despesaNaoPagaProximaData(dataProxima);
            if (despesaProxima != null) {
                System.out.println("Despesa não paga mais próxima de " + dataProxima + ": " + despesaProxima.nomeDespesa);
            } else {
                System.out.println("Não há despesas não pagas próximas até " + dataProxima);
            }
        } catch (ParseException e) {
            System.out.println("Erro na conversão de data.");
        }

        scanner.close();
    }
}
