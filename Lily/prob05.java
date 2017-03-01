//INCOMPLETE

//>_> <_<
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class prob05{
    public static void main(String[] args)throws Exception{
        File file=new File("prob05.in");
        //System.out.println(file.exists());
        Scanner scan=new Scanner(file);
        String input = "";
        String[] inputArr;
        String nl = System.getProperty("line.separator");
        String[] temp;
        double j;
        double n;
        double p;
        double m;
        //bw.write(content);
        while (scan.hasNextLine()){
            input+=""+scan.nextLine()+"/";
        }
        inputArr = input.split("/");
        
        for (int i=0;i<inputArr.length;i++){
            temp = inputArr[i].split(" ");
            j = Integer.parseInt(temp[3])/1200.0;
            p = Integer.parseInt(temp[0]);
            n = Integer.parseInt(temp[3]);
            m = p*(j/(1-Math.pow((1+j),0-n)));
            for (int a =0;a<Integer.parseInt(temp[3]);a++){
                p = p-(m-(p*j));
            }
            System.out.println(p);
        }
        
        scan.close();
    }
}