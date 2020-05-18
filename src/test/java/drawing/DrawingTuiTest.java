package drawing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import commande.Command;
import commande.CommandAffiche;
import commande.CommandCreateC;
import commande.CommandCreateCa;
import commande.CommandCreateRe;
import commande.CommandCreateT;
import commande.CommandMoveC;
import commande.CommandMoveGroup;
import shape.Carre;
import shape.Cercle;
import shape.Rectangle;
import shape.Triangle;


public class DrawingTuiTest {

  DrawingTui dt = new DrawingTui();

  @Rule
	 public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  @Test
  public void drawingTuiTest() {
    String userCommande = "c1=cercle((0,0),50,1)";
    Command commande = dt.nextCommand(userCommande);
    assertTrue( commande instanceof CommandCreateC);
    assertNotNull(dt.getUserShapes());
    assertEquals(dt.getUserShapes().size(),1);
    assertNotNull(dt.getUserGroupes());
    assertEquals(dt.getUserGroupes().size(),1);
    Cercle c = (Cercle) dt.getUserShapes().get(0);
    Double x = c.getCentre().getX();
    Double y = c.getCentre().getY();
    Double rayon = c.getRadius();
    assertEquals(c.getName(),"c1");
    assertEquals(c.getGroupId(),1);
    assertTrue(x.equals(0.0));
    assertTrue(y.equals(0.0));
    assertTrue(rayon.equals(50.0));
    userCommande = "move(c1,10,50)";
    commande = dt.nextCommand(userCommande);
    assertTrue( commande instanceof CommandMoveC);
    c = (Cercle) dt.getUserShapes().get(0);
    x = c.getCentre().getX();
    y = c.getCentre().getY();
    assertTrue(x.equals(10.0));
    assertTrue(y.equals(50.0));
    userCommande = "ca1=carre((10,5),10,1)";
    commande = dt.nextCommand(userCommande);
    assertTrue( commande instanceof CommandCreateCa);
    assertEquals(dt.getUserShapes().size(),2);
    assertEquals(dt.getUserGroupes().size(),1);
    Carre ca = (Carre) dt.getUserShapes().get(1);
    x = ca.getLeftTop().getX();
    y = ca.getLeftTop().getY();
    Double side = ca.getSide();
    assertEquals(ca.getName(),"ca1");
    assertEquals(ca.getGroupId(),1);
    assertTrue(x.equals(10.0));
    assertTrue(y.equals(5.0));
    assertTrue(side.equals(10.0));
    userCommande = "r1=rectangle((8.5,5.3),7,3,1)";
    commande = dt.nextCommand(userCommande);
    assertTrue( commande instanceof CommandCreateRe);
    assertEquals(dt.getUserShapes().size(),3);
    assertEquals(dt.getUserGroupes().size(),1);
    Rectangle r = (Rectangle) dt.getUserShapes().get(2);
    x = r.getLeftTop().getX();
    y = r.getLeftTop().getY();
    Double length = r.getLength();
    Double width = r.getWidth();
    assertEquals(r.getName(),"r1");
    assertEquals(r.getGroupId(),1);
    assertTrue(x.equals(8.5));
    assertTrue(y.equals(5.3));
    assertTrue(length.equals(7.0));
    assertTrue(width.equals(3.0));
    userCommande = "t1=triangle((6.3,2.1),4,9,1)";
    commande = dt.nextCommand(userCommande);
    assertTrue( commande instanceof CommandCreateT);
    assertEquals(dt.getUserShapes().size(),4);
    assertEquals(dt.getUserGroupes().size(),1);
    Triangle t = (Triangle) dt.getUserShapes().get(3);
    x = t.getTop().getX();
    y = t.getTop().getY();
    Double base = t.getBase();
    Double height = t.getHeight();
    assertEquals(t.getName(),"t1");
    assertEquals(t.getGroupId(),1);
    assertTrue(x.equals(6.3));
    assertTrue(y.equals(2.1));
    assertTrue(base.equals(4.0));
    assertTrue(height.equals(9.0));
    userCommande = "affiche t1";
    commande = dt.nextCommand(userCommande);
    assertTrue( commande instanceof CommandAffiche);
    userCommande = "movegroupe(g1,2,4)";
    commande = dt.nextCommand(userCommande);
    assertTrue( commande instanceof CommandMoveGroup);
    c = (Cercle) dt.getUserShapes().get(0);
    x = c.getCentre().getX();
    y = c.getCentre().getY();
    assertTrue(x.equals(12.0));
    assertTrue(y.equals(54.0));
    ca = (Carre) dt.getUserShapes().get(1);
    x = ca.getLeftTop().getX();
    y = ca.getLeftTop().getY();
    assertTrue(x.equals(12.0));
    assertTrue(y.equals(9.0));
    r = (Rectangle) dt.getUserShapes().get(2);
    x = r.getLeftTop().getX();
    y = r.getLeftTop().getY();
    assertTrue(x.equals(10.5));
    assertTrue(y.equals(9.3));
    t = (Triangle) dt.getUserShapes().get(3);
    x = t.getTop().getX();
    y = t.getTop().getY();
    assertTrue(x.equals(8.3));
    assertTrue(y.equals(6.1));
    userCommande = "exit";
    exit.expectSystemExitWithStatus(0);
    commande = dt.nextCommand(userCommande);
  }
}
