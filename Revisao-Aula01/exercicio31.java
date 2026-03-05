import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class exercicio31 {
    public static class AnalisadorDeClasse {
        public static void inspecionar(Object obj){
            System.out.println("Nome completo do objeto: " + obj);

            System.out.println();

            Class<? extends Object> objClass = obj.getClass();

            System.out.println("Classe: " + objClass);
            
            System.out.println();
            
            System.out.println("Atributos:");
            Field[] objFields = objClass.getDeclaredFields();
            for (Field field : objFields) {
                System.out.println(field);
            }

            System.out.println();

            System.out.println("Métodos:");
            Method[] objMethods = objClass.getDeclaredMethods();
            for (Method method : objMethods) {
                System.out.println(method);
            }
        }
    }

    public static class Produto {
        private int codigo;
        public String nome;
        protected double preco;

        public Produto(int codigo, String nome, double preco) {
            this.codigo = codigo;
            this.nome = nome;
            this.preco = preco;
        }

        private double calcularImposto() {
            return preco * 0.1;
        }
    }

    public static void main(String[] args) {
        Produto produto = new Produto(1243, "Teclado", 356);

        AnalisadorDeClasse.inspecionar(produto);
    }
}