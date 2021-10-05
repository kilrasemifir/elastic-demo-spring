package semifir.kira.demo.elastic.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import semifir.kira.demo.elastic.models.Utilisateur;

public interface UtilisateurElasticRepository extends ElasticsearchRepository<Utilisateur, String> {
}
