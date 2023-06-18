package com.example.daofabbackend.api;

import com.example.daofabbackend.model.Parent;
import com.example.daofabbackend.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/parent")
@RestController
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping(path = "getAllParent")
    public List<Parent> getAllParent(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "2") int pageSize) {
        return parentService.getAllParent(pageNumber, pageSize);
    }

    @GetMapping(path = "getParentById/{id}")
    public Optional<Parent> getParentById(@PathVariable("id") int id) {
        Optional<Parent> parentById = parentService.getParentById(id);
        return parentById;
    }
}
