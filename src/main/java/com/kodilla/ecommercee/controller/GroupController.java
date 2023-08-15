package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final DbService dbService;
    private final GroupMapper groupMapper;

    @GetMapping
    public ResponseEntity<List<GroupDto>> getGroups() {
        List<Group> groupsList = dbService.getAllGroups();
        return ResponseEntity.ok(groupMapper.mapToGroupDtoList(groupsList));
    }

    @GetMapping(value = "{groupId}")
    public ResponseEntity<GroupDto> getGroup(@PathVariable Long groupId) {
        Group group = dbService.getGroup(groupId);
        return ResponseEntity.ok(groupMapper.mapToGroupDto(group));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGroup(@RequestBody GroupDto groupDto){
        Group group = groupMapper.mapToGroup(groupDto);
        dbService.saveGroup(group);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<GroupDto> updateGroup(@RequestBody GroupDto groupDto){
        Group group = groupMapper.mapToGroup(groupDto);
        Group savedGroup = dbService.saveGroup(group);
        return ResponseEntity.ok(groupMapper.mapToGroupDto(savedGroup));
    }
}
