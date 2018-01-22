package com.rzonca.barbara.zaliczenie;

import com.rzonca.barbara.zaliczenie.model.DiscModel;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

public class FileHandler {
    public static void saveListToDirectory(List<DiscModel> list, String directoryWithFileName) throws Exception {
        PrintWriter writer = new PrintWriter(directoryWithFileName);
        for (DiscModel model: list) {
            writer.println(model.toString());
        }
        writer.close();
    }

    public static List<DiscModel> getListFromDirectory(String directory) throws Exception {
        List<DiscModel> list = new ArrayList<>();

        FileReader fileReader = new FileReader(directory);
        BufferedReader reader = new BufferedReader(fileReader);
        try {
            String line = reader.readLine();
            while (line != null) {
                DiscModel model = new DiscModel(line);
                list.add(model);
                line = reader.readLine();
            }
            return list;
        } finally {
            reader.close();
        }

    }
}
