public class Q1 {

    public static void towersOfHanoi(int n, char source, char destination, char intermediate) {
        if (n == 1) { // base case
            System.out.println("Move disc 1 from " + source + " to " + destination);
            return;
        }

        // move n-1 discs from source to temp, using destination as temp
        towersOfHanoi(n - 1, source, intermediate, destination);

        // move the nth disc from source to destination
        System.out.println("Move disc " + n + " from " + source + " to " + destination);

        // move n-1 discs from temp to destination, using source as temp
        towersOfHanoi(n - 1, intermediate, destination, source);
    }

    public static void main(String[] args) {
        int numDiscs = 3; 
        towersOfHanoi(numDiscs, 'A', 'C', 'B'); 
    }
}
