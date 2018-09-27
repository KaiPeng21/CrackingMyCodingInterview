

public class P01_EmbedBits{
    public static void main(String[] args){
        int N = 1354376611; // 0101 0000 1011 1010 0010 0101 1010 0011
        int M = 27;         // 1 1011
        int R;

        printBinary("N", N);
        printBinary("M", M);
        R = embed(N, M, 2, 6);
        printBinary("R", R);
    }

    public static void printBinary(String name, int N){
        System.out.print(name + ": ");
        for (int i = 31; i >= 0; i--){
            System.out.print((N & (1 << i)) > 0 ? "1" : "0");
            if (i % 4 == 0){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static int embed(int N, int M, int i, int j){
        int mask = (~0 << (j+1)) | ~(~0 << i);
        return (N & mask) | ((M << i) & ~mask);
    }
}