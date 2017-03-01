
import java.util.Scanner;
import java.io.*;

public class prob01{
    public static void main(String[] args)throws Exception{
        File file=new File("prob01.in");
        //System.out.println(file.exists());
        Scanner scan=new Scanner(file);
        String input = "";
        String[] inputArr;
        String nl = System.getProperty("line.separator");
        String[] coins = {"QUARTER","DIME","NICKEL","HALFDOLLAR","PENNY"};
        int[] vals = {25,10,5,50,1};
        FileWriter fw = new FileWriter("prob01.out");
        BufferedWriter bw = new BufferedWriter(fw);
        int total = 0;
        //bw.write(content);
        
        while (scan.hasNextLine()){
            input+=""+scan.nextLine()+"/";
        }
        inputArr = input.split("/");
        
        for (int i=0;i<inputArr.length;i++){
            for (int a=0;a<coins.length;a++){
                if(inputArr[i].split("=")[0].equals(coins[a])){
                    total+=(vals[a] * Integer.parseInt(inputArr[i].split("=")[1]));
                }
            }
        }
        String out = ""+total;
        System.out.println("$"+out.substring(0,out.length()-2)+"."+out.substring(out.length()-2));
        
        scan.close();
        bw.close();
        fw.close();
    }
}