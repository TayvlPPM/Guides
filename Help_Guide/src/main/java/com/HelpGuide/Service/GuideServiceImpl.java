package com.HelpGuide.service;

import com.HelpGuide.repository.GuideRepository;
import com.HelpGuide.dto.GuideBody;
import com.HelpGuide.dto.GuideTitle;
import com.HelpGuide.model.Guide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    private GuideRepository guideRepository;

    @Override
    @Transactional
    public GuideBody getGuide(String url) {
        Guide guide = guideRepository.findByUrl(url);

        return new GuideBody(guide.getCapture(), guide.getDocument());
    }

    @Override
    @Transactional
    public List<GuideTitle> getGuideList() {
        List<GuideTitle> result= new LinkedList<>();
        List<Guide> guideList= guideRepository.findAll();
        guideList.forEach((n)->result.add(new GuideTitle(n.getUrl(),n.getCapture())));
        return result;
    }

    @Override
    public boolean existByUrl( String url) {
        return guideRepository.existsByUrl(url);
    }

}