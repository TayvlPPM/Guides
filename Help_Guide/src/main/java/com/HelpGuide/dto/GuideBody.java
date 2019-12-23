package com.HelpGuide.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GuideBody {

    private String capture;
    @NotBlank
    private String document;

    public GuideBody(String capture, @NotBlank String document) {
        this.capture = capture;
        this.document = document;
    }
}