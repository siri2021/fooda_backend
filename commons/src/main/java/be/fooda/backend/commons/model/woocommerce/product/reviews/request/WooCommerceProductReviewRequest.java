package be.fooda.backend.commons.model.woocommerce.product.reviews.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WooCommerceProductReviewRequest {

    @JsonProperty("review")
    private String review;

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("reviewer")
    private String reviewer;

    @JsonProperty("reviewer_email")
    private String reviewerEmail;
}