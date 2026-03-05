import java.util.Random;
import java.util.Scanner;

public class exercicio03 {
    
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        Integer numeroAleatorio = random.nextInt(100);
        Integer palpite = 0;
        Integer tentativas = 0;

        System.out.println("Adivinhe o número aleatório entre 1 e 100!");

        while (palpite != numeroAleatorio) {
            System.out.println("Digite seu palpite: ");
            palpite = sc.nextInt();
            tentativas++;

            if (palpite > numeroAleatorio) {
                System.out.println("Muito alto!");
            } else if (palpite < numeroAleatorio) {
                System.out.println("Muito baixo!");
            } else {
                System.out.println("Parabéns! Você acertou!");
            }
        }

        System.out.println("Número de tentativas: " + tentativas);
        sc.close();
    }
}
