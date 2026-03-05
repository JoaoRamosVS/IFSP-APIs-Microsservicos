import java.util.Scanner;

public class exercicio06 {
    public static class Circulo {
        private double raio;

        public Circulo() {}

        public double getRaio() {
            return this.raio;
        }

        public void setRaio(double raio) {
            if(raio <= 0) {
                throw new IllegalArgumentException("O valor do raio não pode 0 ou negativo.");
            }
            this.raio = raio;
        }

        public double calcularArea() {
            return this.raio * 3.14;
        }
    }

    public static void main(String[] args) {
        Circulo circulo = new Circulo();
        Scanner sc = new Scanner(System.in);  
        
        System.out.print("Insira o raio do círculo: ");
        
        try {
            circulo.setRaio(sc.nextDouble());
            System.out.println("A área do círculo é: " + circulo.calcularArea());
            System.out.println("\n");
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("\n");
            sc.close();
        }

    }
}
