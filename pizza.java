import java.util.ArrayList;

public class pizza {
    private ArrayList<Topping> toppings;
    public pizza(Topping firstTopping) {
        toppings = new ArrayList<>();
        toppings.add(firstTopping);
    }
    public ArrayList<Topping> getArrayList() {
        return toppings;
    }
    public int getToppingsLength() {
        return toppings.size();
    }
    public void addTopping(Topping firstTopping) {
        if(toppings.size() < 10) {
            toppings.add(firstTopping);
        }
        else{
            System.out.println("Maximum number of toppings reached");
        }
    }
    public double getAllPrice(){
        double totalPrice = 14;
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }
        return totalPrice;
    }
}
