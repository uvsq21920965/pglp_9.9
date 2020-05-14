package shape;

import java.util.ArrayList;
import java.util.List;

public class GroupShapes extends Shape implements Ishape {

  /**
   * nom du groupe.
   */
  private String nameG;

  /**
   * id du groupe.
   */
  private int idG;

  /**
   * liste des formes.
   */
  private List<Ishape> shapes;

  /**
   * Constructeur.
   * @param nameGatt nom du groupe.
   * @param pointGatt point du reference du groupe.
   * @param idGatt id du groupe.
   */
  public GroupShapes(String nameGatt, int idGatt) {
	super(nameGatt,idGatt);
    nameG = nameGatt;
    idG = idGatt;
    shapes = new ArrayList<Ishape>();
  }

  /**
   * methode pour acceder au nom du groupe.
   * @return nom du groupe.
   */
  public String getNameG() {
    return nameG;
  }

  /**
   * methode pour modifier le nom du groupe.
   * @param nameG le nouveau nom du groupe.
   */
  public void setNameG(String nameG) {
    this.nameG = nameG;
  }

  /**
   * methode pour acceder au id du groupe.
   * @return id du groupe.
   */
  public int getIdG() {
    return idG;
  }

  /**
   * methode pour modifier le id du groupe. 
   * @param idG le nouveau id.
   */
  public void setIdG(int idG) {
    this.idG = idG;
  }

  /**
   * methode pour acceder au groupe des formes.
   * @return le groupe des formes.
   */
  public List<Ishape> getShapes() {
    return shapes;
  }

  /**
   * methode pour ajouter une forme au groupe.
   * @param shape la forme à ajouter .
   */
  public void add(Ishape shape) {
	this.getShapes().add(shape);
  }

  /**
   * methode pour supprimer une formet du groupe.
   * @param shape forme à supprimer.
   */
  public void remove(Ishape shape) {
    if (this.getShapes().contains(shape)) {
      shapes.remove(shape);
    } else {
      System.out.println("element non trouvé");
    }
  }
  /**
   * methode pour déplacer le groupe des formes.
   * @param x coordonnée x du deplacement.
   * @param y coordonnée y du deplacement.
   */
  @Override
  public void move(double x, double y) {
    for (Ishape shape : shapes) {
      shape.move(x, y);
    }
  }

  /**
   * methode pour afficher les caractéristiques de la forme.
   * @return les caractéristiques du groupe.
   */
  @Override
  public String Affiche() {
    StringBuffer affiche = new StringBuffer();
    for (Ishape shape : shapes) {
      affiche.append(" ");
      affiche.append(shape.Affiche());
	}
    return this.getNameG()+"Groupe :" +" " + affiche;
  }
}
