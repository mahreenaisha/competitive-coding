//stack with -1
//takes indices

//if open -> push index to stack
//if closing -> first pop
//if stack is empty, push index
//if stack is not empty, calculate max

import java.util.*;

public class longestValid {

    public static int validLength(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            }

            else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    max = Math.max(max, i - st.peek());
                }

            }
        }

        return max;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(validLength(s));
        sc.close();
    }
}
