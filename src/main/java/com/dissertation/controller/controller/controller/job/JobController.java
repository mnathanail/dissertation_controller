package com.dissertation.controller.controller.controller.job;

import com.dissertation.controller.controller.model.profile.JobPosting;
import com.dissertation.controller.controller.model.profile.RecommendationExtendedModel;
import com.dissertation.controller.controller.service.job.IJob;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/controller")
public class JobController {

    private final IJob jobService;

    /*@PreAuthorize("hasAnyAuthority('ROLE_RECRUITER')")*/
    @PostMapping("/job-posting/save/job")
    public ResponseEntity<JobPosting> saveJob
            (@RequestParam("recruiterId") int recruiterId, @RequestBody JobPosting jobPosting){
        JobPosting job = this.jobService.saveJob(recruiterId, jobPosting);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/job-view/get/job")
    public ResponseEntity<JobPosting> getJob(@RequestParam("jobId") String jobId){
        JobPosting job = this.jobService.getJob(jobId);
        return ResponseEntity.ok(job);
    }

    @PreAuthorize("isOwner(#recruiterId) and hasAnyAuthority('ROLE_RECRUITER')")
    @PatchMapping("/patch/job")
    public ResponseEntity<JobPosting> patchJob(
            @RequestParam("recruiterId") int recruiterId,
            @RequestBody JobPosting jobPosting,
            @RequestParam("jobId") String jobId
    ){
        JobPosting job = this.jobService.patchJob(recruiterId, jobId,jobPosting);
        return ResponseEntity.ok(job);
    }

    @PreAuthorize("isOwner(#recruiterId) and hasAnyAuthority('ROLE_RECRUITER')")
    @DeleteMapping("/delete/job")
    public ResponseEntity<Boolean> deleteJob(@RequestParam("recruiterId") String recruiterId, @RequestParam("jobId") String jobId){
        Boolean isDeleted = this.jobService.deleteJob(recruiterId, jobId);
        return ResponseEntity.ok(isDeleted);
    }

    /*@PreAuthorize("hasAnyAuthority('ROLE_RECRUITER')")*/
    @GetMapping("/get/recruiter")
    public ResponseEntity<String> getRecruiterIdByJobId(@RequestParam("jobId") String jobId){
        String recruiterId = this.jobService.getRecruiterIdByJobId(jobId);
        return ResponseEntity.ok(recruiterId);
    }

    @PostMapping("/candidate/apply/job")
    public ResponseEntity<Boolean> candidateApplyForJob(@RequestParam("candidateId") int candidateId, @RequestParam("jobId") String jobId){
        Boolean isApplied = this.jobService.candidateApplyForJob(candidateId, jobId);
        return ResponseEntity.ok(isApplied);
    }

    @DeleteMapping("/candidate/delete/apply/job")
    public ResponseEntity<Boolean> candidateDeleteApplyForJob(@RequestParam("candidateId") int candidateId, @RequestParam("jobId") String jobId){
        Boolean isApplied = this.jobService.candidateDeleteApplyForJob(candidateId, jobId);
        return ResponseEntity.ok(isApplied);
    }

    @GetMapping("/candidate/already/apply/job")
    public ResponseEntity<Boolean> candidateAlreadyApplyForJob(@RequestParam("candidateId") int candidateId, @RequestParam("jobId") String jobId){
        Boolean isApplied = this.jobService.candidateAlreadyApplyForJob(candidateId, jobId);
        return ResponseEntity.ok(isApplied);
    }

    @GetMapping("/candidate/search/job/keywords")
    public ResponseEntity<Page<JobPosting>> candidateApplyForJob(@RequestParam("keywords") List<String> keywords,
                                                                 @RequestParam(value = "page", required=false) String page){
        if(page.equals("undefined")){
            page = "0";
        }
        Page<JobPosting> jobList = this.jobService.candidateSearchJobByKeywords(keywords, page);
        return ResponseEntity.ok(jobList);
    }

    @GetMapping("/candidate/get/applied-job-list")
    public ResponseEntity<List<JobPosting>> candidateGetAppliedJobList(@RequestParam("candidateId") int candidateId){
        List<JobPosting> jobList = this.jobService.getCandidateAppliedJobList(candidateId);
        return ResponseEntity.ok(jobList);
    }

    @GetMapping("/recruiter/get/manage-job-list")
    public ResponseEntity<List<JobPosting>> recruiterGetManageJobList(@RequestParam("recruiterId") int recruiterId){
        List<JobPosting> jobList = this.jobService.getRecruiterManagesJobList(recruiterId);
        return ResponseEntity.ok(jobList);
    }

//    @PreAuthorize("isOwner(#recruiterId) and hasAnyAuthority('ROLE_RECRUITER')")
    @GetMapping("/recruiter/get/recommendation")
    public ResponseEntity<Set<RecommendationExtendedModel>>
        recruiterGetRecommendationForJob(@RequestParam("recruiterId") int recruiterId,
                                         @RequestParam("jobId") String jobId){
        Set<RecommendationExtendedModel> recommendations = this.jobService.getRecruiterRecommendationForJob(recruiterId,jobId);
        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/recruiter/get/recommendation/applied")
    public ResponseEntity<Set<RecommendationExtendedModel>>
    recruiterGetRecommendationForAppliedJob(@RequestParam("recruiterId") int recruiterId,
                                     @RequestParam("jobId") String jobId){
        Set<RecommendationExtendedModel> recommendations = this.jobService.getRecruiterRecommendationForAppliedJob(recruiterId,jobId);
        return ResponseEntity.ok(recommendations);
    }

}
