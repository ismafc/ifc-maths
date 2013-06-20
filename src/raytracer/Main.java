/*
 * Main.java
 *
 * Created on 25 de abril de 2005, 22:17
 */

package raytracer;

//import java.io.*;
import java.math.*;
import java.util.*;
//import javax.script.ScriptEngine;
//import javax.script.ScriptEngineManager;

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
        if (n == 1) {
            return false;
        }
        if (n % 2 == 0) {
            return n == 2;
        }
        for (long i = 3; i <= Math.sqrt(Math.abs(n)); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(Long n) {
        return isPrime(n.longValue());
    }

    public static ArrayList<Long> primeFactors(long n) {
        ArrayList<Long> factors = new ArrayList<Long>();
        for (long i = 2; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static HashMap<Long, Long> primeFactorization(long n) {
        HashMap<Long, Long> factors = new HashMap<Long, Long>();
        for (long i = 2; i <= n; i++) {
            long occurrences = 0;
            while (n % i == 0) {
                occurrences++;
                n /= i;
            }
            if (occurrences > 0) {
                factors.put(i, occurrences);
            }
        }
        return factors;
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

    static private void combinacion(int i, long num, ArrayList<Integer> posibles) {
        if (i == 0) {
            num += (long)posibles.get(posibles.size() - 1);
            // Tratamos el número final
        }
        else {
            long nnum = num;
            for (Integer d : posibles) {
                ArrayList<Integer> np = new ArrayList<Integer>(posibles);
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

    private static boolean isPalindrome10L(Long n) {
        Long digits = Math.round(Math.floor(Math.log10(n))) + 1L;
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

    // Lista todos los números sin repetir entre los disponibles con 'digitos' digitos
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

    // Esta el (0,0) dentro del tri�ngulo t?
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

    // Cuenta las apariciones del carácter 'c' en la cadena 's'
    public static int count(String s, char c) {
        if (s == null) {
            return 0;
        }
        int ocur = 0;
        for (char cc : s.toCharArray()) {
            ocur += (cc == c ? 1 : 0);
        }
        return ocur;
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

    public static int getSum(ArrayList<Integer> set, int group, boolean first) {
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
/*
    public static ArrayList<ArrayList<Integer>> expandGroups(ArrayList<Integer> group, ArrayList<Integer> set, int elements) {
        ArrayList<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
        if (elements > 0) {
            for (int i = 0; i < set.size(); i++) {
                ArrayList<Integer> newg = (ArrayList<Integer>)group.clone();
                newg.add(set.get(i));
                groups.add(newg);
                ArrayList<Integer> setclone = (ArrayList<Integer>)set.clone();
                for (int index = 0; index <= i; index++)
                    setclone.remove(0);
                groups.addAll(expandGroups(newg, setclone, elements - 1));
                //groups.remove(0);
            }
        }
        return groups;
    }

    public static int getSum(ArrayList<Integer> v) {
        int s = 0;
        for (Integer i : v)
            s += i;
        return s;
    }

    public static boolean findSameSum(ArrayList<Integer> group, ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
        groups.addAll(expandGroups(new ArrayList<Integer>(), set, group.size()));
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


    public static int analizeSet(ArrayList<Integer> set) {
        int sum = 0;
        // No puede haber dos iguales
        for (int i = 0; i < set.size() - 1; i++) {
            sum += set.get(i);
            if (set.get(i) == set.get(i + 1))
                return 0;
        }
        sum += set.get(set.size() - 1);
        
        // Comprovar que si tienen m�s elementos, la suma es mayor
        // Se comprueba el peor caso de cada subgrupo, por ejemplo, de un subgrupo de 3 se mira
        // que la suma de los 3 menores sea mayor o igual que la suma de los 2 mayores
        // Con eso se aseguro que todos los subgrupos 3,2 cumplen la premisa.
        // As� para todos los subgrupos n, n-1
        for (int group = 2; group <= set.size() / 2 + (set.size() % 2); group++) {
            if (getSum(set, group, true) <= getSum(set, group - 1, false)) {
                System.out.println("Se encontr� subgrupo m�s grande (" + group + ") con suma menor: " + set);
                //int index = (set.size() % 2 == 0) ? (set.size() / 2 - 1) : set.size() / 2;
                //int maxsum = set.get(index) * index;
                //System.out.println(maxsum);
                return 0;
            }
        }
        // Comprobar sumas de subgrupos diferentes
        // Solo quedan los subconjuntos con el mismo n�mero de elementos
        System.out.println("Analizando: " + set);
        for (int elements = 2; elements <= set.size() / 2; elements++) {
            ArrayList<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
            groups.addAll(expandGroups(new ArrayList<Integer>(), set, elements));
            int v = 0;
            while (v < groups.size()) {
                if (groups.get(v).size() < elements)
                    groups.remove(v);
                else {
                    ArrayList<Integer> group = groups.get(v);
                    int firstIndex = set.indexOf(group.get(0));
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
                ArrayList<Integer> setcloned = (ArrayList<Integer>)set.clone();
                ArrayList<Integer> group = groups.get(v);
                int i = setcloned.indexOf(group.get(0));
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
*/
    public static ArrayList<Integer> ObtenerAdyacencias(ArrayList<Integer> network, int a) {
        ArrayList<Integer> adyacencias = new ArrayList<Integer>();
        int ancho = (int)Math.sqrt((double)network.size());
        for (int index = 0; index < ancho; index++) {
            if (network.get(a * ancho + index) > 0)
                adyacencias.add(index);
        }
        return adyacencias;
    }

    public static int obtenerPeso(ArrayList<Integer> network) {
        int pesoa = 0;
        int ancho = (int)Math.sqrt((double)network.size());
        for (int j = 1; j < ancho; j++) {
            for (int i = 0; i < j; i++) {
                pesoa += network.get(j * ancho + i);
            }
        }
        return pesoa;
    }

    public static boolean sonAdyacentes(ArrayList<Integer> network, int a, int b) {
        ArrayList<Integer> adyacencias = new ArrayList<Integer>();
        ArrayList<Integer> done = new ArrayList<Integer>();
        adyacencias.add(a);
        while (adyacencias.size() > 0) {
            ArrayList<Integer> nadd = ObtenerAdyacencias(network, adyacencias.get(0));
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

    public static Triangle chooseMinimumEdge(ArrayList<Integer> network, ArrayList<Integer> vnodes) {
        Triangle min = new Triangle();
        min.coord[2] = Double.MAX_VALUE;
        int ancho = (int)Math.sqrt((double)network.size());
        for (Integer node : vnodes) {
            for (int index = 0; index < ancho; index++) {
                if (network.get(node * ancho + index) == 0)
                    continue;
                if (min.coord[2] > network.get(node * ancho + index) &&
                    !vnodes.contains(index)) {
                    min.coord[0] = index;
                    min.coord[1] = node;
                    min.coord[2] = network.get(node * ancho + index);
                }
            }
        }
        vnodes.add((int)min.coord[0]);
        network.set((int)(min.coord[1] * ancho + min.coord[0]), 0);
        network.set((int)(min.coord[0] * ancho + min.coord[1]), 0);
        return min;
    }

    public static void ejercicio110() {
        // 1/x + 1/y = 1/n
        // Número de soluciones para un 'n' determinado (menor 'n' para el que hay más de 4 millones de solucines
        // - x > n
        // - y > n
        // n + 1 <= x <= n(n+1)
        // relacionado con la descomposición en factores
        long solutions = 0;
        //long n = 2*2*2*2*2*3*3*3*3*5*5*5*5*7*7*11;
        // 2*2=3            (4)
        // 2*3=5            (6)
        // 2*2*2=4          (8)
        // 3*3=3            (9)
        // 2*5=5            (10)
        // 2*2*3=8          (12)
        // 2*7=5            (14)
        // 3*5=5            (15)
        // 2*2*2*2=5        (16)
        // 3*3*2=8          (18)
        // 3*3*2*2=8        (36)

        long n = Long.MAX_VALUE;
        n = 2*2*2*3*3;
        long lastx = n * (n + 1);
        for (long x = n + 1; x <= lastx; x++) {
            if (x * n % (x - n) == 0) {
                //System.out.println("1/" + x + " + 1/" + (x * n / (x - n)) + " = 1/" + n);
                lastx = x * n / (x - n);
                solutions++;
            }
            else
                lastx = x * n / (x - n) + 1;
        }
        System.out.println("Solutions for n = " + n + " = " + solutions);
    }

/*      Leer un grafo poderado desde fichero
 *
        ArrayList<Integer> network = new ArrayList<Integer>();
        String text = "";
        int aristas = 0;
        try {
            int c;
            int iaux = 0;
            FileReader fr = new FileReader("network.txt");
            while ((c = fr.read()) != -1) {
                if (c == ',') {
                    iaux = 0;
                    if (!text.equals("-"))
                        iaux = Integer.parseInt(text);
                    if (iaux != 0)
                        aristas++;
                    network.add(iaux);
                    text = "";
                }
                else if (c == 13) {
                    iaux = 0;
                    if (!text.equals("-"))
                        iaux = Integer.parseInt(text);
                    network.add(iaux);
                    if (iaux != 0)
                        aristas++;
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
        int peso = obtenerPeso(network);
        aristas /= 2;
        System.out.println("Red con " + aristas + " aristas");
        for (int j = 1; j < 40; j++) {
           for (int i = 1; i < 40; i++) {
                if (!sonAdyacentes(network, i, j))
                    System.out.println("No son adyacentes!");
            }
        }
    */

/*
 *      Encontrar �rbol m�nimo
 *
        ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
        ArrayList<Triangle> visitedEdges = new ArrayList<Triangle>();
        visitedNodes.add(0);
        int ancho = (int)Math.sqrt((double)network.size());
        int npeso = 0;
        while (visitedNodes.size() < ancho) {
            visitedEdges.add(chooseMinimumEdge(network, visitedNodes));
            npeso += visitedEdges.lastElement().coord[2];
        }
        System.out.println("Peso = " + peso + "; Peso min = " + npeso + "; dif = " + (peso - npeso));
*/

/* DARDOS!!!
    public static boolean alreadyIn(ArrayList<Triangle> combs, Triangle c) {
        for (Triangle cc : combs) {
            if (cc.coord[0] == c.coord[2] && cc.coord[2] == c.coord[0])
                return true;
        }
        return false;
    }

        1.- Debe acabar con un doble. Empezamos por ah� como �ltima tirada.
            para cada doble, si lo que queda es < 0 o 1 = kk y paramos. Si es 0 hemos llegado.
        2.- Para cada caso positivo de los anteriores iniciamos el segundo paso (pen�ltima tirada)
            con lo que queda por sumar. Restamos los simples, dobles y triples. Si es < 0 = kk y
            paramos. Si es 0 hemos llegado. Si lo que queda por restar > 60 kk y paramos.
        3.- Para cada caso de los anteriores probamos todas las opciones que den 0.
            Comprobar posibles repeticiones en el orden de las dos primeras tiradas.

        int totalc = 0;
        for (int score = 2; score < 100; score++) {
            ArrayList<Triangle> combinations = new ArrayList<Triangle>();
            ArrayList<Triangle> combinations1 = new ArrayList<Triangle>();
            int rest;
            for (int points = 1; points <= 20; points++) {
                rest = score - points * 2;
                if (rest < 0)
                    break;
                else if (rest >= 0) {
                    Triangle c = new Triangle();
                    c.coord[4] = 200 + points;
                    c.coord[5] = 2 * points;
                    if (rest == 0)
                        combinations.add(c);
                    else
                        combinations1.add(c);
                }
            }
            rest = score - 25 * 2;
            if (rest >= 0) {
                Triangle c = new Triangle();
                c.coord[4] = 200 + 25;
                c.coord[5] = 2 * 25;
                if (rest == 0)
                    combinations.add(c);
                else
                    combinations1.add(c);
            }

            // Ahora desplegamos la combinaciones incompletas de una tirada
            ArrayList<Triangle> combinations2 = new ArrayList<Triangle>();
            int newscore;
            for (Triangle c : combinations1) {
                newscore = score - (int)c.coord[5];
                for (int points = 1; points <= 20; points++) {
                    rest = newscore - points;
                    if (rest >= 0) {
                        Triangle cc = new Triangle();
                        cc.coord[2] = 100 + points;
                        cc.coord[3] = points;
                        cc.coord[4] = c.coord[4];
                        cc.coord[5] = c.coord[5];
                        if (rest == 0)
                            combinations.add(cc);
                        else
                            combinations2.add(cc);
                    }
                    else
                        break;
                    rest = newscore - points * 2;
                    if (rest >= 0) {
                        Triangle cc = new Triangle();
                        cc.coord[2] = 200 + points;
                        cc.coord[3] = 2 * points;
                        cc.coord[4] = c.coord[4];
                        cc.coord[5] = c.coord[5];
                        if (rest == 0)
                            combinations.add(cc);
                        else
                            combinations2.add(cc);
                    }
                    else
                        continue;
                    rest = newscore - points * 3;
                    if (rest >= 0) {
                        Triangle cc = new Triangle();
                        cc.coord[2] = 300 + points;
                        cc.coord[3] = 3 * points;
                        cc.coord[4] = c.coord[4];
                        cc.coord[5] = c.coord[5];
                        if (rest == 0)
                            combinations.add(cc);
                        else
                            combinations2.add(cc);
                    }
                }

                int points = 25;
                rest = newscore - points;
                if (rest >= 0) {
                    Triangle cc = new Triangle();
                    cc.coord[2] = 100 + points;
                    cc.coord[3] = points;
                    cc.coord[4] = c.coord[4];
                    cc.coord[5] = c.coord[5];
                    if (rest == 0)
                        combinations.add(cc);
                    else
                        combinations2.add(cc);
                }
                rest = newscore - points * 2;
                if (rest >= 0) {
                    Triangle cc = new Triangle();
                    cc.coord[2] = 200 + points;
                    cc.coord[3] = 2 * points;
                    cc.coord[4] = c.coord[4];
                    cc.coord[5] = c.coord[5];
                    if (rest == 0)
                        combinations.add(cc);
                    else
                        combinations2.add(cc);
                }
            }

            // Ahora desplegamos la combinaciones incompletas de dos tiradas
            for (Triangle c : combinations2) {
                newscore = score - (int)c.coord[5] - (int)c.coord[3];
                for (int points = 1; points <= 20; points++) {
                    rest = newscore - points;
                    if (rest == 0) {
                        Triangle cc = new Triangle();
                        cc.coord[0] = 100 + points;
                        cc.coord[1] = points;
                        cc.coord[2] = c.coord[2];
                        cc.coord[3] = c.coord[3];
                        cc.coord[4] = c.coord[4];
                        cc.coord[5] = c.coord[5];
                        if (!alreadyIn(combinations, cc))
                            combinations.add(cc);
                    }
                    rest = newscore - points * 2;
                    if (rest == 0) {
                        Triangle cc = new Triangle();
                        cc.coord[0] = 200 + points;
                        cc.coord[1] = 2 * points;
                        cc.coord[2] = c.coord[2];
                        cc.coord[3] = c.coord[3];
                        cc.coord[4] = c.coord[4];
                        cc.coord[5] = c.coord[5];
                        if (!alreadyIn(combinations, cc))
                            combinations.add(cc);
                    }
                    rest = newscore - points * 3;
                    if (rest == 0) {
                        Triangle cc = new Triangle();
                        cc.coord[0] = 300 + points;
                        cc.coord[1] = 3 * points;
                        cc.coord[2] = c.coord[2];
                        cc.coord[3] = c.coord[3];
                        cc.coord[4] = c.coord[4];
                        cc.coord[5] = c.coord[5];
                        if (!alreadyIn(combinations, cc))
                            combinations.add(cc);
                    }
                }
                int points = 25;
                rest = newscore - points;
                if (rest == 0) {
                    Triangle cc = new Triangle();
                    cc.coord[0] = 100 + points;
                    cc.coord[1] = points;
                    cc.coord[2] = c.coord[2];
                    cc.coord[3] = c.coord[3];
                    cc.coord[4] = c.coord[4];
                    cc.coord[5] = c.coord[5];
                    if (!alreadyIn(combinations, cc))
                        combinations.add(cc);
                }
                rest = newscore - points * 2;
                if (rest == 0) {
                    Triangle cc = new Triangle();
                    cc.coord[0] = 200 + points;
                    cc.coord[1] = 2 * points;
                    cc.coord[2] = c.coord[2];
                    cc.coord[3] = c.coord[3];
                    cc.coord[4] = c.coord[4];
                    cc.coord[5] = c.coord[5];
                    if (!alreadyIn(combinations, cc))
                        combinations.add(cc);
                }
            }
            totalc += combinations.size();
            System.out.println(score + " -> Combinations = " + combinations.size());
        }
        System.out.println("Total combinations = " + totalc);
*/

    public static long combinaciones(long ltotal, long lmin) {
        long total = 0;
        for (long l = lmin; l <= ltotal; l++) {
            total += (ltotal - l + 1);
            if (ltotal - l <= lmin)
                continue;
            for (long i = 0; i < (ltotal - l + 1); i++) {
                total += combinaciones(ltotal - l - 1 - i, lmin);
            }
        }
        return total;
    }

    static private boolean isReversible(long n) {
        long nn = Long.valueOf(rotate(Long.toString(n))) + n;
        long digits = (long)Math.log10(nn) + 1;
        long dd;
        for (long d = 0; d < digits; d++) {
            if ((nn / (long)Math.pow(10, d)) % 2 == 0)
                return false;
        }
        return true;
    }

    // Start PE 123
    // ((Pn-1)^n + (Pn+1)^n) mod Pn^2 > 10^10
    // encontrar n (Pn es el primo n-esimo)
    static int problem123() {
        BigInteger pn = new BigInteger("100001");
        BigInteger order = new BigInteger("9593"); // Del primo 100003
        BigInteger limit = new BigInteger("10000000000");
        while (true) {
            if (isPrime(pn.longValue())) {
                BigInteger pn_1 = pn.subtract(BigInteger.ONE).pow(order.intValue());
                BigInteger pn1 = pn.add(BigInteger.ONE).pow(order.intValue());
                BigInteger pn2 = pn.multiply(pn);
                BigInteger r = pn_1.add(pn1).mod(pn2);
                if (r.compareTo(limit) == 1) {
                    return order.intValue();
                }
                order = order.add(BigInteger.ONE);
            }
            pn = pn.add(BigInteger.ONE);
        }
    }

    // Start PE 125
    // Suma de los palíndrimos < 'to' que son suma de cuadrados (2 o más)
    static long problem125(long to) {
        long sum = 0L;
        for (long pa = 1L; pa < to; pa++) {
            if (isPalindrome10L(pa)) {
                long n = Math.round(Math.floor(Math.sqrt(pa)));
                long s = (n * (n + 1) * (2 * n + 1) / 6);
                while (s > pa && n > 0) {
                    long nn = n;
                    long sumaux = nn * nn;
                    while (sumaux < pa || nn == 1) {
                        nn--;
                        sumaux += (nn * nn);
                    }
                    if (sumaux == pa) {
                        if (nn < n) {
                            sum += pa;
                            System.out.println(pa + " = " + nn + " to " + n);
                        }
                        break;
                    }
                    n--;
                    s = (n * (n + 1) * (2 * n + 1) / 6);
                }
                if (s == pa && 1 < n) {
                    System.out.println(pa + " = " + 1 + " to " + n);
                    sum += pa;
                }
                // n1(n1+1)(2n1+1)/6 - n2(n2+1)(2n2+1)/6 = pa
            }
        }
        System.out.println(sum);
        return sum;
    }

    // Ejercicio 121!!
    static long probabilidades = 0;
    
    public static void sumaProbabilidades(String base) {
        long i = 1L;
        long mul = 1L;
        for (char c : base.toCharArray()) {
            if (c == 'N') {
                mul = mul * i;
            }
            i++;
        }
        probabilidades += mul;
    }
    
    public static void binomial(long m, long n, String base) {
        long a = m - n;
        if (count(base, 'N') >= n) {
            while (base.length() < m)
                base += 'A';
            sumaProbabilidades(base);
            System.out.println(base + "(" + probabilidades + ")");
        }
        else if (count(base, 'A') >= a) {
            while (base.length() < m)
                base += 'N';
            sumaProbabilidades(base);
            System.out.println(base + "(" + probabilidades + ")");
        }
        else {
            String baseA = base + 'A';
            String baseN = base + 'N';
            binomial(m, n, baseA);
            binomial(m, n, baseN);
        }
    }

    // Start PE 121
    // Juego de la bolsa con bolas rojas y azules
    static public void ejercicio121() {
        long m = 15;
        for (long n = 0; n < ((m % 2 == 0) ? (m / 2) : (m / 2 + 1)); n++) {
            binomial(m, n, "");
        }
        long f = factorial(m + 1L);
        double premio = (double)probabilidades / (double)f;
        System.out.println(probabilidades + " Sobre " + f + " = " + premio + " (" + (1.0 / premio) + ")");
    }

    static public boolean isIn(Point3D c, Point3D p) {
        if (p.x < 0 || p.y < 0 || p.z < 0)
            return false;
        if (p.x >= c.x || p.y >= c.y || p.z >= c.z)
            return false;
        return true;
    }
    
    // Start PE 126
    // Capas de cuboides 
    // Para cada coordenada (x,y,depth) intentamos cubrir los 6 lados: 
    // (x+1,y,depth), (x-1,y,depth), (x,y+1,depth), (x,y-1,depth), (x,y,depth+1), (x,y,depth-1)
    // Descartando los que ya estén
    static public void ejercicio126() {
        //C tiene cuantas capas (value) tienen x cubos (key) -> C(22)=2; C(46)=4;
        HashMap<Integer, Integer> C = new HashMap<>();

        // Máximo número de cubos en la capa 
        int MAX_CUBES_IN_LAYER = 20000;
        int FACE_FACTOR = 1;
        
        // Almacenamos para cada cuboide (x,y,depth) un hash con todos los cubos calculados hasta el momento
        HashMap<Point3D, HashMap<Point3D, Boolean>> todas_las_capas = new HashMap<>();

        // Almacenamos para cada cuboide (x,y,depth) un hash con todos los cubos de la última capa
        HashMap<Point3D, HashMap<Point3D, Boolean>> ultimas_capas = new HashMap<>();
        
        int width = 1;
        while (width <= MAX_CUBES_IN_LAYER / FACE_FACTOR) {
            for (int height = 1; height <= width; height++) {
                if ((width * height * 2 + width * 1 * 2 + height * 1 * 2) > MAX_CUBES_IN_LAYER)
                    break;
                for (int depth = 1; depth <= height; depth++) {
                    // Cuboide inicial de width.height.depth

                    int lastCubos = width * height * 2 + width * depth * 2 + height * depth * 2;
                    int lastDiff = 0;
                    if (lastCubos > MAX_CUBES_IN_LAYER)
                        break;

                    // Puntos del cuboide original (width, height, depth) 
                    // si es la primera capa hay que añadir
                    // los puntos del cuboide original
                    Point3D cuboide = new Point3D(width, height, depth);
                    if (!todas_las_capas.containsKey(cuboide)) {
                        HashMap<Point3D, Boolean> dots = new HashMap<>();
                        for (int xx = 0; xx < width; xx++) {
                            for (int yy = 0; yy < height; yy++) {
                                for (int zz = 0; zz < depth; zz++) {
                                    if (xx == 0) {
                                        Point3D p = new Point3D(xx - 1, yy, zz);
                                        dots.put(p, Boolean.TRUE);
                                    }
                                    if (yy == 0) {
                                        Point3D p = new Point3D(xx, yy - 1, zz);
                                        dots.put(p, Boolean.TRUE);
                                    }
                                    if (zz == 0) {
                                        Point3D p = new Point3D(xx, yy, zz - 1);
                                        dots.put(p, Boolean.TRUE);
                                    }
                                    if (xx == width - 1) {
                                        Point3D p = new Point3D(width, yy, zz);
                                        dots.put(p, Boolean.TRUE);
                                    }
                                    if (yy == height - 1) {
                                        Point3D p = new Point3D(xx, height, zz);
                                        dots.put(p, Boolean.TRUE);
                                    }
                                    if (zz == depth - 1) {
                                        Point3D p = new Point3D(xx, yy, depth);
                                        dots.put(p, Boolean.TRUE);
                                    }
                                }
                            }
                        }
                        todas_las_capas.put(cuboide, dots);
                        ultimas_capas.put(cuboide, dots);
                    }

                    // Sumamos 1 al número de capas con ese número de cubos
                    C.put(lastCubos, !C.containsKey(lastCubos) ? 1 : C.get(lastCubos) + 1);
                    System.out.println("(" + width + "," + height + "," + depth + ") = " + lastCubos + " (" + lastDiff + ")");
                    // Mientras la última capa del cuboide tenga más de 'MAX_CUBES_IN_LAYER' 
                    // cubos, seguimos calculando capas
                    while (lastCubos < MAX_CUBES_IN_LAYER) {
                    
                        // Calculamos la nueva capa para el cuboide base (width, height, depth)
                        // Los cubos de la nueva capa van en 'dotsc'
                        // En 'dots' tenemos los cubos totales para el cuboide base (width, height, depth)
                        HashMap<Point3D, Boolean> ultima = (HashMap<Point3D, Boolean>)ultimas_capas.get(cuboide).clone();
                        HashMap<Point3D, Boolean> dotsc = new HashMap<>();
                        ultimas_capas.put(cuboide, dotsc);
                        HashMap<Point3D, Boolean> dots = todas_las_capas.get(cuboide);
                        Point3D pp;

                        for (Point3D p : ultima.keySet()) {
                            pp = new Point3D(p.x - 1, p.y, p.z);
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.x + 1, p.y, p.z);
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.x, p.y - 1, p.z);
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.x, p.y + 1, p.z);
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.x, p.y, p.z - 1);
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.x, p.y, p.z + 1);                            
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                        }
                        int cubos = dotsc.size();
                        int diff = cubos - lastCubos;
                        dots.clear();
                        dots.putAll(ultima);
                        dots.putAll(dotsc);

                        // Sumamos 1 al número de capas con ese número de cubos
                        C.put(cubos, !C.containsKey(cubos) ? 1 : C.get(cubos) + 1);
                        System.out.println("(" + width + "," + height + "," + depth + ") = " + cubos + " (" + diff + ")");
                        lastCubos = cubos;
                        if (diff - lastDiff == 8) {
                            lastDiff = diff;
                            break;
                        }
                        lastDiff = diff;
                    }
                    // Calculamos con la fórmula
                    while (lastCubos <= MAX_CUBES_IN_LAYER) {
                        lastCubos = lastCubos + lastDiff + 8;
                        // Sumamos 1 al número de capas con ese número de cubos
                        C.put(lastCubos, !C.containsKey(lastCubos) ? 1 : C.get(lastCubos) + 1);
                        lastDiff = lastDiff + 8;
                        System.out.println("(" + width + "," + height + "," + depth + ") = " + lastCubos + " (" + lastDiff + ")");
                    }
                    
                    todas_las_capas.remove(cuboide);
                    ultimas_capas.remove(cuboide);
                }
            }
            width++;
        }
        for (Integer n : C.keySet()) {
            System.out.println("C(" + n + ")=" + C.get(n));
        }
    }
    
    public static long rad(long r) {
        long result = 1;
        for (Long pf : primeFactors(r)) {
            result *= pf;
        }
        return result;
    }

    // Es lentísimo (1 semana ejecutándose)
    static public void ejercicio127() {
        long MAX_C = 120000;
        long sc = 0;
        long a = 1;
        while (a < MAX_C / 2) {
            long offsetb = (a % 2 == 0) ? 2 : 1;
            long b = a + 1;
            long c = a + b;
            while (c < MAX_C) {
                if (MCD(a, b) == 1) {
                    if (MCD(a, c) == 1) {
                        if (MCD(b, c) == 1) {
                            long r = rad(a * b * c);
                            if (r < c) {
                                System.out.println("(" + a + "," + b + "," + c + ") = " + r);
                                sc += c;
                            }
                        }         
                    }
                }
                b += offsetb;
                c = a + b;
            }
            a++;
        }
        System.out.println("Suma de c = " + sc);
    }
    
    /**
     * Entry point funcion
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Start PE 128
        // Hexagonal tile differences
        // Cada número tiene 6 adyacentes "MatrixNxM(1,6)"
        
        // Exploramos estas capas
        int MAX_CAPAS = 10;
        
        // Se guardan los valores generales de cada capa (número de valores, valor inicial y valor final)
        ArrayList<Point3D> valores_capa = new ArrayList<Point3D>();

        // Se guardan los valores adyacentes de cada valor (el indice en el vector + 1 es el valor)
        ArrayList<MatrixNxM> adyacentes = new ArrayList<MatrixNxM>();
        
        // La capa 0 tiene 1 valor, empieza en 1 y acaba en 1
        // El primer valor (1) tiene como adyacentes a 2,3,4,5,6 y 7
        valores_capa.add(new Point3D(1, 1, 1));
        adyacentes.add(new MatrixNxM(new double[][]{{2, 3, 4, 5, 6, 7}}));
        
        while (valores_capa.size() < MAX_CAPAS) {
            int capa = valores_capa.size();
            int primero = (int)valores_capa.get(capa - 1).z + 1;
            int ultimo = primero + capa * 6 - 1;
            valores_capa.add(new Point3D(capa * 6, primero, ultimo));
            int step = 0;
            int primeroPrevious = (int)valores_capa.get(capa - 1).y;
            int ultimoPrevious = (int)valores_capa.get(capa - 1).z;
            int primeroNext = ultimo + 1;
            int ultimoNext = primeroNext + (capa + 1) * 6 - 1;
            int previous = primeroPrevious;
            int next = primeroNext;
            for (int valor = primero; valor <= ultimo; valor++) {
                if (step == 0) {
                    // Tiene tres "hijos" (sólo un padre)
                    adyacentes.add(new MatrixNxM(new double[][]{{previous, 
                                                                 (valor == primero) ? ultimo : valor - 1, 
                                                                 (valor == ultimo) ? primero : valor + 1, 
                                                                 (next == primeroNext) ? ultimoNext : next - 1, 
                                                                 next, 
                                                                 next + 1}}));
                    next += 2;
                }
                else {
                    // Tiene dos "hijos" (dos padres)
                    adyacentes.add(new MatrixNxM(new double[][]{{previous, 
                                                                 (previous == ultimoPrevious) ? primeroPrevious : previous + 1,
                                                                 (valor == primero) ? ultimo : valor - 1, 
                                                                 (valor == ultimo) ? primero : valor + 1, 
                                                                 (next == primeroNext) ? ultimoNext : next - 1, 
                                                                 next}}));
                    next++;
                    previous++;
                }
                step = (step + 1) % capa;
            }
        }
        
        // End PE

        // Code application logic here
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
