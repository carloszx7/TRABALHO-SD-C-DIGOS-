public class Main {
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

        Thread consThread1 = new Thread(c1);
        Thread consThread2 = new Thread(c2);
        Thread consThread3 = new Thread(c3);
        Thread consThread4 = new Thread(c4);
        Thread consThread5 = new Thread(c5);

        //iniciar o produtor
        produtorThread.start();

        //iniciar os consumidores
        consThread1.start();
        consThread2.start();
        consThread3.start();
        consThread4.start();
        consThread5.start();

        //esperar que as threads terminem (para que a main não encerre antes)
        try {
            produtorThread.join();
            consThread1.join();
            consThread2.join();
            consThread3.join();
            consThread4.join();
            consThread5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread principal interrompida.");
        }

        System.out.println("\n --- Execução Terminada ---");
        System.out.println("\n Itens finais no depósito: " + deposito.getNumItens() + "\n");
    }
}