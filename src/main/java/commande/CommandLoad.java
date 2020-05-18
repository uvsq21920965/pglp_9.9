package commande;

import dao.GroupShapesJdbc;
import shape.GroupShapes;

public class CommandLoad implements CommandCreate<GroupShapes> {

  /**
   * l'attribut nom dugroupe de formes.
   */
  private String gs;

  /**
   * l'attribut groupeJdbc.
   */
  private GroupShapesJdbc gsj;

  /**
   * Constructeur.
   * @param gsAtt le nom du  groupe à charger.
   */
  public CommandLoad(String gsAtt) {
    this.gs = gsAtt;
    gsj = new GroupShapesJdbc();
  }

  /**
   * methode pour charger un dessin.
   */
  @Override
  public GroupShapes execute() {
    return gsj.find(gs);
  }    
}