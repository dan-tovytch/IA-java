public class Food {
    private String name;
    private double protein;
    private double carbohydrates;
    private double fat;

    public Food(String name, double protein, double carbohydrates, double fat) {
        this.name = name;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

    public String getName() {
        return name;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFat() {
        return fat;
    }
}

