package commande;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import shape.Cercle;
import shape.GroupShapes;
import shape.Point;
import shape.Rectangle;

public class CommandeAfficheGroupTest {

	Point point = new Point(5.2,7);
	Cercle c1 =new Cercle("c1",point,5,1);
	Rectangle r1 = new Rectangle ("re1",point,4.0,3.5,1);
	GroupShapes gs = new GroupShapes("g1",1);
	CommandAfficheGroup mg;
  @Test
  public void executeTest() {
	  gs.add(c1);
	  gs.add(r1);
	  mg = new CommandAfficheGroup(gs);
    String affiche = mg.execute();
    String affichePredict = "g1Groupe :  c1 = Cercle((centre(5.2,7.0),rayon=5.0) re1 = Rectangle(point de reférence(5.2,7.0),longueur=4.0, largeur=3.5)";
    assertEquals(affiche,affichePredict);
  }
}
