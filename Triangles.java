import java.util.*;

public class Triangles {

   
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[] xCoordinate = new int[3];
        int[] yCoordinate = new int[3];
        boolean[][] Matrix = new boolean[51][51];
        
        do { 
            for (int i = 0; i < 3; i++) {
                System.out.println("Enter x" + (i + 1) + " Coordinate");
                xCoordinate[i] = scn.nextInt();
                System.out.println("Enter y" + (i + 1) + " Coordinate");
                yCoordinate[i] = scn.nextInt();                
            }
            if (xCoordinate[0] > 51 || yCoordinate[0] > 51 || xCoordinate[1] > 51 || yCoordinate[1] > 51 || xCoordinate[2] > 51 || yCoordinate[2] > 51){
                System.out.println("invalid input, coordinate must be between 0 and 51");
                for (int i = 0; i < 3; i++) {
                    System.out.println("Enter another x" + (i + 1) + " Coordinate");
                    xCoordinate[i] = scn.nextInt();
                    System.out.println("Enter another y" + (i + 1) + " Coordinate");
                    yCoordinate[i] = scn.nextInt();                
                }
            }
            
         
            if(xCoordinate[0] == 0 && yCoordinate[0] == 0 && xCoordinate[1] == 0 && yCoordinate[1] == 0 && xCoordinate[2] == 0 && yCoordinate[2] == 0){
                System.out.println("All coordinates are 0. Exiting.");
                break;
            }
            
    
            clearMatrix(Matrix);
            
            for (int i = 0; i < 2; i++) {
              drawLine(Matrix, xCoordinate[i], yCoordinate[i], xCoordinate[i+1], yCoordinate[i+1]); 
            }
            drawLine(Matrix, xCoordinate[0], yCoordinate[0], xCoordinate[2], yCoordinate[2]);

            printMatrix(Matrix);
            
        }while (true);
        
   
    }    
    
    public static void clearMatrix(boolean[][] Matrix) {
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix.length; j++) {
                Matrix[i][j] = false;
            }
        }
    }
    
    public static void drawLine(boolean[][] Matrix, int x0, int y0, int x1, int y1) {
        int dx = x1 - x0;
        int dy = y1 - y0;
        
        
        if (dx == 0) {
            for (int y = y0; y < y1; y++) {
                mark(Matrix, x0, y);
            } 
            return;
        }
        
        if (x0 > x1) {
            int temp = x0;
            x0 = x1;
            x1 = temp;
            
            temp = y0;
            y0 = y1;
            y1 = temp;
        }
        
     
        for (int x = x0; x <= x1; x++) {
            int y = y0 + dy * (x - x0) / dx;
            mark(Matrix, x, y);
        } 
    }
    
    public static void mark(boolean[][] Matrix, int x, int y) {
        Matrix[x][y] = true;
    }
        
    public static void printMatrix(boolean[][] Matrix) {
        for (int y = 0; y < Matrix.length; y++) {
            for (int x = 0; x < Matrix.length; x++) {
                if (Matrix[y][x]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");
        }
    }    
    
}

