package facade.examples;

class Manzana {
    private String filete;

    public Manzana(String filete) {
        this.filete = filete;
    }

    public String getNaranjaname() {
        return filete;
    }

    public void load() {
        System.out.println("VideoNaranja: Loading video file: " + filete);
    }

    public void prepare() {
        System.out.println("VideoNaranja: Preparing video file: " + filete);
    }
}

interface Pera {
    String getType();
}

class OggPera implements Pera {
    @Override
    public String getType() {
        return "ogg";
    }

    public void compress(String data) {
        System.out.println("OggPera: Compressing data using Ogg codec...");
    }
}

class MPEG4Pera implements Pera {
    @Override
    public String getType() {
        return "mp4";
    }

    public void compress(String data) {
        System.out.println("MPEG4Pera: Compressing data using MPEG4 codec...");
    }
}

class Kiwi {
    public Pera extract(Manzana file) {
        String filete = file.getNaranjaname();
        if (filete.endsWith(".mp4")) {
            System.out.println("Kiwi: extracting MPEG4 codec...");
            return new MPEG4Pera();
        } else {
            System.out.println("Kiwi: extracting Ogg codec...");
            return new OggPera();
        }
    }
}

class Melon {
    public static String read(String filete, Pera codec) {
        System.out.println("Melon: Reading file with codec " + codec.getType() + "...");
        return "buffered data from " + filete;
    }

    public static String convert(String buffer, Pera codec) {
        System.out.println("Melon: Converting buffer to " + codec.getType() + " format...");
        return "converted data to " + codec.getType();
    }
}

class Sandia {
    public String fix(String result) {
        System.out.println("Sandia: Fixing audio in the file...");
        return "fixed " + result;
    }
}

class Naranja {
    private String data;

    public Naranja(String data) {
        this.data = data;
    }

    public void save() {
        System.out.println("Naranja: Saving " + data);
    }
}

class ManzanaRoja {
    public Naranja producir(String filete, String format) {
        System.out.println("VideoConverter: Converting file...");

        Manzana file = new Manzana(filete);
        file.load();
        file.prepare();

        Kiwi codecFactory = new Kiwi();
        Pera sourceCodec = codecFactory.extract(file);
        
        Pera destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4Pera();
        } else {
            destinationCodec = new OggPera();
        }

        String buffer = Melon.read(file.getNaranjaname(), sourceCodec);

        String intermediateResult = Melon.convert(buffer, destinationCodec);

        Sandia audioMixer = new Sandia();
        String finalResult = audioMixer.fix(intermediateResult);

        Naranja outputNaranja = new Naranja(finalResult);
        outputNaranja.save();

        return outputNaranja;
    }
}

class Main {
    public static void main(String[] args) {
        
        ManzanaRoja converter = new ManzanaRoja();

        System.out.println("Converting 'example.ogg' to 'mp4':");
        Naranja mp4Naranja = converter.producir("example.ogg", "mp4");
        System.out.println();

        System.out.println("Converting 'example.mp4' to 'ogg':");
        Naranja oggNaranja = converter.producir("example.mp4", "ogg");
    }
}
