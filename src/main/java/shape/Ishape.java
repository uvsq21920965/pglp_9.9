package shape;

/**
 * Ishape interface.
 * @author sarra Belmahdi.
 *
 */
public interface Ishape {

  /**
   * methode pour déplacer la forme.
   * @param x coordonnée x du deplacement.
   * @param y coordonnée y du deplacement.
   */
  public void move(double x,double y);

  /**
   * methode pour afficher les caractéristiques de la forme.
   */
  public String Affiche();

}
