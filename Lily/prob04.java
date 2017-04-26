//INCOMPLETE
//misinterpreted the question <_< >_>;;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Prob04{
    public static void main(String[] args)throws Exception{
        File file=new File(args[0] + "Prob04.in.txt");
        //System.out.println(file.exists());
        Scanner scan=new Scanner(file);
        String input = "";
        String[] inputArr;
        String nl = System.getProperty("line.separator");
        String temp;
        String out = "";
        String[] alph; 
        //bw.write(content);
        while (scan.hasNextLine()){
            input+=""+scan.nextLine()+"/";
        }
        inputArr = input.split("/");
        alph = inputArr[0].split("");
        for (int i=1;i<inputArr.length;i++){
            temp = inputArr[i];
            out = "";
            for (int a=0;a<temp.length();a++){
                if (!(temp.substring(a,a+1).equals("-"))){
                    if (temp.substring(a,a+1).equals(" ")){
                        out+=" ";
                    }
                    else{
                        out+=alph[Integer.parseInt(temp.substring(a,a+1))+1];
                    }
                }
            }
            System.out.println(Arrays.toString(alph));
            System.out.println(out);
        }
        
        scan.close();
    }
}