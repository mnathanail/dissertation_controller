package com.dissertation.controller.controller.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class SkillResponse {
    @JsonProperty("skillNode")
    private SkillNode skillNode;
    /*@JsonProperty("yearsOfExperience")*/
    private Long yoe;
    private String relUuid;
}
