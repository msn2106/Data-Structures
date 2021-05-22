package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time Complexity - O(n)
 * Auxiliary Space - O(n)
 */
public class balancedBrackets1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- >0){
            String s = br.readLine();
            if(isBalanced(s)) System.out.println("Balanced");
            else System.out.println("Not Balanced");
        }
        br.close();
    }

    public static boolean isBalanced(String s){
        Deque<Character> stack = new ArrayDeque<Character>();
        if(s.length()==0 || s.length()==1)return false;
        for(int i=0;i<s.length();i++){
                char x = s.charAt(i);
                if(x == '(' || x == '{' || x == '['){
                    stack.push(x);
                    continue;
                }

                if(stack.isEmpty())return false;

                char check;
                switch (x){
                    case ')':
                        check = stack.pop();
                        if(check != '(') {
                            return false;
                        }
                        break;

                    case '}':
                        check = stack.pop();
                        if(check != '{'){
                            return false;
                        }
                        break;

                    case ']':
                        check = stack.pop();
                        if(check != '['){
                            return false;
                        }
                        break;
                }
        }
        return stack.isEmpty();
    }
}
