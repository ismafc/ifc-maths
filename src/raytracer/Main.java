/*
 * Main.java
 *
 * Created on 25 de abril de 2005, 22:17
 */

package raytracer;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * Main test program
 * @author Isma
 */
public class Main {

/*
Números de Friedman:

25 = 5^2
121 = 11^2
125 = 5^(1+2)
126 = 21*6
127 = 2^7-1
128 = 2^(8-1)
153 = 51*3
216 = 6^(2+1)
289 = (9+8)^2
343 = (3+4)^3
347 = 7^3+4
625 = 5^(6-2)
688 = 86*8
736 = 3^6+7
1022 = 2^10-2
1024 = (4/2)^10
1206 = 201*6
1255 = 251*5
1260 = 210*6
1285 = (1+2^8)*5
1296 = 16*9^2
1395 = 31*9*5
1435 = 41*35
1503 = 501*3
1530 = 510*3
1792 = 7*2^(9-1)
1827 = 21*87
2048 = (8^4)/2+0
2187 = (8/2-1)^7
2349 = 29*(3^4)
2500 = 50^2+0
2501 = 50^2+1
2502 = 50^2+2
2503 = 50^2+3
2504 = 50^2+4
2505 = 50^2+5
2506 = 50^2+6
2507 = 50^2+7
2508 = 50^2+8
2509 = 50^2+9
2592 = 2^5*9^2
2737 = (2*7)^3-7
2916 = 1*(9*6)^2
3125, 3159, 3281, 3375, 3378, 3685, 3784, 3864, 3972, 4088, 4096, 4106, 4167, 4536, 4624, 4628, 5120, 5776, 5832, 6144, 6145, 6455, 6880, 7928, 8092, 8192, 9025, 9216, 9261
*/

    private static boolean isPrime(long n) {
        if (n % 2L == 0L)
            return n == 2L;
        for (long i = 3L; i <= Math.sqrt(Math.abs(n)); i += 2L) {
            if (n % i == 0L)
                return false;
        }
        return true;
    }

    private static long MCD(long n1, long n2) {
        long lAux = 0;
        if (n1 < n2) {
            lAux = n1;
            n1 = n2;
            n2 = lAux;
        }
        while (n1 % n2 != 0) {
            lAux = n1 % n2;
            n1 = n2;
            n2 = lAux;
        }
        return n2;
    }

    static private boolean isBouncy(int i) {
        int digits = (int)Math.log10(i) + 1;
        int state = 0;
        int lastDigit = i % 10;
        for (int d = 0; d < digits; d++) {
            int newDigit = (i / (int)Math.pow(10, d)) % 10;
            if (newDigit > lastDigit) {
                if (state == -1)
                    return true;
                lastDigit = newDigit;
                state = 1;
            }
            else if (newDigit < lastDigit) {
                if (state == 1)
                    return true;
                lastDigit = newDigit;
                state = -1;
            }
        }
        return false;
    }

    static private void combinacion(int i, long num, Vector<Integer> posibles) {
        if (i == 0) {
            num += (long)posibles.lastElement();
            // Tratamos el número final
        }
        else {
            long nnum = num;
            for (Integer d : posibles) {
                Vector<Integer> np = new Vector<Integer>(posibles);
                np.remove(d);
                num = nnum + (long)d * (long)Math.pow(10, i);
                combinacion(i - 1, num, np);
            }
        }
    }

    private static String sum(String s1, String s2) {
        int rLength = Math.max(s1.length(), s2.length());

        while (s1.length() < rLength || s2.length() < rLength) {
            if (s1.length() < rLength)
                s1 = "0" + s1;
            if (s2.length() < rLength)
                s2 = "0" + s2;
        }

        String result = "";
        int mellevo = 0;
        for (int j = rLength - 1; j >= 0; j--) {
            int sum = (int)s1.charAt(j) - 48;
            sum += (int)s2.charAt(j) - 48;
            sum += mellevo;
            mellevo = sum / 10;
            sum = sum % 10;
            result = (char)(sum + 48) + result;
        }
        if (mellevo != 0)
            result = (char)(mellevo + 48) + result;
        return result;
    }

