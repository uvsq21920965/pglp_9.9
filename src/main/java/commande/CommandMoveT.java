package commande;

import shape.Triangle;

/**
 * CommandMoveT classe.
 * @author sarra Belmahdi.
 *
 */
public class CommandMoveT implements ICommand {

  /**
   * attribut triangle.
   */
  private Triangle tr;

  /**
   * l'attribut de coordonnée x du deplacement.
   */
  private double x1;

  /**
   * l'attribut de coordonnée y du deplacement.
   */
  private double y1;

  /**
   * constructeur.
   * @param trAtt objet rectangle.
   * @param x1Att coordonnée x du deplacement.
   * @param y1Att coordonnée y du deplacement.
   */
  public CommandMoveT(Triangle trAtt,double x1Att,double y1Att) {
    tr = trAtt;
    x1 = x1Att;
    y1 = y1Att;
  }

  /**
   * methode pour deplacer le retangle.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    tr.move(x1, y1);
  }
}