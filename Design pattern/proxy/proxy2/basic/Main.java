package proxy.proxy2.basic;

interface FileServiceLib {
    void readFile(String fileName);
    void writeFile(String fileName, String content);
}

class FileService implements FileServiceLib {

    @Override
    public void readFile(String fileName) {
        System.out.println("Reading file: " + fileName);
        // leer un archivo desde el sistema de archivos.
    }

    @Override
    public void writeFile(String fileName, String content) {
        System.out.println("Writing to file: " + fileName + " Content: " + content);
        // escribir en un archivo del sistema de archivos.
    }
}
