package com.hywa.pricepublish.representation;

import com.hywa.pricepublish.dao.entity.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductRep {
    private String productId;
    private String productName;
    private String unit;
    private BigDecimal price;

    public ProductRep() {
    }

    public ProductRep(Product product) {
        this.setProductId(product.getId());
        this.setProductName(product.getName());
        this.setUnit(product.getUnit());
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRep that = (ProductRep) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, unit);
    }

    @Override
    public String toString() {
        return "ProductRep{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
