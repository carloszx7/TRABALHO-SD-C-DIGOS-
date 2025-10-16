
public class Race {
    public static void main(String[] args) {
        System.out.println("\n--- Início da Corrida (com Prioridade) ---\n");

       
  //racers de prioridade MAXIMA
        for (int i = 1; i <= 5; i++) {
            RacerRunnable racer = new RacerRunnable(i);
             try {
                Thread.sleep(200); //implementação do sleep pra melhor vizualização
            }          catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
                System.out.println("Racer " + i + " (Thread) foi interrompido.");
                return;
            }
            Thread thread = new Thread(racer);
            thread.setPriority(Thread.MAX_PRIORITY); //prioridade MAXIMA
            thread.start();
            
        }


        //racers de prioridade MINIMA
        for (int i = 6; i <= 10; i++) {
            RacerThread racer = new RacerThread(i);
            try {
                Thread.sleep(200); //implementação do sleep pra melhor vizualização
            }          catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
                System.out.println("Racer " + i + " (Thread) foi interrompido.");
                return;
            }
            Thread thread = new Thread(racer);
            thread.setPriority(Thread.MIN_PRIORITY); //prioridade mínima
            thread.start();
        }
        
        
    }
   
    }

