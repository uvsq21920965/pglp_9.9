package commande;

import shape.Carre;
import shape.Cercle;
import shape.Rectangle;
import shape.Shape;
import shape.Triangle;

/**
 * CommandAffiche Classe.
 * @author sarra Belmahdi.
 *
 */
public class CommandAffiche implements ICommandAffiche {
  /**
   * attribut forme.
   */
  private Shape shape;

  /**
   * constructeur.
   * @param shapeAtt la forme à afficher.
   */
  public CommandAffiche(Shape shapeAtt) {
    this.shape = shapeAtt;
  }

  /**
   * méthode pour afficher forme.
   */
  @Override
  public String execute() {
    if (shape instanceof Cercle) {
      return ((Cercle)shape).affiche();
    }

    if (shape instanceof Rectangle) {
      if (((Rectangle) shape).getLength() == ((Rectangle) shape).getWidth()) {
        return ((Carre)shape).affiche();
      } else {
        return ((Rectangle)shape).affiche();
      }
    }

    if (shape instanceof Triangle) {
      return ((Triangle)shape).affiche();
    }
    return null;
  }
}
