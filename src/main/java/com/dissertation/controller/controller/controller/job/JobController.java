package com.dissertation.controller.controller.controller.job;

import com.dissertation.controller.controller.model.profile.JobPosting;
import com.dissertation.controller.controller.service.job.IJob;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/controller")
@CrossOrigin("http://localhost:4300")
public class JobController {

    private final IJob jobService;

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

    @PatchMapping("/{recruiterId}/patch/job/{jobId}")
    public ResponseEntity<JobPosting> patchJob(
            @PathVariable("recruiterId") int recruiterId,
            @RequestBody JobPosting jobPosting,
            @PathVariable("jobId") String jobId
    ){
        JobPosting job = this.jobService.patchJob(recruiterId, jobId,jobPosting);
        return ResponseEntity.ok(job);
    }

    @DeleteMapping("/{recruiterId}/delete/job/{jobId}")
    public ResponseEntity<Boolean> deleteJob(@PathVariable("recruiterId") String recruiterId, @PathVariable("jobId") String jobId){
        Boolean isDeleted = this.jobService.deleteJob(recruiterId, jobId);
        return ResponseEntity.ok(isDeleted);
    }

    @PostMapping("/candidate/{candidateId}/apply/job/{jobId}")
    public ResponseEntity<Boolean> candidateApplyForJob(@PathVariable("candidateId") int candidateId, @PathVariable("jobId") String jobId){
        Boolean isApplied = this.jobService.candidateApplyForJob(candidateId, jobId);
        return ResponseEntity.ok(isApplied);
    }

    @GetMapping("/candidate/search/job/keywords")
    public ResponseEntity<List<JobPosting>> candidateApplyForJob(@RequestParam("keywords") List<String> keywords){
        List<JobPosting> jobList = this.jobService.candidateSearchJobByKeywords(keywords);
        return ResponseEntity.ok(jobList);
    }
}
