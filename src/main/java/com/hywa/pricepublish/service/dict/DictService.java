package com.hywa.pricepublish.service.dict;

import com.hywa.pricepublish.representation.DictReps;

public interface DictService {
    DictReps findDictListByDictType(String dictTypeId);
}
