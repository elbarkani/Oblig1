import java.util.Arrays;

public class Oblig1 {

    public static void main(String[] args){

        int[] a = {4, 3, 1, 5, 6, 0, 10, 9, 7, 8, 2};

        maks(a);
    }

    public static void maks(int[] a){
        if (a.length < 0)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        System.out.println("Tabell: " + Arrays.toString(a));

        for (int i=0; i<a.length-1; i++){
            if(a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        System.out.println("Tabell etter inversjon: " + Arrays.toString(a));
        System.out.println("Største verdi i tabell: " + a[a.length-1]);

    }

}
