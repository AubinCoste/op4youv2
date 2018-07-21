package fr.gtm.op4youMaven.service;

import java.util.ArrayList;

import fr.gtm.op4youMaven.dao.YoutuberDAO;
import fr.gtm.op4youMaven.domaine.Youtuber;

public class YoutuberService {
	
	//Cr�er un objet dao
	YoutuberDAO maDao = new YoutuberDAO();
	//cr�er un youtuber temporaire
	Youtuber monYoutuber = null;
	//cr�er une liste de youtuber
	ArrayList<Youtuber> listeYoutuber = new ArrayList<Youtuber>();
	
	//m�thod authentification
	public Youtuber authentifier(String login, String mdp) {
		monYoutuber = maDao.checkConnect(login, mdp);
		return monYoutuber;
	}
	//m�thode pour cr�er un youtuber
	public void createYoutuber(Youtuber unYoutuber) {
		maDao.createYoutuber(unYoutuber);
	}
	
	//m�thode pour r�cup�rer tous les youtuber
	public ArrayList<Youtuber> getAll(){
		listeYoutuber = maDao.getAll();
		return listeYoutuber;
	}
	
	//m�thode pour r�cup�rer un youtuber
	public Youtuber readYoutuberById(int idYt) {
		monYoutuber = maDao.readYoutuberFromID(idYt);
		return monYoutuber;
	}
}
