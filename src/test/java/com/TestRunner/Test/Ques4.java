package com.TestRunner.Test;

public class Ques4 {
    public static  void main(String[] args){
        String a="Geeks for Geeks";
        String b="eeks1";
        int flag=0;
        //output : identify string 2 is subset of string 1
//         for(int i=0;i<a.length();i++){
//             for(int j=0;j<b.length();j++){
//                 if(b.charAt(j)== a.charAt(i)){
//                     flag++;
//                     i++;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }
//         System.out.println(flag);
//         if(flag>=b.length()) {
//             System.out.println("Yes Substring");
//         }
//         else{
//             System.out.println("Not a Substring");
//         }
        Boolean yes= a.contains(b);
        if(yes){
            System.out.println("Yes substring");
        }
        else{
            System.out.println("No substring");
        }
    }
}

