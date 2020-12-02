package com.dissertation.controller.controller.service.profile;

import com.dissertation.controller.controller.model.profile.*;

import java.util.List;

public interface IProfile {

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

    Education getEducation(int candidateId, int educationId);

    List<Education> getEducationList(int candidateId);

    void deleteEducation(int candidateId, int educationId);



    List<Skill> getSkillByKeywordList(int candidateId, String skill);

    List<Skill> getCandidateSkillList(int candidateId);

    List<Skill> saveNewSkillList(List<Skill> skill);

    List<Skill> saveNewCandidateSkillList(int candidateId, List<Skill> skills);


}
