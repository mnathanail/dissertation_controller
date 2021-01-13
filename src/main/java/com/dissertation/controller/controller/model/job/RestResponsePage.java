package com.dissertation.controller.controller.model.job;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class RestResponsePage<T> extends PageImpl<T> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RestResponsePage(@JsonProperty("content") List<T> content,
                            @JsonProperty("number") int number,
                            @JsonProperty("size") int size,
                            @JsonProperty("totalElements") Long totalElements,
                            @JsonProperty("totalPages") Long totalPages,
                            @JsonProperty("pageable") JsonNode pageable
    ) {

        super(content, PageRequest.of(number, size), totalElements);
    }


    public RestResponsePage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public RestResponsePage(List<T> content) {
        super(content);
    }

    public RestResponsePage() {
        super(new ArrayList<>());
    }
}
/*
@Data
public class RestResponsePage<T> implements Serializable {

    */
/** The Constant serialVersionUID. *//*

    private static final long serialVersionUID = 3248189030448292002L;

    private int total;

    @Data
    private static class Pageable{
        private int page;
        private int size;

        private Sort sort;
    }

    @Data
    public static class Sort {

        private List<String> orders;

        */
/*private String direction = "ASC";
        private String nullHandling = "NATIVE";
        private boolean ascending = true;
        private String property;
        private boolean ignoreCase;*//*



    }

    private List<T> content = new ArrayList<>();
    */
/*private boolean last, first;
    private int totalPages, numberOfElements, size, number;
    private long totalElements;
    private Sort sort;*//*



}*/
