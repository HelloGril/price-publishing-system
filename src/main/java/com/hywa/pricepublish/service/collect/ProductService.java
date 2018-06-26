package com.hywa.pricepublish.service.collect;

import com.hywa.pricepublish.representation.ProductRep;
import com.hywa.pricepublish.representation.ProductReps;

public interface ProductService {
    ProductReps findByType(String typeId, Integer pageNum, Integer pageSize);

    void save(ProductRep productRep);

    ProductReps findRecentUse(String userId);
}
