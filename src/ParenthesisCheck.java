import java.util.Stack;

public class ParenthesisCheck {
    public static void main(String[] args) {
        System.out.println(parenthesisCheck("() text { sffgdgdg }")); //true
        System.out.println(parenthesisCheck("() text { sffgdgdg ")); //false
        System.out.println(parenthesisCheck("() text { sffgdgdg[ ]} ")); //true
        System.out.println(parenthesisCheck("() text [{ sffgdgdg[ ]}] ")); //true


    }

    public static boolean parenthesisCheck(String text){
        boolean res = true;
        boolean stat = true;
        Stack<Character> stack = new Stack<>();
        stack.push(' ');
        StringBuilder str = new StringBuilder(text);

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                case '<':
                case '[':
                case '{':
                    stack.push(str.charAt(i));
                    break;
                case ')':
                    if ((stack.peek() != '(') || stack.empty()) {
                        stat = false;
                        break;
                    } else stack.pop();
                    break;
                case ']':
                    if ((stack.peek() != '[') || stack.empty()) {
                        stat = false;
                        break;
                    } else stack.pop();
                    break;
                case '}':
                    if ((stack.peek() != '{') || stack.empty()) {
                        stat = false;
                        break;
                    } else stack.pop();
                    break;
                case '>':
                    if ((stack.peek() != '<') || stack.empty()) {
                        stat = false;
                        break;
                    } else stack.pop();
                    break;
            }
            if (!stat) {
                res = false;
                break;
            }
        }
        stack.pop();
        if (!stack.empty()) res = false;
        return res;
    }
}
