/* This code section I use for instanteneous problem solution*/

package com.msn2106.ds;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String conString = convert(str);
        System.out.println(conString);
        sc.close();
    }


    //Almug Question 3 was to find minimum coins for a given n.
    //Almug Question 2 below
    public static String convert(String str){
        String s ="";
        //removing other delimiters
        String[] arr = str.split("[ \\n\\t\\r.,*;:!?%(){-]");
        int l = arr.length;
        //for(String x:arr) System.out.println(x);
        for (int i = 0; i < l; i++) {
            String st = arr[i].substring(1).toLowerCase();
            String firstchar = String.valueOf(arr[i].charAt(0)).toUpperCase();
            arr[i] = firstchar+st;
        }
        //forming final string pattern
        for(String sub :arr)s = s+sub;
        String res = s.substring(1);
        String first = String.valueOf(s.charAt(0)).toLowerCase();
        s = first+res;
        return s;
    }
    /*1.) a b c d-e-f%g
        OP:- aBCDEFG
        2.) BOB loves-coding
        OP:- bobLovesCoding
        3.) cats And*Dogs-are Awesome
        OP:- catsAndDogsAreAwesome*/
}

//            Program to find largest among three inputs
//            if(a>=1 && a<=300 && b>=1 && b<=300 && c>=1 && c<=300){
//                int max = a>b?((a>c)?a:c):((b>c)?b:c);
//                System.out.println(max);
//            }
//            else{
//                System.out.println("Out of Range");
//            }

//      Program to categorize the roots of quadratic equation STQA Exp
//    int a = sc.nextInt();
//    int b = sc.nextInt();
//    int c = sc.nextInt();
//            if(a>=1 && a<=100 && b>=1 && b<=100 && c>=1 && c<=100){
//                    if(Math.pow(b,2)>(4*a*c)) System.out.println("Real and Unequal Roots");
//                    else if(Math.pow(b,2)==(4*a*c)) System.out.println("Real and Equal Roots");
//                    else System.out.println("Imaginary Roots");
//                    }
//                    else System.out.println("Out of Range Inputs");

//    Almug Question 1
//    public static boolean haspat(String str){
//        boolean present = false;
//        int l = str.length();
//        for (int i=0;i<l;i++){
//            char check = str.charAt(i);
//            int val = Integer.parseInt(String.valueOf(check));
//            //String substring = "";
//            StringBuilder substring = new StringBuilder();
//            for(int j=0;j<val;j++){
//                substring = substring.append(check);
//            }
//            for(int k=0;k<l;k++){
//                if(str.contains(substring)){
//                    present = true;
//                    break;
//                }
//            }
//            if(present) break;
//        }
//        return present;
//    }

