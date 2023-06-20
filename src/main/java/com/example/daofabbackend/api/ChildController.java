package com.example.daofabbackend.api;

import com.example.daofabbackend.model.Child;
import com.example.daofabbackend.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
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
    public List<Child> getChildByParentIds(@PathVariable("parentId") int parentId) {
        List<Child> childByParentId = childService.getChildByParentId(parentId);
        return childByParentId;
    }
}
