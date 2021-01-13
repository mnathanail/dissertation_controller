package com.dissertation.controller.controller.endpoint;

public interface Endpoint {

    String FIND_BY_EMAIL = "/api/candidate/find-by-email";
    String REGISTER = "/api/candidate/register";

    //  String FIND_BY_EMAIL = "/candidate/login";

    String SUMMARY_SAVE = "/api/candidate/{id}/save/summary";
    String SUMMARY_GET = "/api/candidate/{id}/get/summary";

    String EXPERIENCE_SAVE = "/api/candidate/{id}/save/working-experience";
    String EXPERIENCE_GET = "/api/candidate/{id}/get/working-experience/{experienceId}";
    String EXPERIENCE_LIST_GET = "/api/candidate/{id}/get/working-experience";
    String EXPERIENCE_PATCH = "/api/candidate/{id}/patch/working-experience/{experienceId}";
    String EXPERIENCE_DELETE = "/api/candidate/{id}/delete/working-experience/{experienceId}";

    String EDUCATION_SAVE = "/api/candidate/{id}/save/education";
    String EDUCATION_GET = "/api/candidate/{id}/get/education/{educationId}";
    String EDUCATION_LIST_GET = "/api/candidate/{id}/get/education";
    String EDUCATION_PATCH = "/api/candidate/{id}/patch/education/{educationId}";
    String EDUCATION_DELETE = "/api/candidate/{id}/delete/education/{educationId}";

    String SKILL_LIST_GET = "/api/skill/get/search/skill-list";
    String SKILL_CANDIDATE_LIST_GET = "/api/candidate/{id}/get/candidate-skill-list";
    String SKILL_SAVE = "/api/candidate/{id}/save/skill";
    String SKILL_LIST_SAVE = "/api/candidate/{id}/save/skill-list";
    String SKILL_CANDIDATE_LIST_SAVE = "/api/candidate/{id}/save/candidate-skill-list";
    String SKILL_CANDIDATE_LIST_PATCH = "/api/candidate/{id}/patch/candidate-skill-list";
    String SKILL_CANDIDATE_DELETE = "/api/candidate/{id}/delete/candidate-skill/{skillUuid}";

    String CANDIDATE_PROFILE_PHOTO_SAVE = "/api/candidate/{id}/save/photo-profile";
    String CANDIDATE_PROFILE_GET = "/api/candidate/{id}/get/profile";

    String RECRUITER_JOB_SAVE = "/api/recruiter/{id}/save/job";
    String RECRUITER_JOB_PATCH = "/api/recruiter/{recruiterId}/patch/job/{jobId}";
    String RECRUITER_JOB_DELETE = "/api/recruiter/{recruiterId}/delete/job/{jobId}";
    String RECRUITER_BY_JOB = "/api/job/get/recruiter/job/{jobId}";

    String JOB_GET = "/api/job/get/job/{jobId}";
    String CANDIDATE_APPLY_FOR_JOB = "/api/job/apply/candidate/{candidateId}/job/{jobId}";

    String CANDIDATE_SEARCH_JOB_BY_KEYWORDS = "/api/job/candidate/search/job/keywords";
}
