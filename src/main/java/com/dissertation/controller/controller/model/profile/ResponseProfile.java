package com.dissertation.controller.controller.model.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProfile<T> {
    private  T type;
    private  String text;

}
