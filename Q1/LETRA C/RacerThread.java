public class RacerThread extends Thread {
    private String racer;

       public RacerThread(int i) {
        this.racer = String.valueOf(i);
    }

    @Override
    public void run() {
        while (true) { 
            System.out.println("Racer " + racer + " - imprimindo (Thread)"); 
            
        }
    }
}