package com.dissertation.controller.controller.model.profile;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class SkillResponse {

    private SkillNode skillNode;
    /*@JsonProperty("yearsOfExperience")*/
    private Long yearsOfExperience;
    private String relUuid;
}
