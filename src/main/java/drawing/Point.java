package drawing;

/**
 * Point classe.
 * @author Sarra Belmahdi.
 *
 */
public class Point {
  /**
   * coordonnée x du point .
   */
  private double x;

  /**
   * coordonnée y du point.
   */
  private double y;
  
  public Point(double xAtt,double yAtt) {
    this.x = xAtt;
    this.y = yAtt;
  }

  /**
   * methode pour accéder au coordonnée x du point.
   * @return cordonné x du point. 
   */
  public double getX() {
    return x;
  }
  /**
   * methode pour accéder au coordonnée y du point.
   * @return cordonné y du point. 
   */
  public double getY() {
    return y;
  }

  /**
   * methode pour modifier coordonnée x du point.
   */
  public void setX(double x1) {
	  this.x = x1;
  }

  /**
   * methode pour modifier coordonnée y du point.
   */
  public void setY(double y1) {
	  this.y = y1;
  }
}