    private static String mul(String m1, String m2) {
        int rLength = m1.length() + m2.length();
        String result = "";
        String[] results = new String [m2.length()];
        for (int i = 0; i < m2.length(); i++) {
            int mellevo = 0;
            int res;
            results[i] = "";
            for (int k = 0; k < i; k++)
                results[i] += "0";
            for (int j = m1.length() - 1; j >= 0; j--) {
                res = ((int)m2.charAt(m2.length() - i - 1) - 48) * ((int)m1.charAt(j) - 48) + mellevo;
                mellevo = res / 10;
                res = res % 10;
                results[i] = (char)(res + 48) + results[i];
            }
            if (mellevo != 0)
                results[i] = (char)(mellevo + 48) + results[i];
            while (results[i].length() < rLength)
                results[i] = "0" + results[i];
        }
        int mellevo = 0;
        for (int j = 0; j < rLength; j++) {
            int sum = 0;
            for (int i = 0; i < results.length; i++) {
                sum += (int)results[i].charAt(rLength - j - 1) - 48;
            }
            sum += mellevo;
            mellevo = sum / 10;
            sum = sum % 10;
            result = (char)(sum + 48) + result;
        }
        if (mellevo != 0)
            result = (char)(mellevo + 48) + result;
        for (int j = 0; j < rLength; j++) {
            if (result.charAt(j) != '0') {
                result = result.substring(j);
                break;
            }
        }
        return result;
    }

    private static void insertOrdered(ArrayList<String> nl, String n) {
        int index = 0;
        for (String name : nl) {
            if (n.compareTo(name) < 0)
                break;
            index++;
        }
        nl.add(index, n);
    }

    private static String rotate(String s) {
        String r = "";
        for (int i = s.length() - 1; i >=0; i--)
            r += s.charAt(i);
        return r;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        return true;
    }

    private static boolean isPalindrome10(int n) {
        int digits = (int)Math.log10(n) + 1;
        for (int digit = 0; digit < digits / 2; digit++) {
            int d1 = (int)(n / Math.pow(10, digit)) % 10;
            int d2 = (int)(n / Math.pow(10, digits - digit - 1)) % 10;
            if (d1 != d2)
                return false;
        }
        return true;
    }

    private static boolean isPalindrome2(int n) {
        String nb = Integer.toBinaryString(n);
        for (int i = 0; i < nb.length() / 2; i++) {
            if (nb.charAt(i) != nb.charAt(nb.length() - i - 1))
                return false;
        }
        return true;
    }

    private static long factorial(long n) {
        long prod = 1;
        for (long i = 2; i <= n; i++)
            prod *= i;
        return prod;
    }

    // Lista todos los número sin repetir entre los disponibles con 'digitos' digitos
    private static void addNewDigit(int digito, long num, ArrayList<Integer> disponibles) {
        if (digito == 0) {
	    System.out.println(num);
            return;
        }
        for (Integer d : disponibles) {
            ArrayList<Integer> newdisponibles = new ArrayList<Integer>();
            newdisponibles.addAll(disponibles);
            newdisponibles.remove(d);
            long nnum = num + (long)d * (long)Math.pow(10, digito - 1);
            addNewDigit(digito - 1, nnum, newdisponibles);
        }
        return;
    }

    private static long phi(long n, double ratio) {
        long p = 1;
        for (long i = 2; i < n; i++) {
            if (MCD(n, i) == 1)
                p++;
            if (((double)n / ((double)p + ((double)n - (double)i - 1.0))) > ratio)
                return 1;
        }
        return p;
    }

    // n1 y n2 son primos (se calcula el phi de n1*n2)
    private static long phi(long n1, long n2) {
        long n = n1 * n2;
        return n - n1 - n2 + 1;
    }

