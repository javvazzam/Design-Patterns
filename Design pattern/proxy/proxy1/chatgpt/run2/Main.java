package proxy.proxy1.chatgpt.run2;

import java.util.*;

// Interface for the YouTube Library
interface ThirdPartyYouTubeLib {
    List<String> listVideos();
    String getVideoInfo(String id);
    void downloadVideo(String id);
}

// The concrete class that implements the YouTube Library interface
class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public List<String> listVideos() {
        // Simulate an API request to YouTube.
        System.out.println("Fetching the list of videos from YouTube...");
        return Arrays.asList("Video1", "Video2", "Video3");
    }

    @Override
    public String getVideoInfo(String id) {
        // Simulate getting metadata about some video.
        System.out.println("Fetching video info for video ID: " + id);
        return "Video Info for " + id;
    }

    @Override
    public void downloadVideo(String id) {
        // Simulate downloading a video file from YouTube.
        System.out.println("Downloading video with ID: " + id);
    }
}

// The proxy class that implements caching
class CachedYouTubeClass implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youtubeService;
    private Map<String, String> cacheVideoInfo = new HashMap<>();
    private List<String> cacheListVideos;
    private Map<String, Boolean> downloadedVideos = new HashMap<>();

    public CachedYouTubeClass(ThirdPartyYouTubeLib youtubeService) {
        this.youtubeService = youtubeService;
    }

    @Override
    public List<String> listVideos() {
        if (cacheListVideos == null) {
            cacheListVideos = youtubeService.listVideos();
        }
        return cacheListVideos;
    }

    @Override
    public String getVideoInfo(String id) {
        if (!cacheVideoInfo.containsKey(id)) {
            cacheVideoInfo.put(id, youtubeService.getVideoInfo(id));
        }
        return cacheVideoInfo.get(id);
    }

    @Override
    public void downloadVideo(String id) {
        if (!downloadedVideos.containsKey(id)) {
            youtubeService.downloadVideo(id);
            downloadedVideos.put(id, true);
        } else {
            System.out.println("Video with ID " + id + " is already downloaded.");
        }
    }
}

// The YouTubeManager class that interacts with the YouTube Library
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
        service.downloadVideo("Video1");
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        // Create the original YouTube service
        ThirdPartyYouTubeLib youtubeService = new ThirdPartyYouTubeClass();
        
        // Create the cached proxy for the YouTube service
        ThirdPartyYouTubeLib cachedService = new CachedYouTubeClass(youtubeService);

        // Create the YouTube manager with the cached service
        YouTubeManager manager = new YouTubeManager(cachedService);

        // First request: data will be fetched and cached.
        System.out.println("First request:");
        manager.reactOnUserInput();
        System.out.println();

        // Subsequent requests: data will be retrieved from the cache.
        System.out.println("Second request:");
        manager.reactOnUserInput();
    }
}

