package repository.common;

import repository.common.sorts.BubbleSort;
import repository.common.sorts.InsertionSort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurator {
    private static Configurator instance = new Configurator();
    public ISort getSorter() {
        Properties properties=new Properties();
        FileInputStream fls = null;
        ISort result = new BubbleSort(); //default
        try {
            fls = new FileInputStream("D:/Универ/3 курс/infotekh/repositoryProject/src/main/resources/Config.properties");
            properties.load(fls);

            String property = properties.getProperty("sorter");
            switch (property) {
                case "bubble":
                    result = new BubbleSort();
                case "insertion":
                    result = new InsertionSort();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fls.close();
            return result;
        }
    }


    public static Configurator getInstance(){
        return instance;
    }

}
