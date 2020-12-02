package com.dissertation.controller.controller.endpoint;

public interface Endpoint {

    public static final String SUMMARY_SAVE = "/api/candidate/{id}/save/summary";
    public static final String SUMMARY_GET = "/api/candidate/{id}/get/summary";

    public static final String EXPERIENCE_SAVE = "/api/candidate/{id}/save/working-experience";
    public static final String EXPERIENCE_GET = "/api/candidate/{id}/get/working-experience/{experienceId}";
    public static final String EXPERIENCE_LIST_GET = "/api/candidate/{id}/get/working-experience";
    public static final String EXPERIENCE_PATCH = "/api/candidate/{id}/patch/working-experience/{experienceId}";
    public static final String EXPERIENCE_DELETE = "/api/candidate/{id}/delete/working-experience/{experienceId}";

    public static final String EDUCATION_SAVE = "/api/candidate/{id}/save/education";
    public static final String EDUCATION_GET = "/api/candidate/{id}/get/education/{educationId}";
    public static final String EDUCATION_LIST_GET = "/api/candidate/{id}/get/education";
    public static final String EDUCATION_DELETE = "/api/candidate/{id}/delete/education/{educationId}";

    public static final String SKILL_LIST_GET = "/api/candidate/{id}/get/search/skill-list";
    public static final String SKILL_CANDIDATE_LIST_GET = "/api/candidate/{id}/get/candidate-skill-list";
    public static final String SKILL_SAVE = "/api/candidate/{id}/save/skill";
    public static final String SKILL_LIST_SAVE = "/api/candidate/{id}/save/skill-list";
    public static final String SKILL_CANDIDATE_LIST_SAVE = "/api/candidate/{id}/save/candidate-skill-list";


    public static final String CANDIDATE_PROFILE_PHOTO_SAVE = "/api/candidate/{id}/save/photo-profile";
    public static final String CANDIDATE_PROFILE_GET = "/api/candidate/{id}/get/profile";
}
