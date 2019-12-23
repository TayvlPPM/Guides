package com.HelpGuide.Service;


import com.HelpGuide.dto.GuideBody;
import com.HelpGuide.dto.GuideDTO;
import com.HelpGuide.dto.GetGuideRequest;
import com.HelpGuide.dto.GuideTitle;

import java.util.List;

public interface GuideService {
    GuideBody getGuide(GetGuideRequest getGuideRequest);
    GuideDTO saveGuide();
    List<GuideTitle> getGuideList();
    boolean existByUrl(String url);
}
