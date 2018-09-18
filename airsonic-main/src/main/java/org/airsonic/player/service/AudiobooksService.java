package org.airsonic.player.service;

import org.airsonic.player.domain.Audiobook;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class AudiobooksService {

    public List<Audiobook> getAudiobooksHearedRecently() {
        return null;
    }

    public List<Audiobook> getAllAudiobooks() {
        return Arrays.asList(new Audiobook());
    }
}