    private static boolean isPermutation(long phin, long n) {
        String s1 = String.valueOf(phin);
        String s2 = String.valueOf(n);
        if (s1.length() != s2.length())
            return false;
        char c;
        int i;
        while (s1.length() > 0) {
            c = s1.charAt(0);
            i = s2.indexOf(c);
            if (i == -1)
                return false;
            if (i == 0)
                s2 = s2.substring(1, s2.length());
            else
                s2 = s2.substring(0, i) + s2.substring(i + 1, s2.length());
            s1 = s1.substring(1, s1.length());
        }
        return true;
    }


// PARA LEER UN FICHERO
// COPIARLO EN MASTER/PWRSTUDIO/APPLETSCADA
/*
        try {
            int found = 0;
            int c;
            int state = 0;
            FileReader fr = new FileReader("words.txt");
            String text = "";
            while ((c = fr.read()) != -1) {
                if (c == '"' && state == 0) {
                    state = 1;
                    text = "";
                }
                else if (c == '"' && state == 1) {
                    int sum = 0;
                    for (int i = 0; i < text.length(); i++)
                        sum += ((int)text.charAt(i) - 65) + 1;
                    double d = (Math.sqrt((double)sum * 8.0 + 1.0) + 1.0)/2.0;
                    d = d - (int)d;
                    if (d == 0)
                        found++;
                    state = 0;
                }
                else if (state == 1) {
                    text += (char)c;
                }
            }
            fr.close();
            System.out.println(found);
        }
        catch (Exception e) {}
    */

    // Esta el (0,0) dentro del triángulo t?
    static private boolean isZeroIn(Triangle t) {
        double minx = Math.min(t.coord[0], Math.min(t.coord[2], t.coord[4]));
        double maxx = Math.max(t.coord[0], Math.max(t.coord[2], t.coord[4]));
        double miny = Math.min(t.coord[1], Math.min(t.coord[3], t.coord[5]));
        double maxy = Math.max(t.coord[1], Math.max(t.coord[3], t.coord[5]));
        if (0 < minx || 0 > maxx || 0 < miny || 0 > maxy)
            return false;

        int cortes = 0;
        // x = (p2.x - p1.x) * r + p1.x;
        // y = (p2.y - p1.y) * r + p1.y;
        // y = 0

        // r = -p1.y / (p2.y - p1.y)
        // x = (p2.x - p1.x) * r + p1.x;
        double x1 = t.coord[0];
        double x2 = t.coord[2];
        double y1 = t.coord[1];
        double y2 = t.coord[3];
        double r;
        double x1t;
        if (Math.min(y1, y2) <= 0 && Math.max(y1, y2) >= 0) {
            r = - y1 / (y2 - y1);
            x1t = (x2 - x1) * r + x1;
            if (x1t >= Math.min(x1, x2) && x1t <= Math.max(x1, x2)) {
                if (x1t >= 0)
                    cortes++;
            }
        }

        x1 = t.coord[2];
        x2 = t.coord[4];
        y1 = t.coord[3];
        y2 = t.coord[5];
        if (Math.min(y1, y2) <= 0 && Math.max(y1, y2) >= 0) {
            r = - y1 / (y2 - y1);
            x1t = (x2 - x1) * r + x1;
            if (x1t >= Math.min(x1, x2) && x1t <= Math.max(x1, x2)) {
                if (x1t >= 0)
                    cortes++;
            }
        }

        x1 = t.coord[4];
        x2 = t.coord[0];
        y1 = t.coord[5];
        y2 = t.coord[1];
        if (Math.min(y1, y2) <= 0 && Math.max(y1, y2) >= 0) {
            r = - y1 / (y2 - y1);
            x1t = (x2 - x1) * r + x1;
            if (x1t >= Math.min(x1, x2) && x1t <= Math.max(x1, x2)) {
                if (x1t > 0)
                    cortes++;
            }
        }

        return cortes % 2 != 0;
    }


    //  Triangle 	  	P3,n=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
    private static boolean isTriangle(int n) {
        double c = (double)n * 2.0;
        double t = (-1.0 + Math.sqrt(1.0 + 4.0 * c)) / 2.0;
        return (t == (double)((int)t));
    }

    // Square          P4,n=n^2            1, 4, 9, 16, 25, ...
    private static boolean isSquare(int n) {
        double t = Math.sqrt(n);
        return (t == (double)((int)t));
    }

    // Pentagonal 	  	P5,n=n(3n-1)/2 	  	1, 5, 12, 22, 35, ...
    private static boolean isPentagonal(int n) {
        double c = (double)n * 2.0;
        double t = (1.0 + Math.sqrt(1.0 + 4.0 * 3.0 * c)) / 6.0;
        return (t == (double)((int)t));
    }

