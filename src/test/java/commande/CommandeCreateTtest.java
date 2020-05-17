package commande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import shape.Point;
import shape.Triangle;

public class CommandeCreateTtest {

	  Point point = new Point(5.2,7);
	  CommandCreateT mct = new CommandCreateT("t1",point,4.0,3.5,2);

	  @Test 
	  public void executeTest() {
	    Triangle t = mct.execute();
	    assertEquals(t.getName(),"t1");
	    Double x = point.getX();
	    Double y = point.getY();
	    Double base = t.getBase();
	    Double height = t.getHeight();
	    assertTrue(x.equals(5.2));
	    assertTrue(y.equals(7.0));
	    assertTrue(base.equals(4.0));
	    assertTrue(height.equals(3.5));
	    assertEquals(t.getGroupId(),2);
	  }
}
