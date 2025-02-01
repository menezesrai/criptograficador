import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String continueOption;

        // Parte do código que o preapra para encriptar e decriptar uma frase.

        do {
            System.out.println("Insira o texto a ser encriptado:");
            String text = scanner.nextLine();
            System.out.println("O quanto você quer encriptar? (números positivos para direita, negativos para esquerda)");
            int desvio = scanner.nextInt();
            scanner.nextLine(); 

            String encryptedText = encrypt(text, desvio);
            System.out.println("Texto encriptado: " + encryptedText);

            String decryptedText = decrypt(encryptedText, desvio);
            System.out.println("Texto decodificado: " + decryptedText);

            System.out.println("Você quer encriptar outra frase? (sim/não)");
            continueOption = scanner.nextLine();

        // função while para garantir que o usuário possa continuar encriptando frases depois de fazer a primeira.
        } while (continueOption.equalsIgnoreCase("sim"));

        scanner.close();
    }
        // Função que encripta o texto.
    public static String encrypt(String text, int desvio) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base + desvio) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    // Função que decripta o texto.

    public static String decrypt(String text, int desvio) {
        return encrypt(text, 26 - desvio);
    }
}
