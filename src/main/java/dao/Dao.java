package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* interface DAO.
* @author Sarra Belmahdi.
*
* @param <T>  type d'objet.
*/
public interface Dao<T> {

  /**
   * methode pour creer un fichier.
   * @param obj T.
   * @return obj crée.
   */
  public T create(T obj);

  /**
   * methode pour trouver fichier id.
   * @param id nom du fichier.
   * @return objet du fichier recherché.
   */
  public T find(String id);

  /**
   * methode pour mettre à jour un objet T.
   * @param obj l'objet qu'on veut mettre à jour.
   * @return l'obj après la mise à jour.
   */
  public T update(T obj);

  /**
   * methode pour supprimer le fichier de l'objet T obj.
   * @param obj T à supprimer.
   */
  public void delete(T obj);

  /**
   * methode pour Connecter à la base de données sarradb.
   */
  public static Connection getConnection() {
    Connection connexion = null;
    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      connexion = DriverManager.getConnection("jdbc:derby:shapedb;create=true");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connexion;
  }
}

