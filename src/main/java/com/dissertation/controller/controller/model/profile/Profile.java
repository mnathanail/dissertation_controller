package com.dissertation.controller.controller.model.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class Profile {
    private int id;
    private Summary summary;
    private Experience experience;
    private Education education;
    private Skill skill;
}
