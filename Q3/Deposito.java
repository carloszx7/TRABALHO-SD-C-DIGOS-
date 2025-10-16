public class Deposito {
    private int items = 0;
    private final int capacidade = 100;

    public synchronized int getNumItens() {
        return items;
    }

    public synchronized boolean retirar() {
        if (items > 0) { //somente retira se houver itens
            items--;
            System.out.println("Retirou um item. Itens no depósito: " + items);
            notifyAll(); //notifica produtores que há espaço
            return true;
        }
        return false;
    }

    public synchronized boolean colocar() {
        if (items < capacidade) { //somente coloca se houver espaço
            items++;
            System.out.println("Colocou um item. Itens no depósito: " + items);
            notifyAll(); //notifica consumidores que há itens
            return true;
        }
        return false;
    }

}