    // Hexagonal 	  	P6,n=n(2n-1) 	  	1, 6, 15, 28, 45, ...
    private static boolean isHexagonal(int n) {
        double c = (double)n;
        double t = (1.0 + Math.sqrt(1.0 + 4.0 * 2.0 * c)) / 4.0;
        return (t == (double)((int)t));
    }

    // Heptagonal 	  	P7,n=n(5n-3)/2 	  	1, 7, 18, 34, 55, ...
    private static boolean isHeptagonal(int n) {
        double c = (double)n * 2.0;
        double t = (3.0 + Math.sqrt(9.0 + 4.0 * 5.0 * c)) / 10.0;
        return (t == (double)((int)t));
    }

    // Octagonal 	  	P8,n=n(3n-2) 	  	1, 8, 21, 40, 65, ...
    private static boolean isOctagonal(int n) {
        double c = (double)n;
        double t = (2.0 + Math.sqrt(4.0 + 4.0 * 3.0 * c)) / 6.0;
        return (t == (double)((int)t));
    }

//
//
//
// Raiz cuadrada grandeeeee
//
//
//

    private static BigDecimal ZERO = new BigDecimal ("0");
    private static BigDecimal ONE = new BigDecimal ("1");
    private static BigDecimal TWO = new BigDecimal ("2");
    public static final int DEFAULT_MAX_ITERATIONS = 50;
    public static final int DEFAULT_SCALE = 10;

    private static BigDecimal getInitialApproximation (BigDecimal n) {
        BigInteger integerPart = n.toBigInteger ();
        int length = integerPart.toString ().length ();
        if ((length % 2) == 0) {
            length--;
        }
        length /= 2;
        BigDecimal guess = ONE.movePointRight (length);
        return guess;
    }

    static private int scale = DEFAULT_SCALE;
    static private int iterations = 0;
    static private BigDecimal error;
    static private int maxIterations = DEFAULT_MAX_ITERATIONS;
    static public int comprobado = 0;

    public static BigDecimal get (BigDecimal n)
    {
        BigDecimal initialGuess = getInitialApproximation (n);
        BigDecimal lastGuess = ZERO;
        BigDecimal guess = new BigDecimal (initialGuess.toString ());

        iterations = 0;
        boolean more = true;
        while (more) {
            lastGuess = guess;
            guess = n.divide(guess, scale, BigDecimal.ROUND_HALF_UP);
            guess = guess.add(lastGuess);
            guess = guess.divide (TWO, scale, BigDecimal.ROUND_HALF_UP);
            error = n.subtract (guess.multiply (guess));
            if (++iterations >= maxIterations) {
                more = false;
            }
            else if (lastGuess.equals (guess)) {
                more = error.abs ().compareTo (ONE) >= 0;
            }
        }
        return guess;
    }

    public static int getSum(Vector<Integer> set, int group, boolean first) {
        int sum = 0;
        if (first) {
            for (int i = 0; i < group; i++)
                sum += set.get(i);
        }
        else {
            for (int i = 0; i < group; i++)
                sum += set.get(set.size() - i - 1);
        }
        return sum;
    }

    @SuppressWarnings("unchecked")
    public static Vector<Vector<Integer>> expandGroups(Vector<Integer> group, Vector<Integer> set, int elements) {
        Vector<Vector<Integer>> groups = new Vector<Vector<Integer>>();
        if (elements > 0) {
            for (int i = 0; i < set.size(); i++) {
                Vector<Integer> newg = (Vector<Integer>)group.clone();
                newg.add(set.get(i));
                groups.add(newg);
                Vector<Integer> setclone = (Vector<Integer>)set.clone();
                for (int index = 0; index <= i; index++)
                    setclone.remove(0);
                groups.addAll(expandGroups(newg, setclone, elements - 1));
                //groups.remove(0);
            }
        }
        return groups;
    }

    public static int getSum(Vector<Integer> v) {
        int s = 0;
        for (Integer i : v)
            s += i;
        return s;
    }

