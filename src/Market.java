import java.util.ArrayList;

public class Market implements MarketBehaviour, QueueBehaviour {

    private ArrayList<Human> actorsQueue;
    
    public Market (){
        this.actorsQueue = new ArrayList<>();
    }


    public void acceptToMarket(Human actor) {// входит в магазин
        System.out.printf("%s вошёл в магазин.\n", actor.getName());
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(Human actor) {// вход в очередь
        this.actorsQueue.add(actor);
        System.out.printf("%s встал в очередь за заказом.\n", actor.getName());
    }

    @Override
    public void releaseFromMarket(Human actor) {// выходит из магазина
        actorsQueue.remove(actor);
        System.out.printf("%s вышёл из магазина.\n", actor.getName());
    }


    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
        System.out.printf("Конец очереди=====.\n");
    }

    @Override
    public void giveOrders() {
        for (Human actor : actorsQueue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ ");
            }
        }
    }

    @Override
    public void takeOrders() {
        for (Human actor : actorsQueue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал заказ ");
            }
        }
    }

    // выход из очереди
    @Override
    public void releaseFromQueue() {
        boolean check = true;
        do {
            Human actor = actorsQueue.get(0);
            if (actor.isTakeOrder()) {
                System.out.println(actor.getName() + " ушел из очереди ");
                releaseFromMarket(actor);
                if (actorsQueue.size() < 1)
                    check = false;
                else
                    actor = actorsQueue.get(0);
            } 
        } while (check);
    }
}