package testng;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class DataProviderClass {

    @DataProvider(name = "dp")
    public String[][] getData() {
        String data[][] = {
                {"appu", "appu123","valid"}, {"shivu", "shivu123","invalid"}
        };

        return data;
    }
}
