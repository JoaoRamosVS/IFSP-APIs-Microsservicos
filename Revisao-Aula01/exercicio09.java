import java.util.ArrayList;
import java.util.Scanner;

public class exercicio09 {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<String>();
        Integer opcaoMenu = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("---- Lista de tarefas ----\n");
            System.out.println("1 - Adicionar uma tarefa\n");
            System.out.println("2 - Remover uma tarefa pelo índice\n");
            System.out.println("3 - Listar todas as tarefas\n");
            System.out.println("0 - Sair do programa\n");

            opcaoMenu = sc.nextInt();
            
            switch (opcaoMenu) {
                case 1:
                    System.out.print("\nDigite a descrição da tarefa: ");
                    sc.nextLine();
                    String novaTarefa = sc.nextLine();
                    System.out.println(novaTarefa);
                    tarefas.add(novaTarefa);
                    break;
                case 2:
                    System.out.print("\nDigite o índice da tarefa a ser deletada: ");                
                    int indiceTarefa = sc.nextInt();
                    try {
                        String tarefaRemovida = tarefas.remove(indiceTarefa);
                        System.out.println("\nA tarefa " + tarefaRemovida + " foi excluída da lista de tarefas.\n");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("\nEste índice não existe na lista atualmente.\n");
                    }
                    break;
                case 3:
                    System.out.println("\n---- INÍCIO DA LISTA ----");
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.printf("\nTarefa %d: %s\n",i+1,tarefas.get(i));
                    }
                    System.out.println("\n---- FIM DA LISTA ----");
                    break;
            
                default:
                    break;
            }
            System.out.println("\n");

        } while (opcaoMenu != 0);

        System.out.println("\n\nPrograma finalizado.");
        sc.close();
    }
}
