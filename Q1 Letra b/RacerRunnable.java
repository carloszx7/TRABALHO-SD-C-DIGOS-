//basicamente essa parte do codigo é a implementação da interface runnable sendo o primeiro metodo de criação de threads
public class RacerRunnable implements Runnable {
    private String racer;

    // aqui o construtor recebe o identificador 'i':
    public RacerRunnable(int i) {
        this.racer = String.valueOf(i);
    }

    public void run() {
        while(true) {
            System.out.println("Racer" + racer + " – imprimindo");
            //resultado da execução
        }
    }
}
