
import java.util.*;
import java.io.*;

public class Prob12{
    static boolean[][] grid;
    public static void main(String[] args)throws Exception{
        File file=new File(args[0] + "Prob12.in.txt");
        //System.out.println(file.exists());
        Scanner scan=new Scanner(file);
        String input = "";
        String[] inputArr;
        String nl = System.getProperty("line.separator");
        boolean hasDead = false;
        
        while (scan.hasNextLine()){
            input+=""+scan.nextLine()+"/";
        }
        inputArr = input.split("/");
        grid = new boolean[inputArr[0].length()][inputArr.length];
        
        //System.out.println(Arrays.toString(inputArr));
        for (int i=0;i<inputArr.length;i++){//y
            for (int a=0;a<inputArr[i].length();a++){//x
                grid[a][i] = (inputArr[i].substring(a,a+1).equals("O"));
            }
        }
        
        int[] tmp = getEnd();
        hasDead = (tmp[0]!=-1&&tmp[1]!=-1);
        
        //while there is still a dead end
        while (hasDead){
            tmp = getEnd();
            hasDead = (tmp[0]!=-1&&tmp[1]!=-1);
        }
        
        //loop through and find/delete each next dead end
        for (int i=0;i<inputArr.length;i++){
            for (int a=0;a<inputArr[i].length();a++){
                System.out.print((grid[a][i])? "O":"X");
            }
            System.out.print("\n");
        }
        
        scan.close();
    }
    
    public static int[] getEnd(){
        int[] temp;
        for (int i=1;i<grid[0].length-1;i++){
            for (int a=1;a<grid.length-1;a++){
                //must have one or less neighbors to be a dead end
                if(grid[a][i] && countAdj(new int[]{a,i})<2){
                    grid[a][i]=false;
                    return new int[]{a,i};
                }
            }
        }  
        return new int[]{-1,-1};
    }
    
    public static int countAdj(int[] pos){
        int alive = 0;
        int a = pos[0];
        int i = pos[1];
        if (i<grid[0].length-1 && grid[pos[0]][pos[1]+1]){
            alive++;
        }
        if (i>0 && grid[pos[0]][pos[1]-1]){
            alive++;
        }
        if (a>0 && grid[pos[0]-1][pos[1]]){
            alive++;
        }
        if (a<grid.length-1 && grid[pos[0]+1][pos[1]]){
            alive++;
        }
        return alive;
    }
}