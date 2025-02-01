import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String continueOption;

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
        } while (continueOption.equalsIgnoreCase("sim"));

        scanner.close();
    }

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

    public static String decrypt(String text, int desvio) {
        return encrypt(text, 26 - desvio);
    }
}
