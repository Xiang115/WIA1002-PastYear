package Q1;

import java.util.Scanner;

public class Day {

    private static final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify your day in number: ");
        for (int i = 0; i < 7; i++) {
            System.out.printf("%d for %s\n", i + 1, days[i]);
        }

        int day = sc.nextInt() - 1;
        System.out.println("The name of the day is : " + days[day]);
        System.out.printf("The following day of %S is : %s\n", days[day], days[(day + 1) % 7]);
        System.out.printf("The previous day of %S is : %s\n", days[day], days[day - 1]);

        System.out.printf("How many days to add to the specified/current day (%s)? : \n", days[day]);
        int num = sc.nextInt();
        System.out.printf("The new day after the addition of %d day(s) is : %s\n", num, days[(day + num) % 7]);
        sc.close();
    }
}
