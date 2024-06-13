

public class App {
    public static void main(String[] args) throws Exception {

        Market myMarket = new Market();

        Human ivan = new Human("Иван Степанович");
        Human valia = new Human("Валя");
        Human olga = new Human("Ольга");
        Human yra = new Human("Юрий");


        myMarket.acceptToMarket(yra);
        
        myMarket.update();

        myMarket.acceptToMarket(olga);
        myMarket.acceptToMarket(valia);
        myMarket.acceptToMarket(ivan);


        myMarket.update();
        
    }
}
