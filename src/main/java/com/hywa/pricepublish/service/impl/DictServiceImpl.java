package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.dao.entity.Dict;
import com.hywa.pricepublish.dao.mapper.DictMapper;
import com.hywa.pricepublish.representation.DictRep;
import com.hywa.pricepublish.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DictServiceImpl implements DictService {

    @Autowired
    public DictMapper dictMapper;

    @Override
    public List<DictRep> findDictListByDictType(String dictTypeId) {
        List<Dict> dictList = dictMapper.selectByDictType(dictTypeId);
        List<DictRep> dictReps = new ArrayList<>();
        dictList.forEach(dict -> {
            DictRep dictRep = new DictRep(dict.getId(), dict.getCode(), dict.getName());
            dictReps.add(dictRep);
        });
        return dictReps;
    }
}
