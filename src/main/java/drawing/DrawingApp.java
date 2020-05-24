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
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("                        Logiciel de dessin");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("Formes et les commande disponibles sur ce logiciel :");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("                                Cercle");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("pour créer un cercle la commande sera : c1=cercle((1,1),2,1)");
    System.out.println("celà va créer un cercle nommée c1 son centre (1,1) son rayon : 2 dans le  groupe: 1");
    System.out.println("pour déplacer un cercle la commande sera : move(c1,2,3)");
    System.out.println("celà va déplacer le cercle c1 avec 2 positions par x et 3 positions par y");
    System.out.println("pour afficher un cercle la commande sera : affiche c1");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("                                Carre");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("pour créer un carre la commande sera : ca1=carre((1,5),2,1)");
    System.out.println("celà va créer un carré nommé ca1 à la position (1,5) avec son coté:2 dans le groupe: 1");
    System.out.println("pour déplacer un carré la commande sera : move(ca1,2,3)");
    System.out.println("celà va déplacer le carré ca1 avec 2 positions par x et 3 positions par y");
    System.out.println("pour afficher un carre la commande sera : affiche ca1");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("                                Rectangle");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("pour créer un rectangle la commande sera : re1=rectangle((1,5),6,2,1)");
    System.out.println("celà va créer un rectangle nommé re1 à la position (1,5), sa longueur:6 ,sa largeur:2 dans le groupe: 1");
    System.out.println("pour déplacer un rectangle la commande sera : move(re1,2,3)");
    System.out.println("celà va déplacer le rectangle r1 avec 2 positions par x et 3 positions par y");
    System.out.println("pour afficher un rectangle la commande sera : affiche re1");
	System.out.println("                                Traingle");
	System.out.println("-----------------------------------------------------------------------------------");
	System.out.println("pour créer un triangle la commande sera : t1=triangle((1,5),4,5,1)");
	System.out.println("celà va créer un triangle nommé re1 à la position (1,5), sa base:4, sa hauteur:5 dans le groupe: 1");
    System.out.println("pour déplacer un triangle la commande sera : move(t1,2,3)");
    System.out.println("celà va déplacer le rectangle r1 avec 2 positions par x et 3 positions par y");
    System.out.println("pour afficher un triangle la commande sera : affiche t1");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("                              groupe de formes");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("un groupe est l'ensemble des formes qui ont le meme id du groupe");
	System.out.println("pour déplacer un groupe la commande sera : movegroupe(g1,2,3)");
	System.out.println("celà va déplacer toutes les formes du groupe g1 avec 2 positions par x et 3 positions par y");
    System.out.println("pour afficher un groupe la commande sera : affichegroupe g1");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("               sauvgarder un dessin ");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("pour sauvgader un dessin dans le sgbd la commande sera : save g1");
    System.out.println("-----------------------------------------------------------------------------------");
	System.out.println("               charger un dessin ");
    System.out.println("-----------------------------------------------------------------------------------");
	System.out.println("pour charger un desssin à partir du sgbd la commande sera : load g1");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("               	Afficher le dessin actuel ");
    System.out.println("-----------------------------------------------------------------------------------");
	System.out.println("pour afficher le desssin actuel : afficheall");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("               	fermer le logiciel ");
    System.out.println("-----------------------------------------------------------------------------------");
	System.out.println("pour fermer le logiciel : exit");
    System.out.println("-----------------------------------------------------------------------------------");
	    
    DrawingTui dt = new DrawingTui();
    System.out.println("");
    System.out.println("");
    System.out.println("Start");
    System.out.println("");
    //System.out.println(" veuillez entrer votre commande");
    Scanner scan = new Scanner(System.in, "UTF-8");
	String dessin ="";
    while (true) {
      System.out.println(" veuillez entrer votre commande");
      if (scan.hasNextLine()) {
        dessin = scan.nextLine();
        dt.nextCommand(dessin);
      }
    }
  }

  public static void main(String[] args) {
    DrawingApp da = new DrawingApp();
    da.run();
  }
}
