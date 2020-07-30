package com.shop.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(schema = "shopping")
public class Product {

    @Id
    @Column(updatable = false)
    private String productCode;

    @NotBlank
    @Column(nullable = false)
    private String productName;

    @NotBlank
    @Column(nullable = false)
    private float productPrice;

    @NotBlank
    @Column(nullable = false)
    private Integer productCount;

    @Column
    private String productType;

    @Column
    private String productOffer;

    @Column
    private Timestamp createdOn;

    @Column
    private Timestamp updatedOn;

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

    /**
     * @return the createdOn
     */
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn
     *            the createdOn to set
     */
    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the updatedOn
     */
    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    /**
     * @param updatedOn
     *            the updatedOn to set
     */
    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Product [productCode=" + productCode + ", productName=" + productName + ", productPrice=" + productPrice + ", productCount=" + productCount + ", productType=" + productType
            + ", productOffer=" + productOffer + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
    }

}
