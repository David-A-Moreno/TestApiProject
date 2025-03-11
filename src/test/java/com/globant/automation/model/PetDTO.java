package com.globant.automation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import groovy.lang.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.HTML;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetDTO {
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private String status;
}
