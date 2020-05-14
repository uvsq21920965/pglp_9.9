package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import shape.Cercle;
import shape.Point;

public class CercleJdbcTest {
	CercleJdbc cjdbc=new CercleJdbc();

	@Before
	public void deleteTable() {
		//vider le tabelau Personnels
		  Connection connexion = Dao.getConnection();
		  String deleteTableString = "delete from cercles";
		  try {
			  connexion.createStatement().execute(deleteTableString);
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
		Point point = new Point(0,0);
		Cercle  r1= new Cercle("c1",point,5,1); 
	    assertNotNull(cjdbc.create(r1));
	  }
	  /**
	   * teste de la metheode find.
	   */
	  @Test
	  public void Test2find() {
	    Point point = new Point(0,0);
		Cercle  c2= new Cercle("c2",point,2,2);
		cjdbc.create(c2);
	    Cercle c = cjdbc.find("c2");
	    assertEquals(c.getName(),"c2");
	    Double x = c.getCentre().getX();
	    Double y = c.getCentre().getY();
	    Double redius = c.getRadius();
	    assertTrue(x.equals(0.0));
	    assertTrue(y.equals(0.0));
	    assertTrue(redius.equals(2.0));
	    assertEquals(c.getGroupId(),2);
	  }

	  /**
	   * teste de la metheode update.
	   */
	  @Test
	  public void Test3upDate() {
		  Point p = new Point(5,8);
		  Cercle  c3= new Cercle("c3",p,8.3,2);
		  cjdbc.create(c3);
		  Cercle  cs = new Cercle("c3",p,6,3);
		  cjdbc.update(cs);
		  Cercle c = cjdbc.find("c3");
		  assertEquals(c.getName(),"c3");
		  Double x = c.getCentre().getX();
		  Double y = c.getCentre().getY();
		  Double redius = c.getRadius();
		  assertTrue(x.equals(5.0));
		  assertTrue(y.equals(8.0));
		  assertTrue(redius.equals(6.0));
		  assertEquals(c.getGroupId(),3);
	  }

	  /**
	   * teste de la metheode delete.
	   */
	  @Test
	  public void Test4delete() {
		  Point point3 = new Point(2,2);
		  Cercle r4 = new Cercle("c4",point3,5.0,2);
		  cjdbc.create(r4);
		  cjdbc.delete(r4);
		  assertNull(cjdbc.find("c4"));
	  }
}
