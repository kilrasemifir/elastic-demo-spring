package semifir.kira.demo.elastic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import semifir.kira.demo.elastic.repositories.UtilisateurElasticRepository;
import semifir.kira.demo.elastic.repositories.UtilisateurRepository;
import semifir.kira.demo.elastic.services.UtilisateurService;
import semifir.kira.demo.elastic.services.impl.UtilisateurServiceImpl;

@Configuration
public class UtilisateurConfiguration {

    @Bean
    public UtilisateurService utilisateurService(UtilisateurRepository repo){
        return new UtilisateurServiceImpl(repo);
    }
}