    public static boolean findSameSum(Vector<Integer> group, Vector<Integer> set) {
        Vector<Vector<Integer>> groups = new Vector<Vector<Integer>>();
        groups.addAll(expandGroups(new Vector<Integer>(), set, group.size()));
        int sum = getSum(group);
        int v = 0;
        while (v < groups.size()) {
            if (groups.get(v).size() < group.size())
                groups.remove(v);
            else {
                if (getSum(groups.get(v)) == sum) {
                    System.out.println("Found " + groups.get(v) + " = " + group + " = " + sum);
                    return true;
                }
                boolean ok = false;
                for (int i = 0; i < group.size(); i++)
                    if (group.get(i) > groups.get(v).get(i))
                        ok = true;
                if (ok)
                    comprobado++;
                v++;
            }
        }
        //System.out.println("Finding same sum of " + group + " in " + set);
        //System.out.println(groups);
        return false;
    }

    @SuppressWarnings("unchecked")
    public static int analizeSet(Vector<Integer> set) {
        int sum = 0;
        // No puede haber dos iguales
        for (int i = 0; i < set.size() - 1; i++) {
            sum += set.get(i);
            if (set.get(i) == set.get(i + 1))
                return 0;
        }
        sum += set.lastElement();
        
        // Comprovar que si tienen más elementos, la suma es mayor
        // Se comprueba el peor caso de cada subgrupo, por ejemplo, de un subgrupo de 3 se mira
        // que la suma de los 3 menores sea mayor o igual que la suma de los 2 mayores
        // Con eso se aseguro que todos los subgrupos 3,2 cumplen la premisa.
        // Así para todos los subgrupos n, n-1
        for (int group = 2; group <= set.size() / 2 + (set.size() % 2); group++) {
            if (getSum(set, group, true) <= getSum(set, group - 1, false)) {
                System.out.println("Se encontró subgrupo más grande (" + group + ") con suma menor: " + set);
                //int index = (set.size() % 2 == 0) ? (set.size() / 2 - 1) : set.size() / 2;
                //int maxsum = set.get(index) * index;
                //System.out.println(maxsum);
                return 0;
            }
        }
        // Comprobar sumas de subgrupos diferentes
        // Solo quedan los subconjuntos con el mismo número de elementos
        System.out.println("Analizando: " + set);
        for (int elements = 2; elements <= set.size() / 2; elements++) {
            Vector<Vector<Integer>> groups = new Vector<Vector<Integer>>();
            groups.addAll(expandGroups(new Vector<Integer>(), set, elements));
            int v = 0;
            while (v < groups.size()) {
                if (groups.get(v).size() < elements)
                    groups.remove(v);
                else {
                    Vector<Integer> group = groups.get(v);
                    int firstIndex = set.indexOf(group.firstElement());
                    int lastIndex = firstIndex;
                    boolean bad = true;
                    for (int i = 1; i < group.size(); i++) {
                        int newIndex = set.indexOf(group.get(i));
                        if (newIndex > lastIndex + 2)
                            bad = false;
                        lastIndex = newIndex;
                    }
                    if (bad)
                        groups.remove(v);
                    else if (set.size() - firstIndex - elements < elements)
                        groups.remove(v);
                    else
                        v++;
                }
            }
            v = 0;
            while (v < groups.size()) {
                Vector<Integer> setcloned = (Vector<Integer>)set.clone();
                Vector<Integer> group = groups.get(v);
                int i = setcloned.indexOf(group.firstElement());
                while (i >= 0) {
                    setcloned.remove(0);
                    i--;
                }
                for (i = 1; i < group.size(); i++)
                    setcloned.remove(setcloned.indexOf(group.get(i)));
                if (findSameSum(groups.get(v), setcloned))
                    return 0;
                v++;
            }
            System.out.println(groups);
        }
        return sum;
    }

    public static Vector<Integer> ObtenerAdyacencias(Vector<Integer> network, int a) {
        Vector<Integer> adyacencias = new Vector<Integer>();
        int ancho = (int)Math.sqrt((double)network.size());
        for (int index = 0; index < ancho; index++) {
            if (network.get(a * ancho + index) > 0)
                adyacencias.add(index);
        }
        return adyacencias;
    }

    public static int obtenerPeso(Vector<Integer> network) {
        int pesoa = 0;
        int ancho = (int)Math.sqrt((double)network.size());
        for (int j = 1; j < ancho; j++) {
            for (int i = 0; i < j; i++) {
                pesoa += network.get(j * ancho + i);
            }
        }
        return pesoa;
    }

