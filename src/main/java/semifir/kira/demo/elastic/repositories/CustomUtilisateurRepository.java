package semifir.kira.demo.elastic.repositories;

import semifir.kira.demo.elastic.models.Utilisateur;

import java.util.List;

public interface CustomUtilisateurRepository {
    List<Utilisateur> search(String nom, String prenom, String biographie);
}
