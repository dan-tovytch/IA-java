import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Foods {
    private final List<Food> foodList;

    public Foods() {
        this.foodList = new ArrayList<>();
    }

    public void loadFoodsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Ler a primeira linha contendo os nomes das colunas
            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");

            // Obter os índices das colunas desejadas
            int nameIndex = getIndex(headers, "Name");
            int proteinIndex = getIndex(headers, "Protein (g)");
            int carbohydratesIndex = getIndex(headers, "Carbohydrates (g)");
            int fatIndex = getIndex(headers, "Fat (g)");

            // Ler as linhas de dados
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == headers.length) {
                    String name = data[nameIndex].trim();
                    double protein = Double.parseDouble(data[proteinIndex].trim());
                    double carbohydrates = Double.parseDouble(data[carbohydratesIndex].trim());
                    double fat = Double.parseDouble(data[fatIndex].trim());

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

    private int getIndex(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(value)) {
                return i;
            }
        }
        return -1;
    }
}
