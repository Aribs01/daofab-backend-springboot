package com.example.daofabbackend.service;

import com.example.daofabbackend.dao.ParentDao;
import com.example.daofabbackend.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    private final ParentDao parentDao;

    @Autowired
    public ParentService(@Qualifier("fakeDao") ParentDao parentDao) {
        this.parentDao = parentDao;
    }

    public List<Parent> getAllParent(int pageNumber, int pageSize) {
        return parentDao.selectAllParent(pageNumber, pageSize);
    }

    public Optional<Parent> getParentById(int id) {
        return parentDao.selectParentById(id);
    }
}
