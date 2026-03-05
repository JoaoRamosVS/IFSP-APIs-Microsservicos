public class exercicio07 {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 4);
        Moto moto = new Moto("Honda", "CB 500", 500);

        System.out.println(carro);
        System.out.println("\n");
        System.out.println(moto);
    }
    
    public static class Veiculo {
        private String marca;
        private String modelo;

        public Veiculo(String marca, String modelo) {
            this.marca = marca;
            this.modelo = modelo;
        }

        public String getMarca() {
            return this.marca;
        }
        
        public String getModelo() {
            return this.modelo;
        }
    }

    public static class Carro extends Veiculo {
        private Integer numeroDePortas;

        public Carro(String marca, String modelo, Integer numeroDePortas) {
            super(marca, modelo);
            this.numeroDePortas = numeroDePortas;
        }

        public Integer getNumeroDePortas() {
            return this.numeroDePortas;
        }

        @Override
        public String toString() {
            return "CARRO\n-------------\nMARCA: " 
            + getMarca()
            + "\nMODELO: "
            + getModelo()
            + "\nNÚMERO DE PORTAS: "
            + getNumeroDePortas();
        }
    }
    
    public static class Moto extends Veiculo {
        private Integer cilindradas;

        public Moto(String marca, String modelo, Integer cilindradas) {
            super(marca, modelo);
            this.cilindradas = cilindradas;
        }

        public Integer getCilindradas() {
            return this.cilindradas;
        }

        @Override
        public String toString() {
            return "MOTO\n-------------\nMARCA: " 
            + getMarca()
            + "\nMODELO: "
            + getModelo()
            + "\nCILINDRADAS: "
            + getCilindradas();
        }
    }
}
