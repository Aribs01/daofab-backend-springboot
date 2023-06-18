package com.example.daofabbackend.dao;

import com.example.daofabbackend.model.Child;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository("fakeChildDao")
public class ChildDataAccessService implements ChildDao{
    private static final String JSON_FILE_PATH = "static/Child.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

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
        var allParents = selectAllChild();
        return allParents.stream().filter(child -> child.getId() == id).findFirst();
    }

    @Override
    public Optional<Child> selectChildByParentId(int id) {
        var allParents = selectAllChild();
        return allParents.stream().filter(child -> child.getParentId() == id).findFirst();
    }
}
