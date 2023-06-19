package com.example.daofabbackend.dao;

import com.example.daofabbackend.model.Child;

import java.util.List;
import java.util.Optional;

public interface ChildDao {

    List<Child> selectAllChild();

    Optional<Child> selectChildById(int id);

    List<Child> selectChildByParentId(int id);
}
