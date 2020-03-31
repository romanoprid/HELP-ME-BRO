package ua.lviv.iot.spring.database.rest.manager;

import ua.lviv.iot.spring.database.rest.model.Good;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ClubWriter {

    public static void writeToFile(final List<Good> goods) {
            File csvOutputFile = new File("D:\\projects\\Iot-2020Labs\\List.csv");
            try {

                FileWriter pw = new FileWriter(csvOutputFile);
                Good g = new Good();
                pw.write(g.getHeaders());
                for (Good good : goods) {
                    String toCSV = good.toCSV();
                    pw.write(toCSV);
                }
                pw.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
