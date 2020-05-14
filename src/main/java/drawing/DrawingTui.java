package drawing;

import shape.Shape;

import java.util.ArrayList;
import java.util.List;

import commande.*;
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
   * 
   */
  private List<GroupShapes> groupes;

  /**
   * constructeur.
   */
  public DrawingTui() {
    formes = new ArrayList<Shape>();
    groupes = new ArrayList<GroupShapes>();
  }

  /**
   * methode pour trouver une forme.
   * à  partir de son nom.
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
   * et ajouter  la formequi appartient à ce groupe.
   * @param idG id du groupe
   * @param shape la forme qui va etre ajoutée.
   */
  public void CreateGroupe(int idG,Shape shape) {
    Boolean existeG = false;
    for(GroupShapes groupe: groupes) {
      if(((Integer)groupe.getGroupId()).equals((Integer)idG)) {
        groupe.add(shape);
        existeG = true;
      }      
	}
    if(existeG.equals(false)) {
      Command command = new CommadCreateGroup("groupe"+idG,idG);
      GroupShapes groupe = (GroupShapes)command;
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
   * methode pour retourner la commande suivante.
   * @param userCommande
   * @return la commande.
   */
  public Command nextCommand(String userCommande) {
	userCommande = userCommande.replaceAll("=(,)","");
    String[] textUser = userCommande.split("\\s");
    Command command = null;
    String nextCommande = textUser[0].toLowerCase();
    double x = Double.parseDouble(textUser[2]);
	double y = Double.parseDouble(textUser[3]);
    try {
      switch(nextCommande) {
        case "move":
          Shape shape = findShape(textUser[1]);
          command = this.whichFormeMove(shape,x,y);
          break;
        case "movegroupe":
        	GroupShapes shapeG = findGroup(textUser[1]);
        	command = new CommandMoveGroup(shapeG,x,y);
        	break;
        case "exit":
    	  command = new CommandExit();
          break;
        default:
          Point point = new Point(x,y);
          int groupId;
    	  nextCommande = textUser[1].toLowerCase();
    	  switch(nextCommande) {
            case "cercle":
        	  groupId = Integer.parseInt(textUser[5]);
        	  double radius = Double.parseDouble(textUser[4]);
        	  command = new CommandCreateC(textUser[0],point,radius,groupId);
    	      formes.add((Cercle)command);
    	      CreateGroupe(groupId,(Cercle)command);
    	      break;
            case "carre":
          	  groupId = Integer.parseInt(textUser[5]);
          	  double side = Double.parseDouble(textUser[4]);
          	  command = new CommandCreateCa(textUser[0],point,side,groupId);
      	      formes.add((Carre)command);
      	    CreateGroupe(groupId,(Carre)command);
    	      break;
            case "triangle":
        	  groupId = Integer.parseInt(textUser[6]);
              double base = Double.parseDouble(textUser[4]);
              double height = Double.parseDouble(textUser[5]);
              command = new CommandCreateT(textUser[0],point,base,height,groupId);
        	  formes.add((Triangle)command);
        	  CreateGroupe(groupId,(Triangle)command);
    	      break;
            case "rectangle":
        	  groupId = Integer.parseInt(textUser[6]);
              double length = Double.parseDouble(textUser[4]);
              double width = Double.parseDouble(textUser[5]);
              command = new CommandCreateRe(textUser[0],point,length,width,groupId);
              formes.add((Rectangle)command);
              CreateGroupe(groupId,(Rectangle)command);
    	      break;
            default:
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
    if(shape instanceof Carre) {
      return ((Carre)shape).Affiche();
    }

    if(shape instanceof Cercle) {
      return ((Cercle)shape).Affiche();
    }

    if(shape instanceof Rectangle) {
      return ((Rectangle)shape).Affiche();
    }

    if(shape instanceof Triangle) {
      return ((Triangle)shape).Affiche();
    }

    if(shape instanceof GroupShapes) {
      return ((GroupShapes)shape).Affiche();
    }
    return null;	
  }
}
