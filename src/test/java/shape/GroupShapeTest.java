package shape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import shape.Carre;
import shape.Cercle;
import shape.GroupShapes;
import shape.Ishape;
import shape.Point;
import shape.Rectangle;
import shape.Shape;
import shape.Triangle;

public class GroupShapeTest {
  GroupShapes gf1 = new GroupShapes("gf1",1);
  GroupShapes gf2 = new GroupShapes("gf2",2);
  Point point2 = new Point(1,3);
  Rectangle r1 = new Rectangle("r1",point2,6.2,3.0,1);
  Point point3 = new Point(2,2);
  Rectangle r2 = new Rectangle("r2",point3,5.0,2.0,2);
  Point point4 = new Point(5,4);
  Carre ca1 = new Carre("ca1",point4,6,1);
  Point point5 = new Point(5,8);
  Carre ca2 = new Carre("ca2",point5,3,2);
  Point point6 = new Point(2,9);
  Cercle c1 = new Cercle("c1",point6,4,1);
  Point point7 = new Point(1.5,3);
  Cercle c2 = new Cercle("c2",point7,2,2);
  Point point8 = new Point(4,6);
  Triangle tr1 = new Triangle("tr1",point8,3.5,5,1);
  Point point9 = new Point(1.25,2.5);
  Triangle tr2 = new Triangle("tr2",point9,4,6,2);

  @Test
  public void getNameGTest() {
    assertEquals(gf1.getName(),"gf1");
    gf1.setName("gf3");
    assertEquals(gf1.getName(),"gf3");
  }

  @Test
  public void getIdGTest() {
	  assertEquals(gf1.getIdG(),1);
	  assertEquals(gf2.getIdG(),2);
	  gf1.setIdG(3);
	  assertEquals(gf1.getIdG(),3);
  }

  @Before
  public void Test1add() {
	assertEquals(gf2.getShapes().size(),0);
    gf2.add(r2);
    gf2.add(ca2);
    gf2.add(c2);
    gf2.add(tr2);
    assertEquals(gf2.getShapes().size(),4);
    assertEquals(gf1.getShapes().size(),0);
    gf1.add(gf2);
    gf1.add(r1);
    gf1.add(ca1);
    gf1.add(c1);
    gf1.add(tr1);
    assertEquals(gf1.getShapes().size(),5);
  }

  @Test
  public void Test2move() {
  gf1.move(1, 1);
  Ishape  sh2 = gf1.getShapes().get(1);
  Double x = ((Rectangle)((Shape) sh2)).getLeftTop().getX();
  Double y = ((Rectangle)((Shape) sh2)).getLeftTop().getY();
  assertTrue(x.equals(2.0));
  assertTrue(y.equals(4.0));
  sh2 = gf1.getShapes().get(3);
  x = ((Cercle)((Shape) sh2)).getCentre().getX();
  y = ((Cercle)((Shape) sh2)).getCentre().getY();
  assertTrue(x.equals(3.0));
  assertTrue(y.equals(10.0));
  }

  @Test
  public void Test3remove() {
	assertEquals(gf1.getShapes().size(),5);
    gf1.remove(r1);
    gf1.remove(ca1);
    gf1.remove(c1);
    gf1.remove(tr1);
    gf1.remove(gf2);
    assertEquals(gf1.getShapes().size(),0);
    assertEquals(gf2.getShapes().size(),4);
    gf2.remove(r2);
    gf2.remove(ca2);
    gf2.remove(c2);
    gf2.remove(tr2);
    assertEquals(gf2.getShapes().size(),0);
  }
  
}
