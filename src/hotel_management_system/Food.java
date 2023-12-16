package hotel_management_system;

public class Food {
    private String foodName;
    private String foodDesc;
    private int price;

    public Food(String foodName, String foodDesc, int price) {
        this.foodName = foodName;
        this.foodDesc = foodDesc;
        this.price = price;
    }

    public void setFood(String foodName, String foodDesc, int price) {
        this.foodName = foodName;
        this.foodDesc = foodDesc;
        this.price = price;
    }

    public String getFood() {
        return "Food Name: " + foodName + ", Description: " + foodDesc + ", Price: " + price;
    }
}
