//basicamente essa parte do codigo tem a finalidade de iniciar/executar o sistema instanciando as outras classes
public class Race {
    public static void main(String[] args) {
        //criação  da interface (Runnable):
        Runnable racerRunnable = new RacerRunnable(i);
        //criação o "objeto" Thread: 
        Thread thread1 = new Thread(racerRunnable);
        thread1.start();
        //criação da Thread e execução:
        RacerThread racerThread = new RacerThread(i);
        racerThread.start();
    }
}


