package com.dissertation.controller.controller.model.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class Skill {
    private int id;
    private int entityId;
    private String name;
    private int yoe;
}
