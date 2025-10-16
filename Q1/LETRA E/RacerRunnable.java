public class RacerRunnable implements Runnable {
private String racer;

       public RacerRunnable(int i) {
        this.racer = String.valueOf(i);
    }

    @Override
    public void run() {
        while (true) { 
            System.out.println("Racer " + racer + " - imprimindo (PRIORIDADE MAXIMA)"); 
          try {
                Thread.sleep(200); //implementação do sleep pra melhor vizualização
            } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
                System.out.println("Racer " + racer + " (Thread) foi interrompido.");
                return;
            }
    }
    }
}