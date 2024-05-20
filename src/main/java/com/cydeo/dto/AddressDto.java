package com.cydeo.dto;

import com.cydeo.enums.State;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    @NotNull
    private String addressInfo;
    @NotNull
    private State state;
}
