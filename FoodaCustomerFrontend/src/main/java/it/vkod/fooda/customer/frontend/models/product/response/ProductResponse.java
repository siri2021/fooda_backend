package it.vkod.fooda.customer.frontend.models.product.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse implements Serializable {

    private long storeId;
    private String restUrl;
    private List<Object> upsellIds;
    private boolean featured;
    private boolean purchasable;
    private List<Object> groupedProducts;
    private Links links;
    private String taxStatus;
    private String catalogVisibility;
    private String type;
    private String externalUrl;
    private Double price;
    private List<Object> metaData;
    private int id;
    private String sku;
    private String slug;
    private Object dateOnSaleFrom;
    private boolean shippingRequired;
    private String dateModifiedGmt;
    private List<ImagesItem> images;
    private String stockStatus;
    private String priceHtml;
    private int downloadExpiry;
    private boolean backordered;
    private String weight;
    private int ratingCount;
    private List<TagsItem> tags;
    private Object dateOnSaleTo;
    private boolean soldIndividually;
    private String backorders;
    private boolean shippingTaxable;
    private int parentId;
    private int downloadLimit;
    private String name;
    private String shippingClass;
    private String buttonText;
    private String permalink;
    private String status;
    private List<Object> crossSellIds;
    private String shortDescription;
    private boolean virtual;
    private boolean downloadable;
    private int menuOrder;
    private String description;
    private Object dateOnSaleToGmt;
    private Object dateOnSaleFromGmt;
    private String regularPrice;
    private boolean backordersAllowed;
    private List<Object> downloads;
    private boolean reviewsAllowed;
    private List<Object> variations;
    private List<CategoriesItem> categories;
    private String totalSales;
    private boolean onSale;
    private boolean manageStock;
    private List<Object> defaultAttributes;
    private String purchaseNote;
    private String dateCreated;
    private String taxClass;
    private String dateCreatedGmt;
    private String averageRating;
    private Object stockQuantity;
    private String salePrice;
    private int shippingClassId;
    private String dateModified;
    private List<Integer> relatedIds;
    private List<Object> attributes;
    private Dimensions dimensions;
}