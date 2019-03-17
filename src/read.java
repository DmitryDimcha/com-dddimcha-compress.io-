import com.google.gson.Gson;
import compress.DeSerialize;
import compress.DirectoryRemaper;
import compress.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;

public class read {


    public static void main(String[] args) throws Exception {
        String from = "D:\\from13\\";
        String to = "D:\\to\\";
        String name = "project";
        //DirectoryRemaper directoryRemaper = new DirectoryRemaper();
        //directoryRemaper.ProjectDesctiptor(from, to, name);
        Main main = new Main();

        main.Zip(from, to, name);
        //main.UnZip(from,to,name);
    }

}
