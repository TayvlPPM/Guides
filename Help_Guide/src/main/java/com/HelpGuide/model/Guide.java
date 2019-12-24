package com.HelpGuide.model;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "guide")
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

    public void setUrl(String url){
        this.url=url;
    }
    public String getUrl (){
        return url;
    }
    public void setCapture(String capture){
        this.capture=capture;
    }
    public String getCapture (){
        return capture;
    }
    public void setDocument(String document){
        this.document=document;
    }
    public String getDocument (){
        return document;
    }
}
