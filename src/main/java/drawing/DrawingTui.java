package drawing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commande.*;
import dao.Dao;
import shape.*;


/**
 *  DrawingTui classe.
 * @author Sarra Belmahdi.
 *
 */
public class DrawingTui {

  /**
   * la liste des formes crees par l'utilisateur.
   */
  private List<Shape> formes;

  /**
   * la liste des groupe créer.
   */
  private List<GroupShapes> groupes;
 
  /**
   * constructeur.
   */
  public DrawingTui() {
    formes = new ArrayList<Shape>();
    groupes = new ArrayList<GroupShapes>();
    this.deleteTables("cercles");
    this.deleteTables("carres");
    this.deleteTables("rectangles");
    this.deleteTables("triangles");
    this.deleteTables("groupshapes");
  }

  /**
   * méthodes pour accéder aux formes créer par les utilisiteurs.
   * @return la liste des formes crées.
   */
  public List<Shape> getUserShapes() {
    return formes;
  }

  /**
   * méthode pour accéder aux groupes créer les utilisateurs.
   * @return la liste des groupes crées.
   */
  public List<GroupShapes> getUserGroupes() {
    return groupes;
  }

  /**
   * methode pour trouver une forme.
   * à partir de son nom.
   * @param name le nom de la forme.
   * @return la forme.
   */
  public Shape findShape(String name) {
    for(Shape forme: formes) {
      if(forme.getName().contentEquals(name)) {
        return forme;
      }
    }
    return null;
  }

  /**
   * methode pour trouver un groupe.
   * à  partir de son nom.
   * @param name le nom du groupe.
   * @return le groupe.
   */
  public GroupShapes findGroup(String name) {
    for(GroupShapes groupe: groupes) {
      if(groupe.getName().equals(name)) {
        return groupe;
      }
    }
    return null;
  }

  /**
   * methode pour creer un groupe s'il n'existe pas.
   * et ajouter à ce la forme qui appartient à ce groupe.
   * @param idG id du groupe
   * @param shape la forme qui va etre ajoutée.
   */
  public void createGroupe(int idG,Shape shape) {
    Boolean existeG = false;
    for(GroupShapes groupe: groupes) {
      if(((Integer)groupe.getGroupId()).equals((Integer)idG)) {
        groupe.add(shape);
        existeG = true;
      }      
	}
    if(existeG.equals(false)) {
      CommadCreateGroup command = new CommadCreateGroup("g"+idG,idG);
      GroupShapes groupe = command.execute();
      groupes.add(groupe);
      groupe.add(shape);
    }
  }

  /**
   * methode pour trouver la commande qui déplace la forme..
   * @param shape la forme à deplacer.
   * @param x le déplacement par x.
   * @param y déplacement 
   * @return la commande de  déplacement.
   */
  public Command whichFormeMove(Shape shape,double x,double y) {
    if(shape instanceof Carre) {
      return new CommandMoveCa(((Carre)shape),x,y);
    }
    if(shape instanceof Cercle) {
        return new CommandMoveC(((Cercle)shape),x,y);
      }
    if(shape instanceof Rectangle) {
        return new CommandMoveRe(((Rectangle)shape),x,y);
    }
    if(shape instanceof Triangle) {
        return new CommandMoveT(((Triangle)shape),x,y);
    }
    return null;	
}
 
  /**
   * methode pour sauvegarder un dessin.
   * @return commandSave.
   */
  public Command saveGroups(GroupShapes gs) {
	CommandSave cs = new CommandSave(gs);
    cs.execute();
    return cs;
  }

  /**
   * méthode pour charger un dessin à partir du BD.
   * @param  groupe  le groupe à charger.
   * @return commandeLoad.
   */
  public Command loadGroups(GroupShapes groupe) {
   
    for(Ishape shape : groupe.getShapes()) {
      if(shape instanceof Shape && groupe.getIdG() == ((Shape) shape).getGroupId()){
        formes.remove((Shape)shape);
      }
    }
    groupes.remove(groupe);
    CommandLoad cl= new CommandLoad(String.valueOf(groupe.getIdG()));
    GroupShapes gs = cl.execute();
    groupes.add(gs);
    for(Ishape shape : gs.getShapes()) {
        if(shape instanceof Shape) {
          formes.add((Shape)shape);
        }
      }
    return cl;
  }

