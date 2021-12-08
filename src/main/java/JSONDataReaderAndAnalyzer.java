import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class JSONDataReaderAndAnalyzer {
    String link;

    public JSONDataReaderAndAnalyzer(){

    }

    public JSONDataReaderAndAnalyzer(String link){
        this.link = link;
    }

    public Optional<APIResponse> mapRawJsonObjectsToPopulationDataList(){
        Optional<APIResponse> apiResponseOptional = Optional.empty();
        try {

            // convert JSON string to Java
            URL url = new URL(this.link);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            APIResponse apiResponse = new Gson().fromJson(
                    reader
                    , APIResponse.class);

            apiResponseOptional = Optional.of(apiResponse);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return apiResponseOptional;
    }

    public List<Long> mapPopulation(APIResponse apiResponse){
        ArrayList<Population> test = apiResponse.getData();

        return test.stream()
                .map(population -> population.getPopulation())
                .collect(Collectors.toList());

    }

    public long getAveragePopulationCount(APIResponse apiResponse){
        ArrayList<Population> test = apiResponse.getData();

        List<Long> populations = test.stream()
                .map(Population::getPopulation).toList();

        return populations.stream()
                    .reduce(0L,Long::sum)/populations.size();
    }

    public long getMinPopulationCount(APIResponse apiResponse){
        ArrayList<Population> test = apiResponse.getData();

        List<Long> populations = test.stream()
                .map(Population::getPopulation).toList();
        return populations.stream()
                    .mapToLong(v -> v)
                    .min().orElseThrow(NoSuchElementException::new);
    }

    public long getMaxPopulationCount(APIResponse apiResponse){
        ArrayList<Population> test = apiResponse.getData();

        List<Long> populations = test.stream()
                .map(Population::getPopulation).toList();

        return populations.stream()
                .mapToLong(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
    }
}
