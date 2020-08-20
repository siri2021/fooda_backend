package be.fooda.backend.matching.model.request;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "MATCH_RESULT")
public class MatchResultRequest implements Serializable {
    private static final long serialVersionUID = -414398119931631885L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_result_id")
    private Long id;

    @Column(name = "related_id")
    private Integer relatedId;

    @Column(name = "keyword")
    private String keyword;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MatchResultCategoryRequest category;

    @Column(name = "score")
    private Double score;
    
}