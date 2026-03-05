public class exercicio08 {

    public static void main(String[] args) {
        ContaBancaria contaJoao = new ContaBancaria("João");
        contaJoao.depositar(100);
        System.out.println("Titular da conta: " + contaJoao.getTitular());
        System.out.println("\n");
        System.out.println("Saldo inicial: " + contaJoao.getSaldo());
        System.out.println("\n");

        double valorSaque = 120;
        // double valorSaque = 50;
        boolean conseguiuSacar = contaJoao.sacar(valorSaque);

        if(conseguiuSacar) {
            System.out.printf("O saque de %.2f foi realizado com sucesso.\n\n", valorSaque);
            System.out.println("Saldo final: " + contaJoao.getSaldo());
            System.out.println("\n");
        }
        else {
            System.out.printf("\nNão foi possível realizar o saque de %.2f.\n\n", valorSaque);
        }
    }
    
    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }

    public static class ContaBancaria {
        private String titular;
        private double saldo = 0;

        public ContaBancaria(String titular) {
            this.titular = titular;
        }

        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }

        public void depositar(double valor) {
            this.saldo += valor;
        }

        public boolean sacar(double valor) {
            try {

                if(valor > this.saldo) {
                    throw new SaldoInsuficienteException("Saldo insuficiente para tal transação.\n");
                }
                
                this.saldo -= valor;
                return true;
                
            } catch (SaldoInsuficienteException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
    
}
