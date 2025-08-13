public class RestaurantTip {
    // Fields
    private double totalBill;
    private double tipAmount;
    private String customerGender;
    private String dayOfWeek;
    private String mealTime;
    private int partySize;

    // Default constructor
    public RestaurantTip() {
    }

    // Parameterized constructor
    public RestaurantTip(double totalBill, double tipAmount, String customerGender, 
                         String dayOfWeek, String mealTime, int partySize) {
        this.totalBill = totalBill;
        this.tipAmount = tipAmount;
        this.customerGender = customerGender;
        this.dayOfWeek = dayOfWeek;
        this.mealTime = mealTime;
        this.partySize = partySize;
    }

    // Getters
    public double getTotalBill() {
        return totalBill;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getMealTime() {
        return mealTime;
    }

    public int getPartySize() {
        return partySize;
    }

    // Setters
    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = tipAmount;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    // Calculate tip percentage (tip / total bill * 100)
    public double getTipPercentage() {
        if (totalBill == 0) return 0;
        return (tipAmount / totalBill) * 100;
    }

    // Calculate tip per person
    public double getTipPerPerson() {
        if (partySize == 0) return 0;
        return tipAmount / partySize;
    }

    @Override
    public String toString() {
        return "RestaurantTip{" +
                "totalBill=" + totalBill +
                ", tipAmount=" + tipAmount +
                ", customerGender='" + customerGender + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", mealTime='" + mealTime + '\'' +
                ", partySize=" + partySize +
                '}';
    }
}
