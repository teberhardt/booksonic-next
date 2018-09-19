package org.airsonic.player.domain;

import java.util.List;

public class Audiobook {

    private Integer id;

    private List<AudiobookFile> audiobookFiles;

    private String title;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<AudiobookFile> getAudiobookFiles() {
        return audiobookFiles;
    }

    public void setAudiobookFiles(List<AudiobookFile> audiobookFiles) {
        this.audiobookFiles = audiobookFiles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
