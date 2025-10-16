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
                //tenta retirar um item, espera se o depósito estiver vazio
                synchronized (deposito) {
                    while (!deposito.retirar()) { //tenta retirar. Se não conseguir, espera.
                        System.out.println("\nConsumidor  aguardando itens no depósito...\n");
                        deposito.wait(); //espera até que um item seja colocado
                    }
                }
                caixasConsumidas++;
                Thread.sleep(tempoConsumo); //simula o tempo de consumo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumidor interrompido.");
                return;
            }
        }
        System.out.println("\nConsumidor terminou de consumir " + CAIXAS_A_CONSUMIR + " caixas.\n");
    }

}