    public static boolean sonAdyacentes(Vector<Integer> network, int a, int b) {
        Vector<Integer> adyacencias = new Vector<Integer>();
        Vector<Integer> done = new Vector<Integer>();
        adyacencias.add(a);
        while (adyacencias.size() > 0) {
            Vector<Integer> nadd = ObtenerAdyacencias(network, adyacencias.get(0));
            done.add(adyacencias.get(0));
            for (Integer i : nadd) {
                if (i == b)
                    return true;
                if (done.contains(i))
                    continue;
                else
                    adyacencias.add(i);
            }
            adyacencias.remove(0);
        }


        return false;
    }

    public static Vector<Integer> minima = new Vector<Integer>();
    public static int peso = Integer.MAX_VALUE;
    public static int pesomax = Integer.MAX_VALUE;
    public static Hashtable<Vector<Integer>, Integer> processed = new Hashtable<Vector<Integer>, Integer>();

    @SuppressWarnings("unchecked")
    public static void desgranar(Tree<Vector<Integer>> nodo) {
        Vector<Integer> network = nodo.getValue();
        int ancho = (int)Math.sqrt((double)network.size());
        for (int j = 1; j < ancho; j++) {
            for (int i = 0; i < j; i++) {
                int pesoa = network.get(j * ancho + i);
                if (pesoa > 0) {
                    Vector<Integer> nnetwork = (Vector<Integer>)network.clone();
                    nnetwork.set(j * ancho + i, 0);
                    nnetwork.set(i * ancho + j, 0);
                    if (!processed.containsKey(nnetwork)) {
                        if (sonAdyacentes(nnetwork, i, j)) {
                            int npeso = obtenerPeso(nnetwork);
                            processed.put(nnetwork, npeso);
                            if (npeso < peso) {
                                minima = nnetwork;
                                peso = npeso;
                            }
                            Tree<Vector<Integer>> branch = new Tree<Vector<Integer>>();
                            branch.setValue(nnetwork);
                            nodo.addBranch(branch);
                            desgranar(branch);
                        }
                    }
                    //else
                    //    System.out.println("Ya procesado!");
                }
            }
        }
    }

/*
         Vector<Integer> network = new Vector<Integer>();
        String text = "";
        try {
            int c;
            int iaux = 0;
            FileReader fr = new FileReader("network.txt");
            while ((c = fr.read()) != -1) {
                if (c == ',') {
                    iaux = 0;
                    if (!text.equals("-"))
                        iaux = Integer.parseInt(text);
                    network.add(iaux);
                    text = "";
                }
                else if (c == 13) {
                    iaux = 0;
                    if (!text.equals("-"))
                        iaux = Integer.parseInt(text);
                    network.add(iaux);
                    text = "";
                }
                else if (c == 10)
                    continue;
                else
                    text += (char)c;
            }
            fr.close();
        }
        catch (Exception e) {}
        peso = obtenerPeso(network);
        pesomax = peso;

        Tree<Vector<Integer>> arbol = new Tree<Vector<Integer>>();
        minima = network;
        processed.put(network, peso);
        arbol.setValue(network);

        // Voy a ir quitando aristas (si es posible)
        // no puedo quitarla si es el único camino que comunica los dos vértices, o sea,
        // o uno de los dos vértices se queda sin aristas adyacentes o
        // ya no existe camino para ir de un vertice al otro por otro lado.
        desgranar(arbol);
        System.out.println("Max = " + pesomax + ", Min = " + peso + ", Saving = " + (pesomax - peso));

 */

