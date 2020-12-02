package com.dissertation.controller.controller.model.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class CandidateImage {
    private int id;
    private String profilePic;
}
