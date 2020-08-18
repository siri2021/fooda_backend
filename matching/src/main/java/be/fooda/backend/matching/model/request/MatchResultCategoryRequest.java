package be.fooda.backend.matching.model.request;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "MATCH_CATEGORY")
public class MatchResultCategoryRequest implements Serializable {

    private static final long serialVersionUID = 7134150925415141731L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "parent")
    private MatchResultCategoryRequest parent;

    @Column(name = "weight")
    private Double weight;
}
