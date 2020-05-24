package commande;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import shape.Cercle;
import shape.Point;
import shape.Shape;

public class CommandAfficheTest {

	Point point = new Point(5.2,7);
	Shape c1 =new Cercle("c1",point,5,1);
	CommandAffiche ma = new CommandAffiche(c1);
  @Test
  public void executeTest() {
    String affiche = ma.execute();
    String affichePredict = "c1 = Cercle((centre(5.2,7.0),rayon=5.0)";
    assertEquals(affiche,affichePredict);
  }
}
