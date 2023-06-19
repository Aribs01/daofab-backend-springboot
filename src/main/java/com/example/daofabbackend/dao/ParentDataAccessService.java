package com.example.daofabbackend.dao;

import com.example.daofabbackend.model.Parent;
import com.example.daofabbackend.model.ParentData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Repository("fakeDao")
public class ParentDataAccessService implements ParentDao {

    private static List<Parent> DB = new ArrayList<>();
    private static final String JSON_FILE_PATH = "static/Parent.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Parent> selectAllParent(int pageNumber, int pageSize) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(JSON_FILE_PATH);

            JsonNode rootNode = objectMapper.readTree(inputStream);
            JsonNode dataArray = rootNode.get("data");

            if (dataArray.isArray()) {
                Parent[] allParents = objectMapper.treeToValue(dataArray, Parent[].class);
                if (pageNumber == -1 || pageSize == -1) {
                    return Arrays.asList(allParents);
                }

                int totalParents = allParents.length;
                int startIndex = (pageNumber - 1) * pageSize;
                int endIndex = Math.min(startIndex + pageSize, totalParents);

                if (startIndex >= totalParents) {
                    // Return empty list if the start index exceeds the total number of parents
                    return Collections.emptyList();
                }

                Parent[] parentsForPage = Arrays.copyOfRange(allParents, startIndex, endIndex);
                return Arrays.asList(parentsForPage);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<ParentData> selectAllParentData(int pageNumber, int pageSize) {
        var parentData = new ParentData(
                selectAllParent(pageNumber, pageSize),
                selectAllParent(-1, -1).size()
        );
        return Optional.of(parentData);
    }

    @Override
    public Optional<Parent> selectParentById(int id) {
        var allParents = selectAllParent(-1,-1);
        return allParents.stream().filter(parent -> parent.getId() == id).findFirst();
    }
}
