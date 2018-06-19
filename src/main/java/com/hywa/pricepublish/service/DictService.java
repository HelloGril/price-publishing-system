package com.hywa.pricepublish.service;

import com.hywa.pricepublish.representation.DictReps;

public interface DictService {
    DictReps findDictListByDictType(String dictTypeId);
}
