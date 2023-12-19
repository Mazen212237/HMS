package Server;

public class Chef implements Observer {
    @Override
    public void update(String notification) {
        System.out.println("Chef received update: " + notification);
    }

    public void prepareFood(String foodName,String foodDesc, int price, int quantity, Guest guest) {
        //
        Food foodToPrepare = new Food(foodName,foodDesc,price);

        if (foodToPrepare != null) {
            System.out.println("Chef is preparing " + quantity + "x " + foodName + foodDesc +
                    " for " + guest.getName());
        } 
    }
}
