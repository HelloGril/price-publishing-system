package com.hywa.pricepublish.service;

import com.hywa.pricepublish.representation.DictRep;

import java.util.List;

public interface DictService {
    List<DictRep> findDictListByDictType(String dictTypeId);
}
