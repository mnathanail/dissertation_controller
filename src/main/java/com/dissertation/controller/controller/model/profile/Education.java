package com.dissertation.controller.controller.model.profile;

import com.dissertation.controller.controller.model.shared.Period;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "Title is required")
    @JsonProperty("title")
    public String title;
    @NotEmpty(message = "Degree is required")
    @JsonProperty("degree")
    public String degree;
    @NotEmpty(message = "School is required")
    @JsonProperty("school")
    public String school;
    @JsonProperty("period")
    public Period period;
}
