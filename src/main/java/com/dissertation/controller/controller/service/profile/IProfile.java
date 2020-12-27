package com.dissertation.controller.controller.service.profile;

import com.dissertation.controller.controller.model.profile.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IProfile {

    Candidate findByEmail(String email);

    Candidate savePhotoProfile(int id, byte[] profilePic);

    Candidate getProfile(int id);


    Summary insertOrUpdateSummary(int id, Summary summary);

    Summary getSummary(String id);


    Experience saveExperience(int id, Experience experience);

    Experience getExperience(int candidateId, String experienceId);

    List<Experience> getExperienceList(int candidateId);

    Experience patchExperience(int id, String experienceId,  Experience experience);

    Boolean deleteExperience(int candidateId, String experienceId);


    Education saveEducation(int id, Education education);

    Education getEducation(int candidateId, String educationId);

    Set<Education> getEducationList(int candidateId);

    Education patchEducation(int id, String educationId,  Education education);

    Boolean deleteEducation(int candidateId, int educationId);


    List<Skill> getSkillByKeywordList(int candidateId, String skill);

    HashSet<SkillResponse> getCandidateSkillList(int candidateId);

    List<Skill> saveNewSkillList(int candidateId, List<Skill> skill);

    HashSet<SkillResponse> saveNewCandidateSkillList(int candidateId, List<Skill> skills);

    List<SkillResponse> patchCandidateSkillList(int candidateId, List<SkillResponse> skills);

    Boolean deleteCandidateSkill(int candidateId, String skillUuid);

}
