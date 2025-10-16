public class RacerRunnable implements Runnable {
private String racer;

       public RacerRunnable(int i) {
        this.racer = String.valueOf(i);
    }

    @Override
    public void run() {
        while (true) { 
            System.out.println("Racer " + racer + " - imprimindo (Runnable)"); 
          try {
                Thread.sleep(100); //implementação do sleep
            } catch (InterruptedException e) {
                // Se a thread for interrompida enquanto dorme, essa exceção é lançada.
                Thread.currentThread().interrupt();
                System.out.println("Racer " + racer + " (Runnable) foi interrompido.");
                return; // Sai do método run() e, consequentemente, encerra a thread
            }
            
        }
    }
}