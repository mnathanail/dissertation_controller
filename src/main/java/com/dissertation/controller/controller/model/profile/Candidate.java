package com.dissertation.controller.controller.model.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class Candidate {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String image;
    private byte[] profilePic;
}
