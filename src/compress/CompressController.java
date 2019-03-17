package compress;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static compress.File2Byte.getBytesFromFile;
import static compress.QuickLZ.compress;
import static compress.QuickLZ.decompress;
import static compress.GZIP.gzipCompress;
import static compress.GZIP.gzipUncompress;

public class CompressController {
    private String path;
    private String destination;

    public void Compress() {
        File f = new File(path);
        try {
          //  Files.write(new File(destination).toPath(),compress(getBytesFromFile(f), 3)); -QickLZ
            Files.write(new File(destination).toPath(),gzipCompress(getBytesFromFile(f)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Decompress() {
        File f = new File(path);
        try {
            //Files.write(new File(destination).toPath(),decompress(getBytesFromFile(f))); -QickLZ
            Files.write(new File(destination).toPath(),gzipUncompress(getBytesFromFile(f)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setPath(String path){
        this.path = path;
    }

    public void setDestination(String destination){
        this.destination=destination;
    }



}
