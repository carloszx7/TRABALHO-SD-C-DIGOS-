public class Produtor implements Runnable {
    private Deposito deposito;
    private int tempoProducao; //sleep entre produções
    private static final int MAX_CAIXAS = 100; //produtor produz no total 100 caixas
    private int caixasProduzidas = 0;

    public Produtor(Deposito deposito, int tempoProducao) {
        this.deposito = deposito;
        this.tempoProducao = tempoProducao;
    }

    @Override
    public void run() {
        while (caixasProduzidas < MAX_CAIXAS) {
            try {
                //tenta colocar um item, espera se o depósito estiver cheio
                synchronized (deposito) {
                    while (!deposito.colocar()) { //tenta colocar. Se não conseguir, espera.
                        System.out.println("Produtor aguardando espaço no depósito...");
                        deposito.wait(); //espera até que um item seja retirado
                    }
                }
                caixasProduzidas++;
                Thread.sleep(tempoProducao); //simula o tempo de produção
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Produtor interrompido.");
                return;
            }
        }
        System.out.println("\n --- Produtor terminou de produzir  " + MAX_CAIXAS + " caixas. --- \n");
    }
}