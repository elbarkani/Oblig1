import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static void main(String[] args){

        int[] a = {4, 3, 2, 8, 6, 5, 10, 1, 7, 9};
        int[] b = {3, 3, 4, 5, 5, 6, 7, 7, 7, 8};
        int[] c = {5, 3, 7, 4, 3, 5, 7, 8, 6, 7};
        int[] d = {1, 6, 13, 3, 2, 12, 7, 4, 11, 5, 8, 10, 9, 14};
        int[] e = {1, 2, 3};
        char[] x = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};


        rotasjon(x, -2);
        System.out.println(Arrays.toString(x));

        //System.out.println("Antall ombyttinger i tabell: " + ombyttinger(a));
        //System.out.println("Antall ulike: " + antallUlikeSortert(b));
        //System.out.println("Antall ulike tall i usortert tabell: " + antallUlikeUsortert(c));
        //System.out.println("Maks verdi i tabell: " + maks(a));

    }

    public static int gcd(int a, int b)  // Euklids algoritme
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void rotasjon(char[] a, int k){

        int n = a.length;  if (n < 2) return;         // ingen rotasjon
        if ((k %= n) < 0) k += n;                     // motsatt vei?

        int s = gcd(n, k);                            // største felles divisor

        for (int i = 0; i < s; i++)                   // antall sykler
        {
            char verdi = a[i];                          // hjelpevariabel

            for (int j = i - k, u = i; j != i; j -= k)  // løkke
            {
                if (j < 0) j += n;                        // sjekker fortegnet til i
                a[u] = a[j]; u = j;                       // kopierer og oppdaterer j
            }

            a[i + k] = verdi;                           // legger tilbake verdien
        }
    }

    public static void rotasjon(char[] a){

        if(a.length > 1) {


            int d = 1;

            char temp = a[0];

            for (int i = -d, j = 0; i != 0; i = i - d) {
                if (i < 0) i += a.length;
                a[j] = a[i];
                j = i;
            }

            a[d] = temp;
        }
    }

    public static void delsortering(int[] a) {

        int v=0;
        int h=a.length-1;
        int antallOddetall=0;

        for (int i=0; i<a.length; i++){
            if (a[i] % 2 != 0) antallOddetall++;
        }

        int skilleverdi = antallOddetall;

        while (v < h){
            while (v < antallOddetall && h >= antallOddetall && a[v] % 2 != 0) v++;
            while (v < antallOddetall && h >= antallOddetall && a[h] % 2 == 0) h--;

            if ((a[v] % 2) == 0 && (a[h] % 2) != 0){
                bytt(a, v++, h--);
            }

            else if ((a[v] % 2) == 0 && (a[h] % 2) == 0){
                h--;
            }

            else if((a[v] % 2) != 0 && (a[h] % 2) != 0) {
            v++;
        }

            else if ((a[v] % 2) != 0 && (a[h] % 2) == 0){
                v++;
                h--;
            }

        }



        Arrays.sort(a, 0, antallOddetall);
        Arrays.sort(a, antallOddetall, a.length);

    }



    public static int ombyttinger(int[] a) {

            if (a.length<0) {
                throw new IllegalArgumentException("Må ha stigende rekkefølge i tabell");

        }

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



    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int antallUlikeUsortert(int[] a){
        if (a.length == 0){
            return 0;
        }

        if(a.length == 1){
            return 1;
        }

        int antallUlike = 0;
        int m = maks0(a);
        int startVerdi = 0;

        for(int i = 0; i <= m; i++){
            for (int j : a){
                if(startVerdi == j){
                    antallUlike++;
                    break;
                }
            }
            if(startVerdi > m){
                break;
            }
            startVerdi++;
        }

        return antallUlike;
    }

    public static int maks0(int[] a){

        int m = 0;            // indeks til minste verdi i a[fra:til>
        int maksverdi = a[0];  // minste verdi i a[fra:til>

        for(int i = 0 + 1; i < a.length; i++){
            if(a[i] > maksverdi){
                m = i;              // indeks til minste verdi oppdateres
                maksverdi = a[m];    // minste verdi oppdateres
            }
        }

        return a[m];       // posisjonen til minste verdi i a[fra:til>
    }

    public static int antallUlikeSortert(int[] a){

        if (a.length==0){
            return 0;
        }

        for (int i=0; i<a.length-1; i++){
            if (a[i] > a[i+1]){
                throw new IllegalStateException("Tabellen er ikke sortert");
            }
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



    public static int maks(int[] a){
        if (a.length < 1)
        {throw new NoSuchElementException("Illegalt intervall!");
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
