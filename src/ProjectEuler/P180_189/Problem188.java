/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P180_189;

import java.math.BigInteger;

/**
 *
 * @author ismael.flores
 */
public class Problem188 {
    
    //The hyperexponentiation of a number
    //
    //The hyperexponentiation or tetration of a number a by a positive integer b, denoted by a↑↑b or ^ba, is recursively defined by:
    //
    //a↑↑1 = a,
    //a↑↑(k+1) = a^(a↑↑k).
    //
    //Thus we have e.g. 3↑↑2 = 3^3 = 27, hence 3↑↑3 = 3^27 = 7625597484987 and 3↑↑4 is roughly 10^3.6383346400240996*10^12.
    //
    //Find the last 8 digits of 1777↑↑1855.
    public static void problem188() {
        //1.- 1777
        //2.- 3157729
        //3.- 5611284433
        //4.- 9971252437441
        //5.- 17718915581332657
        //6.- 31486512988028131489
        //7.- 55951533579725989655953
        //8.- 99425875171173083618628481
        //9.- 176679780179174569590302810737
        //10.- 313959969378393210161968094679649
        //11.- 557906865585404734457817304245736273
        //12.- 991400500145264213131541349644673357121
        //13.- 1761718688758134506734748978318584555604017
        //14.- 3130574109923205018467648934472124755308338209
        //15.- 5563030193333535317817012156556965690182916997393
        //16.- 9885504653553692259760830602201728031455043504367361
        //17.- 17566541769364911145594995980112470711895612307260800497
        //18.- 31215744724161447105722307856659860455038503070002442483169
        //19.- 55470378374834891506868541061284572028603419955394340292591313
        //20.- 98570862372081602207705397465902684494828277260735742699934763201
        /*
        BigInteger B1 = new BigInteger("1777");
        BigInteger N1 = new BigInteger("1777");
        for (long K = 0; K < 20; K++) {
            System.out.println((K+1) + ".- " + N1.toString());
            N1 = N1.multiply(B1);
        }
        */
        
        // Cada las siguientes posiciones se repiten los 1,2,3, ..., 8 últimos dígitos
        // 4, 20, 100, 500, 2500, 12500, 62500, 312500
        
        // 1777^1777 mod 100000000 = 87955697
        // 1777^87955697 mod 100000000 = 99034097
        // 1777^99034097 mod 100000000 = 01402097
        // 1777^1402097 mod 100000000 = 84762097
        // 1777^84762097 mod 100000000 = 71962097
        // 1777^71962097 mod 100000000 = 15962097
        // 1777^15962097 mod 100000000 = 95962097
        // 1777^95962097 mod 100000000 = 95962097
        // ...
        BigInteger BASE = new BigInteger("1777");
        BigInteger N = new BigInteger("1777");
        BigInteger M8 = new BigInteger("100000000");
        N = N.pow(BASE.intValue()).mod(M8);
        System.out.println(N.toString());
        BigInteger last = N;
        while (true) {
            N = BASE.pow(N.intValue()).mod(M8);
            System.out.println(N.toString());
            if (N.compareTo(last) == 0)
                break;
            last = N;
        }
        System.out.println(N.toString());        
    }
}
