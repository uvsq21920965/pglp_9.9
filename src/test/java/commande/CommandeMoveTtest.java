package commande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import shape.Point;
import shape.Triangle;

public class CommandeMoveTtest {

	Point point = new Point(5.2,7);
	Triangle t = new Triangle("t1",point,4.0,3.5,1);
	CommandMoveT mvt = new CommandMoveT(t,1,1);

	@Test 
	  public void executeTest() {
	    mvt.execute();
	    assertEquals(t.getName(),"t1");
	    Double x = t.getTop().getX();
	    Double y = t.getTop().getY();
	    Double base = t.getBase();
	    Double height = t.getHeight();
	    assertTrue(x.equals(6.2));
	    assertTrue(y.equals(8.0));
	    assertTrue(base.equals(4.0));
	    assertTrue(height.equals(3.5));
	    assertEquals(t.getGroupId(),1);
	  }
}
