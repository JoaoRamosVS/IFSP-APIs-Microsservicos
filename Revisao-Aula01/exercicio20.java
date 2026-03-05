
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class exercicio20 {
    public static void main(String[] args) {
        HashMap<String, String> agendaContatos = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        Integer opcao = 1;

        do {
            System.out.println("---- AGENDA DE CONTATOS ----");
            System.out.println("- OPÇÕES:");
            System.out.println("- 1-ADICIONAR NOVO CONTATO");
            System.out.println("- 2-BUSCAR CONTATO POR NOME");
            System.out.println("- 3-LISTAR TODOS OS CONTATOS");
            System.out.println("- 0-SAIR");
            System.out.print("- ->: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\n\n- Digite o nome do contato: ");
                    String novoNome = sc.nextLine();
                    System.out.print("\n- Digite o número do contato: ");
                    String novoTelefone = sc.nextLine();
                    agendaContatos.put(novoNome, novoTelefone);
                    break;

                case 2:
                    System.out.print("\n\n- Digite o nome a ser buscado: ");
                    String buscaNome = sc.nextLine();
                    String resultadoBusca = agendaContatos.getOrDefault(buscaNome, null);
                    if (resultadoBusca != null) {
                        System.out.println("Número de telefone do nome buscado: " + resultadoBusca);
                    }
                    else {
                        System.out.println("Nenhum telefone foi encontrado para este nome.");
                    }
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("\n---- TODOS OS CONTATOS ----");
                    Set<Entry<String,String>> keys = agendaContatos.entrySet();
                    for (Entry<String,String> entry : keys) {
                        System.out.println("- NOME: " + entry.getKey() + " | TELEFONE: " + entry.getValue());
                    }
                    System.out.println("\n");
                    break;
            
                default:
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}
