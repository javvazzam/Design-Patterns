package proxy.proxy1.basic;

import java.util.Arrays;
import java.util.List;

interface ThirdPartyYouTubeLib {
    List<String> listVideos();
    String getVideoInfo(String id);
    void downloadVideo(String id);
}

class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public List<String> listVideos() {
        // Send an API request to YouTube.
        System.out.println("Fetching the list of videos from YouTube...");
        return Arrays.asList("Video1", "Video2", "Video3");
    }

    @Override
    public String getVideoInfo(String id) {
        // Get metadata about some video.
        System.out.println("Fetching video info for video ID: " + id);
        return "Video Info for " + id;
    }

    @Override
    public void downloadVideo(String id) {
        // Download a video file from YouTube.
        System.out.println("Downloading video with ID: " + id);
    }
}

class YouTubeManager {
    protected ThirdPartyYouTubeLib service;

    public YouTubeManager(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

    public void renderVideoPage(String id) {
        String info = service.getVideoInfo(id);
        System.out.println("Rendering video page for: " + info);
    }

    public void renderListPanel() {
        List<String> list = service.listVideos();
        System.out.println("Rendering the list of video thumbnails: " + list);
    }

    public void reactOnUserInput() {
        renderVideoPage("Video1");
        renderListPanel();
    }
}
