package elukat;

/**
 * Elain-luokka.  Kantaluokka el‰imille.
 * @author Vesa Lappalainen
 * @version 1.0, 06.02.2003
 *
*/
public class Elain {
    private String nimi;
    private double paino;

    /**
     * El‰imen alustus
     * @param nimi el‰imen nimi
     * @param paino el‰imen paino g
     */
    public Elain(String nimi, double paino) {
        this.nimi = nimi;
        this.paino = paino;
    }
 
    
    /**
     * El‰imen ‰‰ntely
     */
    public void aantele() {
        System.out.println("???");
    }

    
    /**
     * @return el‰imen tiedot muodossa "Miuku 18000"
     */
    @Override
    public String toString() {
        return nimi + " " + paino;
    }
}