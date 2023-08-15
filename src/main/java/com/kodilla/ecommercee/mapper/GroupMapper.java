package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {

    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(
                groupDto.getId(),
                groupDto.getName(),
                groupDto.getItems()
        );
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getProducts()
        );
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groupsList) {
        return groupsList.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }

}
