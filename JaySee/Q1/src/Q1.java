import java.util.Scanner;

public class Q1 {
    // To be honest, you can probably just do this with the below code:
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify your day in number:");
        for(int i = 0; i < days.length; i++){
            System.out.println(i+1 + " for " + days[i]);
        }
        int key = sc.nextInt();

        String day = days[key - 1];
        System.out.println("The name of the day is : " + day);
        System.out.println("The following day of " + day + " is : " + days[key % 7]);
        System.out.println("The previous day of " + day + " is : " + days[key - 2]);
        System.out.println("How many days to add to the specified/current day (" + day + ")? :");
        int add = sc.nextInt();
        System.out.printf("The new day after the addition of %d day(s) is : %s", add, days[(key + add - 1) % 7]);
        sc.close();

    }
    static final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    
    But come on, that is filthy, and not efficient. 
    You might have noticed the use of % in the code. 
    Technically you could've just used it to power the code.
    After modifying, it should look a little but like this.
    */
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify your day in number:");

        for(int i = 1; i <= 7; i++) {
            System.out.println(i + " for " + getWeekDay(i));
        }

        int key = sc.nextInt();
        String day = getWeekDay(key);
        System.out.println("The name of the day is :  " + day);
        System.out.println("The following day of " + day + " is : " + getWeekDay(key + 1));
        System.out.println("The previous day of " + day + " is : " + getWeekDay(key - 1));
        System.out.println("How many days to add to the specified/current day (" + day + ")? :");
        int add = sc.nextInt();
        System.out.printf("The new day after the addition of %d day(s) is : %s", add, getWeekDay(key + add));
        sc.close();
    }

    public static String getWeekDay(int key) {
        return days[key % 7];
    }

    public static final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    /*
    The only real problem with the above code is that 0 and numbers larger than 7 also works.
    But, I mean, you kinda need that for the add part.
    So you can just test this, but you really only need to try 0,1 and 7 to see if your code works.
     */
}

