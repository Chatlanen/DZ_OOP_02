

public interface QueueBehaviour {

    void takeInQueue(Human actor);

    // оформление заказа
    void takeOrders();

    // получение заказа
    void giveOrders();

    void releaseFromQueue();
}