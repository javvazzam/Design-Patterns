package visitor.visitor1.basic;

import java.util.ArrayList;
import java.util.List;

class TextFile {
    private String content;

    public TextFile(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class ImageFile {
    private String format;

    public ImageFile(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}

class VideoFile {
    private int duration;

    public VideoFile(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}


public class Main {
    public static void main(String[] args) {
        List<Object> archivos = new ArrayList<>();
        archivos.add(new TextFile("Hola, este es un documento de texto."));
        archivos.add(new ImageFile("JPEG"));
        archivos.add(new VideoFile(120));
    }
}

//I want to analize each object of the list depending of its type; get the content if it is a text, get the format if it is an image and get the duration if it is a video. Moreover, I want to print through the screen that the object is being converted to another format. I need to do it the most optimize way, so it is still working fine if I change the structure of my elements