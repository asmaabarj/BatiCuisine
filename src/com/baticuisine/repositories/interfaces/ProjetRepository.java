package com.baticuisine.repositories.interfaces;

import com.baticuisine.models.Projet;

public interface ProjetRepository {
    void ajouterProjet(Projet projet);
    void mettreAJourCoutTotal(Projet projet);
    void mettreAJourMargeBeneficiaire(int projetId, double nouvelleMarge);
    public void mettreAJourEtatProjet(Projet projet) ;

    }
