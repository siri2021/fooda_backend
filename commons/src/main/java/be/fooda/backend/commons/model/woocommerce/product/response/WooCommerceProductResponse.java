package be.fooda.backend.commons.model.woocommerce.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class WooCommerceProductResponse {

    @JsonProperty("store_id")
    private Integer storeId;

    @JsonProperty("upsell_ids")
    private List<Object> upsellIds;

    @JsonProperty("featured")
    private Boolean featured;

    @JsonProperty("purchasable")
    private Boolean purchasable;

    @JsonProperty("grouped_products")
    private List<Object> groupedProducts;

    @JsonProperty("_links")
    private Links links;

    @JsonProperty("tax_status")
    private String taxStatus;

    @JsonProperty("catalog_visibility")
    private String catalogVisibility;

    @JsonProperty("type")
    private String type;

    @JsonProperty("external_url")
    private String externalUrl;

    @JsonProperty("price")
    private String price;

    @JsonProperty("meta_data")
    private List<Object> metaData;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("date_on_sale_from")
    private Object dateOnSaleFrom;

    @JsonProperty("shipping_required")
    private Boolean shippingRequired;

    @JsonProperty("date_modified_gmt")
    private String dateModifiedGmt;

    @JsonProperty("images")
    private List<ImagesItem> images;

    @JsonProperty("stock_status")
    private String stockStatus;

    @JsonProperty("price_html")
    private String priceHtml;

    @JsonProperty("download_expiry")
    private Integer downloadExpiry;

    @JsonProperty("backordered")
    private Boolean backordered;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("rating_count")
    private Integer ratingCount;

    @JsonProperty("tags")
    private List<Object> tags;

    @JsonProperty("date_on_sale_to")
    private Object dateOnSaleTo;

    @JsonProperty("sold_individually")
    private Boolean soldIndividually;

    @JsonProperty("backorders")
    private String backorders;

    @JsonProperty("shipping_taxable")
    private Boolean shippingTaxable;

    @JsonProperty("parent_id")
    private Integer parentId;

    @JsonProperty("download_limit")
    private Integer downloadLimit;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shipping_class")
    private String shippingClass;

    @JsonProperty("button_text")
    private String buttonText;

    @JsonProperty("permalink")
    private String permalink;

    @JsonProperty("status")
    private String status;

    @JsonProperty("cross_sell_ids")
    private List<Object> crossSellIds;

    @JsonProperty("short_description")
    private String shortDescription;

    @JsonProperty("virtual")
    private Boolean virtual;

    @JsonProperty("downloadable")
    private Boolean downloadable;

    @JsonProperty("menu_order")
    private Integer menuOrder;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date_on_sale_to_gmt")
    private Object dateOnSaleToGmt;

    @JsonProperty("date_on_sale_from_gmt")
    private Object dateOnSaleFromGmt;

    @JsonProperty("regular_price")
    private String regularPrice;

    @JsonProperty("backorders_allowed")
    private Boolean backordersAllowed;

    @JsonProperty("downloads")
    private List<Object> downloads;

    @JsonProperty("reviews_allowed")
    private Boolean reviewsAllowed;

    @JsonProperty("variations")
    private List<Object> variations;

    @JsonProperty("categories")
    private List<CategoriesItem> categories;

    @JsonProperty("total_sales")
    private Integer totalSales;

    @JsonProperty("on_sale")
    private Boolean onSale;

    @JsonProperty("manage_stock")
    private Boolean manageStock;

    @JsonProperty("default_attributes")
    private List<Object> defaultAttributes;

    @JsonProperty("purchase_note")
    private String purchaseNote;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("tax_class")
    private String taxClass;

    @JsonProperty("date_created_gmt")
    private String dateCreatedGmt;

    @JsonProperty("average_rating")
    private String averageRating;

    @JsonProperty("stock_quantity")
    private Object stockQuantity;

    @JsonProperty("sale_price")
    private String salePrice;

    @JsonProperty("shipping_class_id")
    private Integer shippingClassId;

    @JsonProperty("date_modified")
    private String dateModified;

    @JsonProperty("related_ids")
    private List<Integer> relatedIds;

    @JsonProperty("attributes")
    private List<Object> attributes;

    @JsonProperty("dimensions")
    private Dimensions dimensions;
}