package com.HelpGuide.dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GuideDTO {

    @NotBlank
    private String url;

    private String caption;

    private String document;

    public GuideDTO(@NotBlank String url,
                       String caption,
                    @NotBlank String document) {
        this.url = url;
        this.caption = caption;
        this.document = document;
    }
}