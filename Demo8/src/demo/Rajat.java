package demo;

/**
 * Aliohjelmia taulukon raja-arvojen etsimiseen
 * @author Vesa Lappalainen
 * @version 1.0, 21.02.2003
 */
public class Rajat {

    /**
     * Etsit‰‰n "paras" eli suurin taulukosta
     * @param luvut taulukko josta etsit‰‰n
     * @return taulukon suurin luku tai 0 jos lukuja ei ole
     * 
     * @example
     * <pre name="test">
     *   paras(null) ~~~ 0;
     *   paras(new double[]$luvut) ~~~ $paras;
     *   
     *      $luvut      |   $paras
     *    -------------------------------
     *       {}         |    0
     *       {11}       |    11
     *       {11,22}    |    22
     *       {22,11}    |    22
     *       {11,22,33} |    33  
     *       {22,11,33} |    33  
     *       {22,33,11} |    33  
     *       {33,22,11} |    33  
     *       {1,2,4,3}  |    4  
     *       {1,4,2,3}  |    4  
     * </pre>
     */
    public static double paras(final double luvut[]) {
        if (luvut == null) return 0;
        if (luvut.length <= 0) return 0;
        double ehdokas = luvut[0];
        for (int i = 1; i < luvut.length; i++)
            if (luvut[i] > ehdokas) ehdokas = luvut[i];
        return ehdokas;
    }


    /**
     * Etsit‰‰n "huonoin" eli pienin taulukosta
     * @param luvut taulukko josta etsit‰‰n
     * @return taulukon pienin luku tai 0 jos lukuja ei ole
     * 
     * @example
     * <pre name="test">
     *   huonoin(null) ~~~ 0;
     *   huonoin(new double[]$luvut) ~~~ $paras;
     *   
     *      $luvut      |   $paras
     *    -------------------------------
     *       {}         |    0
     *       {11}       |    11
     *       {11,22}    |    11
     *       {22,11}    |    11
     *       {11,22,33} |    11  
     *       {22,11,33} |    11  
     *       {22,33,11} |    11  
     *       {33,22,11} |    11  
     *       {1,2,4,3}  |    1  
     *       {3,4,2,1}  |    1  
     *       {3,4,1,2}  |    1  
     *       {3,1,4,2}  |    1  
     * </pre>
     */
    public static double huonoin(final double luvut[]) {
        if (luvut == null) return 0;
        if (luvut.length <= 0) return 0;
        double ehdokas = Double.MAX_VALUE;
        for (double luku : luvut)
            if (luku < ehdokas) ehdokas = luku;
        return ehdokas;
    }


    /**
     * Lasketaan taulukon alkioiden summa
     * @param luvut taulukko jonka summaa lasketaan
     * @return lukujen summa
     * @example
     * <pre name="test">
     *   summa(null) ~~~ 0;
     *   summa(new double[]$luvut) ~~~ $paras;
     *   
     *      $luvut      |   $paras
     *    -------------------------------
     *       {}         |    0
     *       {11}       |    11
     *       {11,22}    |    33
     *       {22,11}    |    33
     *       {11,22,33} |    66  
     *       {22,11,33} |    66  
     *       {1,2,4,3}  |    10  
     *       {1,4,2,3}  |    10  
     * </pre>
     */
    public static double summa(final double luvut[]) {
        if (luvut == null) return 0;
        double summa = 0;
        int i;
        for (i = 0; i < luvut.length; i++)
            summa += luvut[i];
        // for (double luku:luvut) summa += luku;
        return summa;
    }
    /**
     * Lasketaan taulukon alkioiden summa
     * @param luvut taulukko jonka summaa lasketaan
     * @return lukujen summa
     * @example
     * <pre name="test">
     *   summa(null) ~~~ 0;
     *   summa(new int[][]$luvut) ~~~ $paras;
     *   
     *      $luvut          |   $paras
     *    -------------------------------
     *       {}             |    0
     *       {{11,1}}       |    12
     *       {{11,22}}      |    33
     *       {{22,11}}      |    33
     *       {{11,22},{2,3}}|    38  
     *       {{22,11},{3,4}}|    40  
     *       {{1,2},{4,5}}  |    12    
     * </pre>
     */
    public static int summa(final int luvut[][]) {
        if (luvut == null) return 0;
        int summa = 0;
        int i;
        for (i = 0; i < luvut.length; i++)
        	for(int t = 0; t < 2; t++)
            summa += luvut[i][t];
        // for (double luku:luvut) summa += luku;
        return summa;
    }


    /**
     * Lasketaan taulukon lukujen summa ilman parasta ja huonointa
     * @param luvut taulukko jonka summaa lasketaan
     * @return summa huonoin ja paras poistettuna
     * 
     * @example
     * <pre name="test">
     *   double luvut[] = { 19,18,17,19,20 };
     *   summaHuonoinJaParasPois(luvut) ~~~ 56;
     *   summaHuonoinJaParasPois(null) ~~~ 0;
     *   
     *   summaHuonoinJaParasPois(new double[]$luvut) ~~~ $paras;
     *   
     *      $luvut      |   $paras
     *    -------------------------------
     *       {}         |    0
     *       {11}       |    0
     *       {11,22}    |    0
     *       {22,11}    |    0
     *       {11,22,33} |    22  
     *       {22,11,33} |    22  
     *       {1,2,4,3}  |    5  
     *       {1,4,2,3}  |    5  
     * </pre>
     */
    public static double summaHuonoinJaParasPois(final double luvut[]) {
        if (luvut == null) return 0;
        if (luvut.length <= 2) return 0;
        return summa(luvut) - huonoin(luvut) - paras(luvut);
    }

}