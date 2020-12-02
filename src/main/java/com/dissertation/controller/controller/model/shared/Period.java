package com.dissertation.controller.controller.model.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "endMonth",
        "endYear",
        "startMonth",
        "startYear"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class Period {

    @JsonProperty("endMonth")
    public String endMonth;
    @JsonProperty("endYear")
    public String endYear;
    @JsonProperty("startMonth")
    public String startMonth;
    @JsonProperty("startYear")
    public String startYear;

}