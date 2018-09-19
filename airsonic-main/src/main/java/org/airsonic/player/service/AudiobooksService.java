package org.airsonic.player.service;

import org.airsonic.player.domain.Audiobook;
import org.airsonic.player.domain.AudiobookFile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class AudiobooksService {

    public List<Audiobook> getAudiobooksHearedRecently() {
        return null;
    }

    public List<Audiobook> getAllAudiobooks() {
        Audiobook ab = new Audiobook();
        ab.setId(1);
        ab.setTitle("commonTitle");
        ab.setAudiobookFiles(Arrays.asList(new AudiobookFile(), new AudiobookFile()));
        return Arrays.asList(ab, ab, ab);
    }
}
