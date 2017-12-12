package repository.sorts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurator {
    private static Configurator instance = new Configurator();
    public ISort getSorter() throws IOException {
        Properties properties=new Properties();

        FileInputStream inputStream = new FileInputStream("/PPerson/src/main/resources/Config.properties");
        properties.load(inputStream);

        String property = properties.getProperty("sorter");
        switch (property) {
            case "bubble":
                return new BubbleSort();
            case "insertion":
                return new InsertionSort();
            default:
                return new BubbleSort();
        }
    }


    public static Configurator getInstance(){
        return instance;
    }

}