  /**
   * methode pour retourner la commande suivante.
   * @param userCommande la chaine entreé par l'utilisateur.
   * @return la commande.
   */
  @SuppressWarnings("unchecked")
  public Command nextCommand(String userCommande) {
    userCommande = userCommande.replaceAll("[=)(,]"," ");
    String[] textUser = userCommande.split("\\s+");
    Command command = null;
    String nextCommande = textUser[0].toLowerCase();
	Shape shape = null;
    try {
      switch(nextCommande) {
        case "move":
          shape = findShape(textUser[1]);
          double x1 = Double.parseDouble(textUser[2]);
      	  double y1 = Double.parseDouble(textUser[3]);
          command = this.whichFormeMove(shape,x1,y1);
          ((ICommand)command).execute();
          break;
        case "affiche":
          shape = findShape(textUser[1]);
          command = new CommandAffiche(shape);
          String affiche = ((ICommandAffiche)command).execute();
          System.out.println(affiche);
          break;
        case "movegroupe":
          GroupShapes shapeG = findGroup(textUser[1]);
          double x2 = Double.parseDouble(textUser[2]);
          double y2 = Double.parseDouble(textUser[3]);
          command = new CommandMoveGroup(shapeG,x2,y2);
          ((ICommand)command).execute();
           break;
        case "affichegroupe":
          GroupShapes shapeG1 = findGroup(textUser[1]);
          command = new CommandAfficheGroup(shapeG1);
          String affiche1 = ((ICommandAffiche)command).execute();
          System.out.println(affiche1);
          break;
        case "afficheall":
          String affiche2 = afficheAllDessins();
          if(this.getUserShapes().size()>=1) {
            System.out.println("vos dessins actuels sont:");
            System.out.println(affiche2);
          }
          break;
        case "save":
          GroupShapes shapeG2 = findGroup(textUser[1]);
          command = saveGroups(shapeG2);
          System.out.println("votre dessin a éte sauvgardé");
          break;
        case "load":
          GroupShapes shapeG3 = findGroup(textUser[1]);
          command = loadGroups(shapeG3);
          System.out.println("votre dessin a éte chargé");
          break;
        case "exit":
    	  command = new CommandExit();
    	  ((ICommand)command).execute();
          break;
        default:
          double x3 = Double.parseDouble(textUser[2]);
          double y3 = Double.parseDouble(textUser[3]);
          Point point = new Point(x3,y3);
          int groupId;
    	  nextCommande = textUser[1].toLowerCase();
    	  switch(nextCommande) {
            case "cercle":
        	  groupId = Integer.parseInt(textUser[5]);
        	  double radius = Double.parseDouble(textUser[4]);
        	  command = new CommandCreateC(textUser[0],point,radius,groupId);
        	  shape = ((CommandCreate<Cercle>)command).execute();
    	      formes.add((Cercle)shape);
    	      createGroupe(groupId,(Cercle)shape);
    	      break;
            case "carre":
          	  groupId = Integer.parseInt(textUser[5]);
          	  double side = Double.parseDouble(textUser[4]);
          	  command = new CommandCreateCa(textUser[0],point,side,groupId);
          	  shape = ((CommandCreate<Carre>)command).execute();
  	          formes.add((Carre)shape);
  	          createGroupe(groupId,(Carre)shape);
    	      break;
            case "triangle":
        	  groupId = Integer.parseInt(textUser[6]);
              double base = Double.parseDouble(textUser[4]);
              double height = Double.parseDouble(textUser[5]);
              command = new CommandCreateT(textUser[0],point,base,height,groupId);
        	  shape = ((CommandCreate<Triangle>)command).execute();
    	      formes.add((Triangle)shape);
    	      createGroupe(groupId,(Triangle)shape);
    	      break;
            case "rectangle":
        	  groupId = Integer.parseInt(textUser[6]);
              double length = Double.parseDouble(textUser[4]);
              double width = Double.parseDouble(textUser[5]);
              command = new CommandCreateRe(textUser[0],point,length,width,groupId);
              shape = ((CommandCreate<Rectangle>)command).execute();
    	      formes.add((Rectangle)shape);
    	      createGroupe(groupId,(Rectangle)shape);
    	      break;
            default:
              System.out.println("forme invalide");
              command = null;
              break;
          }
      }
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      return null;
    }
    return command;
  }

  /**
   * méthode pour afficher un dessin.
   * @param shape la forme à afficher.
   * @return le dessin textuel.
   */
  public String afficheDessin(Shape shape) {
    if(shape instanceof Cercle) {
      return ((Cercle)shape).affiche();
    }

    if(shape instanceof Rectangle) {
      if(((Rectangle) shape).getLength() == ((Rectangle) shape).getWidth()) {
        return((Carre)shape).affiche();  
      } else {
        return((Rectangle)shape).affiche();
      }
  	}

    if(shape instanceof Triangle) {
      return ((Triangle)shape).affiche();
    }

    if(shape instanceof GroupShapes) {
      return ((GroupShapes)shape).affiche();
    }
    return null;	
  }
  /**
   * methode pour afficher les formes actuelles dessinées.
   * @return
   */
  public String afficheAllDessins() {
	StringBuffer affiche = new StringBuffer();
    for(Shape shape : this.getUserShapes()) {
      affiche.append(this.afficheDessin(shape));
      affiche.append("\n");
    }
    return affiche+"";
  }

  /**
   * méthode pour supprimer la table dand base de données à chaque utilisation.
   * @param nameTble le nom de la table à supprimer.
   */
  public void deleteTables(String nameTable) {
    Connection connexion = Dao.getConnection();
    String deleteTableString = "delete from "+nameTable;
    try {
      connexion.createStatement().execute(deleteTableString);
      connexion.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
	} 
  }
}
