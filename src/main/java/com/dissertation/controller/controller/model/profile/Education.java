package com.dissertation.controller.controller.model.profile;

import com.dissertation.controller.controller.model.shared.Period;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({
        "id",
        "educationId",
        "title",
        "degree",
        "school",
        "period"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class Education {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("educationId")
    public String educationId;
    @JsonProperty("title")
    public String title;
    @JsonProperty("degree")
    public String degree;
    @JsonProperty("school")
    public String school;
    @JsonProperty("period")
    public Period period;
}
