package com.dissertation.controller.controller.endpoint;

public interface Endpoint {

     public static final String FIND_BY_EMAIL = "/api/candidate/find-by-email";
    // public static final String FIND_BY_EMAIL = "/candidate/login";

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
    public static final String EDUCATION_PATCH = "/api/candidate/{id}/patch/education/{educationId}";
    public static final String EDUCATION_DELETE = "/api/candidate/{id}/delete/education/{educationId}";

    public static final String SKILL_LIST_GET = "/api/candidate/{id}/get/search/skill-list";
    public static final String SKILL_CANDIDATE_LIST_GET = "/api/candidate/{id}/get/candidate-skill-list";
    public static final String SKILL_SAVE = "/api/candidate/{id}/save/skill";
    public static final String SKILL_LIST_SAVE = "/api/candidate/{id}/save/skill-list";
    public static final String SKILL_CANDIDATE_LIST_SAVE = "/api/candidate/{id}/save/candidate-skill-list";
    public static final String SKILL_CANDIDATE_LIST_PATCH = "/api/candidate/{id}/patch/candidate-skill-list";
    public static final String SKILL_CANDIDATE_DELETE = "/api/candidate/{id}/delete/candidate-skill/{skillUuid}";

    public static final String CANDIDATE_PROFILE_PHOTO_SAVE = "/api/candidate/{id}/save/photo-profile";
    public static final String CANDIDATE_PROFILE_GET = "/api/candidate/{id}/get/profile";

    public static final String RECRUITER_JOB_SAVE = "/api/recruiter/{id}/save/job";
    public static final String RECRUITER_JOB_PATCH = "/api/recruiter/{recruiterId}/patch/job/{jobId}";
    public static final String RECRUITER_JOB_DELETE = "/api/recruiter/{recruiterId}/delete/job/{jobId}";

    public static final String JOB_GET = "/api/job/get/job/{jobId}";
    public static final String CANDIDATE_APPLY_FOR_JOB= "/api/job/apply/candidate/{candidateId}/job/{jobId}";

    public static final String CANDIDATE_SEARCH_JOB_BY_KEYWORDS= "/api/job/candidate/search/job/keywords";
}
