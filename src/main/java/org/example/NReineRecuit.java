package org.example;


    public class NReineRecuit implements Solution{

        int[] posReine;
        int taille;
        public NReineRecuit(int[] tab, int taille)
        {
            this.posReine = tab;
            this.taille = taille;
        }

        public static void main(String[] args) {
            int taille = 10;
            int[] tabPosReine = new int[taille];
            for(int i = 0; i < taille; i++)
            {
                tabPosReine[i] = i;
            }
            long tmpDebut = System.currentTimeMillis();
            Solution nReine = new NReineRecuit(tabPosReine,taille);
            nReine = Recuit.recuit(nReine);
            long tmpFin = System.currentTimeMillis();
            System.out.println((tmpFin-tmpDebut));
            afficherTab(((NReineRecuit)nReine).posReine);
        }
        @Override
        public Solution voisin() {
            int rdm1 = (int)(Math.random()*taille);
            int rdm2 = (int)(Math.random()*taille);
            while(rdm2 == rdm1)
                rdm2 = (int)(Math.random()*taille);
            int valeurTmp = this.posReine[rdm1];
            int[] tab = this.posReine.clone();
            tab[rdm1] = tab[rdm2];
            tab[rdm2] = valeurTmp;
            return new NReineRecuit(tab,taille);
        }

        @Override
        public double qualite() {
            int qualite = 0;
            for(int i = 0; i < taille; i ++)
            {
                if(!estCasePossible(i,this.posReine[i],this.posReine))
                    qualite ++;
            }
            return qualite;
        }

        @Override
        public boolean conditionArret() {
            if(qualite() == 0)
                return true;
            else
                return false;
        }

        public static boolean estCasePossible(int i, int j, int[] tabNonLibre)
        {
            int cpt = 0;
            for(int ligne = i-1; ligne >=0 ; ligne--)
            {
                cpt++;
                if(j+cpt == tabNonLibre[ligne] || j-cpt == tabNonLibre[ligne] || j == tabNonLibre[ligne])
                {
                    return false;
                }
            }
            return true;
        }

        public static void afficherTab(int[] tab)
        {
            String result = "";
            String lignesep = "-";
            for(int i = 0 ; i < tab.length; i++)
            {
                lignesep += "----";
            }

            for(int i = 0 ; i < tab.length; i++)
            {
                result+=lignesep+"\n";
                result+= "|";
                for(int j = 0; j < tab.length; j++)
                {
                    result += tab[i]==j?" Q |":"   |";
                }
                result+="\n";
            }
            System.out.println(result);
        }
    }

