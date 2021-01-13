package com.dissertation.controller.controller.controller.job;

import com.dissertation.controller.controller.model.profile.JobPosting;
import com.dissertation.controller.controller.service.job.IJob;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/controller")
public class JobController {

    private final IJob jobService;

    @PreAuthorize("isOwner(#recruiterId) and hasAnyAuthority('ROLE_RECRUITER')")
    @PostMapping("/job-posting/{id}/save/job")
    public ResponseEntity<JobPosting> saveJob
            (@PathVariable("id") int recruiterId, @RequestBody JobPosting jobPosting){
        JobPosting job = this.jobService.saveJob(recruiterId, jobPosting);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/job-view/get/job/{jobId}")
    public ResponseEntity<JobPosting> getJob(@PathVariable("jobId") String jobId){
        JobPosting job = this.jobService.getJob(jobId);
        return ResponseEntity.ok(job);
    }

    @PreAuthorize("isOwner(#recruiterId) and hasAnyAuthority('ROLE_RECRUITER')")
    @PatchMapping("/{recruiterId}/patch/job/{jobId}")
    public ResponseEntity<JobPosting> patchJob(
            @PathVariable("recruiterId") int recruiterId,
            @RequestBody JobPosting jobPosting,
            @PathVariable("jobId") String jobId
    ){
        JobPosting job = this.jobService.patchJob(recruiterId, jobId,jobPosting);
        return ResponseEntity.ok(job);
    }

    @PreAuthorize("isOwner(#recruiterId) and hasAnyAuthority('ROLE_RECRUITER')")
    @DeleteMapping("/{recruiterId}/delete/job/{jobId}")
    public ResponseEntity<Boolean> deleteJob(@PathVariable("recruiterId") String recruiterId, @PathVariable("jobId") String jobId){
        Boolean isDeleted = this.jobService.deleteJob(recruiterId, jobId);
        return ResponseEntity.ok(isDeleted);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_RECRUITER')")
    @GetMapping("/get/recruiter")
    public ResponseEntity<String> getRecruiterIdByJobId(@RequestParam("jobId") String jobId){
        String recruiterId = this.jobService.getRecruiterIdByJobId(jobId);
        return ResponseEntity.ok(recruiterId);
    }

    @PostMapping("/candidate/{candidateId}/apply/job/{jobId}")
    public ResponseEntity<Boolean> candidateApplyForJob(@PathVariable("candidateId") int candidateId, @PathVariable("jobId") String jobId){
        Boolean isApplied = this.jobService.candidateApplyForJob(candidateId, jobId);
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
}
