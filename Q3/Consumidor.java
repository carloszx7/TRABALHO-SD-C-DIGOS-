public class Consumidor implements Runnable {
    private Deposito deposito;
    private int tempoConsumo; //sleep contando o tempo entre consumos
    private static final int CAIXAS_A_CONSUMIR = 20; //cada consumidor consome no total  20 caixas
    private int caixasConsumidas = 0;

    public Consumidor(Deposito deposito, int tempoConsumo) {
        this.deposito = deposito;
        this.tempoConsumo = tempoConsumo;
    }

    @Override
    public void run() {
        while (caixasConsumidas < CAIXAS_A_CONSUMIR) {
            try {
                if (deposito.retirar()) { //tenta retirar
                    caixasConsumidas++;
                    Thread.sleep(tempoConsumo); //simula o tempo de consumo
                } else {
                    System.out.println("\n Consumidor aguardando itens no depósito (tentando novamente em 200ms)... \n");
                    Thread.sleep(200); //espera 200ms antes de tentar de novo
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumidor interrompido.");
                return;
            }
        }
        System.out.println("\n --- Consumidor terminou de consumir " + CAIXAS_A_CONSUMIR + " caixas. --- \n");
    }

}
