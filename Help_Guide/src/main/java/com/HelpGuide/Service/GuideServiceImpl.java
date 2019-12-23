package com.HelpGuide.Service;

import com.HelpGuide.Repository.GuideRepository;
import com.HelpGuide.dto.GuideBody;
import com.HelpGuide.dto.GuideDTO;
import com.HelpGuide.dto.GetGuideRequest;
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
    public GuideBody getGuide(GetGuideRequest getGuideRequest) {
        Guide guide = guideRepository.findByUrl(getGuideRequest.getUrl());

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

    @Override
    @Transactional
    public GuideDTO saveGuide() {
        Guide guide = new Guide("test11",
                "testcap1",
                "<h1>Facebook &amp; Google Limits</h1>\n" +
                        "<table>\n" +
                        "<tbody><tr>\n" +
                        "<th>Limit/Channel</th>\n" +
                        "<th>Google</th>\n" +
                        "<th>Facebook</th>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>Ad account requests/operations limits</td>\n" +
                        "<td>No limits</td>\n" +
                        "<td>Ad Account 20-25 requests per 10 minutes, header flag Ad Account API usage in percentage (0-100%)</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>Application requests / operations limits</td>\n" +
                        "<td>10 000 operations or 1 000 report downloads per day</td>\n" +
                        "<td>240 * number of users requests per hour</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>Ad Campaigns limits</td>\n" +
                        "<td>10 000 Ad Campaigns per Ad Account (includes active and paused)</td>\n" +
                        "<td>5 000 Ad Campaigns that aren't deleted per Ad Account</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>Ad Groups / Ad Sets limits</td>\n" +
                        "<td>20 000 Ad Groups per Ad Campaign 20 000 Ad Group targeting items per Ad Group (such as keywords, placements, and audience lists)</td>\n" +
                        "<td>70 Ad Sets per Ad Campaign 5 000 Ad Sets that aren't deleted per Ad Account</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>Statistics limits</td>\n" +
                        "<td> </td>\n" +
                        "<td>Calls within one hour = 190000 + 400 * Number of Active ads - 0.001 * User Errors</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>Ads Management</td>\n" +
                        "<td> </td>\n" +
                        "<td>Calls within one hour = 100000 + 40 * Number of Active Ads</td>\n" +
                        "</tr>\n" +
                        "</tbody></table>\n" +
                        "<br>\n" +
                        "<h1>Publishing Ad Campaigns Time</h1>\n" +
                        "<table>\n" +
                        "<tbody><tr>\n" +
                        "<th>Ad Campaings</th>\n" +
                        "<th>Ad Sets</th>\n" +
                        "<th>Estimate</th>\n" +
                        "<th>Actual</th>\n" +
                        "<th>Actual with sleep 3s.\n" +
                        "(Actual time, but with 3 second stop after every request)\n" +
                        "</th>\n" +
                        "<th>Receiving Estimates</th>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>1</td>\n" +
                        "<td>50</td>\n" +
                        "<td>30-50m.</td>\n" +
                        "<td>~25m.</td>\n" +
                        "<td> </td>\n" +
                        "<td> </td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>3</td>\n" +
                        "<td>150</td>\n" +
                        "<td>90-150m.</td>\n" +
                        "<td>~50m.</td>\n" +
                        "<td></td>\n" +
                        "<td></td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>10</td>\n" +
                        "<td>500</td>\n" +
                        "<td>300-500m.</td>\n" +
                        "<td>~2h. 50m. (170m.)</td>\n" +
                        "<td></td>\n" +
                        "<td></td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>20</td>\n" +
                        "<td>1000</td>\n" +
                        "<td>600-1000m.</td>\n" +
                        "<td>~4h. 20m. (260m.)</td>\n" +
                        "<td>6h. 40m. (400m.)</td>\n" +
                        "<td>3h. 20m. (200m.)</td>\n" +
                        "</tr>\n" +
                        "</tbody></table><br>\n" +
                        "<p>Documentation links:</p>\n" +
                        "<a href=\"https://www.facebook.com/business/help/652738434773716\">Maximum Ads and Ad Accounts You Can Have in Ads Manager</a><br>\n" +
                        "<a href=\"https://developers.facebook.com/docs/graph-api/overview/rate-limiting#ad-account-level-rate-limiting\">Rate Limits(Facebook)</a><br>\n" +
                        "<a href=\"https://support.google.com/google-ads/answer/6372658?hl=en\">About your Google Ads account limits</a><br>\n" +
                        "<a href=\"https://developers.google.com/adwords/api/docs/guides/rate-limits\">Rate Limits(Google)</a><br>");
        guideRepository.save(guide);
        return new GuideDTO(guide.getUrl(),
                guide.getCapture(),
                guide.getDocument());
    }
}