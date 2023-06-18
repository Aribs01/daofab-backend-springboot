package com.example.daofabbackend.service;

import com.example.daofabbackend.dao.ChildDao;
import com.example.daofabbackend.model.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildService {
    private final ChildDao childDao;

    @Autowired
    public ChildService(@Qualifier("fakeChildDao") ChildDao childDao) {
        this.childDao = childDao;
    }

    public List<Child> getAllChildren() {
        return childDao.selectAllChild();
    }

    public Optional<Child> getChildById(int id) {
        return childDao.selectChildById(id);
    }

    public Optional<Child> getChildByParentId(int id) {
        return childDao.selectChildByParentId(id);
    }
}
