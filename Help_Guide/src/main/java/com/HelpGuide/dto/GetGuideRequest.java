package com.HelpGuide.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GetGuideRequest {

    @NotBlank
    private String url;

    public GetGuideRequest(@NotBlank String url){
        this.url=url;
    }
}
