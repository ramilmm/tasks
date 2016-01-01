package com.kpfu.itis;

public class StringParser {
//    private static int a = 1,b = 2,c = 3;
    private static int tempResult = 0;
    private static int first = 0,second = 0,third = 0,n = 0,tmpN = 0,signN = 0;
    private static char[] chars;
    public static void main(String[] args) {

        String seq = "15/3*20";
        int startPos = 0;
        int endPos;

        chars = seq.toCharArray();
        for (char c : chars){
            System.out.print(c);
        }
        System.out.println();
        System.out.println(first = getNumber(n,1));
        signN = n;
        n++;
        System.out.println(second = getNumber(n,2));
        addTmp(first,second);
        signN = n;
        n++;
        System.out.println(third = getNumber(n,3));
        addTmp(tempResult,third);
        System.out.println(tempResult);
    }
    private static int getNumber(int n, int countNumber){
        int number = 0;
        if((int)chars[0]<48){
            System.out.println("Error!");
        }else if(n == (chars.length - 1)) {
            number = Integer.parseInt(Character.toString(chars[n]));
        }else if((int)chars[n]>=48 && (int)chars[n+1]<48){
            number = Integer.parseInt(Character.toString(chars[n]));
            StringParser.n+=1;
        }else if((int)chars[n]>=48 && (int)chars[n+1]>=48 && (int)chars[n+2]>=48){
            number = Integer.parseInt(Character.toString(chars[n])+Character.toString(chars[n+1])+Character.toString(chars[n+2]));
            StringParser.n +=3;
        }else if((int)chars[n]>=48 && (int)chars[n+1]>=48){
            number = Integer.parseInt(Character.toString(chars[n])+Character.toString(chars[n+1]));
            StringParser.n+=2;
        }
        return number;
    }
    private static void addTmp(int n1,int n2){
        switch (chars[signN]){
            case '+':{
                tempResult = n1 + n2;
                break;
            }
            case '-':{
                tempResult = n1 - n2;
                break;
            }
            case '*':{
                tempResult = n1 * n2;
                break;
            }
            case '/':{
                tempResult = n1 / n2;
                break;
            }
        }
    }

}
