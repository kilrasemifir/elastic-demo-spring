package semifir.kira.demo.elastic.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "utilisateurs")
public class Utilisateur {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String nom;
    @Field(type = FieldType.Keyword)
    private String prenom;
    @Field(type = FieldType.Text)
    private String biographie;

}
