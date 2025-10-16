
public class Race {
    public static void main(String[] args) {
        System.out.println("\n--- Início da Corrida (Runnable) ---\n");
        for (int i = 1; i <= 5; i++) { //criando 5 racers com Runnable
            RacerRunnable racer = new RacerRunnable(i);
            Thread thread = new Thread(racer);
            thread.start();
             try {
                Thread.sleep(100); //implementação do sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n--- Início da Corrida (Extensão de Thread) ---\n");
        for (int i = 6; i <= 10; i++) { //criando 5 racers com Extensão de Thread
            RacerThread racerThread = new RacerThread(i);
            racerThread.start();
             try {
                Thread.sleep(100); //implementação do sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

}
