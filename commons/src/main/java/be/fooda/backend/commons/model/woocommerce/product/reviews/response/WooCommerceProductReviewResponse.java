package be.fooda.backend.commons.model.woocommerce.product.reviews.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WooCommerceProductReviewResponse {

    @JsonProperty("reviewer_avatar_urls")
    private ReviewerAvatarUrls reviewerAvatarUrls;

    @JsonProperty("_links")
    private Links links;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("review")
    private String review;

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("verified")
    private Boolean verified;

    @JsonProperty("date_created_gmt")
    private String dateCreatedGmt;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("reviewer")
    private String reviewer;

    @JsonProperty("reviewer_email")
    private String reviewerEmail;

    @JsonProperty("status")
    private String status;
}