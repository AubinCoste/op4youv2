package fr.gtm.op4youMaven.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.op4youMaven.domaine.Youtuber;

public class YoutuberDAO {

	// cr�er un objet de connection BDD
	ConnectionBDD myConnection = new ConnectionBDD();
	// cr�er un youtuber temporaire pour r�cup�rer les infos
	Youtuber temporaryYT = null;
	// Une liste de Youtuber pour le get all
	ArrayList<Youtuber> listeYT = new ArrayList<Youtuber>();

	// Methode CRUD

	// Create de CRUD
	public void createYoutuber(Youtuber myYoutuber) {
		// cr�er la requete
		String requete = "INSERT INTO youtuber VALUES ('" + myYoutuber.getId() + "','" + myYoutuber.getNom() + "','"
				+ myYoutuber.getPrenom() + "','" + myYoutuber.getNomChaine() + "','" + myYoutuber.getLienChaine()
				+ "','" + myYoutuber.getNbrAbonnes() + "')";
		// se connecter � la base de donn�es
		myConnection.seConnecter();
		// ex�cuter al requte
		myConnection.updateData(requete);
		;
		// fermer la connection
		myConnection.closeConnection();

	}

	// Read de CRUD
	public Youtuber readYoutuberFromID(int idYT) {
		// cr�er la requete
		String requete = "SELECT * FROM youtuber WHERE idYoutuber=" + idYT;
		// Cr�er un resultset et y mettre le r�sultat
		ResultSet rs = myConnection.executeRequete(requete);
		// faire un try catch sur �a
		try {
			while (rs.next()) {
				String nom = rs.getString("nomYT");
				String prenom = rs.getString("prenomYT");
				String nomChaine = rs.getString("nomChaine");
				String lienChaine = rs.getString("lienChaine");
				int nbrAbos = rs.getInt("nbrAbonnes");
				String login = rs.getString("login");
				String mdp = rs.getString("mdp");
				// mettre ce r�sultat dans mon youtuber temporairee
				temporaryYT = new Youtuber(idYT, nom, prenom, nomChaine, lienChaine, nbrAbos, login, mdp);

			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la m�thode readYoutuberFromID de la classe YoutuberDAO");
			e.printStackTrace();
			System.out.println("------------------------------------------------------------");
		}

		//fermer la co
		myConnection.closeConnection();
		return temporaryYT;
	}

	// Methode pour retourner la liste de youtuber
	public ArrayList<Youtuber> getAll() {
		// cr�er la requete
		String requete = "SELECT * FROM youtuber";
		// cr�er le resultset et y mettre le r�sultat
		ResultSet rs = myConnection.executeRequete(requete);
		// faire un try catch sur �a
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
				// mettre ce r�sultat dans mon youtuber temporairee
				temporaryYT = new Youtuber(id, nom, prenom, nomChaine, lienChaine, nbrAbos, login, mdp);
				// et remplir l'arraylist
				listeYT.add(temporaryYT);
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la m�thode getAll de la classe YoutuberDAO");
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
		
		//se connecter � la base de donner
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
				// mettre ce r�sultat dans mon youtuber temporairee
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
