import java.util.*;

public class minimumRemove {
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        String s = sc.next();

        System.out.println(minimumRemoveParentheses(s));
        sc.close();
    }

    public static String minimumRemoveParentheses (String s){
        Stack <Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder (s);

        for (int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);

            if (ch == '('){
                st.push(i);
            }

            else if (ch == ')'){
                if (!st.isEmpty()){
                    st.pop();
                }
                else {
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!st.isEmpty()){
            sb.setCharAt(st.pop(), '*');
        }

        StringBuilder res = new StringBuilder();

        for (int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);

            if(ch != '*'){
                res.append(ch);
            }
        }

        return res.toString();
    }
}
