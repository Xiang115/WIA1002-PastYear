import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        
        // Don't ask why this is used, it definitely is not YouTube
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("BracMatch.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] line = lines.toArray(new String[lines.size()]);
        for(int i = 0; i < line.length; i++){
            System.out.print(i+1 + ". ");
            if (isMatched(line[i])) {
                System.out.print("YES - all matched!\n");
            }else if(noBracket(line[i])){
                System.out.print("There is no bracket in the input.\n");  
            } else {
                System.out.print("Not all brackets are matched.\n");
            }
        }
    }

    private static boolean noBracket(String string) {
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if(isOpenBracket(ch) || isCloseBracket(ch)){
                return false;
            }
        }
        return true;
    }

    public static boolean isMatched(String line) {
        Stack<Character> stack = new Stack<>();
        boolean bracket = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (isOpenBracket(ch)){
                stack.push(ch);
                bracket = true;
            } else if (isCloseBracket(ch)) {
                bracket = true;
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), ch)) {
                    return false;
                }
                stack.pop();
            }
        }
        if(!bracket){
            return false;
        }
        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{' || ch == '<';
    }

    private static boolean isCloseBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}' || ch == '>';
    }

    private static boolean isMatchingPair(char openBracket, char closeBracket) {
        return (openBracket == '(' && closeBracket == ')') ||
                (openBracket == '[' && closeBracket == ']') ||
                (openBracket == '{' && closeBracket == '}') ||
                (openBracket == '<' && closeBracket == '>');
    }
}
