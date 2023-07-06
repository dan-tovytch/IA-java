import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Foods {
    private List<Food> foodList;

    public Foods() {
        this.foodList = new ArrayList<>();
    }

    public void loadFoodsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0];
                    double protein = Double.parseDouble(data[1]);
                    double carbohydrates = Double.parseDouble(data[2]);
                    double fat = Double.parseDouble(data[3]);

                    Food food = new Food(name, protein, carbohydrates, fat);
                    foodList.add(food);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os alimentos do arquivo: " + e.getMessage());
        }
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
