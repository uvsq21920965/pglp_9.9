package commande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import shape.Carre;
import shape.Cercle;
import shape.Point;
import shape.Rectangle;
import shape.Triangle;

public class CommandeMoveCaTest {
	Point point = new Point(5.2,7);
	Carre ca = new Carre("ca1",point,4.0,1);
	CommandMoveCa mvca = new CommandMoveCa(ca,1,1);
	@Test 
	  public void executeTest() {
	    mvca.execute();
	    assertEquals(ca.getName(),"ca1");
	    Double x = ca.getLeftTop().getX();
	    Double y = ca.getLeftTop().getY();
	    Double side = ca.getSide();
	    assertTrue(x.equals(6.2));
	    assertTrue(y.equals(8.0));
	    assertTrue(side.equals(4.0));
	    assertEquals(ca.getGroupId(),1);
	  }
}
