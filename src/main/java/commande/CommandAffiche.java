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
    if(shape instanceof Carre) {
      return((Carre)shape).Affiche();
	}

    if(shape instanceof Cercle) {
	  return((Cercle)shape).Affiche();
	}

    if(shape instanceof Rectangle) {
      return((Rectangle)shape).Affiche();
	}

    if(shape instanceof Triangle) {
      return((Triangle)shape).Affiche();
	}
    return null;
  }
}
