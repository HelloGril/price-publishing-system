package com.hywa.pricepublish.service;

import com.hywa.pricepublish.representation.ProductRep;

import java.util.List;

public interface ProductService {
    List<ProductRep> findByType(String typeId);

    void save(ProductRep productRep);
}
