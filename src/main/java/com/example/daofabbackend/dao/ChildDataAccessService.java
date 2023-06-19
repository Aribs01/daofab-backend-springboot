package com.example.daofabbackend.dao;

import com.example.daofabbackend.model.Child;
import com.example.daofabbackend.model.Parent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("fakeChildDao")
public class ChildDataAccessService implements ChildDao{
    private static final String JSON_FILE_PATH = "static/Child.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final ParentDao parentDao;

    @Autowired
    public ChildDataAccessService(@Qualifier("fakeDao") ParentDao parentDao) {
        this.parentDao = parentDao;
    }

    @Override
    public List<Child> selectAllChild() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(JSON_FILE_PATH);

            JsonNode rootNode = objectMapper.readTree(inputStream);
            JsonNode dataArray = rootNode.get("data");

            if (dataArray.isArray()) {
                Child[] children = objectMapper.treeToValue(dataArray, Child[].class);
                return Arrays.asList(children);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<Child> selectChildById(int id) {
        var allChildren = selectAllChild();
        return allChildren.stream().filter(child -> child.getId() == id).findFirst();
    }

    @Override
    public List<Child> selectChildByParentId(int id) {
//        Parent parent = new Parent(2, "PPP", "PAPA", 1000);

        Optional<Parent> parent = parentDao.selectParentById(id);

        List<Child> allChildren = selectAllChild();
        List<Child> filteredChildren = allChildren.stream().filter(child -> child.getParentId() == id)
                .collect(Collectors.toList());

        for (Child child : filteredChildren) {
//            child.setParent(Optional.of(parent));
            child.setParent(parent);
        }

        return filteredChildren;
    }
}
