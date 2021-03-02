package com.dissertation.controller.controller.model.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationExtendedModel {
    private String candidateName;
    private Long candidateEntityId;
    private String[] haveSkillNames;
    private String[] totalSkillNames;
    private double percent;
    private int totalSkillsNumber;
    private int candidateSkillNumber;

}