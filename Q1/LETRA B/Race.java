//basicamente essa parte do codigo tem a finalidade de iniciar/executar o sistema instanciando as outras classes
public class Race {
    //essa primeira parte do codigo faz rodar o  race runnable("coloquei esse nome para uma melhor organização"), ou seja, o primeiro metodo de criação e instanciação:
    public static void main(String[] args) {

        //Criação  da interface (Runnable):
        Runnable racerRunnable = new RacerRunnable(1);
        //Criação o "objeto" Thread: 
        Thread thread1 = new Thread(racerRunnable);
        thread1.start();


        //essa segunda parte do codigo faz rodar o  racer thread java, ou seja, o segundo metodo de criação e instanciação:
        //Criação da Thread e execução:
        RacerThread racerThread = new RacerThread(2);
        racerThread.start();

    }
}

