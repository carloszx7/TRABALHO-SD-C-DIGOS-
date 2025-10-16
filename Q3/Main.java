import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Deposito deposito = new Deposito();

        //Produtor
        Produtor p = new Produtor(deposito, 50); //produz a cada 50ms
        Thread produtorThread = new Thread(p);

        //Consumidores
        Consumidor c1 = new Consumidor(deposito, 150); //consome a cada 150ms
        Consumidor c2 = new Consumidor(deposito, 100); //consome a cada 100ms
        Consumidor c3 = new Consumidor(deposito, 150); //consome a cada 150ms
        Consumidor c4 = new Consumidor(deposito, 100); //consome a cada 100ms
        Consumidor c5 = new Consumidor(deposito, 150); //consome a cada 150ms

        List<Thread> allThreads = new ArrayList<>();
        allThreads.add(produtorThread);
        allThreads.add(new Thread(c1));
        allThreads.add(new Thread(c2));
        allThreads.add(new Thread(c3));
        allThreads.add(new Thread(c4));
        allThreads.add(new Thread(c5));

        //inicia todas as threads
        for (Thread thread : allThreads) {
            thread.start();
        }

        //espera que todas as threads terminem
        for (Thread thread : allThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread principal interrompida.");
            }
        }

        System.out.println("\n --- Execução terminada --- ");
        System.out.println( "\n Itens finais no depósito: " + deposito.getNumItens()+ "\n");
    }
}