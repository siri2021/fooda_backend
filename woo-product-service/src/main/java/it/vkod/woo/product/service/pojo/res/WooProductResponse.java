package it.vkod.woo.product.service.pojo.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooProductResponse implements Serializable {

    @Getter
    @Setter
    private long storeId;
    @Getter
    @Setter
    private String restUrl;
    @Getter
    @Setter
    private List<Object> upsellIds;
    @Getter
    @Setter
    private boolean featured;
    @Getter
    @Setter
    private boolean purchasable;
    @Getter
    @Setter
    private List<Object> groupedProducts;
    @Getter
    @Setter
    private Links links;
    @Getter
    @Setter
    private String taxStatus;
    @Getter
    @Setter
    private String catalogVisibility;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String externalUrl;
    @Getter
    @Setter
    private Double price;
    @Getter
    @Setter
    private List<Object> metaData;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String sku;
    @Getter
    @Setter
    private String slug;
    @Getter
    @Setter
    private Object dateOnSaleFrom;
    @Getter
    @Setter
    private boolean shippingRequired;
    @Getter
    @Setter
    private String dateModifiedGmt;
    @Getter
    @Setter
    private List<ImagesItem> images;
    @Getter
    @Setter
    private String stockStatus;
    @Getter
    @Setter
    private String priceHtml;
    @Getter
    @Setter
    private int downloadExpiry;
    @Getter
    @Setter
    private boolean backordered;
    @Getter
    @Setter
    private String weight;
    @Getter
    @Setter
    private int ratingCount;
    @Getter
    @Setter
    private List<TagsItem> tags;
    @Getter
    @Setter
    private Object dateOnSaleTo;
    @Getter
    @Setter
    private boolean soldIndividually;
    @Getter
    @Setter
    private String backorders;
    @Getter
    @Setter
    private boolean shippingTaxable;
    @Getter
    @Setter
    private int parentId;
    @Getter
    @Setter
    private int downloadLimit;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String shippingClass;
    @Getter
    @Setter
    private String buttonText;
    @Getter
    @Setter
    private String permalink;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private List<Object> crossSellIds;
    @Getter
    @Setter
    private String shortDescription;
    @Getter
    @Setter
    private boolean virtual;
    @Getter
    @Setter
    private boolean downloadable;
    @Getter
    @Setter
    private int menuOrder;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Object dateOnSaleToGmt;
    @Getter
    @Setter
    private Object dateOnSaleFromGmt;
    @Getter
    @Setter
    private String regularPrice;
    @Getter
    @Setter
    private boolean backordersAllowed;
    @Getter
    @Setter
    private List<Object> downloads;
    @Getter
    @Setter
    private boolean reviewsAllowed;
    @Getter
    @Setter
    private List<Object> variations;
    @Getter
    @Setter
    private List<CategoriesItem> categories;
    @Getter
    @Setter
    private String totalSales;
    @Getter
    @Setter
    private boolean onSale;
    @Getter
    @Setter
    private boolean manageStock;
    @Getter
    @Setter
    private List<Object> defaultAttributes;
    @Getter
    @Setter
    private String purchaseNote;
    @Getter
    @Setter
    private String dateCreated;
    @Getter
    @Setter
    private String taxClass;
    @Getter
    @Setter
    private String dateCreatedGmt;
    @Getter
    @Setter
    private String averageRating;
    @Getter
    @Setter
    private Object stockQuantity;
    @Getter
    @Setter
    private String salePrice;
    @Getter
    @Setter
    private int shippingClassId;
    @Getter
    @Setter
    private String dateModified;
    @Getter
    @Setter
    private List<Integer> relatedIds;
    @Getter
    @Setter
    private List<Object> attributes;
    @Getter
    @Setter
    private Dimensions dimensions;


}