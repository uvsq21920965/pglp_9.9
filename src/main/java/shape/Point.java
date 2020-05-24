package shape;

/**
 * Point classe.
 * @author Sarra Belmahdi.
 *
 */
public class Point {
  /**
   * coordonnée x du point .
   */
  private double x1;

  /**
   * coordonnée y du point.
   */
  private double y1;
  
  public Point(double x1Att,double y1Att) {
    this.x1 = x1Att;
    this.y1 = y1Att;
  }

  /**
   * methode pour accéder au coordonnée x du point.
   * @return cordonné x du point. 
   */
  public double getX() {
    return x1;
  }

  /**
   * methode pour accéder au coordonnée y du point.
   * @return cordonné y du point. 
   */
  public double getY() {
    return y1;
  }

  /**
   * methode pour modifier coordonnée x du point.
   */
  public void setX(double x1) {
    this.x1 = x1;
  }

  /**
   * methode pour modifier coordonnée y du point.
   */
  public void setY(double y1) {
    this.y1 = y1;
  }
}
