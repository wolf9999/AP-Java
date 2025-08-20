public class Main {
    public static void main(String[] args) {
        RestaurantTip tip = new RestaurantTip(
            50.0,     // totalBill
            7.5,      // tipAmount
            "Female", // customerGender
            "Sat",    // dayOfWeek
            "Dinner", // mealTime
            3         // partySize
        );

        // Print the object info
        System.out.println(tip);

        // Print calculated fields
        System.out.printf("Tip Percentage: %.2f%%\n", tip.getTipPercentage());
        System.out.printf("Tip Per Person: $%.2f\n", tip.getTipPerPerson());
    }
}
