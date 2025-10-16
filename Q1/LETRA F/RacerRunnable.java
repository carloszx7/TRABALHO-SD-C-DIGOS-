public class RacerRunnable implements Runnable {
     private String racer;
    private static final int MAX_PRINTS = 1000;
    private int printCount = 0;

       public RacerRunnable(int i) {
        this.racer = String.valueOf(i);
    }

    @Override
    public void run() {
        while (printCount < MAX_PRINTS) {
            System.out.println("Racer " + racer + " - imprimindo (" + (printCount + 1) + "/" + MAX_PRINTS + ")");
            printCount++;
            try {
                Thread.sleep(10); // Um pequeno sleep para visualizar melhor
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Racer " + racer + " foi interrompido.");
                return;
            }
        }
        System.out.println("\n --- Racer " + racer + " terminou sua corrida.--- \n");
    }
}