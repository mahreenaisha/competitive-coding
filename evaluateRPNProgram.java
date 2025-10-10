//input is a string array with +,-,/,* or numbers
//usecases: ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]

import java.util.*;

public class evaluateRPNProgram {

    public static int evaluate(String tokens[]) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int num2 = st.pop();
                int num1 = st.pop();

                st.push(num1 + num2);

            }

            else if (token.equals("-")) {
                int num2 = st.pop();
                int num1 = st.pop();

                st.push(num1 - num2);

            }

            else if (token.equals("*")) {
                int num2 = st.pop();
                int num1 = st.pop();

                st.push(num1 * num2);

            }

            else if (token.equals("/")) {
                int num2 = st.pop();
                int num1 = st.pop();

                st.push(num1 / num2);

            }

            else {
                int x = Integer.parseInt(token);
                st.push(x);
            }

        }

        return st.pop();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        System.out.println(evaluate(arr));
        sc.close();
    }
}
