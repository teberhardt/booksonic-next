package org.airsonic.player.domain;

import java.util.List;

public class Audiobook {

    private Integer id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public List<Integer> getMediaFileIds() {
        return mediaFileIds;
    }

    public void setMediaFileIds(List<Integer> mediaFileIds) {
        this.mediaFileIds = mediaFileIds;
    }

    private List<Integer> mediaFileIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
