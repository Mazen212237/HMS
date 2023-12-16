package hotel_management_system;
import java.util.ArrayList;
import java.util.List;

public class Kitchen implements KitchenInterface {
    private List<Food> menu;
    private Chef chef;
    private List<Observer> observers;

    public Kitchen() {
        this.menu = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.chef = new Chef();
    }

    @Override
    public void setFood(String foodName, String foodDesc, int price) {
        Food newFood = new Food(foodName, foodDesc, price);
        menu.add(newFood);
        notifyGuests("New food added to the menu: " + newFood.getFood());
    }

    @Override
    public Food getFood(String foodName, String foodDesc, int price) {
        for (Food food : menu) {
            String foodString = food.getFood();
            String expectedFoodString = "Food Name: " + foodName + ", Description: " + foodDesc + ", Price: " + price;
    
            if (foodString.equals(expectedFoodString)) {
                return food;
            }
        }
        return null;
    }
    
    @Override
    public void makeOrder(String foodName, int quantity, Guest guest) {
        notifyGuests("New order: " + quantity + " x " + foodName + " for guest " + guest.getGuestID());
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyGuests(String notification) {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }
}
