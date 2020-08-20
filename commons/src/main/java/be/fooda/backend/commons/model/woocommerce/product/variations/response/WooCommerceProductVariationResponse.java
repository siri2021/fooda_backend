package be.fooda.backend.commons.model.woocommerce.product.variations.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class WooCommerceProductVariationResponse {

    @JsonProperty("purchasable")
    private Boolean purchasable;

    @JsonProperty("virtual")
    private Boolean virtual;

    @JsonProperty("downloadable")
    private Boolean downloadable;

    @JsonProperty("menu_order")
    private Integer menuOrder;

    @JsonProperty("_links")
    private Links links;

    @JsonProperty("tax_status")
    private String taxStatus;

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

    @JsonProperty("price")
    private String price;

    @JsonProperty("meta_data")
    private List<Object> metaData;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("date_on_sale_from")
    private Object dateOnSaleFrom;

    @JsonProperty("on_sale")
    private Boolean onSale;

    @JsonProperty("date_modified_gmt")
    private String dateModifiedGmt;

    @JsonProperty("manage_stock")
    private Boolean manageStock;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("stock_status")
    private String stockStatus;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("tax_class")
    private String taxClass;

    @JsonProperty("download_expiry")
    private Integer downloadExpiry;

    @JsonProperty("backordered")
    private Boolean backordered;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("date_created_gmt")
    private String dateCreatedGmt;

    @JsonProperty("stock_quantity")
    private Object stockQuantity;

    @JsonProperty("sale_price")
    private String salePrice;

    @JsonProperty("shipping_class_id")
    private Integer shippingClassId;

    @JsonProperty("date_on_sale_to")
    private Object dateOnSaleTo;

    @JsonProperty("date_modified")
    private String dateModified;

    @JsonProperty("backorders")
    private String backorders;

    @JsonProperty("download_limit")
    private Integer downloadLimit;

    @JsonProperty("shipping_class")
    private String shippingClass;

    @JsonProperty("attributes")
    private List<AttributesItem> attributes;

    @JsonProperty("permalink")
    private String permalink;

    @JsonProperty("status")
    private String status;

    @JsonProperty("dimensions")
    private Dimensions dimensions;
}