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
        "experienceId",
        "jobTitle",
        "companyName",
        "industry",
        "isCurrent",
        "period",
        "description"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class Experience {
    @NotEmpty(message = "Company is required")
    @JsonProperty("companyName")
    public String companyName;
    @JsonProperty("description")
    public String description;
    @JsonProperty("experienceId")
    public String experienceId;
    @JsonProperty("industry")
    public String industry;
    @JsonProperty("isCurrent")
    public boolean isCurrent;
    @JsonProperty("jobTitle")
    public String jobTitle;
    @JsonProperty("period")
    public Period period;

}