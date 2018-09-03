import java.util.Arrays;

public class Oblig1 {

    public static void main(String[] args){

        int[] a = {4, 3, 1, 5, 6, 6, 10, 9, 7, 7, 8, 2};
        int[] b = {3, 3, 4, 5, 5, 6, 7, 7, 7, 8};

        System.out.println("Antall ulike: " + antallUlikeSortert(b));
        System.out.println("Antall ulike: " + antallUlikeUsortert(a));
        //ombyttinger(a);
        //maks(a);

    }

    public static int antallUlikeUsortert(int[] a){

        if (a.length==0) {
            return 0;
        }

        int ulike = 1;
        for (int i=0; i<a.length-1; i++){
            if (a[i] != a[i+1]) {
                ulike++;
            }
        }
        return ulike;
    }

    public static int antallUlikeSortert(int[] a){

        if (a.length==0){
            return 0;
        }

        for (int i=0; i<a.length-1; i++){
            if (a[i] > a[i+1]) {
                throw new IllegalArgumentException("Må ha stigende rekkefølge i tabell");
            }
        }

        int ulike = 1;

        for (int i=0; i<a.length-1; i++){
            if (a[i] != a[i+1]) {
                ulike++;
            }
        }
        return ulike;
    }

    public static int ombyttinger(int[] a) {

        int ombyttinger = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                ombyttinger++;
            }
        }

        System.out.println("Antall ombyttinger: " + ombyttinger);
        return ombyttinger;

    }

    public static int maks(int[] a){
        if (a.length < 1)
        {throw new IllegalArgumentException("Illegalt intervall!");
        }

        System.out.println("Tabell: " + Arrays.toString(a));
        for (int i=0; i<a.length-1; i++){
            if(a[i] > a[i + 1]) {
                int temp = a[i]; a[i] = a[i + 1]; a[i + 1] = temp;
            }
        }
        System.out.println("Tabell etter inversjon: " + Arrays.toString(a));
        System.out.println("Største verdi i tabell: " + a[a.length-1]);

        return a[a.length-1];

    }




}
