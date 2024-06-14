import java.util.ArrayDeque;
import java.util.Deque;

public class MarketQ implements MarketBehaviour, QueueBehaviour {

    private Deque<Human> q_actors;
    
    public MarketQ (){
        this.q_actors = new ArrayDeque<>();
    }


    // входит в магазин

    public void acceptToMarket(Human actor) {
        System.out.printf("%s вошёл в магазин.\n", actor.getName());
        takeInQueue(actor);
    }

    // вход в очередь

    @Override
    public void takeInQueue(Human actor) {
        this.q_actors.add(actor);
        takeOrders();
        System.out.printf("%s встал в очередь за заказом.\n", actor.getName());
    }

    //делаем заказ

    @Override
    public void takeOrders() {
        Human actor = q_actors.getLast();
        if (!actor.isMakeOrder()) {
            actor.setMakeOrder(true);
            System.out.println(actor.getName() + " сделал заказ ");
        }
    }

    // выдаем все заказы в очереди

    @Override
    public void update() {
        while (!q_actors.isEmpty()){
            giveOrders();
        }
        System.out.printf("======= Конец очереди =====.\n\n");
    }

    // выдаем заказ

    @Override
    public void giveOrders() {
        Human actor = q_actors.getFirst();
        if (actor.isMakeOrder()) {
            actor.setTakeOrder(true);
            System.out.println(actor.getName() + " получил свой заказ ");
        }
        releaseFromQueue();
    }

    // выходим из очереди

    @Override
    public void releaseFromQueue() {
        Human actor = q_actors.pollFirst();
        if (actor.isTakeOrder()) {
            System.out.println(actor.getName() + " ушел из очереди ");
            releaseFromMarket(actor);
        }
    }

    // выходим из магазина

    @Override
    public void releaseFromMarket(Human actor) {// выходит из магазина
        System.out.printf("%s вышёл из магазина.\n", actor.getName());
    }
}