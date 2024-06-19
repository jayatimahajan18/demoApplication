package com.TestRunner.Test;

import org.apache.xmlbeans.impl.xb.xsdschema.Facet;

import java.util.*;

public class LeedCode {
    public static void main(String[] args){
        LeedCode lc=new LeedCode();
        lc.amazonSAD();
    }
    public void uniqueCharaterOfString(){
        //1.1
        String x="Selenium";
        int count=0;
        ArrayList<Character> arr= new ArrayList<>();
        for(int i=0;i<x.length();i++){
            for(int j=0;j<x.length();j++){
                if(!(i==j)){
                    if(x.charAt(i)==x.charAt(j)){
                        count++;
                        break;
                    }
                }
            }
            if(count==0){
                arr.add(x.charAt(i));
            }
            count=0;
        }
        System.out.println(arr);
    }
    public void permutationIsPalidromeOfString(){
        //1.2
        //1.4
        String x="abbac";
        String y="bbac";
        Map<Character, Integer> mapx = new HashMap<>();
        Map<Character, Integer> mapy = new HashMap<>();
         if(x.length()==y.length()){
             for(int i=0;i<x.length();i++) {
                 if(mapx.containsKey(x.charAt(i))) {
                     mapx.put(x.charAt(i),mapx.get(x.charAt(i))+1);
                 }
                 else{
                     mapx.put(x.charAt(i),1);
                 }
             }
             System.out.println(mapx+"----------------------------------Mapx");;
             for(int i=0;i<y.length();i++) {
                 if(mapy.containsKey(y.charAt(i))) {
                     mapy.put(y.charAt(i),mapy.get(y.charAt(i))+1);
                 }
                 else{
                     mapy.put(y.charAt(i),1);
                 }
             }
             System.out.println(mapy+"----------------------------------Mapy");;
         }
         else {
             System.out.println("Length of 2 string is not same.String is not palidrome of permutated  String");
         }
         if(mapx.equals(mapy)){
             System.out.println("true");
             String temp=y;
             String rev="";
             for( int j=(y.length())-1;j>=0;j--){
                 rev= rev.concat(String.valueOf(y.charAt(j)));
             }
             //System.out.println(rev);
             if(temp.equals(rev)){
                 System.out.println("Given value of Y is : Palidrome");
             }
             else {
                 System.out.println("Given value of Y is not : Palidrome");
             }
         }
         else {
             System.out.println("Map is not same");
         }

    }
    public void replaceSpacs(){
        //1.3
        String x="Mr John Smith";
        String[] arr=new String[x.length()+10];
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)==' '){
                arr[i]="%20";
            }
            else {
                arr[i]= String.valueOf(x.charAt(i));
            }
        }
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i].toString());
//        }
          System.out.print(Arrays.toString(arr));
    }
    public void findNumberInMatrixAndReplaceWith0(){
        //1.8
        //2D array
        int count=0;
        //int x=5;
        //int row = 0,col=0;
        Boolean flag = false;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter length of row");
        Integer row=myObj.nextInt();//3
        System.out.println("Enter length of column");
        Integer col=myObj.nextInt();//3
        int[][] arr= InputFromUser(row,col);
        System.out.println("Enter number to be replaced");
        Integer x=myObj.nextInt();//3
        //System.out.println(arr.length);
        //System.out.println(arr[0].length);
//        for(int i=0;i<arr.length;i++){
//            for( int j=0;j<arr[0].length;j++){
//                arr[i][j]=count++;
//            }
//        }
        for(int i=0;i<row;i++) {
            for (int j = 0; j <col; j++) {
                if(arr[i][j]==x){
                    flag=true;
                    arr[i][j]=0;
                    row=i;//1
                    col=j;//2
                    System.out.println(row+"  row");
                    System.out.println(col+"  col");
                    break;
                }
                if(flag){
                    break;
                }
            }
        }
        //1 0,1 1,1,2
        //0 2, 1 2, 2 2
            for(int n=0;n<arr.length;n++){
                arr[row][n]=0;//12 11 10    //22 21 20
                //System.out.print(arr[z][n]+"   row update");
            }
            for(int n=0;n<arr.length;n++){
                arr[n][col]=0;
                //System.out.print(arr[n][m]+"   col update");
            }

        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
   }
   public int[][] InputFromUser(int row,int col){
       Scanner myObj = new Scanner(System.in);  // Create a Scanner object
       int[][] arr= new int[row][col];
       for(int i=0;i<row;i++) {
           for (int j = 0; j < col; j++) {
               System.out.println("Enter numbers ");
               Integer input = myObj.nextInt();
               arr[i][j]=input;
           }
       }
       for(int i=0;i<row;i++) {
           for (int j = 0; j < col; j++) {
               System.out.print(arr[i][j]+" ");
           }
           System.out.println();
       }
      // myObj.close();
       return arr;
   }
   public void sumOfDiagonalElementOfArray(){
        int[][] arr=new int[3][3];
        int count=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=count++;
            }
        }
       for(int i=0;i<arr.length;i++) {
           for (int j = 0; j < arr[0].length; j++) {
                if(i==j){
                    sum=sum+arr[i][j];
                }
           }
       }
       for(int i=0;i<arr.length;i++) {
           for (int j = 0; j < arr[0].length; j++) {
               System.out.print(arr[i][j]+" ");
           }
           System.out.println();
       }
       System.out.println(sum);
   }
   public void transposeOArray(){
       int[][] arr=new int[3][3];
       int temp=0;
       //int[][] transArr= new int[arr.length][arr[0].length];
       int count=1;
       for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr[0].length;j++){
               arr[i][j]=count++;
           }
       }
       for(int i=0;i<arr.length;i++) {
           for (int j = 1; j < (arr[0].length); j++) {
               temp= arr[j][i];
               arr[j][i]=arr[i][j];
               arr[i][j]= temp;
           }
       }

       for(int i=0;i<arr.length;i++) {
           for (int j = 0; j < arr[0].length; j++) {
               System.out.print(arr[i][j]+" ");
           }
           System.out.println();
       }

   }
   public void rotateArrayByGivenIndex(){
        int[] arr= {1,2,3,4,10,11,12};
        int[] rota=new int[arr.length];
        int move=14;
        int i=0;
        int startIndex= (move%arr.length);
        int endIndex= startIndex-1;
        while(startIndex < arr.length){
            rota[startIndex]=arr[i];
            startIndex++;
            i++;
            if(startIndex==arr.length){
                for(int x=0;x<=endIndex;x++){
                    rota[x]=arr[i];
                    i++;
                }
            }
        }
       for( int k=0;k<arr.length;k++) {
           System.out.print(rota[k]+",");
       }
   }
   public void doubleArray(){
        int[] arr={10,20,3,5,111,29};
        //output: int[] n= n[2* arr.length]  --> {1,2,3,1,2,3}
       int[] n= new int[arr.length*2];
       int i=0;
       while(i<n.length){
           for( int j=0;j<arr.length;j++){
               n[i]=arr[j];
               i++;
           }
       }
       for( int k=0;k<n.length;k++) {
           System.out.print(n[k]+",");
       }
   }

   public void buildArrayFromPermutation(){
        int[] arr={5,0,1,2,3,4};
                //output : new array x= x[x[0]], x[x[2]],x[x[1]],x[x[5]],x[x[3]],x[x[4]]
                //pass number of array as index and find the value in new array
       int[] x= new int[arr.length];
       for(int i=0;i<x.length;i++){
            x[i]= arr[arr[i]];
       }
       for(int i=0;i<x.length;i++){
          System.out.print(x[i]+" ");
       }
   }

   public void variableAfterPerformingPoerators(){
        String[] z={"--x","x++","++x","x--"};
        int g=10;
        int rs=0;
        String value=null;
        for( int i=0;i<z.length;i++){
            value= z[i];
            if(value.equals("--x")){
                rs=--g;
            } else if (value.equals("x++")) {
                rs=g++;
            } else if (value.equals("++x")) {
                rs=++g;
            } else if (value.equals("x--")) {
                rs=g--;
            }
//            System.out.println(rs);
        }
       System.out.println(rs);
   }
   public  void largestNumberWithNegative(){
        /*
        check if largest number present in given array whose negative value should also exusts. if exists ,return 0  else -1
         */
       int[] arr={1,2,0,8,5,6,-0};
       int temp=arr[0];//1
       for( int i=1;i<arr.length;i++){
           if(temp<arr[i]){
               temp=arr[i];
           }
       }
       for( int i=0;i<arr.length;i++){
           if(temp==-arr[i]){
               System.out.println("Yes, present");
               break;
           }
       }
   }

   /*
   yet to complete
    */
   public void maxNumberArrayFind(){
        int[][] arr={{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}}; //4*4
        int[][] max= new int[arr.length-2][arr.length-2];//2*2
       int maxValue = 0;
       for( int k=0;k<max.length;k++) {//0
           for (int l = 0; l < max.length; l++) {//0
               maxValue = arr[0][0];
               for (int m = 0; m < arr.length-1; m++) {
                   for (int n = 0; n < arr.length - 1; n++) {
                        if(maxValue<arr[m][n]){
                            maxValue= arr[m][n];
                        }
                   }
               }
               max[k][l]=maxValue;
               System.out.println(maxValue);
           }
       }
        for( int a=0;a<max.length;a++){
            for(int b=0;b<max.length;b++){
                System.out.print(max[a][b]+" ");
            }
            System.out.println();
        }
   }
   public void amazonSAD(){
       /*
       int[] x={1,2,1,2,1]
       int[] q={-1,-1,3,4,-3}
       perform addition of q value if positive, else remove first occurence of q value if receive negative
        */
       ArrayList<Integer> x= new ArrayList<>(Arrays.asList(1,2,1,2,1));
       int[] q={-1,-1,3,4,-3,-2};
       int value=0;
       for( int i=0;i<q.length;i++){
           for(int j=0;j<x.size();j++){
               if (q[i]<0){
                   value= Math.abs(q[i]);
                   System.out.println(value);
                   if(x.get(j)==value){
                        x.remove(j);
                        break;
                   }
               } else {
                   x.add(q[i]);
                   break;
               }
           }
       }
       System.out.println(x);
   }
   public void selfDivosionNumber(){

   }
}
