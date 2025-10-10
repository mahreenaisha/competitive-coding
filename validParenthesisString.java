import java.util.*;

public class validParenthesisString {

    public static boolean isValid (String s){
        Stack <Integer> open = new Stack <>();
        Stack <Integer> star = new Stack <>();

        char token[] = s.toCharArray();
        for (int i=0;i<token.length;i++){
            
            char ch = token[i];

            if (ch == '('){
                open.push(i);
            }

            else if(ch == '*'){
                star.push(i);
            }

            else {
                if (!open.isEmpty()){
                    open.pop();
                }

                else if (!star.isEmpty()){
                    star.pop();
                }

                else {
                    return false;
                }

            }
        }

        while(!open.isEmpty() && !star.isEmpty()){
            if (open.pop() > star.pop()){
                return false;
            }
        }

        //if opening brackets are still left in the beginning
        return open.isEmpty();
    }
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(isValid(s));

        sc.close();
    }
}
