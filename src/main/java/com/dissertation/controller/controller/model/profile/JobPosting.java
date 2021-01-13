package com.dissertation.controller.controller.model.profile;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class JobPosting {


    private String jobId;
    @NotEmpty(message = "Job title is required")
    private String jobTitle;
    @NotEmpty(message = "Description is required")
    private String description;
    @NotEmpty(message = "At least one skill is required")
    private Set<RequiredSkill> requiredSkills;

}
