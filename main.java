package listaviii;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

class Cliente {
    public String nome;
    public int tempoDeEspera;
}

class Funcionario {
    public String nome;

    public void atenderCliente(Cliente cliente) throws InterruptedException {
        System.out.println(nome + " está atendendo o cliente " + cliente.nome + " por " + cliente.tempoDeEspera + " segundos.");
        Thread.sleep(cliente.tempoDeEspera * 1000);
        System.out.println(nome + " atendeu o cliente " + cliente.nome + " em " + cliente.tempoDeEspera + " segundos.");
    }
}

public class main {
	
	public static void main(String[] args) throws InterruptedException {
        Queue<Cliente> fila = new LinkedList<>();
        List<Funcionario> funcionarios = new LinkedList<>();
        funcionarios.add(new Funcionario() {{
            nome = "Funcionário 1";
        }});
        funcionarios.add(new Funcionario() {{
            nome = "Funcionário 2";
        }});

        Random random = new Random();

        // Simulando a chegada de clientes à fila
        for (int i = 1; i <= 5; i++) {
            Cliente cliente = new Cliente();
            cliente.nome = "Cliente " + i;
            cliente.tempoDeEspera = random.nextInt(5) + 1; // Tempo de espera aleatório de 1 a 5 segundos
            fila.add(cliente);
            System.out.println("Novo cliente na fila: " + cliente.nome + " (Tempo de espera: " + cliente.tempoDeEspera + " segundos)");
        }

        // Atendimento dos clientes pelos funcionários
        while (!fila.isEmpty()) {
            for (Funcionario funcionario : funcionarios) {
                if (fila.isEmpty())
                    break;

                Cliente cliente = fila.poll();
                funcionario.atenderCliente(cliente);
            }
        }

        System.out.println("Todos os clientes foram atendidos.");
    }

}
