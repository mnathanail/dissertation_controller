package com.dissertation.controller.controller.model.profile;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class RequiredSkill {

    private SkillNode skillNode;
    private Long yearsOfExperience;
}
