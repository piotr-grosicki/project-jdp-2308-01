package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GroupController {


    @GetMapping
    public ResponseEntity<List<GroupDto>> getGroups() {
        List<GroupDto> groups = new ArrayList<>();
        return ResponseEntity.ok(groups);
    }

    @GetMapping(value = "{groupId}")
    public ResponseEntity<GroupDto> getGroup() {
        return ResponseEntity.ok(new GroupDto(2L, "retrieved group"));
    }

    @PutMapping
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupDto){
        GroupDto group = new GroupDto(1L, "new group");
        return ResponseEntity.ok(group);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateGroup(@RequestBody GroupDto groupDto){
        return ResponseEntity.ok("Group has been updated successfully.");
    }
}
