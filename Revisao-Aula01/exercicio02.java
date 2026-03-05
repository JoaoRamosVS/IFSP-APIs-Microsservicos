import java.util.Scanner;

public class exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        Integer num = sc.nextInt();
        
        System.out.printf("\nTabuada do número %d:\n", num);
        for(int i=1; i<=10; i++) {
            System.out.printf("\n%d x %d = %d", num, i, num*i);
        }
        System.out.println("\n");
        sc.close();
    }
}
