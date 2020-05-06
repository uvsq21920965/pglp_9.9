package drawing;

public class Cercle extends Shape{

  /**
   * le rayon du cecle.
   */
  private double redius;

  /**
   * centre du cercle.
   */
  private Point centre;

  /**
   * constructeur.
   * @param nameCatt nom du cercle.
   * @param pointC centre du cercle.
   * @param rediusAtt rayon du cerle.
   */
  public Cercle(String nameCatt,Point pointC ,double rediusAtt) {
    super(nameCatt,pointC);
    redius = rediusAtt;
    centre = pointC;
  }

  /**
   * methode pour acceder au rayon du cercle.
   * @return rayon.
   */
  public double getRedius() {
    return redius;
  }

  /**
   * methode pour acceder au centre du cercle.
   * @returnle centre 
   */
  public Point getCentre() {
    return centre;
  }

  /**
   * methode pour afficher les caractéristiques du cercle.
   */
  @Override
  public String Affiche() {
  Point point = this.getPointRef();
  return this.getName()+" = Cercle((centre("+point.getX()+","
      +point.getY()+"),rayon="+this.getRedius()+")";
  }
}
