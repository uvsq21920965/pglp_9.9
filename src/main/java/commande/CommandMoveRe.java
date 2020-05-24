package commande;

import shape.Rectangle;

/**
 * CommandMoveRe Classe.
 * @author Sarra Belmahdi.
 *
 */
public class CommandMoveRe implements ICommand {

  /**
   * attribut rectangle.
   */
  private Rectangle re;

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
   * @param reAtt objet rectangle.
   * @param x1Att coordonnée x du deplacement.
   * @param y1Att coordonnée y du deplacement.
   */
  public CommandMoveRe(Rectangle reAtt,double x1Att,double y1Att) {
    re = reAtt;
    x1 = x1Att;
    y1 = y1Att;
  }

  /**
   * methode pour deplacer le retangle.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    re.move(x1, y1);
  }
}
