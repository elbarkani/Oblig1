import java.util.Arrays;

public class Oblig1 {

    public static void main(String[] args){

        int[] a = {4, 3, 1, 5, 6, 10, 9, 7, 8, 2};
        int[] b = {3, 3, 4, 5, 5, 6, 7, 7, 7, 8};
        int[] c = {5, 3, 7, 4, 3, 5, 7, 8, 6, 7};
        int[] d = {1, 6, 13, 3, 2, 12, 7, 4, 11, 5, 8, 10, 9, 14};

        //System.out.println("Antall ombyttinger i tabell: " + ombyttinger(a));
        //System.out.println("Antall ulike: " + antallUlikeSortert(b));
        //System.out.println("Antall ulike tall i usortert tabell: " + antallUlikeUsortert(c));
        //System.out.println("Maks verdi i tabell: " + maks(a));




    }


    public static void delsortering(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[i]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
            }
        }

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length - 1; j++) {
                    if ((a[j] % 2) == 0) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;

                    }
                }
            }


    }
    public static int antallUlikeUsortert(int[] a){

        if (a.length==0){
            return 0;
        }

        for (int j=0; j<a.length; j++) {
            for (int i=0; i < a.length - 1; i++) {

                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;

                }
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
        return ombyttinger;

    }

    public static int maks(int[] a){
        if (a.length < 1)
        {throw new IllegalArgumentException("Illegalt intervall!");
        }


        for (int i=0; i<a.length-1; i++){
            if(a[i] > a[i + 1]) {
                //System.out.println(" Inversjon i plass  " + i + " bytter om"); //Se tabell før
                int temp = a[i]; a[i] = a[i + 1]; a[i + 1] = temp;

                //System.out.println("Tabell: " + Arrays.toString(a));  //Se tabell underveis
            }
        }
        return a[a.length-1];

    }




}
