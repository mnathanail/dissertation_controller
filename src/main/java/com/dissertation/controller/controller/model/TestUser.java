package com.dissertation.controller.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestUser {

//    private String name;

   // private Boolean is;
   /* private Long id;*/
    private String name;
    private String surname;
    private String email;
    private byte[] profilePic;
    private String password;

}
