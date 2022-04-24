package utilities;

import org.openqa.selenium.WebElement;
import pages.N11Page;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteToTxt {

    public static void saveData(List<String> tumMagazalarList){
        try{
            // TumMagazalar.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("tumMagazalar"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(tumMagazalarList+"\n");

            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}