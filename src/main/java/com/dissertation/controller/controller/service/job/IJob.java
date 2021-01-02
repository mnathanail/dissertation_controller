package com.dissertation.controller.controller.service.job;

import com.dissertation.controller.controller.model.profile.JobPosting;

import java.util.List;

public interface IJob {

    JobPosting saveJob(int recruiterId, JobPosting jobPosting);

    JobPosting getJob(String jobId);

    JobPosting patchJob(int recruiterId, String jobId, JobPosting jobPosting);

    Boolean deleteJob(String recruiterId, String jobId);

    Boolean candidateApplyForJob(int candidateId, String jobId);

    List<JobPosting> candidateSearchJobByKeywords(List<String> keywords);
}
