package semifir.kira.demo.elastic.repositories;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;
import semifir.kira.demo.elastic.models.Utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class CustomUtilisateurRepositoryImpl implements CustomUtilisateurRepository{

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<Utilisateur> search(String nom, String prenom, String biographie) {

        /*
        "bool": {
            "should": [
                { "match": { "nom": "TEXT" } },
                { "match": { "prenom": "TEXT" } },
                { "match": { "biographie": "TEXT" } }
            ]
         }
         */
        QueryBuilder queryBuilder = QueryBuilders
                .boolQuery()
                    .should(QueryBuilders.matchQuery("nom", nom))
                    .should(QueryBuilders.matchQuery("prenom", prenom))
                    .should(QueryBuilders.matchQuery("biographie", biographie));

        /*
        { "query": ... }
         */
        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        /*
        GET utilisateurs/_search + searchQuery en body
         */
        SearchHits<Utilisateur> hits = elasticsearchOperations.search(
                searchQuery,
                Utilisateur.class,
                IndexCoordinates.of("utilisateurs"));

        return hits.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());

    }
}
