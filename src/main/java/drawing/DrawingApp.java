package drawing;

import java.util.Scanner;

/**
 * DrawingApp Classe.
 * @author sarra Belmahdi.
 *
 */
public class DrawingApp {

  public static void main(String[] args) {
    System.out.println("");
    System.out.println("-------------------------------------------------");
    System.out.println("               Logiciel de dessin");
    System.out.println("-------------------------------------------------");
    System.out.println("");
    DrawingTui dt = new DrawingTui();
    System.out.println("Ecrire la Descreption de votre dessin pour créer "
			        + "déplacer une forme géométrique ou pour sortir: ");
	Scanner scan = new Scanner(System.in, "UTF-8");
	String dessin ="";
	while (true) {
	  if (scan.hasNext()) {
	    dessin = scan.next();
	    dt.nextCommand(dessin);
	    System.out.println("vos dessins actuels :");
	    System.out.println(dt.afficheAllDessins());	
	  }
	}

}
}
