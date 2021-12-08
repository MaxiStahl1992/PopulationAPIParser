import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;


public class JSONDataReaderTest {

    JSONDataReaderAndAnalyzer pop = new JSONDataReaderAndAnalyzer("https://datausa.io/api/data?drilldowns=Nation&measures=Population");
    Optional<APIResponse> apiResponseOptional = pop.mapRawJsonObjectsToPopulationDataList();
    APIResponse apiResponse = apiResponseOptional.get();

    @Test
    public void shouldMapRawJsonObjectsToPopulationDataList(){
        List<Long> actual = pop.mapPopulation(apiResponse);
        List<Long> expected = new ArrayList<>();
        expected.add(328239523L);
        expected.add(327167439L);
        expected.add(325719178L);
        expected.add(323127515L);
        expected.add(321418821L);
        expected.add(318857056L);
        expected.add(316128839L);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAveragePopulationCount(){
        Long actual = pop.getAveragePopulationCount(apiResponse);
        Long expected = 322951195L;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPopulationDataWithMinPopulationsCount(){
        Long actual = pop.getMinPopulationCount(apiResponse);
        Long expected = 316128839L;
        assertEquals(actual,expected);
    }

    @Test
    public void shouldGetPopulationDataWithMaxPopulationCount(){
        Long actual = pop.getMaxPopulationCount(apiResponse);
        Long expected = 328239523L;
        assertEquals(expected,actual);
    }

}
