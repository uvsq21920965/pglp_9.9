package commande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import shape.Cercle;
import shape.Point;

public class CommandCreateCtest {

  Point point = new Point(5.2,7);
  CommandCreateC mcc = new CommandCreateC("c1",point,4.0,1);

  @Test 
  public void executeTest() {
    Cercle c = mcc.execute();
    assertEquals(c.getName(),"c1");
    Double x = point.getX();
    Double y = point.getY();
    Double rayon = c.getRadius();
    assertTrue(x.equals(5.2));
    assertTrue(y.equals(7.0));
    assertTrue(rayon.equals(4.0));
    assertEquals(c.getGroupId(),1);
    
  }
}
