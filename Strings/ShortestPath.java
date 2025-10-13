package Strings;

public class ShortestPath {

    public static float shortestPath(String path){
        int x = 0;
        int y = 0;

        for(int i=0; i<path.length(); i++){
            char ch = path.charAt(i);

            if(ch == 'N'){
               y++;
            }

            if(ch == 'S'){
               y--;
            }

            if(ch == 'E'){
                x++;
            }

            if(ch == 'W'){
                x--;
            }

        }
        
        int x1 = x*x; 
        int y1 = y*y;

        return (float)Math.sqrt(x1 + y1);
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(shortestPath(path));
    }
}
