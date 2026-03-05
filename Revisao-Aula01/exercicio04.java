import java.util.Random;

public class exercicio04 {
    public static void main(String[] args) {
        int arrayAleatorio[] = new int[10];
        int somaImpares = 0;
        Random random = new Random();
        for (int i=0; i<10; i++) {
            arrayAleatorio[i] = random.nextInt(100);
        }

        System.out.println("Array aleatório: ");
        for (int i : arrayAleatorio) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        for (int i : arrayAleatorio) {
            if (i % 2 != 0) {
                somaImpares += i;
            }
        }
        System.out.printf("\nA soma dos números ímpares: %d\n\n", somaImpares);
    }
}
