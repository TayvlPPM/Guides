package com.HelpGuide.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GuideTitle {

    @NotBlank
    private String url;

    private String caption;

    public GuideTitle(@NotBlank String url,
                      String caption) {
        this.url = url;
        this.caption = caption;
    }
}