public class Produtor implements Runnable {
    private Deposito deposito;
    private int tempoProducao;
    private static final int MAX_CAIXAS = 100;
    private int caixasProduzidas = 0;

    public Produtor(Deposito deposito, int tempoProducao) {
        this.deposito = deposito;
        this.tempoProducao = tempoProducao;
    }

    @Override
    public void run() {
        while (caixasProduzidas < MAX_CAIXAS) {
            try {
                if (deposito.colocar()) { //tenta colocar
                    caixasProduzidas++;
                    Thread.sleep(tempoProducao); //simula o tempo de produção
                } else {
                    System.out.println("\n Produtor aguardando espaço no depósito (tentando novamente em 200ms)...\n");
                    Thread.sleep(200); //espera 200ms antes de tentar de novo se o depósito estiver cheio
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Produtor interrompido.");
                return;
            }
        }
        System.out.println("\n --- Produtor terminou de produzir " + MAX_CAIXAS + " caixas. --- \n");
    }
}