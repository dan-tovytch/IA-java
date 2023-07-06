import java.util.List;

public class IA {
    private final Foods foods;

    public IA(Foods foods) {
        this.foods = foods;
    }

    public String suggestDietPlan() {
        StringBuilder dietPlan = new StringBuilder();

        // Obter a lista de alimentos
        List<Food> foodList = foods.getFoodList();

        // Montar o plano alimentar
        for (Food food : foodList) {
            dietPlan.append(food.getName()).append(":");
            dietPlan.append("\nProteína: ").append(food.getProtein()).append("g");
            dietPlan.append("\nCarboidrato: ").append(food.getCarbohydrates()).append("g");
            dietPlan.append("\nGordura: ").append(food.getFat()).append("g");
            dietPlan.append("\n\n");
        }

        return dietPlan.toString();
    }
}
