
public class Race {
    public static void main(String[] args) {
        System.out.println("--- Início da Corrida (Runnable) ---");
        for (int i = 1; i <= 5; i++) { // Criando 5 racers com Runnable
            RacerRunnable racer = new RacerRunnable(i);
            Thread thread = new Thread(racer);
            thread.start();
        }

        System.out.println("\n--- Início da Corrida (Extensão de Thread) ---");
        for (int i = 6; i <= 10; i++) { // Criando 5 racers com Extensão de Thread
            RacerThread racerThread = new RacerThread(i);
            racerThread.start();
        }
    }

}
