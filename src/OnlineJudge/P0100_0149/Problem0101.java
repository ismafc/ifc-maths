/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OnlineJudge.P0100_0149;

import OnlineJudge.StdInOut;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author ismael.flores
 */
public class Problem0101 {
    /*
    The Blocks Problem 
    
    Background 
    Many areas of Computer Science use simple, abstract domains for both analytical and empirical studies. 
    For example, an early AI study of planning and robotics (STRIPS) used a block world in which a robot arm performed tasks involving the manipulation of blocks.
    In this problem you will model a simple block world under certain rules and constraints. 
    Rather than determine how to achieve a specified state, you will ``program'' a robotic arm to respond to a limited set of commands.

    The Problem 
    The problem is to parse a series of commands that instruct a robot arm in how to manipulate blocks that lie on a flat table. 
    Initially there are n blocks on the table (numbered from 0 to n-1) with block bi adjacent to block bi+1 for all  0 <= i < n-1 as shown in the diagram below:
 
    -------------------------     -------
    |     |     |     |     |     |     |
    |  0  |  1  |  2  |  3  | ... | n-1 |
    |     |     |     |     |     |     |
    -------------------------     -------
    Figure: Initial Blocks World

    The valid commands for the robot arm that manipulates blocks are:

    move a onto b
    where a and b are block numbers, puts block a onto block b after returning any blocks that are stacked on top of blocks a and b to their initial positions.

    move a over b
    where a and b are block numbers, puts block a onto the top of the stack containing block b, 
    after returning any blocks that are stacked on top of block a to their initial positions.

    pile a onto b
    where a and b are block numbers, moves the pile of blocks consisting of block a, and any blocks that are stacked above block a, onto block b.
    All blocks on top of block b are moved to their initial positions prior to the pile taking place. The blocks stacked above block a retain their order when moved.

    pile a over b
    where a and b are block numbers, puts the pile of blocks consisting of block a, and any blocks that are stacked above block a, onto the top of the stack containing block b. 
    The blocks stacked above block a retain their original order when moved.

    quit
    terminates manipulations in the block world.

    Any command in which a = b or in which a and b are in the same stack of blocks is an illegal command. 
    All illegal commands should be ignored and should have no affect on the configuration of blocks.

    The Input 

    The input begins with an integer n on a line by itself representing the number of blocks in the block world. You may assume that 0 < n < 25.
    The number of blocks is followed by a sequence of block commands, one command per line. Your program should process all commands until the quit command is encountered.

    You may assume that all commands will be of the form specified above. There will be no syntactically incorrect commands.

    The Output 

    The output should consist of the final state of the blocks world. 
    Each original block position numbered i (0 <= i < n where n is the number of blocks) should appear followed immediately by a colon. 
    If there is at least a block on it, the colon must be followed by one space, 
    followed by a list of blocks that appear stacked in that position with each block number separated from other block numbers by a space. 
    Don't put any trailing spaces on a line.

    There should be one line of output for each block position (i.e., n lines of output where n is the integer on the first line of input).

    Sample Input 

    10
    move 9 onto 1
    move 8 over 1
    move 7 over 1
    move 6 over 1
    pile 8 over 6
    pile 8 over 5
    move 2 over 1
    move 4 over 9
    quit
    
    Sample Output 

    0: 0
    1: 1 9 2 4
    2:
    3: 3
    4:
    5: 5 8 7 6
    6:
    7:
    8:
    9:
    */

