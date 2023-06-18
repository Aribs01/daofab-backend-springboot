package com.example.daofabbackend.dao;

import com.example.daofabbackend.model.Parent;

import java.util.List;
import java.util.Optional;

public interface ParentDao {

    List<Parent> selectAllParent(int pageNumber, int pageSize);

    Optional<Parent> selectParentById(int id);
}
