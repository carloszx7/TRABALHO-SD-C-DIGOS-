//basicamente essa parte do codigo é a extensão da thread sendo o segundo metodo de criação de threads
public class RacerThread extends Thread {
    private String racer;

    public RacerThread(int i) {
        this.racer = String.valueOf(i);

        this.setName("Racer" + this.racer); 
    }

    @Override
    public void run() {
        
        while(true) {
            System.out.println(this.getName() + " – imprimindo");
        }
    }
}
