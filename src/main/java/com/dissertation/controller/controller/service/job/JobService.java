package com.dissertation.controller.controller.service.job;

import com.dissertation.controller.controller.endpoint.Endpoint;
import com.dissertation.controller.controller.model.job.RestResponsePage;
import com.dissertation.controller.controller.model.profile.CandidateSearch;
import com.dissertation.controller.controller.model.profile.JobPosting;
import com.dissertation.controller.controller.model.profile.RecommendationExtendedModel;
import com.dissertation.controller.controller.model.profile.SkillEntityModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class JobService implements IJob{

    @Qualifier("restTemplateBean")
    private final RestTemplate restTemplate;

    @Override
    public JobPosting saveJob(int recruiterId, JobPosting jobPosting) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(recruiterId));
        ResponseEntity<JobPosting> educationEntity =
                this.restTemplate.exchange(
                        Endpoint.RECRUITER_JOB_SAVE,
                        HttpMethod.POST,
                        new HttpEntity<JobPosting>(jobPosting),
                        JobPosting.class,
                        urlParams);
        return  educationEntity.getBody();
    }

    @Override
    public JobPosting getJob(String jobId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("jobId", jobId);
        ResponseEntity<JobPosting> jobNode =
                this.restTemplate.exchange(
                        Endpoint.JOB_GET,
                        HttpMethod.GET,
                        new HttpEntity<>(null),
                        JobPosting.class,
                        urlParams);
        return  jobNode.getBody();
    }

    @Override
    public JobPosting patchJob(int recruiterId, String jobId, JobPosting jobPosting) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("jobId", jobId);
        urlParams.put("recruiterId", String.valueOf(recruiterId));
        ResponseEntity<JobPosting> jobNode =
                this.restTemplate.exchange(
                        Endpoint.RECRUITER_JOB_PATCH,
                        HttpMethod.PATCH,
                        new HttpEntity<JobPosting>(jobPosting),
                        JobPosting.class,
                        urlParams);
        return  jobNode.getBody();
    }

    @Override
    public Boolean deleteJob(String recruiterId, String jobId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("recruiterId", recruiterId);
        urlParams.put("jobId", jobId);
        ResponseEntity<Boolean> jobNode =
                this.restTemplate.exchange(
                        Endpoint.RECRUITER_JOB_DELETE,
                        HttpMethod.DELETE,
                        new HttpEntity<>(""),
                        Boolean.class,
                        urlParams);
        return  jobNode.getBody();
    }

    @Override
    public Boolean candidateApplyForJob(int candidateId, String jobId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("candidateId", String.valueOf(candidateId));
        urlParams.put("jobId", jobId);
        ResponseEntity<Boolean> candidateApplyForJob =
                this.restTemplate.exchange(
                        Endpoint.CANDIDATE_APPLY_FOR_JOB,
                        HttpMethod.POST,
                        new HttpEntity<>(""),
                        Boolean.class,
                        urlParams);
        return  candidateApplyForJob.getBody();
    }

    @Override
    public Boolean candidateDeleteApplyForJob(int candidateId, String jobId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("candidateId", String.valueOf(candidateId));
        urlParams.put("jobId", jobId);
        ResponseEntity<Boolean> candidateApplyForJob =
                this.restTemplate.exchange(
                        Endpoint.CANDIDATE_DELETE_APPLY_FOR_JOB,
                        HttpMethod.DELETE,
                        new HttpEntity<>(""),
                        Boolean.class,
                        urlParams);
        return  candidateApplyForJob.getBody();
    }

    @Override
    public Boolean candidateAlreadyApplyForJob(int candidateId, String jobId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("candidateId",String.valueOf(candidateId));
        urlParams.put("jobId",String.valueOf(jobId));

        ResponseEntity<Boolean> candidateAlreadyApplied =
                this.restTemplate.exchange(
                        Endpoint.CANDIDATE_ALREADY_APPLY_FOR_JOB,
                        HttpMethod.GET,
                        new HttpEntity<>(""),
                        Boolean.class,
                        urlParams
                );
        return candidateAlreadyApplied.getBody();
    }

    @Override
    public Page<JobPosting> candidateSearchJobByKeywords(List<String> keywords, String page) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081"+Endpoint.CANDIDATE_SEARCH_JOB_BY_KEYWORDS)
                .queryParam("keywords", keywords).queryParam("page", page).queryParam("size", "2");
        String url = uriBuilder.toUriString();

        ResponseEntity<RestResponsePage<JobPosting>> candidateApplyForJob =
                this.restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                        );
        return candidateApplyForJob.getBody();
    }

    @Override
    public Set<CandidateSearch> searchForCandidateBySkillList(int recruiterId, SkillEntityModel[] skillList) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("recruiterId", String.valueOf(recruiterId));

        ResponseEntity<Set<CandidateSearch>> exchange = this.restTemplate.exchange(
                Endpoint.RECRUITER_SEARCH_CANDIDATE_BY_SKILL_LIST,
                HttpMethod.POST,
                new HttpEntity<>(skillList),
                new ParameterizedTypeReference<>() {},
                urlParams);
        return exchange.getBody();
    }

    @Override
    public String getRecruiterIdByJobId(String jobId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("jobId", jobId);

        ResponseEntity<String> exchange = this.restTemplate.exchange(
                Endpoint.RECRUITER_BY_JOB,
                HttpMethod.GET,
                new HttpEntity<String>(""),
                String.class,
                urlParams);
        return exchange.getBody();
    }

    @Override
    public List<JobPosting> getCandidateAppliedJobList(int candidateId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("candidateId", String.valueOf(candidateId));
        ResponseEntity<List<JobPosting>> exchange = this.restTemplate.exchange(
                Endpoint.JOB_GET_CANDIDATE_APPLIED_LIST,
                HttpMethod.GET,
                new HttpEntity<String>(""),
                new ParameterizedTypeReference<>() {},
                urlParams);
        return exchange.getBody();

    }

    @Override
    public List<JobPosting> getRecruiterManagesJobList(int recruiterId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("recruiterId", String.valueOf(recruiterId));
        ResponseEntity<List<JobPosting>> exchange = this.restTemplate.exchange(
                Endpoint.JOB_GET_RECRUITER_MANAGES_LIST,
                HttpMethod.GET,
                new HttpEntity<String>(""),
                new ParameterizedTypeReference<>() {},
                urlParams);
        return exchange.getBody();
    }

    @Override
    public Set<RecommendationExtendedModel> getRecruiterRecommendationForJob(int recruiterId, String jobId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("jobId",jobId);
        urlParams.put("recruiterId",String.valueOf(recruiterId));

        ResponseEntity<Set<RecommendationExtendedModel>> recommendations =
                restTemplate.exchange(
                        Endpoint.JOB_GET_RECOMMENDATION_JOB_LIST,
                        HttpMethod.GET,
                        new HttpEntity<>(""),
                        new ParameterizedTypeReference<>() {},
                        urlParams
                );
        return recommendations.getBody();
    }

    @Override
    public Set<RecommendationExtendedModel> getRecruiterRecommendationForAppliedJob(int recruiterId, String jobId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("jobId",jobId);
        urlParams.put("recruiterId",String.valueOf(recruiterId));

        ResponseEntity<Set<RecommendationExtendedModel>> recommendations =
                restTemplate.exchange(
                        Endpoint.JOB_GET_RECOMMENDATION_APPLIED_JOB_LIST,
                        HttpMethod.GET,
                        new HttpEntity<>(""),
                        new ParameterizedTypeReference<>() {},
                        urlParams
                );
        return recommendations.getBody();
    }

}
