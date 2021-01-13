package com.dissertation.controller.controller.model.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class Skill {
    private int id;
    private int entityId;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Years of Experience are required")
    private Long yearsOfExperience;
}
