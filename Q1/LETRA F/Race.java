import java.util.ArrayList;
import java.util.List;

public class Race{
    public static void main(String[] args) {
        List<Thread> oddRacers = new ArrayList<>();
        List<Thread> evenRacers = new ArrayList<>();

        System.out.println("\n--- Iniciando Racers Ímpares ---\n");
        for (int i = 1; i <= 9; i += 2) { //racers ímpares (1, 3, 5, 7, 9)
            RacerRunnable racer = new RacerRunnable(i);
            Thread thread = new Thread(racer);
            oddRacers.add(thread);
            thread.start();
        }

        //espera que todos os racers ímpares terminem
        for (Thread thread : oddRacers) {
            try {
                thread.join(); //espera esta thread terminar
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("A thread principal foi interrompida enquanto esperava pelos ímpares.");
            }
        }
        System.out.println("\n--- Racers Ímpares Terminados. Iniciando Racers Pares ---\n");

        for (int i = 2; i <= 10; i += 2) { //racers pares (2, 4, 6, 8, 10)
            RacerRunnable racer = new RacerRunnable(i);
            Thread thread = new Thread(racer);
            evenRacers.add(thread);
            thread.start();
        }

        System.out.println("\n--- Todos os Racers Terminados. Fim da Corrida! ---\n");
    }

}
