package drawing;

import java.util.Scanner;

/**
 * DrawingApp Classe.
 * @author sarra Belmahdi.
 *
 */
public class DrawingApp {
  /**
   * méthode pour interagire avec `DrawingTUI`,récupérer la prochaine commande.
   * l’exécutera puis affichera le résultat.
   */
  public void run() {
		System.out.println("");
	    System.out.println("-------------------------------------------------");
	    System.out.println("               Logiciel de dessin");
	    System.out.println("-------------------------------------------------");
	    System.out.println("");
	    System.out.println("-------------------------------------------------");
	    System.out.println("Formes et les commande disponibles sur ce logiciel :");
	    System.out.println("-------------------------------------------------");
	    System.out.println("               Cercle");
	    System.out.println("-------------------------------------------------");
	    System.out.println("pour créer une cercle la commande sera : c1=cercle((1,1),2,1)");
	    System.out.println("celà va créer une cercle c1 de centre (1,1) et rayon 2 et groupe 1");
	    System.out.println("pour déplacer un cercle la commande sera : move(c1,2,3)");
	    System.out.println("pour afficher un cercle la commande sera : affiche c1");
	    System.out.println("-------------------------------------------------");
	    System.out.println("               Carre");
	    System.out.println("-------------------------------------------------");
	    System.out.println("pour créer une carre la commande sera : ca1=carre((1,5),2,1)");
	    System.out.println("celà va créer un carre ca1 à la position (1,5) avec un coté 2 et groupe 1");
	    System.out.println("pour déplacer un carre la commande sera : move(ca1,2,3)");
	    System.out.println("pour afficher un carre la commande sera : affiche ca1");
	    System.out.println("-------------------------------------------------");
	    System.out.println("               Rectangle");
	    System.out.println("-------------------------------------------------");
	    System.out.println("pour créer une rectangle la commande sera : re1=rectangle((1,5),6,2,1)");
	    System.out.println("celà va créer un rectangle re1 à la position (1,5) avec une longueur 6 ,largeur 2 et groupe 1");
	    System.out.println("pour déplacer un rectangle la commande sera : move(re1,2,3)");
	    System.out.println("pour afficher un rectangle la commande sera : affiche re1");
	    System.out.println("               Traingle");
	    System.out.println("-------------------------------------------------");
	    System.out.println("pour créer une triangle la commande sera : t1=triangle((1,5),4,5,1)");
	    System.out.println("celà va créer un triangle re1 à la position (1,5) avec une base 4 ,hauteur 5 et groupe 1");
	    System.out.println("pour déplacer un triangle la commande sera : move(rt1,2,3)");
	    System.out.println("pour afficher un triangle la commande sera : affiche t1");
	    System.out.println("-------------------------------------------------");
	    System.out.println("               groupe de formes");
	    System.out.println("-------------------------------------------------");
	    System.out.println("un groupe est l'ensemble des formes qui ont le meme id du groupe");
	    System.out.println("pour déplacer un groupe la commande sera : movegrouep(g1,2,3)");
	    System.out.println("pour afficher un grouep la commande sera : affichegroupe g1");
	    System.out.println("-------------------------------------------------");

	    
	    DrawingTui dt = new DrawingTui();
	    System.out.println("Ecrire la Descreption de votre forme géométrique pour créer,"
				        + "déplacer , afficherune forme géométrique ou pour sortir");
	    System.out.println("");
	    System.out.println("");
		Scanner scan = new Scanner(System.in, "UTF-8");
		String dessin ="";
		while (true) {
		  if (scan.hasNext()) {
		    dessin = scan.next();
		    dt.nextCommand(dessin);
		    String affiche =dt.afficheAllDessins();
		    if(affiche.equals(null)) {
		      System.out.println("vous avez dessiné aucune forme géométrique");
		    } else {
		      System.out.println("vos dessins actuels sont:");
		      System.out.println(dt.afficheAllDessins());
		    }
		  }
		}
	}

  public static void main(String[] args) {
       DrawingApp da = new DrawingApp();
       da.run();
  }
}
