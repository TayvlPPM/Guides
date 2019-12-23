package com.HelpGuide.service;


import com.HelpGuide.dto.GuideBody;
import com.HelpGuide.dto.GuideTitle;

import java.util.List;

public interface GuideService {
    GuideBody getGuide(String url);
    List<GuideTitle> getGuideList();
    boolean existByUrl(String url);
}
