//TIP: HANDLE THE BASE CASE THAT IF THE CHARACTER IS CLOSING BRACKET

import java.util.*;
public class validParenthesisProgram {

    public static boolean isValid (String s){

        Stack <Character> st = new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }

            else {
                if(st.isEmpty()) { return false;} //base case - if closing bracket is coming first
                if (
                    (ch == ')' && st.peek() == '(') ||
                    (ch == ']' && st.peek() == '[') ||
                    (ch == '}' && st.peek() == '{')
                ){
                    st.pop();
                }

                else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        String s = sc.next();

        System.out.println(isValid(s));
        sc.close();
    }
}
