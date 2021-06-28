package com.gcl.crm.service;

import com.gcl.crm.entity.Source;
import com.gcl.crm.repository.SourceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {

    @Autowired
    SourceJpaRepository sourceJpaRepository;

    public Source getSourceByName(String name){
        List<Source> sources = sourceJpaRepository.findAllBySourceName(name);
        if (sources.size() > 0){
            return sources.get(0);
        }
        return null;
    }
}
