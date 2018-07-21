package fr.gtm.op4youMaven.service;

import java.util.ArrayList;

import fr.gtm.op4youMaven.dao.YoutuberDAO;
import fr.gtm.op4youMaven.domaine.Youtuber;

public class YoutuberService {
	
	//Créer un objet dao
	YoutuberDAO maDao = new YoutuberDAO();
	//créer un youtuber temporaire
	Youtuber monYoutuber = null;
	//créer une liste de youtuber
	ArrayList<Youtuber> listeYoutuber = new ArrayList<Youtuber>();
	
	//méthod authentification
	public Youtuber authentifier(String login, String mdp) {
		monYoutuber = maDao.checkConnect(login, mdp);
		return monYoutuber;
	}
	//méthode pour créer un youtuber
	public void createYoutuber(Youtuber unYoutuber) {
		maDao.createYoutuber(unYoutuber);
	}
	
	//méthode pour récupérer tous les youtuber
	public ArrayList<Youtuber> getAll(){
		listeYoutuber = maDao.getAll();
		return listeYoutuber;
	}
	
	//méthode pour récupérer un youtuber
	public Youtuber readYoutuberById(int idYt) {
		monYoutuber = maDao.readYoutuberFromID(idYt);
		return monYoutuber;
	}
}
