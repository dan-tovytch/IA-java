import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Nutrição IA");

        // Solicitar informações básicas do usuário
        System.out.print("Informe sua idade: ");
        int age = scanner.nextInt();

        System.out.print("Informe sua altura (cm): ");
        int height = scanner.nextInt();

        System.out.print("Informe seu peso (kg): ");
        int weight = scanner.nextInt();

        // Criar uma instância do objeto User
        User user = new User(age, height, weight);

        // Obter o estado nutricional do usuário
        String status = user.getNutritionalStatus();

        // Exibir o estado nutricional
        System.out.println("\nEstado Nutricional:");
        System.out.println(status);

        // Exibir sugestões personalizadas
        System.out.println("\nSugestões:");
        if (status.equals("Baixo Peso")) {
            System.out.println("Recomenda-se aumentar a ingestão calórica com alimentos ricos em nutrientes.");
        } else if (status.equals("Peso Normal")) {
            System.out.println("Mantenha uma dieta equilibrada com alimentos de todos os grupos alimentares.");
        } else if (status.equals("Sobrepeso")) {
            System.out.println("Recomenda-se reduzir a ingestão calórica e aumentar a prática de exercícios físicos.");
        } else if (status.equals("Obesidade")) {
            System.out.println("É importante buscar orientação de um profissional de saúde para um plano adequado de emagrecimento.");
        }

        // Criar uma instância de Foods
        Foods foods = new Foods();

        // Carregar os alimentos a partir do arquivo CSV
        String filePath = "../data/alimentos.csv";
        foods.loadFoodsFromFile(filePath);

        // Obter a lista de alimentos
        List<Food> foodList = foods.getFoodList();

        // Exibir a lista de alimentos
        System.out.println("\nLista de Alimentos:");
        for (Food food : foodList) {
            System.out.println(food.getName());
            System.out.println("Proteína: " + food.getProtein());
            System.out.println("Carboidrato: " + food.getCarbohydrates());
            System.out.println("Gordura: " + food.getFat());
            System.out.println();
        }

        // Fechar o scanner
        scanner.close();
    }
}
