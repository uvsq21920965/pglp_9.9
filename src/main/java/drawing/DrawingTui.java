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
   * la liste des groupe créer.
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
  public void CreateGroupe(int idG,Shape shape) {
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
   * methode pour sauvgarder un dessin.
   * @return commandSave.
   */
  public Command saveGroups(GroupShapes gs) {
	CommandSave cs = new CommandSave(gs);
    cs.execute();
    return cs;
  }

  /**
   * méthode pour charger un dessin.
   *@return commandeLoad.
   */
  public Command loadGroups(String nameGroupe) {
    CommandLoad cl= new CommandLoad(nameGroupe);
    GroupShapes gs = cl.execute();
    groupes.clear();
    formes.add((Shape)gs.getShapes());
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
        case"affiche":
          shape = findShape(textUser[1]);
          command = new CommandAffiche(shape);
          System.out.println(((ICommandAffiche)command).execute());
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
          System.out.println(((ICommandAffiche)command).execute());
          break;
        case "save":
          GroupShapes shapeG2 = findGroup(textUser[1]);
          command = saveGroups(shapeG2);
          System.out.println("votre dessin a éte sauvgardé");
        case "load":
        	String shapeG3 = textUser[1];
        	command = loadGroups(shapeG3);
        	System.out.println("votre dessin a éte chargé");
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
    	      CreateGroupe(groupId,(Cercle)shape);
    	      break;
            case "carre":
          	  groupId = Integer.parseInt(textUser[5]);
          	  double side = Double.parseDouble(textUser[4]);
          	  command = new CommandCreateCa(textUser[0],point,side,groupId);
          	  shape = ((CommandCreate<Carre>)command).execute();
  	          formes.add((Carre)shape);
  	          CreateGroupe(groupId,(Carre)shape);
    	      break;
            case "triangle":
        	  groupId = Integer.parseInt(textUser[6]);
              double base = Double.parseDouble(textUser[4]);
              double height = Double.parseDouble(textUser[5]);
              command = new CommandCreateT(textUser[0],point,base,height,groupId);
        	  shape = ((CommandCreate<Triangle>)command).execute();
    	      formes.add((Triangle)shape);
    	      CreateGroupe(groupId,(Triangle)shape);
    	      break;
            case "rectangle":
        	  groupId = Integer.parseInt(textUser[6]);
              double length = Double.parseDouble(textUser[4]);
              double width = Double.parseDouble(textUser[5]);
              command = new CommandCreateRe(textUser[0],point,length,width,groupId);
              shape = ((CommandCreate<Rectangle>)command).execute();
    	      formes.add((Rectangle)shape);
    	      CreateGroupe(groupId,(Rectangle)shape);
    	      break;
            default:
              break;
          }
      }
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      System.out.println("votre description de dessin est erronée.");
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
}
