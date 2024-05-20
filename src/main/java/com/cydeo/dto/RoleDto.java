package com.cydeo.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    @NotNull
    private Long id;
    @NotNull
    private String description;
}
