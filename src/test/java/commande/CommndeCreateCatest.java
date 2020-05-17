package commande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import shape.Carre;
import shape.Point;

public class CommndeCreateCatest {

  Point point = new Point(5.2,7);
  CommandCreateCa mcca = new CommandCreateCa("ca1",point,4.0,1);

  @Test 
  public void executeTest() {
    Carre ca = mcca.execute();
    assertEquals(ca.getName(),"ca1");
    Double x = point.getX();
    Double y = point.getY();
    Double side = ca.getSide();
    assertTrue(x.equals(5.2));
    assertTrue(y.equals(7.0));
    assertTrue(side.equals(4.0));
    assertEquals(ca.getGroupId(),1);
  }
}
