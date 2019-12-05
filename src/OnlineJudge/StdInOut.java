/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OnlineJudge;

import java.io.IOException;

/**
 *
 * @author ismael.flores
 */
public class StdInOut {
    
    public static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return null;
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        if (lg == 0) 
            return null;
        else
            return new String (lin, 0, lg);
    }
    
}
