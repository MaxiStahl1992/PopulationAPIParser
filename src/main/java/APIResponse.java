import java.util.ArrayList;

public class APIResponse {

    private ArrayList<Population> data;

    public ArrayList<Population> getData() {
        return data;
    }

    public void setData(ArrayList<Population> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "data=" + data +
                '}';
    }
}
