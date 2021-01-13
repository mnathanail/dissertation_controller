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

    Experience getExperience(String candidateId, String experienceId);

    List<Experience> getExperienceList(String candidateId);

    Experience patchExperience(String id, String experienceId,  Experience experience);

    Boolean deleteExperience(String candidateId, String experienceId);


    Education saveEducation(String id, Education education);

    Education getEducation(String candidateId, String educationId);

    Set<Education> getEducationList(String candidateId);

    Education patchEducation(String id, String educationId,  Education education);

    Boolean deleteEducation(String candidateId, int educationId);


    List<Skill> getSkillByKeywordList(String skill);

    HashSet<SkillResponse> getCandidateSkillList(String candidateId);

    List<Skill> saveNewSkillList(String candidateId, List<Skill> skill);

    HashSet<SkillResponse> saveNewCandidateSkillList(String candidateId, List<Skill> skills);

    List<SkillResponse> patchCandidateSkillList(String candidateId, List<SkillResponse> skills);

    Boolean deleteCandidateSkill(String candidateId, String skillUuid);

}
