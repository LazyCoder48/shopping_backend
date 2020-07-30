package com.shop.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {

    private static final long serialVersionUID = 6183554232733700075L;
    private String productCode;
    private String productName;
    private float productPrice;
    private Integer productCount;
    private String productType;
    private String productOffer;

    /**
     * @return the productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * @param productCode
     *            the productCode to set
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     *            the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productPrice
     */
    public float getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice
     *            the productPrice to set
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return the productCount
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * @param productCount
     *            the productCount to set
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType
     *            the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the productOffer
     */
    public String getProductOffer() {
        return productOffer;
    }

    /**
     * @param productOffer
     *            the productOffer to set
     */
    public void setProductOffer(String productOffer) {
        this.productOffer = productOffer;
    }

    @Override
    public String toString() {
        return "ProductDto [" + (productCode != null ? "productCode=" + productCode + ", " : "") + (productName != null ? "productName=" + productName + ", " : "") + "productPrice=" + productPrice
            + ", " + (productCount != null ? "productCount=" + productCount + ", " : "") + (productType != null ? "productType=" + productType + ", " : "")
            + (productOffer != null ? "productOffer=" + productOffer : "") + "]";
    }

}
