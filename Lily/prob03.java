
import java.util.Scanner;
import java.io.*;

public class prob03{
    public static void main(String[] args)throws Exception{
        File file=new File("prob03.in");
        //System.out.println(file.exists());
        Scanner scan=new Scanner(file);
        String input = "";
        String[] inputArr;
        String nl = System.getProperty("line.separator");
        String state = "na";
        String[] temp;
        //bw.write(content);
        while (scan.hasNextLine()){
            input+=""+scan.nextLine()+"/";
        }
        inputArr = input.split("/");
        
        for (int i=0;i<inputArr.length;i++){
            temp = inputArr[i].split(" ");
            state = "na";
            for (int a=0;a<temp.length-1;a++){
                try{
                    if ((state.equals("ascending")&&Integer.parseInt(temp[a+1])<=Integer.parseInt(temp[a]))||(state.equals("descending")&&Integer.parseInt(temp[a+1])>=Integer.parseInt(temp[a]))){
                        state = "random";
                        break;
                    }
                    state = (Integer.parseInt(temp[a+1])>Integer.parseInt(temp[a])?"ascending":"descending");
                }
                catch(NumberFormatException e){
                    state = "invalid";
                    break;
                }
            }
            
            System.out.println(((state.equals("invalid"))?"The input was invalid":"The numbers are in "+state+" order"));
        }
        
        
        
        scan.close();
    }
}