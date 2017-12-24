package repository.common;

import repository.common.sorts.BubbleSort;
import repository.common.sorts.InsertionSort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurator {
    private static Configurator instance = new Configurator();
    public ISort getSorter() {
        Properties properties = new Properties();
        try(FileInputStream fls = new FileInputStream("D:/Универ/3 курс/infotekh/repositoryProject/Config.properties")) {

            properties.load(fls);

            String property = properties.getProperty("sorter");
            switch (property) {
                case "bubble":
                    return  new BubbleSort();
                case "insertion":
                    return  new InsertionSort();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new InsertionSort();
    }


    public static Configurator getInstance(){
        return instance;
    }

}
