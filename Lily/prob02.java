
import java.util.Scanner;
import java.io.*;

public class prob02{
    public static void main(String[] args)throws Exception{
        File file=new File("prob02.in");
        //System.out.println(file.exists());
        Scanner scan=new Scanner(file);
        String input = "";
        String[] inputArr;
        String nl = System.getProperty("line.separator");
        int herald = 0;
        int times = 0;
        //bw.write(content);
        
        while (scan.hasNextLine()){
            input+=""+scan.nextLine()+"/";
        }
        inputArr = input.split("/");
        
        for (int i=0;i<inputArr.length;i++){
            times=Integer.parseInt(inputArr[i].split(" ")[0])*2;
            herald=Integer.parseInt(inputArr[i].split(" ")[1])*2;
            if (herald==times){
                System.out.println("Times and Herald have the same number of subscribers");
            }
            else{
                System.out.println(((herald>times)? "herald":"times")+" has "+Math.abs(herald-times)+" more subscribers");
            }
        }
        
        
        scan.close();
    }
}