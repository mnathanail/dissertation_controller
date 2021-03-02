package com.dissertation.controller.controller.service.job;

import com.dissertation.controller.controller.model.profile.JobPosting;
import com.dissertation.controller.controller.model.profile.RecommendationExtendedModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface IJob {

    JobPosting saveJob(int recruiterId, JobPosting jobPosting);

    JobPosting getJob(String jobId);

    JobPosting patchJob(int recruiterId, String jobId, JobPosting jobPosting);

    Boolean deleteJob(String recruiterId, String jobId);

    Boolean candidateApplyForJob(int candidateId, String jobId);

    Boolean candidateDeleteApplyForJob(int candidateId, String jobId);

    Boolean candidateAlreadyApplyForJob(int candidateId, String jobId);

    Page<JobPosting> candidateSearchJobByKeywords(List<String> keywords, String page);

    String getRecruiterIdByJobId(String jobId);

    List<JobPosting> getCandidateAppliedJobList(int candidateId);

    List<JobPosting> getRecruiterManagesJobList(int recruiterId);

    Set<RecommendationExtendedModel> getRecruiterRecommendationForJob(int recruiterId, String jobId);

    Set<RecommendationExtendedModel> getRecruiterRecommendationForAppliedJob(int recruiterId, String jobId);
}
