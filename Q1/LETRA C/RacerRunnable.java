public class RacerRunnable implements Runnable {
     private String racer;

       public RacerRunnable(int i) {
        this.racer = String.valueOf(i);
    }

    @Override
    public void run() {
        while (true) { 
            System.out.println("Racer " + racer + " - imprimindo (Runnable)"); 
        
            
        }
    }
}
