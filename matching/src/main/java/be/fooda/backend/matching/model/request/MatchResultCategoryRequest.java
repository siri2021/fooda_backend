package be.fooda.backend.matching.model.request;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "MATCH_CATEGORY")
public class MatchResultCategoryRequest implements Serializable {

    private static final long serialVersionUID = 7134150925415141731L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "parent")
    private MatchResultCategoryRequest parent;

    @Column(name = "weight")
    private Double weight;
}
