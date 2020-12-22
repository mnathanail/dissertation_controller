package com.dissertation.controller.controller.service.profile;

import com.dissertation.controller.controller.endpoint.Endpoint;
import com.dissertation.controller.controller.model.profile.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ProfileService implements IProfile {

    @Qualifier("restTemplateBean")
    private final RestTemplate restTemplate;

    //Candidate

    @Override
    public Candidate savePhotoProfile(int candidateId, byte[] profilePic) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));

        Candidate candidate = new Candidate();
        candidate.setProfilePic(profilePic);

        return this.restTemplate.postForObject(Endpoint.CANDIDATE_PROFILE_PHOTO_SAVE, candidate , Candidate.class, urlParams);
    }

    @Override
    public Candidate getProfile(int candidateId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));

        return this.restTemplate.getForObject(Endpoint.CANDIDATE_PROFILE_GET, Candidate.class, urlParams);
    }

    @Override
    public Summary insertOrUpdateSummary(int id, Summary summary) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Summary> entity = new HttpEntity<>(summary, headers);
        ParameterizedTypeReference<ResponseProfile<Summary>> myBean =
                new ParameterizedTypeReference<ResponseProfile<Summary>>() {
                };

        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(id));

        Summary response = this.restTemplate.postForObject(Endpoint.SUMMARY_SAVE, entity, Summary.class, urlParams);
        return response;
    }

    @Override
    public Summary getSummary(String id) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(id));
        return this.restTemplate.getForObject(Endpoint.SUMMARY_GET, Summary.class, urlParams);
    }

    // Experience
    @Override
    public Experience saveExperience(int id, Experience experience) {
        //id=1;
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(id));
        return this.restTemplate.postForObject(Endpoint.EXPERIENCE_SAVE,experience, Experience.class, urlParams);
    }

    @Override
    public Experience getExperience(int candidateId, String experienceId ) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        urlParams.put("experienceId", String.valueOf(experienceId));
        return this.restTemplate.getForObject(Endpoint.EXPERIENCE_GET,Experience.class,  urlParams);
    }

    @Override
    public List<Experience> getExperienceList(int candidateId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        ResponseEntity<List<Experience>> a =
                this.restTemplate.exchange(
                        Endpoint.EXPERIENCE_LIST_GET,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Experience>>() {},
                        urlParams);
        return  a.getBody();
    }

    @Override
    public Experience patchExperience(int candidateId, String experienceId,  Experience experience) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        urlParams.put("experienceId", experienceId);

        try {
            return this.restTemplate.patchForObject(Endpoint.EXPERIENCE_PATCH, experience, Experience.class , urlParams);
        }
        catch (final HttpClientErrorException e) {
            System.out.println(e);
            System.out.println(e.getStatusCode());
            System.out.println(e.getResponseBodyAsString());
            return null;
        }
    }

    @Override
    public Boolean deleteExperience(int candidateId, String experienceId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        urlParams.put("experienceId", experienceId);

        ResponseEntity<Boolean> exchange = this.restTemplate.exchange(
                Endpoint.EXPERIENCE_DELETE,
                HttpMethod.DELETE,
                new HttpEntity<String>(""),
                Boolean.class,
                urlParams);
        return exchange.getBody();
        //this.restTemplate.delete(Endpoint.EXPERIENCE_DELETE, urlParams);
    }
    // End Experience

    // Education
    @Override
    public Education saveEducation(int id, Education education) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(id));
        return this.restTemplate.postForObject(Endpoint.EDUCATION_SAVE,education, Education.class, urlParams);
    }

    @Override
    public Education getEducation(int candidateId, String educationId ) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        urlParams.put("educationId", educationId);
        return this.restTemplate.getForObject(Endpoint.EDUCATION_GET,Education.class,  urlParams);
    }

    @Override
    public Set<Education> getEducationList(int candidateId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        ResponseEntity<Set<Education>> educationEntity =
                this.restTemplate.exchange(
                        Endpoint.EDUCATION_LIST_GET,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Set<Education>>() {},
                        urlParams);
        return  educationEntity.getBody();
    }

    @Override
    public Education patchEducation(int candidateId, String educationId,  Education education) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        urlParams.put("educationId", educationId);

        try {
            return this.restTemplate.patchForObject(Endpoint.EDUCATION_PATCH, education, Education.class , urlParams);
        }
        catch (final HttpClientErrorException e) {
            System.out.println(e);
            System.out.println(e.getStatusCode());
            System.out.println(e.getResponseBodyAsString());
            return null;
        }
    }

    @Override
    public Boolean deleteEducation(int candidateId, int educationId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        urlParams.put("educationId", String.valueOf(educationId));
        ResponseEntity<Boolean> exchange = this.restTemplate.exchange(
                Endpoint.EDUCATION_DELETE,
                HttpMethod.DELETE,
                new HttpEntity<String>(""),
                Boolean.class,
                urlParams);
        return exchange.getBody();

    }

    // End Experience

    // Skiils

    @Override
    public List<Skill> getSkillByKeywordList(int candidateId, String skill) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        urlParams.put("skill", skill);

        /*UriComponents uriComponents = UriComponentsBuilder.fromUriString(Endpoint.SKILL_LIST_GET)
                .query("?skill={skill}").buildAndExpand("{skill}");

        System.out.println("UriComponents uriComponents");
        System.out.println(uriComponents);
        System.out.println("---------------------------");*/

        ResponseEntity<List<Skill>> skillResponseEntity =
                this.restTemplate.exchange(
                        Endpoint.SKILL_LIST_GET+"?skill={skill}",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Skill>>() {},
                        urlParams);

        return skillResponseEntity.getBody();
        //return this.restTemplate.getForObject(Endpoint.SKILL_LIST_GET+"?skill={skill}", List.class , urlParams);
    }

    @Override
    public HashSet<SkillResponse> getCandidateSkillList(int candidateId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));

        ResponseEntity<HashSet<SkillResponse>> skillResponseEntity =
                this.restTemplate.exchange(
                        Endpoint.SKILL_CANDIDATE_LIST_GET,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<HashSet<SkillResponse>>() {},
                        urlParams);

        return skillResponseEntity.getBody();
    }

    @Override
    public List<Skill> saveNewSkillList(int candidateId, List<Skill> skill) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));

        ResponseEntity<List<Skill>> skillResponseEntity =
                this.restTemplate.exchange(
                        Endpoint.SKILL_LIST_SAVE,
                        HttpMethod.POST,
                        new HttpEntity<>(skill),
                        new ParameterizedTypeReference<List<Skill>>() {},
                        urlParams);

        return skillResponseEntity.getBody();
        //return this.restTemplate.postForObject(Endpoint.SKILL_SAVE, skill, Skill.class);
    }

    @Override
    public HashSet<SkillResponse> saveNewCandidateSkillList(int candidateId, List<Skill> skills) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));

        ResponseEntity<List<SkillResponse>> skillResponseEntity =
                this.restTemplate.exchange(
                        Endpoint.SKILL_CANDIDATE_LIST_SAVE,
                        HttpMethod.POST,
                        new HttpEntity<>(skills),
                        new ParameterizedTypeReference<List<SkillResponse>>() {},
                        urlParams);

        return new HashSet<SkillResponse>(skillResponseEntity.getBody());

        //return this.restTemplate.postForObject(Endpoint.SKILL_SAVE, skills, List.class, urlParams);
    }

    @Override
    public List<SkillResponse> patchCandidateSkillList(int candidateId, List<SkillResponse> skills) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));

        ResponseEntity<List<SkillResponse>> skillResponseEntity =
            this.restTemplate.exchange(
                Endpoint.SKILL_CANDIDATE_LIST_PATCH,
                HttpMethod.PATCH,
                new HttpEntity<>(skills),
                new ParameterizedTypeReference<List<SkillResponse>>() {},
                urlParams
            );

        return skillResponseEntity.getBody();
    }

    @Override
    public Boolean deleteCandidateSkill(int candidateId, String skillUuid) {
        //candidateId =1;
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id", String.valueOf(candidateId));
        urlParams.put("skillUuid", skillUuid);

        ResponseEntity<Boolean> exchange = this.restTemplate.exchange(
                Endpoint.SKILL_CANDIDATE_DELETE,
                HttpMethod.DELETE,
                new HttpEntity<String>(""),
                Boolean.class,
                urlParams);
        return exchange.getBody();
        //this.restTemplate.delete(Endpoint.EXPERIENCE_DELETE, urlParams);
    }


}
