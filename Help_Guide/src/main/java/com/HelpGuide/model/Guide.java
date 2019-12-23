package com.HelpGuide.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "guide")
@Getter
@Setter
@NoArgsConstructor
public class Guide {
    @Id
    @NotBlank
    private String url;

    @NotBlank
    private String capture;

    @NotBlank
    private String document;

    public Guide(@NotBlank @Size(max = 40) String url, @NotBlank @Size(max = 40) String capture, @NotBlank @Size(max = 40) String document) {
        this.url=url;
        this.capture = capture;
        this.document=document;
    }
}
