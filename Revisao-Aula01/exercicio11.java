import java.util.LinkedList;

public class exercicio11 {
    public static void main(String[] args) {
        LinkedList<String> listaAtendimento = new LinkedList<>();
        listaAtendimento.add("João");
        listaAtendimento.add("Ana");
        listaAtendimento.add("Guilherme");
        listaAtendimento.add("Eduardo");
        listaAtendimento.add("Giovani");
        System.out.println("--- Lista de atendimento ---\n");
        for (int i = 0; i < listaAtendimento.size(); i++) {
            System.out.print(listaAtendimento.get(i) + " ");
        }

        System.out.println("\n\nAtendendo os 2 primeiros da fila:");
        for (int i = 0; i < 2; i++) {
            System.out.printf("\nAtendendo %d da fila: %s",i+1,listaAtendimento.get(0));
            listaAtendimento.pop();
        }

        System.out.println("\n\n--- Lista de atendimento atualizada ---\n");
        for (int i = 0; i < listaAtendimento.size(); i++) {
            System.out.print(listaAtendimento.get(i) + " ");
        }

        System.out.println("\n\nAdicionando clientes com prioridade no início da fila.");
        listaAtendimento.addFirst("Diego");
        listaAtendimento.addFirst("Giulia");

        System.out.println("\n\n--- Lista de atendimento atualizada ---\n");
        for (int i = 0; i < listaAtendimento.size(); i++) {
            System.out.print(listaAtendimento.get(i) + " ");
        }
        System.out.println("\n");
    }
    
}
