import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Conversor {
    private final static ArrayList<String> historial = new ArrayList<>();

    public static void eleccionUserMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("\n\n\n_____ BIENVENIDO AL CONVERSOR DE MONEDAS _____");
        while (continuar) {
            System.out.println("\n\n\n_____ ¿QUÉ DESEAS HACER? _____");
            System.out.println("1. Hacer conversión");
            System.out.println("2. Ver historial");
            System.out.println("3. Salir");
            System.out.print("Elige opción (1-3): ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    hacerConversion(scanner);
                    break;
                case 2:
                    verHistorial();
                    break;
                case 3:
                    continuar = false;
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo,");
            }
        }
        scanner.close();
    }

    public static void hacerConversion(Scanner scanner) {
        System.out.println("\n_____ NUEVA CONVERSIÓN _____");

        // Mostrar opciones
        System.out.println("________________________________");
        System.out.println("Elige moneda ORIGEN:");
        System.out.println("1. Peso argentino (ARS)");
        System.out.println("2. Peso boliviano (BOB)");
        System.out.println("3. Real brasileño (BRL)");
        System.out.println("4. Peso chileno (CLP)");
        System.out.println("5. Peso colombiano (COP)");
        System.out.println("6. Dólar estadounidense (USD)");
        System.out.println("________________________________");
        System.out.print("Elige moneda ORIGEN: ");
        int opcion1 = scanner.nextInt();

        // Elección de moneda según posición en el arrya
        String[] monedas = { "ARS", "BOB", "BRL", "CLP", "COP", "USD" };
        String monedaOrigen = "USD"; // Valor por defecto
        if (opcion1 < 1 || opcion1 > 6) {
            System.out.println("Opción inválida. Usando USD por defecto.");
        } else {
            monedaOrigen = monedas[opcion1 - 1];
        }

        System.out.println("________________________________");
        System.out.println("Elige moneda DESTINO:");
        System.out.println("1. Peso argentino (ARS)");
        System.out.println("2. Peso boliviano (BOB)");
        System.out.println("3. Real brasileño (BRL)");
        System.out.println("4. Peso chileno (CLP)");
        System.out.println("5. Peso colombiano (COP)");
        System.out.println("6. Dólar estadounidense (USD)");
        System.out.println("________________________________");
        System.out.print("Elige moneda DESTINO: ");
        int opcion2 = scanner.nextInt();

        String monedaDestino = "USD"; // Valor por defecto
        if (opcion2 < 1 || opcion2 > 6) {
            System.out.println("Opción inválida. Usando USD por defecto.");
        } else {
            monedaDestino = monedas[opcion2 - 1];
        }

        if (monedaOrigen.equals(monedaDestino)) {
            System.out.println("Las monedas de origen y destino son iguales. No se realizará conversión.");
            return;
        }

        System.out.print("Cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        String apiKey = "9057cf3927b063dc23fa624e";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey +
                "/pair/" + monedaOrigen + "/" + monedaDestino;

        try {
            double tasa = ConversorApp.obtenerTasa(url);
            double resultado = cantidad * tasa;
            BigDecimal resultadoDecimal = BigDecimal.valueOf(resultado)
                    .setScale(2, RoundingMode.HALF_UP);

            System.out.println("_____ TASA _____");
            System.out.println("1 " + monedaOrigen + " = " + tasa + " " + monedaDestino);

            System.out.println("_____ RESULTADO _____");
            System.out.println(cantidad + " " + monedaOrigen + " = " + resultadoDecimal + " " + monedaDestino);

            // Guardar en historial
            historial.add(
                    cantidad + " " + monedaOrigen + " = " + resultadoDecimal + " " + monedaDestino + " (Tasa: " + tasa
                            + ")");
            System.out.println("(Guardado en historial)");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void verHistorial() {
        System.out.println("\n_____ HISTORIAL DE CONVERSIONES _____");

        if (historial.isEmpty()) {
            System.out.println("No hay conversiones aún.");
        } else {
            int historialLenght = historial.size();
            for (int i = 0; i < historialLenght; i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
            System.out.println("Total: " + historialLenght + " conversiones");
        }
    }
}