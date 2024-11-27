import java.util.Scanner;

public class IT24104099Lab5Q3 {
    public static void main(String[] args) {
        final int ROOM_CHARGE_PER_DAY = 48000;
        final int NO_DISCOUNT_DAYS = 2;
        final int LOW_DISCOUNT_RATE = 10; // 3-4 days
        final int HIGH_DISCOUNT_RATE = 20; // 5 or more days

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start date (day): ");
        int startDate = scanner.nextInt();
        System.out.print("Enter the end date (day): ");
        int endDate = scanner.nextInt();

        // Validate dates
        if (startDate < 1 || startDate > 31 || endDate < 1 || endDate > 31) {
            System.out.println("Error: Start date and end date must be between 1 and 31.");
            System.exit(1);
        }
        if (startDate >= endDate) {
            System.out.println("Error: Start date should be less than the end date.");
            System.exit(1);
        }

        int numberOfDaysReserved = endDate - startDate + 1;
        int discountRate = 0;

        if (numberOfDaysReserved > NO_DISCOUNT_DAYS) {
            if (numberOfDaysReserved <= 4) {
                discountRate = LOW_DISCOUNT_RATE;
            } else {
                discountRate = HIGH_DISCOUNT_RATE;
            }
        }

        float totalAmount = ROOM_CHARGE_PER_DAY * numberOfDaysReserved;
        totalAmount = totalAmount - (totalAmount * discountRate / 100);

        System.out.printf("Number of days reserved: %d\n", numberOfDaysReserved);
        System.out.printf("Total amount to be paid: Rs %.2f\n", totalAmount);

        scanner.close();
    }
}
