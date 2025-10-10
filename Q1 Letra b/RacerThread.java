//basicamente essa parte do codigo é a extensão da thread sendo o segundo metodo de criação de threads
public class RacerThread extends Thread {
    private String racer;

    // novamente construtor recebe o identificador 'i'
    public RacerThread(int i) {
        this.racer = String.valueOf(i);

        this.setName("Racer" + this.racer); 
    }

    @Override
    public void run() {
        // while(true) para rodar indefinidamente
        while(true) {
            System.out.println(this.getName() + " – imprimindo");
        }
    }
}

// Exemplo de Instanciação (usando a classe Race):
// RacerThread racer2 = new RacerThread(2);
// racer2.start(); // Inicia a execução [5]