    private static void printState(HashMap<Integer, ArrayList<Integer>> blocks, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print (i + ":");
            for (int p : blocks.get(i))
                System.out.print (" " + p);
            System.out.println ();
        }
    }
    
    public static void problem0101() {
        String input = StdInOut.ReadLn (255);
        StringTokenizer idata = null;
        int n;
        String c1, c2;
        int p1, p2;
        HashMap<Integer, ArrayList<Integer>> blocks = new HashMap<Integer, ArrayList<Integer>>();   //la pila key 'i' (base) es el array dado
        HashMap<Integer, Integer> pile = new HashMap<Integer, Integer>();                           // El bloque key 'i' está en la pila 'j' (key de blocks = base)

        if (input == null)
            return;
        
        idata = new StringTokenizer (input);
        if (idata.countTokens() != 1)
            return;
        
        n = Integer.parseInt (idata.nextToken());
        if (n == 0)
            return;
        
        // Initialization
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> p = new ArrayList<Integer>();
            p.add(i);
            blocks.put(i, p);
            pile.put(i, i);
        }
        
        while ((input = StdInOut.ReadLn (255)) != null)
        {
            idata = new StringTokenizer (input);
            if (idata.countTokens() == 1 && idata.nextToken().equals("quit"))
                break;
            
            if (idata.countTokens() != 4)
                continue;
            
            c1 = idata.nextToken();
            p1 = Integer.parseInt (idata.nextToken());
            c2 = idata.nextToken();
            p2 = Integer.parseInt (idata.nextToken());
            
            if (p1 != p2 && pile.get(p1) != pile.get(p2)) {
                if (c1.equals("move") && c2.equals("onto"))
                    moveOnto(p1, p2, blocks, pile);
                else if (c1.equals("move") && c2.equals("over"))
                    moveOver(p1, p2, blocks, pile);
                else if (c1.equals("pile") && c2.equals("onto"))
                    pileOnto(p1, p2, blocks, pile);
                else if (c1.equals("pile") && c2.equals("over"))
                    pileOver(p1, p2, blocks, pile);
            }            
        }

        printState(blocks, n);
    }

    private static void desapilar(int p, HashMap<Integer, ArrayList<Integer>> blocks, HashMap<Integer, Integer> pile) {
        int block = pile.get(p);
        
        // Hay que desapilar lo que hay sobre p, que está en la pila de 'block'
        ArrayList<Integer> pila = blocks.get(block);
        int i = pila.indexOf(p);
        for (int j = pila.size() - 1; j > i; j--) {
            ArrayList<Integer> pAux = new ArrayList<Integer>();
            pAux.add(pila.get(j));
            blocks.put(pila.get(j), pAux);
            pile.put(pila.get(j), pila.get(j));
        }
        int s = pila.size();
        for (int j = i + 1; j < s; j++) {
            pila.remove(pila.size() - 1);
        }
    }
    
    /* Mueve el bloque p1 y los que estén encima, sobre la pila en la que está el bloque p2 */
    private static void moveTo(int p1, int p2, HashMap<Integer, ArrayList<Integer>> blocks, HashMap<Integer, Integer> pile) {
        ArrayList<Integer> l = blocks.get(pile.get(p1));
        int iP1 = l.indexOf(new Integer(p1));
        ArrayList<Integer> blocksToMove = new ArrayList<Integer>(l.subList(iP1, l.size()));
        for (Integer p : blocksToMove) {
            blocks.get(pile.get(p2)).add(p);
            blocks.get(pile.get(p)).remove(new Integer(p));
            pile.put(p, pile.get(p2));
        }
    }
    
    /*
    move 'a' onto 'b'
    where 'a' and 'b' are block numbers, puts block 'a' onto block 'b' after returning any blocks that 
    are stacked on top of blocks 'a' and 'b' to their initial positions.
    */
    private static void moveOnto(int p1, int p2, HashMap<Integer, ArrayList<Integer>> blocks, HashMap<Integer, Integer> pile) {
        desapilar(p1, blocks, pile);
        desapilar(p2, blocks, pile);
        moveTo(p1, p2, blocks, pile);
    }

    /*
    move 'a' over 'b'
    where 'a' and 'b' are block numbers, puts block 'a' onto the top of the stack containing block 'b', 
    after returning any blocks that are stacked on top of block 'a' to their initial positions.
    */
    private static void moveOver(int p1, int p2, HashMap<Integer, ArrayList<Integer>> blocks, HashMap<Integer, Integer> pile) {
        desapilar(p1, blocks, pile);
        moveTo(p1, p2, blocks, pile);
    }

    /*
    pile 'a' onto 'b'
    where 'a' and 'b' are block numbers, moves the pile of blocks consisting of block 'a', 
    and any blocks that are stacked above block 'a', onto block 'b'.
    All blocks on top of block 'b' are moved to their initial positions prior to the pile taking place. 
    The blocks stacked above block 'a' retain their order when moved.
    */
    private static void pileOnto(int p1, int p2, HashMap<Integer, ArrayList<Integer>> blocks, HashMap<Integer, Integer> pile) {
        desapilar(p2, blocks, pile);
        moveTo(p1, p2, blocks, pile);
    }
    
    /*
    pile 'a' over 'b'
    where 'a' and 'b' are block numbers, puts the pile of blocks consisting of block 'a', 
    and any blocks that are stacked above block 'a', onto the top of the stack containing block 'b'. 
    The blocks stacked above block a retain their original order when moved.
    */
    private static void pileOver(int p1, int p2, HashMap<Integer, ArrayList<Integer>> blocks, HashMap<Integer, Integer> pile) {
        moveTo(p1, p2, blocks, pile);
    }
   
}
