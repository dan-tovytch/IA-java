public class User {
    private final int age;
    private final int height;
    private final int weight;

    public User(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getNutritionalStatus() {
        double bmi = calculateBMI();

        if (bmi < 18.5) {
            return "Baixo Peso";
        } else if (bmi < 25) {
            return "Peso Normal";
        } else if (bmi < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }

    private double calculateBMI() {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getEstadoNutricional() {
        return getNutritionalStatus();
    }

}
