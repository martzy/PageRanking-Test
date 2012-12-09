/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pagerank;

import java.util.ArrayList;
import java.util.Vector;


/**
 *
 * @author martzy
 */
public class Main {
    public static Vector<Vector<Float>> A;
    public static Vector<Integer> corespondent;
    static int N; // numărul de CV-uri
    static Vector<Float> initialRank = new Vector<Float>();
    

    public static Vector<Float> multiply() {
        Vector<Float> result = new Vector<Float>();
        Vector<Float> aux = new Vector<Float>();

        System.out.print("result: ");
        for(int i = 0; i < N; i++) {
            aux.add(initialRank.elementAt(i));
            System.out.print(aux.elementAt(i) + " ");
        }
        System.out.println();

        for(int i = 0; i < N; i++) {
            float temp = 0;
            for(int j = 0; j < N; j++) {
                temp += A.elementAt(i).elementAt(j) * aux.elementAt(j);
            }
            result.add(temp);
        }

        while(Math.abs(result.elementAt(0) - aux.elementAt(0)) > 0.05) {
            System.out.print("result: ");
            for(int i = 0; i < N; i++) {
                aux.set(i, result.elementAt(i));
                System.out.print(aux.elementAt(i) + " ");
            }
            System.out.println();

            for(int i = 0; i < N; i++) {
                float temp = 0;
                for(int j = 0; j < N; j++) {
                    temp += A.elementAt(i).elementAt(j) * aux.elementAt(j);
                }
                result.set(i, temp);
            }
        }

        return result;
    }
    
    public static void makeMatrix() {
        ArrayList<CV> cvs = Database.getAllCVs();
        N = Database.getNumberofCVs();
        for (int i = 0; i < N; i++) {
            Vector<Float> line = new Vector<Float>();
            
            initialRank.add(cvs.get(i).getRank());
            
            for (int j = 0; j < N; j++) {
                line.add(new Float(1/(float)N));
            }
            A.add(line);
            corespondent.add(cvs.get(i).getId());
        }

        System.out.println("N = " + N);
        System.out.println("matrix:");
        for (int i = 0; i < N; i++) {
            Vector<Float> line = A.elementAt(i);
            for (int j = 0; j < N; j++) {
                System.out.print(line.elementAt(j)+" ");
            }
            System.out.println();
        }
        System.out.println("corespondent:");
        for (int i = 0; i < N; i++) {
            System.out.print(corespondent.elementAt(i) + " ");
        }
    }

    public static void addCV(int id_cv) {
        N++;
        Vector<Float> line = new Vector<Float>();
        
        /* daca nu exista like-uri pe coloană, A[N-1][j] nu mai trebuie modificat, dar restul coloanei trebuie
             Dacă există like-uri pe coloană A[N-1][j] trebuie sa fie 0, iar restul coloanei nu trebuie modificată.
             Pentru verificarea existenței de like-uri se compară cu 1/(N -1) prima valoare. */
        for (int j = 0; j < N - 1; j++) {
            if (1/(float)(N-1) == A.elementAt(0).elementAt(j)) {     //nu exista like-uri date
                line.add(new Float(1/(float)N)); //trebuie modificata toata coloana (1/(N-1) trebuie înlocuit cu 1/N)
            } else { //s-au dat like-uri, cv-ul adaugat nu a primit inca, deci va primi ponderea 0, celelalte nemodificandu-se
                line.add(new Float(0));
            }
            
        }
        A.add(line);

        //modificare pe toate coloanele: (1/(N-1) trebuie înlocuit cu 1/N
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (1/(float)(N-1) == A.elementAt(i).elementAt(j)) {
                    A.elementAt(i).set(j, new Float(1/(float)N));
                }
            }
        }

        // parcurg toate liniile și pe ultima coloana pun 1/N
        for (int i = 0; i < N; i++) {
            A.elementAt(i).add(new Float(1/(float)N));
        }

        corespondent.add(id_cv);
    }

    /* CV1 dă like la CV2 */
    public static void addLike(int id_cv1, int id_cv2) {
        int ind1 = corespondent.indexOf(id_cv1);
        int ind2 = corespondent.indexOf(id_cv2);

        if (A.elementAt(0).elementAt(ind1) == 1/(float)N) {    //CV1 nu a dat niciun like, CV2 primeste primul like
            for (int i = 0; i < N; i++) {
                A.elementAt(i).set(ind1, new Float(0));
            }
            A.elementAt(ind2).set(ind1, new Float(1));
        } else {        //CV1 a dat like-uri
            int nr = 0;
            for (int i = 0; i < N; i++) {
                if (A.elementAt(i).elementAt(ind1) != 0) {
                    A.elementAt(i).set(ind1,
                            new Float(1/(float)(1 + ((int)(1/A.elementAt(i).elementAt(ind1))))));
                    nr++;
                }
            }
            A.elementAt(ind2).set(ind1, new Float(1/(float)(nr + 1)));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A = new Vector<Vector<Float>>();
        corespondent = new Vector<Integer>();
        Database db = new Database();
        makeMatrix();
        ArrayList<CV> CVs = Database.getAllCVs();
        
        addCV(33);
        initialRank.add(new Float(2.8));
        
        System.out.println("N = " + N);
        System.out.println("matrix:");
        for (int i = 0; i < N; i++) {
            Vector<Float> line = A.elementAt(i);
            for (int j = 0; j < N; j++) {
                System.out.print(line.elementAt(j)+" ");
            }
            System.out.println();
        }
        System.out.println("corespondent:");
        for (int i = 0; i < N; i++) {
            System.out.print(corespondent.elementAt(i) + " ");
        }

        addLike(30, 33);
        System.out.println("matrix:");
        for (int i = 0; i < N; i++) {
            Vector<Float> line = A.elementAt(i);
            for (int j = 0; j < N; j++) {
                System.out.print(line.elementAt(j)+" ");
            }
            System.out.println();
        }
        addLike(30, 31);
        addLike(27, 28);
        System.out.println("matrix:");
        for (int i = 0; i < N; i++) {
            Vector<Float> line = A.elementAt(i);
            for (int j = 0; j < N; j++) {
                System.out.print(line.elementAt(j)+" ");
            }
            System.out.println();
        }
        addCV(40);
        initialRank.add(new Float(2.5));
        
        for (int i = 0; i < N; i++) {
            Vector<Float> line = A.elementAt(i);
            for (int j = 0; j < N; j++) {
                System.out.print(line.elementAt(j)+" ");
            }
            System.out.println();
        }

        multiply();
    }
}
