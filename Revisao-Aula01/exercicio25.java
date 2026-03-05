import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class exercicio25 {
    public static void main(String[] args) {
        Deque<String> pilhaLivros = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do 1o livro: ");
        pilhaLivros.push(sc.nextLine());
        System.out.print("Digite o nome do 2o livro: ");
        pilhaLivros.push(sc.nextLine());
        System.out.print("Digite o nome do 3o livro: ");
        pilhaLivros.push(sc.nextLine());

        System.out.println("\nDesempilhando livro: " + pilhaLivros.pop());
        System.out.println("Primeiro livro da fila atualmente: " + pilhaLivros.peek());
        sc.close();
    }   
}
