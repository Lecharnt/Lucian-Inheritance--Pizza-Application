public class DeliveryPizza extends pizza {

    private double delivfee;
    private String delivAdr;

    public DeliveryPizza(Topping firstTopping, double delivfee, String delivAdr) {
        super(firstTopping);
        this.delivfee = delivfee;
        this.delivAdr = delivAdr;
        double total = getAllPrice();
    }
        @Override
        public double getAllPrice() {
            double totalPrice = super.getAllPrice();
            if (totalPrice > 18) {
                return totalPrice + 3;
            } else {
                return totalPrice + 5;
            }
        }

}
