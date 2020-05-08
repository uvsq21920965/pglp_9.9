package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import drawing.Carre;
import drawing.Cercle;
import drawing.GroupShapes;
import drawing.Ishape;
import drawing.Point;
import drawing.Rectangle;
import drawing.Triangle;

public class GroupShapesJdbcTest {
	GroupShapesJdbc gsjdbc = new GroupShapesJdbc();
	GroupShapes gf1 = new GroupShapes("gf1",1);
	Point point2 = new Point(1,3);
	Rectangle r1 = new Rectangle("r1",point2,6.2,3.0,1);
	Point point4 = new Point(5,4);
	Carre ca1 = new Carre("ca1",point4,6,1);
	Point point6 = new Point(2,9);
	Cercle c1 = new Cercle("c1",point6,4,1);
	Point point8 = new Point(4,6);
    Triangle tr1 = new Triangle("tr1",point8,3.5,5,1);
	  
	  @Before
	  public void deleteTable() {
	  	//vider le tabelau Personnels
	  	Connection connexion = Dao.getConnection();
	  	String deleteTableString = "delete from groupshapes";
	  	String deleteTableString1 = "delete from triangles";
	  	String deleteTableString2 = "delete from rectangles";
	  	String deleteTableString3 = "delete from carres";
	  	String deleteTableString4 = "delete from cercles";
	  	  try {
	  		  connexion.createStatement().execute(deleteTableString);
	  		connexion.createStatement().execute(deleteTableString1);
	  		connexion.createStatement().execute(deleteTableString2);
	  		connexion.createStatement().execute(deleteTableString3);
	  		connexion.createStatement().execute(deleteTableString4);
	  		  connexion.close();
	  		} catch (SQLException e1) {
	  		  e1.printStackTrace();
	  		} 
	   }

		  /**
		   * teste de la metheode create.
		   */
		  @Test
		  public void Test1create() {
			  gf1.add(r1);gf1.add(ca1);
		  	  gf1.add(c1);gf1.add(tr1);
		    assertNotNull(gsjdbc.create(gf1));
		 }
		  /**
		   * teste de la metheode find.
		   */
		  @Test
		  public void Test2find() {
		  GroupShapes gf5 = new GroupShapes("gf5",5);
		  Point point4 = new Point(5,4);
		  Carre ca5 = new Carre("ca1",point4,6,5);
		  gf5.add(ca5);
		  gsjdbc.create(gf5);
		   GroupShapes gs1 =gsjdbc.find("5");
			assertEquals(gs1.getNameG(),"gf5");
		    assertNotNull(gs1.getShapes());
			Ishape p = gf5.getShapes().get(0);
		    String nom = ((Carre)p).getName();
		    Double x = ((Carre)p).getLeftTop().getX();
			Double y = ((Carre)p).getLeftTop().getY();
			Double side = ((Carre)p).getSide();
			int groupeid = ((Carre)p).getGroupId();
          assertEquals(nom,"ca1");
		  assertTrue(x.equals(5.0));
		  assertTrue(y.equals(4.0));
		  assertTrue(side.equals(6.0));
		  assertEquals(groupeid,5);
		  }
		
		  /**
		   * teste de la metheode update.
		   */
		  @Test
		  public void Test3upDate() {
			  GroupShapes gf2 = new GroupShapes("gf2",2);
			  gsjdbc.create(gf2);
			  GroupShapes gf3 = new GroupShapes("gf3",2);
			  gsjdbc.update(gf3);
			  GroupShapes gs1 = gsjdbc.find("2");
		      assertEquals(gs1.getNameG(),"gf3");
		  }
		  /**
		   * teste de la metheode delete.
		   */
		  @Test
		  public void Test4delete() {
			  GroupShapes gf4 = new GroupShapes("gf4",4);
			  gsjdbc.create(gf4);
			  gsjdbc.delete(gf4);
			  assertNull(gsjdbc.find("4"));
		  }

}
