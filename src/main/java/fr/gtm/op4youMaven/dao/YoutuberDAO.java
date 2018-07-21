package fr.gtm.op4youMaven.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.op4youMaven.domaine.Youtuber;

public class YoutuberDAO {

	// créer un objet de connection BDD
	ConnectionBDD myConnection = new ConnectionBDD();
	// créer un youtuber temporaire pour récupérer les infos
	Youtuber temporaryYT = null;
	// Une liste de Youtuber pour le get all
	ArrayList<Youtuber> listeYT = new ArrayList<Youtuber>();

	// Methode CRUD

	// Create de CRUD
	public void createYoutuber(Youtuber myYoutuber) {
		// créer la requete
		String requete = "INSERT INTO youtuber VALUES ('" + myYoutuber.getId() + "','" + myYoutuber.getNom() + "','"
				+ myYoutuber.getPrenom() + "','" + myYoutuber.getNomChaine() + "','" + myYoutuber.getLienChaine()
				+ "','" + myYoutuber.getNbrAbonnes() + "')";
		// se connecter à la base de données
		myConnection.seConnecter();
		// exécuter al requte
		myConnection.updateData(requete);
		;
		// fermer la connection
		myConnection.closeConnection();

	}

	// Read de CRUD
	public Youtuber readYoutuberFromID(int idYT) {
		// créer la requete
		String requete = "SELECT * FROM youtuber WHERE idYoutuber=" + idYT;
		// Créer un resultset et y mettre le résultat
		ResultSet rs = myConnection.executeRequete(requete);
		// faire un try catch sur ça
		try {
			while (rs.next()) {
				String nom = rs.getString("nomYT");
				String prenom = rs.getString("prenomYT");
				String nomChaine = rs.getString("nomChaine");
				String lienChaine = rs.getString("lienChaine");
				int nbrAbos = rs.getInt("nbrAbonnes");
				String login = rs.getString("login");
				String mdp = rs.getString("mdp");
				// mettre ce résultat dans mon youtuber temporairee
				temporaryYT = new Youtuber(idYT, nom, prenom, nomChaine, lienChaine, nbrAbos, login, mdp);

			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la méthode readYoutuberFromID de la classe YoutuberDAO");
			e.printStackTrace();
			System.out.println("------------------------------------------------------------");
		}

		//fermer la co
		myConnection.closeConnection();
		return temporaryYT;
	}

	// Methode pour retourner la liste de youtuber
	public ArrayList<Youtuber> getAll() {
		// créer la requete
		String requete = "SELECT * FROM youtuber";
		// créer le resultset et y mettre le résultat
		ResultSet rs = myConnection.executeRequete(requete);
		// faire un try catch sur ça
		try {
			while (rs.next()) {
				int id = rs.getInt("idYoutuber");
				String nom = rs.getString("nomYT");
				String prenom = rs.getString("prenomYT");
				String nomChaine = rs.getString("nomChaine");
				String lienChaine = rs.getString("lienChaine");
				int nbrAbos = rs.getInt("nbrAbonnes");
				String login = rs.getString("login");
				String mdp = rs.getString("mdp");
				// mettre ce résultat dans mon youtuber temporairee
				temporaryYT = new Youtuber(id, nom, prenom, nomChaine, lienChaine, nbrAbos, login, mdp);
				// et remplir l'arraylist
				listeYT.add(temporaryYT);
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la méthode getAll de la classe YoutuberDAO");
			e.printStackTrace();
			System.out.println("------------------------------------------------------------");
		}
		//fermer la connection
		myConnection.closeConnection();
		return listeYT;
	}

	// Methode update de CRUD
	public void updateYoutuber(Youtuber oldVersion, Youtuber newVersion) {
		// creer la requete
		String requete = "UPDATE youtuber SET nom='" + newVersion.getNom() + "', prenom = '" + newVersion.getPrenom()
				+ "', nomChaine = '" + newVersion.getNomChaine() + "', lienChaine='" + newVersion.getLienChaine()
				+ "', nbrAbonnes = '" + newVersion.getNbrAbonnes() + "' WHERE idYoutuber=" + oldVersion.getId();
		//se connecter
		myConnection.seConnecter();
		//executer la requete
		myConnection.executeRequete(requete);
		//fermer la connection
		myConnection.closeConnection();
	}
	
	//Methode delete de CRUD
	public void deleteYoutuber(Youtuber myYoutuber) {
		//creer la requete
		String requete = "DELETE FROM youtuber WHERE idYoutuber = "+myYoutuber.getId();
		//executer la requete
		myConnection.executeRequete(requete);
		//fermer la connection
		myConnection.closeConnection();
	}
	
	//Method de check authentification
	public Youtuber checkConnect(String login, String mdp) {
		//creation de la requete
		String requete = "SELECT * FROM youtuber WHERE login='"+login+"' AND mdp='"+mdp+"'";
		
		//se connecter à la base de donner
		myConnection.seConnecter();
		
		//executer la requete et mettre dans un resultset
		ResultSet rs = myConnection.executeRequete(requete);
		
		try {
			while(rs.next()) {
				int id = rs.getInt("idYoutuber");
				String nom = rs.getString("nomYT");
				String prenom = rs.getString("prenomYT");
				String nomChaine = rs.getString("nomChaine");
				String lienChaine = rs.getString("lienChaine");
				int nbrAbos = rs.getInt("nbrAbonnes");
				String loginyt = rs.getString("login");
				String mdpyt = rs.getString("mdp");
				// mettre ce résultat dans mon youtuber temporairee
				temporaryYT = new Youtuber(id, nom, prenom, nomChaine, lienChaine, nbrAbos, loginyt, mdpyt);
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur lors de la methode checkConnect de YoutuberDao");
			e.printStackTrace();
			System.out.println("--------------------------------------------------------");
		}
		
		return temporaryYT;
	}
}
