package org.airsonic.player.service;

import org.airsonic.player.domain.Audiobook;
import org.airsonic.player.domain.AudiobookFile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AudiobookService {
    public Audiobook getAudiobook(int id) {

        Audiobook audiobook = new Audiobook();
        audiobook.setId(id);
        audiobook.setTitle("Commonbook");
        audiobook.setDescription("common description");

        AudiobookFile audiobookFile1 = new AudiobookFile();
        audiobookFile1.setId(11);
        audiobookFile1.setDuration(10);

        AudiobookFile audiobookFile2 = new AudiobookFile();
        audiobookFile2.setId(11);
        audiobookFile2.setDuration(10);

        AudiobookFile audiobookFile3 = new AudiobookFile();
        audiobookFile3.setId(11);
        audiobookFile3.setDuration(10);

        audiobook.setAudiobookFiles(Arrays.asList(audiobookFile1, audiobookFile2, audiobookFile3));
        return audiobook;
    }
}
