package facade.facade3.basic;

class VideoFile {
    private String filename;

    public VideoFile(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void load() {
        System.out.println("VideoFile: Loading video file: " + filename);
    }

    public void prepare() {
        System.out.println("VideoFile: Preparing video file: " + filename);
    }
}

interface CompressionCodec {
    String getType();
}

class OggCompressionCodec implements CompressionCodec {
    @Override
    public String getType() {
        return "ogg";
    }

    public void compress(String data) {
        System.out.println("OggCompressionCodec: Compressing data using Ogg codec...");
    }
}

class MPEG4CompressionCodec implements CompressionCodec {
    @Override
    public String getType() {
        return "mp4";
    }

    public void compress(String data) {
        System.out.println("MPEG4CompressionCodec: Compressing data using MPEG4 codec...");
    }
}

class CodecFactory {
    public CompressionCodec extract(VideoFile file) {
        String filename = file.getFilename();
        if (filename.endsWith(".mp4")) {
            System.out.println("CodecFactory: extracting MPEG4 codec...");
            return new MPEG4CompressionCodec();
        } else {
            System.out.println("CodecFactory: extracting Ogg codec...");
            return new OggCompressionCodec();
        }
    }
}

class BitrateReader {
    public static String read(String filename, CompressionCodec codec) {
        System.out.println("BitrateReader: Reading file with codec " + codec.getType() + "...");
        return "buffered data from " + filename;
    }

    public static String convert(String buffer, CompressionCodec codec) {
        System.out.println("BitrateReader: Converting buffer to " + codec.getType() + " format...");
        return "converted data to " + codec.getType();
    }
}

class AudioMixer {
    public String fix(String result) {
        System.out.println("AudioMixer: Fixing audio in the file...");
        return "fixed " + result;
    }
}

class File {
    private String data;

    public File(String data) {
        this.data = data;
    }

    public void save() {
        System.out.println("File: Saving " + data);
    }
}
