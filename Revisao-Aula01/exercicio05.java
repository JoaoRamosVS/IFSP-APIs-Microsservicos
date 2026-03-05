public class exercicio05 {
 
    public static class Carro {
        
        public Carro(String marca, String modelo, int ano) {
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
        }
        
        private String marca;
        private String modelo;
        private int ano;

        public int getAno() {
            return this.ano;
        }

        public String getMarca() {
            return this.marca;
        }

        public String getModelo() {
            return this.modelo;
        }

        public void exibirInfo() {
            System.out.println("INFORMAÇÕES DO CARRO");
            System.out.println("-------------");
            System.out.println("MARCA: " + this.getMarca());
            System.out.println("MODELO: " + this.getModelo());
            System.out.println("Ano: " + this.getAno());
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Carro camaro = new Carro("Chevrolet", "Camaro", 2012);
        camaro.exibirInfo();
    }    
}
