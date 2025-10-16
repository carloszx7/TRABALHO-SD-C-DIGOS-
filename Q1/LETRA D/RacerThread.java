public class RacerThread extends Thread {
   private String racer;

       public RacerThread(int i) {
        this.racer = String.valueOf(i);
    }

    @Override
    public void run() {
        while (true) { 
            System.out.println("Racer " + racer + " - imprimindo (Thread)"); 
              try {
                Thread.sleep(100); //implementação do sleep
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Racer " + racer + " (Thread) foi interrompido.");
                return; 
            }
        }
    }
}