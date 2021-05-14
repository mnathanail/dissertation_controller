package com.dissertation.controller.controller.service.profile;

import com.dissertation.controller.controller.model.profile.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IProfile {

    Candidate findByEmail(String email);
    Candidate savePhotoProfile(String id, byte[] profilePic);
    Candidate getProfile(String id);
    Summary insertOrUpdateSummary(String id, Summary summary);
    Summary getSummary(String id);
    Experience saveExperience(String id, Experience experience);
    Experience getExperience(String id, String experienceId);
    List<Experience> getExperienceList(String id);
    Experience patchExperience(String id, String experienceId,  Experience experience);
    Boolean deleteExperience(String id, String experienceId);
    Education saveEducation(String id, Education education);
    Education getEducation(String id, String educationId);
    Set<Education> getEducationList(String candidateId);
    Education patchEducation(String id, String educationId,  Education education);
    Boolean deleteEducation(String candidateId, int educationId);
    List<Skill> getSkillByKeywordList(String skill);
    HashSet<SkillResponse> getCandidateSkillList(String candidateId);
    List<Skill> saveNewSkillList(String id, List<Skill> skill);
    HashSet<SkillResponse> saveNewCandidateSkillList(String id, List<Skill> skills);
    List<SkillResponse> patchCandidateSkillList(String id, List<SkillResponse> skills);
    Boolean deleteCandidateSkill(String id, String skillUuid);
}
