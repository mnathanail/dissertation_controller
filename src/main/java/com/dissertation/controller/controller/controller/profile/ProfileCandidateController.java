package com.dissertation.controller.controller.controller.profile;

import com.dissertation.controller.controller.auth.jwt.services.SecurityService;
import com.dissertation.controller.controller.model.profile.*;
import com.dissertation.controller.controller.service.profile.IProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class ProfileCandidateController {

    private final IProfile profileService;
    private final SecurityService securityService;

    //Candidate Area
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    @PostMapping("/profile/save/profile-photo")
    public ResponseEntity<Candidate> postProfilePhoto(@RequestParam("candidateId") String candidateId, @RequestBody CandidateImage profilePic) {
        byte[] byteArrray = profilePic.getProfilePic().getBytes();
        Candidate candidate = this.profileService.savePhotoProfile(candidateId, byteArrray);
        candidate.setImage(new String(candidate.getProfilePic(), StandardCharsets.UTF_8));
        return ResponseEntity.ok(candidate);
    }

    @GetMapping("/profile/get/profile")
    public ResponseEntity<Candidate> getProfilePhoto(@RequestParam("candidateId") String candidateId) {
        Candidate candidate = this.profileService.getProfile(candidateId);
        if (candidate.getProfilePic() != null) {
            candidate.setImage(new String(candidate.getProfilePic(), StandardCharsets.UTF_8));
        }
        return ResponseEntity.ok(candidate);
    }

    // End of Candidate

    // Summary Area! authentication.name

    @PostMapping("/profile/save/summary")
    @PreAuthorize("isOwner(#candidateId) and hasRole('ROLE_CANDIDATE')")
    public ResponseEntity<Summary> postSummary(@RequestParam("candidateId") String candidateId,
                                               @RequestBody Summary summary) {

        Summary response = this.profileService.insertOrUpdateSummary(candidateId, summary);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/get/summary")
    public ResponseEntity<Summary> getSummary(@RequestParam("candidateId") String candidateId) {
        Summary response = this.profileService.getSummary(candidateId);
        return ResponseEntity.ok(response);
    }
    // End Of Summary!

    // Experience Area!
    @PostMapping("/profile/save/experience")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<Experience> postExperience(@RequestParam("candidateId") String candidateId, @RequestBody Experience experience) {
        Experience response = this.profileService.saveExperience(candidateId, experience);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/get/experience-list")
    public ResponseEntity<List<Experience>> getExperienceList(@RequestParam("candidateId") String candidateId) {
        List<Experience> response = this.profileService.getExperienceList(candidateId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/get/experience")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<Experience> getExperience(@RequestParam("candidateId") String candidateId,
                                                    @RequestParam("experienceId") String experienceId) {
        Experience response = this.profileService.getExperience(candidateId, experienceId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/profile/patch/experience")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<Experience> patchExperience(@RequestParam("candidateId") String candidateId,
                                                      @RequestParam("experienceId") String experienceId,
                                                      @RequestBody Experience experience) {
        Experience exp = this.profileService.patchExperience(candidateId, experienceId, experience);
        return ResponseEntity.ok(exp);
    }

    @DeleteMapping("/profile/delete/experience")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<Boolean> deleteExperience(@RequestParam("candidateId") String candidateId,
                                                    @RequestParam("experienceId") String experienceId) {
        Boolean deleted = this.profileService.deleteExperience(candidateId, experienceId);
        return ResponseEntity.ok(deleted);
    }
    // End of Experience!

    // Education Area!
    @PostMapping("/profile/save/education")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<Education> postEducation(@RequestParam("candidateId") String candidateId,
                                                   @RequestBody Education education) {
        Education response = this.profileService.saveEducation(candidateId, education);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/get/education-list")
    public ResponseEntity<Set<Education>> getEducationList(@RequestParam("candidateId") String candidateId) {
        Set<Education> response = this.profileService.getEducationList(candidateId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/get/education")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<Education> getEducation(@RequestParam("candidateId") String candidateId,
                                                  @RequestParam("educationId") String educationId) {
        Education response = this.profileService.getEducation(candidateId, educationId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/profile/patch/education")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<Education> patchExperience(@RequestParam("candidateId") String candidateId,
                                                     @RequestParam("educationId") String educationId,
                                                     @RequestBody Education education) {
        Education exp = this.profileService.patchEducation(candidateId, educationId, education);
        return ResponseEntity.ok(exp);
    }

    @DeleteMapping("/profile/delete/education")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<Boolean> deleteEducation(@RequestParam("candidateId") String candidateId,
                                                   @RequestParam("educationId") int educationId) {
        Boolean deleted = this.profileService.deleteEducation(candidateId, educationId);
        return ResponseEntity.ok(deleted);
    }
    // End of Education!

    // Skill

    @GetMapping("/profile/get/skill-list")
    public ResponseEntity<List<Skill>> getSkillsListByKeyword(@RequestParam("name") String skill) {
        List<Skill> skills = this.profileService.getSkillByKeywordList(skill);
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/profile/get/candidate-skill-list")
    public ResponseEntity<HashSet<SkillResponse>> getCandidateSkillsList(@RequestParam("candidateId") String candidateId) {

        HashSet<SkillResponse> skills = this.profileService.getCandidateSkillList(candidateId);
        return ResponseEntity.ok(skills);
    }

    @PostMapping("/profile/save/skill-list")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<List<Skill>> saveNewSkill(@RequestParam("candidateId") String candidateId,
                                                    @RequestBody List<Skill> skills) {
        List<Skill> newSkill = this.profileService.saveNewSkillList(candidateId, skills);
        return ResponseEntity.ok(newSkill);
    }

    @PostMapping("/profile/save/candidate-skill-list")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<HashSet<SkillResponse>> saveNewSkillListToCandidate(@RequestParam("candidateId") String candidateId,
                                                                              @RequestBody List<Skill> skills) {
        HashSet<SkillResponse> newSkill = this.profileService.saveNewCandidateSkillList(candidateId, skills);
        return ResponseEntity.ok(newSkill);
    }

    @PatchMapping("/profile/patch/skill-list")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<List<SkillResponse>> patchSkillListToCandidate(@RequestParam("candidateId") String candidateId,
                                                                         @RequestBody List<SkillResponse> skills) {
        List<SkillResponse> newSkill = this.profileService.patchCandidateSkillList(candidateId, skills);
        return ResponseEntity.ok(newSkill);
    }

    @DeleteMapping("/profile/delete/candidate-skill")
    @PreAuthorize("isOwner(#candidateId) and hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<Boolean> deleteSkillCandidate(@RequestParam("candidateId") String candidateId,
                                                        @RequestParam("skillUuid") String skillUuid) {
        Boolean isDeleted = this.profileService.deleteCandidateSkill(candidateId, skillUuid);
        return ResponseEntity.ok(isDeleted);
    }

   /*
    @PostMapping("/profile/skills")
    public ResponseEntity<?> skills(@RequestBody Login credentials){
        ResponseLogin response = this.loginService.login(credentials);
        return ResponseEntity.ok(response);
    }*/



}
