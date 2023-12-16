package Server;

public interface KitchenInterface {
    void setFood(String foodName, String foodDesc, int price);
    Food getFood(String foodName, String foodDesc, int price);
    void makeOrder(String foodName, int quantity, Guest guest);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyGuests(String notification);
}
