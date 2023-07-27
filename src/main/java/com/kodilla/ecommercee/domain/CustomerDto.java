package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDto {

    private long id;
    private String login;
    private boolean isLocked;
    private String customerKey;
}
