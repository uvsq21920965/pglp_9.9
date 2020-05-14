package commande;

import shape.GroupShapes;

/**
 * CommandCreateGroup Clasee.
 * @author Sarra Belmahdi.
 *
 */
public class CommadCreateGroup implements Command {

  /**
   * nom du groupe.
   */
  private String nameG;

  /**
   * id du groupe.
   */
  private int idG;

  /**
   * Constructeur.
   * @param nameGatt nom du groupe.
   * @param pointGatt point du reference du groupe.
   * @param idGatt id du groupe.
   */
  public CommadCreateGroup(String nameGatt, int idGatt) {
    nameG = nameGatt;
    idG = idGatt;
  }

  /**
   * methode pour creer un nouveau groupe.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    new GroupShapes(nameG,idG);	
  }
}
