package com.example.daofabbackend.api;

import com.example.daofabbackend.model.Child;
import com.example.daofabbackend.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/child")
@RestController
public class ChildController {

    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping(path = "getAllChildren")
    public List<Child> getAllParent() {
        return childService.getAllChildren();
    }

    @GetMapping(path = "getChildrenById/{id}")
    public Optional<Child> getChildById(@PathVariable("id") int id) {
        Optional<Child> childById = childService.getChildById(id);
        return childById;
    }

    @GetMapping(path = "getChildrenByParentId/{parentId}")
    public Optional<Child> getChildByParentId(@PathVariable("parentId") int parentId) {
        Optional<Child> childByParentId = childService.getChildByParentId(parentId);
        return childByParentId;
    }
}
