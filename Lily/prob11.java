import java.util.Scanner;
import java.io.*;

public class prob11{
    public static void main(String[] args)throws Exception{
        File file=new File("prob11.in");
        //System.out.println(file.exists());
        Scanner scan=new Scanner(file);
        String input = "";
        String[] inputArr;
        String nl = System.getProperty("line.separator");
        FileWriter fw = new FileWriter("prob11.out");
        BufferedWriter bw = new BufferedWriter(fw);
        //bw.write(content);
        int gridlen;
        int gridheight;
        int grid[][];
        int maxvalue = 0;
        int maxsize = Integer.MIN_VALUE;
        int tempsum = 0;
        String coords = "";
        
        while (scan.hasNextLine()){
            input+=""+scan.nextLine()+"/";
        }
        inputArr = input.split("/");
        
        gridlen = Integer.parseInt(inputArr[0].split(",")[0]);
        gridheight = Integer.parseInt(inputArr[0].split(",")[1]);

        //loop through regions
        for (int x = 1;x<=gridlen;x++){
         for (int y = 1;y<=gridheight;y++){
          for (int i = 1;i<=gridlen-x+1;i++){//region len
           for (int a = 1;a<=gridheight-y+1;a++){//region height
            tempsum = 0;
            for (int index = 1;index<inputArr.length;index++){//loop through vals
             if (Integer.parseInt(inputArr[index].split(",")[0])>=x
              && Integer.parseInt(inputArr[index].split(",")[1])>=y
              && Integer.parseInt(inputArr[index].split(",")[0])<=x+i-1
              && Integer.parseInt(inputArr[index].split(",")[1])<=y+a-1){
              tempsum+=Integer.parseInt(inputArr[index].split(",")[2]);
             }
            }
            if (maxvalue<tempsum||(maxvalue==tempsum&&i*a>maxsize)){
                maxvalue = tempsum;
                maxsize = (i*a);
                coords = x+","+y+"\n"+(x+i-1)+","+(y+a-1);
            }
           }
          }
         }
        }
        System.out.println(coords);
        System.out.println(maxvalue);
        scan.close();
        bw.close();
        fw.close();
    }
}
