package com.baticuisine.services;

import com.baticuisine.models.Projet;
import com.baticuisine.repositories.interfaces.ProjetRepository;
import com.baticuisine.repositories.impl.ProjetRepositoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProjetService {
    private final Map<String, Projet> projetMap = new HashMap<>();
    private final ProjetRepository projetRepository;

    public ProjetService() {
        this.projetRepository = new ProjetRepositoryImpl();
        chargerProjets();
    }

    public void chargerProjets() {
        projetRepository.recupererTousLesProjets().forEach(projet -> projetMap.put(projet.getNomProjet(), projet));
    }

    public void ajouterProjet(Projet projet) {
        projetRepository.ajouterProjet(projet);
        projetMap.put(projet.getNomProjet(), projet);
    }

    public Optional<Projet> chercherProjetParNom(String nomProjet) {
        return Optional.ofNullable(projetMap.get(nomProjet));
    }

    public void mettreAJourCoutTotal(Projet projet) {
        projetRepository.mettreAJourCoutTotal(projet);
        projetMap.put(projet.getNomProjet(), projet);
    }
}
