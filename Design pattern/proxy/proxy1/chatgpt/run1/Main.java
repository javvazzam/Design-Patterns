package proxy.proxy1.chatgpt.run1;

import java.util.*;

// Define the interface for the third-party YouTube library
interface ThirdPartyYouTubeLib {
    List<String> listVideos();
    String getVideoInfo(String id);
    void downloadVideo(String id);
}

// Implement the real YouTube service
class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public List<String> listVideos() {
        System.out.println("Fetching the list of videos from YouTube...");
        // Simulate a delay for the API call
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return Arrays.asList("Video1", "Video2", "Video3");
    }

    @Override
    public String getVideoInfo(String id) {
        System.out.println("Fetching video info for video ID: " + id);
        // Simulate a delay for the API call
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "Video Info for " + id;
    }

    @Override
    public void downloadVideo(String id) {
        System.out.println("Downloading video with ID: " + id);
    }
}

// Proxy class for caching video information
class ThirdPartyYouTubeProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib service;
    private Map<String, String> videoInfoCache;
    private List<String> videoListCache;

    public ThirdPartyYouTubeProxy(ThirdPartyYouTubeLib service) {
        this.service = service;
        this.videoInfoCache = new HashMap<>();
        this.videoListCache = null; // Initialize as null to indicate cache is not yet populated
    }

    @Override
    public List<String> listVideos() {
        if (videoListCache == null) {
            videoListCache = service.listVideos();
        }
        return videoListCache;
    }

    @Override
    public String getVideoInfo(String id) {
        String info = videoInfoCache.get(id);
        if (info == null) {
            info = service.getVideoInfo(id);
            videoInfoCache.put(id, info);
        }
        return info;
    }

    @Override
    public void downloadVideo(String id) {
        service.downloadVideo(id);
    }
}

// Manager class that uses the third-party service or its proxy
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

// Main class to run the application
class Main {
    public static void main(String[] args) {
        // Create the real service instance
        ThirdPartyYouTubeLib realService = new ThirdPartyYouTubeClass();
        
        // Wrap it with a proxy for caching
        ThirdPartyYouTubeLib proxyService = new ThirdPartyYouTubeProxy(realService);
        
        // Create a manager with the proxy service
        YouTubeManager manager = new YouTubeManager(proxyService);

        // Simulate user input
        System.out.println("First interaction:");
        manager.reactOnUserInput();
        
        // Simulate a second interaction to show the benefit of caching
        System.out.println("\nSecond interaction (cached data):");
        manager.reactOnUserInput();
    }
}

