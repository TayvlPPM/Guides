package com.HelpGuide.Repository;

import com.HelpGuide.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    Guide findByUrl(String email);
    Boolean existsByUrl(String email);
}