package com.dissertation.controller.controller.model.profile;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class JobPosting {

    private String jobId;
    private String jobTitle;
    private String description;

    private Set<RequiredSkill> requiredSkills;

}
