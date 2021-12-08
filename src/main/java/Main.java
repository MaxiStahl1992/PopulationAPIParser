import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        JSONDataReaderAndAnalyzer pop = new JSONDataReaderAndAnalyzer("https://datausa.io/api/data?drilldowns=Nation&measures=Population");
        Optional<APIResponse> apiResponseOptional = pop.mapRawJsonObjectsToPopulationDataList();
        if(apiResponseOptional.isPresent()){
            APIResponse apiResponse = apiResponseOptional.get();
            System.out.println("Populations: " + pop.mapPopulation(apiResponse));
            System.out.println("Average: " + pop.getAveragePopulationCount(apiResponse));
            System.out.println("Min Population: " + pop.getMinPopulationCount(apiResponse));
            System.out.println("Max Population: " + pop.getMaxPopulationCount(apiResponse));
        } else {
            System.out.println("Not Working");
        }
    }
}
