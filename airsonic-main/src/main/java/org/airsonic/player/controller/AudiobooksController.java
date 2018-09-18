/*
 * This file is part of Airsonic.
 *
 *  Airsonic is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Airsonic is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Airsonic.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright 2015 (C) Sindre Mehus
 */
package org.airsonic.player.controller;

import org.airsonic.player.domain.Audiobook;
import org.airsonic.player.service.AudiobooksService;
import org.airsonic.player.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for the "Audiobooks" page.
 *
 * @author Sindre Mehus
 */
@Controller
@RequestMapping("/audiobooks")
public class AudiobooksController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AudiobooksService audiobooksService;

    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, Object> map = new HashMap<>();
        ModelAndView result = new ModelAndView();
        result.addObject("model", map);

        List<Audiobook> abooks =  audiobooksService.getAllAudiobooks();

        map.put("user", securityService.getCurrentUser(request));
        map.put("abooks", abooks);
       // map.put("abookSeriesMap", abookSeriesMap);
        map.put("hearedRecently", audiobooksService.getAudiobooksHearedRecently());
        return result;
    }
}
