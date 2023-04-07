package org.example;

public class Recuit {

    public static Solution recuit(Solution x0){

        Solution x = x0;
        double t = 0.99;
        float nt = 100;

        while(!x.conditionArret()){
            for(int m=0; m<nt;m++){
                Solution y = x.voisin();
                double df = y.qualite() - x.qualite();
                if(accepte(df,t)){
                    x = y;
                }
            }
            t = decroissance(t);
        }

        return x;
    }

    public static boolean accepte(double df, double t) {
        if(df >= 0){
            double a = Math.exp(-df/t);
            if(Math.random() >= a){
                return false;
            }
        }
        return true;
    }

    public static double decroissance(double t) {
        double valeurDecroissance = 0.5;
        return t*valeurDecroissance;
    }

}