    /**
     * Entry point funcion
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Start PE
        // problema 145
        // números reversibles
        // End PE

        // TODO code application logic here
        Object3D o = new Object3D(1.0, 1.0, 0.0);
        Vector3D v = new Vector3D(o);
        Vector3D w = new Vector3D();
        Point3D p = new Point3D(v);
        Point3D pp = new Point3D(1.0, 2.0, 3.0);
        Box3D box = new Box3D(p, pp);
        System.out.println(box + " " + box.inside(p) + " " + box.inside(new Point3D(1,1.5,4)));
        if (o.equals(v))
            System.out.println("Iguales");
        else
            System.out.println("Diferentes");
        p = Point3D.add(pp, v);
        w.set(v);
        w.normalize();
        v.setX(0);
        v.add(w);
        p.add(w);
        Ray3D r = new Ray3D(p, w);
        System.out.println("p = " + p);
        System.out.println("p to pp = " + p.distance(pp));
        System.out.println("w = " + w);
        System.out.println("v = " + v);
        System.out.println("r = " + r);
        System.out.println("r(1.0) = " + r.getPoint(1.0));
        System.out.println(Vector3D.angle(v, w));
        System.out.println(Vector3D.angle(w, v));
        Point3D pk = new Point3D();
        pk.rotate(0.34, p, pp);
        System.out.println("pk = " + pk);
        
        double[][] m = { {1, 0, 1, 2}, 
                         {0, 1, 2, 1},
                         {3, 1, 1, 0},
                         {1, 1, 2, 4} };
        MatrixNxM mat = new MatrixNxM(m);
        System.out.println("Determinante de " + mat + " = " + mat.determinant());
        m[0][0] = 1; m[0][1] = 2; m[0][2] = 0; m[0][3] = 3;
        m[1][0] = 0; m[1][1] = 1; m[1][2] = 0; m[1][3] = 0;
        m[2][0] = 1; m[2][1] = 1; m[2][2] = 1; m[2][3] = 1;
        m[3][0] = 0; m[3][1] = 2; m[3][2] = 1; m[3][3] = 2;
        MatrixNxM mat1 = new MatrixNxM(m);
        System.out.println("Inversa de " + mat1 + " = " + mat1.getInverse());
        m[0][0] = 1; m[0][1] = 2; m[0][2] = 3; m[0][3] = 6;
        m[1][0] = 2; m[1][1] = 4; m[1][2] = 6; m[1][3] = 12;
        m[2][0] = 3; m[2][1] = 6; m[2][2] = 9; m[2][3] = 18;
        m[3][0] = 4; m[3][1] = 8; m[3][2] = 12; m[3][3] = 24;
        MatrixNxM mat2 = new MatrixNxM(m);
        System.out.println("Inversa de " + mat2 + " = " + mat2.getInverse());
        System.out.println("Composicion mat1.mat2 = " + MatrixNxM.mul(mat1, mat2));
        mat1.mul(mat2);
        System.out.println("Composicion mat1.mat2 = " + mat1);
        double[][] mm = { {6,-1, 2}, 
                          {3, 1, 2},
                          {0, 1, 3} };
        System.out.println(MatrixNxM.determinant(mm));
        
        Point3D pt = new Point3D(0, 1, 0);
        mat.toRotation(Math.PI / 2.0, new Object3D(1,0,0));
        p = new Point3D(pt);
        mat.transform(p);
        v = new Vector3D(pt);
        mat.transform(v);
        System.out.println("Rotate PI/2 arround (1,0,0) = " + mat);
        System.out.println("Point transformated = " + p);
        System.out.println("Vector transformated = " + v);
        
        Normal3D n = new Normal3D(p);
        System.out.println("Norma = " + n);
        n = new Normal3D(v);
        System.out.println("Norma = " + n);
        
        m[0][0] = 1; m[0][1] = 2; m[0][2] = 0; m[0][3] = 3;
        m[1][0] = 0; m[1][1] = 1; m[1][2] = 0; m[1][3] = 0;
        m[2][0] = 1; m[2][1] = 1; m[2][2] = 1; m[2][3] = 1;
        m[3][0] = 0; m[3][1] = 2; m[3][2] = 1; m[3][3] = 2;
        mat = new MatrixNxM(m);
        System.out.println("Matrix = " + mat);        
        System.out.println("Inverse = " + mat.getInverse());
        mat.transpose();
        System.out.println("Transpose = " + mat);
        mat.invert();
        System.out.println("Inverse = " + mat);
        
        Box3D b = new Box3D(new Point3D(-1,-1,-1), new Point3D(1,1,1));
        mat.toRotationZ(Math.PI/4);
        mat.transform(b);
        System.out.println(b);
    }

}
