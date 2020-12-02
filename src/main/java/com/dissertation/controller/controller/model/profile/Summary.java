package com.dissertation.controller.controller.model.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class Summary {
    private int id;
    private String summary;
}

