package shape;

/**
 * Shape classe.
 * @author Sarra Belmahdi.
 *
 */
public abstract class Shape implements Ishape{

  /**
   * le nom de la forme.
   */
  private String name;

  /**
   * id du groupe.
   */
  private int groupId;
  /**
   * constructeur.
   * @param nameAtt le nom e la forme.
   */
  public Shape(String nameAtt,int groupIdAtt) {
    name = nameAtt;
    setGroupId(groupIdAtt);
  }

  /**
   * methode pour déplacer la forme.
   * @param x coordonnée x du deplacement.
   * @param y coordonnée y du deplacement.
   */
  public abstract void move(double x,double y);

  /**
   * methode pour accéder au nom de la forme.
   * @return le nom de la forme.
   */
  public String getName() {
    return name;
  }

  /**
   * methode pour modifier le nom de la forme.
   * @param name1 le nouveau nom de la forme.
   */
  public void setName(String name1) {
    name = name1;
  }

  /**
   * methode pour accéder à id du groupe de la forme.
   * @return id groupe de la forme.
   */
  public int getGroupId() {
		return groupId;
	}

  /**
   * methode pour modifier le id du groupe de la forme.
   * @param groupId1 le nouveau id groupe  de la forme.
   */
  public void setGroupId(int groupId1) {
		this.groupId = groupId1;
	}

  /**
   * methode pour afficher les caractéristiques de la forme.
   */
  public abstract String Affiche();
}
