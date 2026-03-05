import java.util.Scanner;

public class exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a primeira nota do aluno: ");
        double nota1 = sc.nextInt();
        System.out.println("Digite a segunda nota do aluno: ");
        double nota2 = sc.nextInt();
        System.out.println("Digite a terceira nota do aluno: ");
        double nota3 = sc.nextInt();
        
        double media = (nota1 + nota2 + nota3) / 3.0;
        System.out.printf("A média do aluno é: %.2f%n", media);

        if(media >= 7.0) {
            System.out.println("O aluno foi aprovado!");
        } else if (media >= 5.0) {
            System.out.println("O aluno está de recuperação!");
        } else {
            System.out.println("O aluno foi reprovado!");
        }

        sc.close();
    }
}