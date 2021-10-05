package semifir.kira.demo.elastic.services.impl;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import semifir.kira.demo.elastic.models.Utilisateur;
import semifir.kira.demo.elastic.repositories.UtilisateurElasticRepository;
import semifir.kira.demo.elastic.repositories.UtilisateurRepository;
import semifir.kira.demo.elastic.services.UtilisateurService;

public class UtilisateurServiceImpl extends AbstractCRUDService<Utilisateur> implements UtilisateurService {

    public UtilisateurServiceImpl(UtilisateurRepository repository) {
        super(repository);
        System.out.println(repository.sayToto());
    }


}
