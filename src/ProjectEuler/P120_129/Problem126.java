/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P120_129;

import java.util.HashMap;
import raytracer.Point3D;

/**
 *
 * @author ismael.flores
 */
public class Problem126 {
    
    private static boolean isIn(Point3D c, Point3D p) {
        if (p.getX() < 0 || p.getY() < 0 || p.getZ() < 0)
            return false;
        if (p.getX() >= c.getX() || p.getY() >= c.getY() || p.getZ() >= c.getZ())
            return false;
        return true;
    }

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
                        HashMap<Point3D, Boolean> ultima = new HashMap<>(ultimas_capas.get(cuboide));
                        HashMap<Point3D, Boolean> dotsc = new HashMap<>();
                        ultimas_capas.put(cuboide, dotsc);
                        HashMap<Point3D, Boolean> dots = todas_las_capas.get(cuboide);
                        Point3D pp;

                        for (Point3D p : ultima.keySet()) {
                            pp = new Point3D(p.getX() - 1, p.getY(), p.getZ());
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.getX() + 1, p.getY(), p.getZ());
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.getX(), p.getY() - 1, p.getZ());
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.getX(), p.getY() + 1, p.getZ());
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.getX(), p.getY(), p.getZ() - 1);
                            if (!isIn(cuboide, pp) && !dots.containsKey(pp) && !dotsc.containsKey(pp)) {
                                dotsc.put(pp, Boolean.TRUE);
                            }
                            pp = new Point3D(p.getX(), p.getY(), p.getZ() + 1);                            
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

}
