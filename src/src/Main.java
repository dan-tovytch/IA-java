import java.util.Scanner;
import java.util.List;

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
        String filePath = "data/alimentos.csv";
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

        // Loop de diálogo
        System.out.println("Digite suas perguntas sobre nutrição (ou 'sair' para encerrar):");
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("sair")) {
            // Processar a pergunta e fornecer a resposta da IA
            String respostaIA = processarPergunta(input);

            // Exibir a resposta
            System.out.println(respostaIA);

            // Solicitar a próxima pergunta
            input = scanner.nextLine();
        }

        // Fechar o scanner
        scanner.close();
    }

    // Método para processar a pergunta e fornecer a resposta adequada
    private static String processarPergunta(String pergunta) {
        // Converter a pergunta para minúsculas para facilitar o processamento
        pergunta = pergunta.toLowerCase();

        // Lógica para processar a pergunta e fornecer a resposta
        String resposta;

        if (pergunta.contains("proteína")) {
            resposta = "A proteína é um nutriente essencial para a construção e reparação dos tecidos do corpo. Alguns alimentos ricos em proteína são carne, peixe, ovos, laticínios, leguminosas e nozes.";
        } else if (pergunta.contains("carboidrato")) {
            resposta = "Os carboidratos são uma importante fonte de energia para o corpo. Alguns alimentos ricos em carboidratos são pães, massas, arroz, cereais, frutas e vegetais.";
        } else if (pergunta.contains("gordura")) {
            resposta = "Existem diferentes tipos de gorduras, como as gorduras saturadas, insaturadas e trans. É importante consumir gorduras saudáveis em moderação, como as encontradas em peixes, abacate, azeite de oliva e nozes.";
        } else {
            resposta = "Desculpe, não tenho informações específicas sobre essa pergunta. Por favor, consulte um nutricionista ou profissional de saúde para obter orientações mais precisas.";
        }

        return resposta;
    }

}