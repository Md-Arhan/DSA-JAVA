public class BitOperations {
    public static int getithBit(int n, int i){
        int bitMask = 1<<i;

        if((n & bitMask) == 0){

            return 0;
        }else{
            return 1;
        }
    }

    public static int setithBit(int n, int i){
        int bitMask = 1<<i;
        return n|bitMask;
    }

    public static int clearithBit(int n, int i){
     int bitMask = ~(1<<i);
        return n & bitMask;
    }

    public static int updateithBit(int n, int i, int newBit){
        // if(newBit == 0){
        //     return clearithBit(n, i);
        // }else{
        //     return setithBit(n, i);
        // }

        //Time complecity
        n = clearithBit(n, i);  // n = 10, i = 2;
        // System.out.println(n); //10
        int bitMask = newBit << i;   //newBit = 1, i = 2;
        return n | bitMask;    // 10 = (1010) | 4 = (0100)

    }

    public static int cleatLastBit(int n, int i){
        int bitMask = ~0<<i;
        return n & bitMask;
    }

    public static int clearRangeBits(int n, int i, int j){
       int a = (~0) << (j+1);
       int b = (1<<i)-1;
       int bitMask = a | b;
       return n & bitMask;
    }

    public static void main(String[] args) {
        
        System.out.println(getithBit(10, 3));
        System.out.println(setithBit(10, 2));
        System.out.println(clearithBit(10, 2));
        System.out.println(updateithBit(10, 2, 1));
        System.out.println(cleatLastBit(10, 2));
        System.out.println(clearRangeBits(10, 2, 4));
    }
}
