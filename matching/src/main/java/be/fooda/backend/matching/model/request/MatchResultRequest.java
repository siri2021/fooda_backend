package be.fooda.backend.matching.model.request;

import java.io.Serializable;
import java.math.BigInteger;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "MATCH_RESULT")
public class MatchResultRequest implements Serializable{
	private static final long serialVersionUID = -414398119931631885L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_result_id")
    private BigInteger id;

    @Column(name = "related_id")
    private Integer relatedId;

    @Column(name = "keyword")
    private String keyword;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MatchResultCategoryRequest category;

    @Column(name = "score")
    private Double score;
    
}