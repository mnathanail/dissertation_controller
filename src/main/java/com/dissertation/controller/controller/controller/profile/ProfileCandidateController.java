package com.dissertation.controller.controller.controller.profile;

import com.dissertation.controller.controller.model.profile.*;
import com.dissertation.controller.controller.service.profile.IProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("http://localhost:4300")
public class ProfileCandidateController {

    private final IProfile profileService;

    //Candidate Area

    @PostMapping("/profile/{id}/save/profile-photo")
    public ResponseEntity<Candidate> postProfilePhoto(@PathVariable("id") int candidateId,
                                                      @RequestBody CandidateImage profilePic){
        byte[] byteArrray = profilePic.getProfilePic().getBytes();
        Candidate candidate = this.profileService.savePhotoProfile(candidateId, byteArrray);
        candidate.setImage(new String(candidate.getProfilePic(), StandardCharsets.UTF_8));
        return ResponseEntity.ok(candidate);
    }

    @GetMapping("/profile/{id}/get/profile")
    public ResponseEntity<Candidate> getProfilePhoto(@PathVariable("id") int candidateId){
        Candidate candidate = this.profileService.getProfile(candidateId);
        candidate.setImage(new String(candidate.getProfilePic(), StandardCharsets.UTF_8));
        return ResponseEntity.ok(candidate);
    }

    // End of Candidate

    // Summary Area!
    @PostMapping("/profile/{id}/save/summary")
    public ResponseEntity<Summary> postSummary(@RequestBody Summary summary){
        Summary response = this.profileService.insertOrUpdateSummary(summary.getId(), summary);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{id}/get/summary")
    public ResponseEntity<Summary> getSummary(@PathVariable String id){
        Summary response = this.profileService.getSummary(id);
        return ResponseEntity.ok(response);
    }
    // End Of Summary!

    // Experience Area!
    @PostMapping("/profile/{id}/save/experience")
    public ResponseEntity<Experience> postExperience(@RequestBody Experience experience, @PathVariable("id") int id){
        Experience response = this.profileService.saveExperience(id, experience);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{id}/get/experience-list")
    public ResponseEntity<List<Experience>> getExperienceList(@PathVariable("id") int id){
        List<Experience> response = this.profileService.getExperienceList(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{id}/get/experience/{experienceId}")
    public ResponseEntity<Experience>
    getExperience(@PathVariable("experienceId") String experienceId, @PathVariable("id") int id){
        Experience response = this.profileService.getExperience(id, experienceId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/profile/{id}/patch/experience/{experienceId}")
    public ResponseEntity<Experience> patchExperience(@PathVariable("id") int candidateId,
                                                   @PathVariable("experienceId") String experienceId,
                                                   @RequestBody Experience experience){
        Experience exp = this.profileService.patchExperience(candidateId,experienceId, experience);
        return ResponseEntity.ok(exp);
    }

    @DeleteMapping("/profile/{id}/delete/experience/{experienceId}")
    public ResponseEntity<Boolean> deleteExperience(@PathVariable("id") int candidateId,
                                                    @PathVariable("experienceId") String experienceId){
        Boolean deleted = this.profileService.deleteExperience(candidateId, experienceId);
        return ResponseEntity.ok(deleted);
    }
    // End of Experience!

    // Education Area!
    @PostMapping("/profile/{id}/save/education")
    public ResponseEntity<Education> postEducation(@RequestBody Education education, @PathVariable("id") int id){
        Education response = this.profileService.saveEducation(id, education);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{id}/get/education-list")
    public ResponseEntity<List<Education>> getEducationList(@PathVariable("id") int id){
        List<Education> response = this.profileService.getEducationList(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{id}/get/education/{educationId}")
    public ResponseEntity<Education> getEducation(
            @PathVariable("educationId") int educationId, @PathVariable("id") int id){
        Education response = this.profileService.getEducation(id, educationId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/profile/{id}/delete/education/{educationId}")
    public ResponseEntity<Boolean> deleteEducation(@PathVariable("id") int candidateId,
                                                    @PathVariable("educationId") int educationId){
        this.profileService.deleteEducation(candidateId, educationId);
        return ResponseEntity.ok(true);
    }
    // End of Education!

    // Skill

    @GetMapping("/profile/{id}/get/skill-list")
    public ResponseEntity<List<Skill>> getSkillsListByKeyword(@PathVariable("id") int candidateId,
                                                   @RequestParam("name") String skill){

        List<Skill> skills = this.profileService.getSkillByKeywordList(candidateId, skill);
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/profile/{id}/get/candidate-skill-list")
    public ResponseEntity<List<Skill>> getCandidateSkillsList(@PathVariable("id") int candidateId){

        List<Skill> skills = this.profileService.getCandidateSkillList(candidateId);
        return ResponseEntity.ok(skills);
    }

    @PostMapping("/profile/{id}/save/skill")
    public ResponseEntity<List<Skill>> saveNewSkill(@PathVariable("id") int candidateId,
                                                @RequestBody List<Skill> skills){
        List<Skill> newSkill = this.profileService.saveNewSkillList(skills);
        return ResponseEntity.ok(newSkill);
    }

    @PostMapping("/profile/{id}/save/candidate-skill-list")
    public ResponseEntity<List<Skill>> saveNewSkillListToCandidate(@PathVariable("id") int candidateId,
                                                        @RequestBody List<Skill> skills){
        List<Skill> newSkill = this.profileService.saveNewCandidateSkillList(candidateId, skills);
        return ResponseEntity.ok(newSkill);
    }

   /*
    @PostMapping("/profile/skills")
    public ResponseEntity<?> skills(@RequestBody Login credentials){
        ResponseLogin response = this.loginService.login(credentials);
        return ResponseEntity.ok(response);
    }*/
}
