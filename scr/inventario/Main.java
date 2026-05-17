package scr.inventario;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=================================================");
            System.out.println("  SISTEMA DE GESTIÓN DE INVENTARIO (UNIDAD 3)    ");
            System.out.println("=================================================");

            // REQUISITO 5: Probar con diferentes conjuntos de datos de forma iterativa
            System.out.print("Ingrese el numero de productos a evaluar: ");
            int n = scanner.nextInt();

            Producto[] p = new Producto[n];

            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Datos del Producto " + (i + 1) + " ---");
                System.out.print("Peso (Capacidad que ocupa): ");
                int peso = scanner.nextInt();
                System.out.print("Valor (Beneficio economico): ");
                int valor = scanner.nextInt();
                p[i] = new Producto(peso, valor);
            }

            System.out.print("\nIngrese la capacidad maxima de almacenamiento: ");
            int capacidad = scanner.nextInt();

            System.out.println("\nCalculando soluciones y analizando rendimiento...");
            System.out.println("-------------------------------------------------");

            // --- MEDICIÓN RECURSIVO ---
            long t1 = System.nanoTime();
            int resRec = Mochila.recursivo(p, p.length, capacidad);
            long t2 = System.nanoTime();
            long tiempoRec = t2 - t1;

            // --- MEDICIÓN TOP-DOWN ---
            int[][] memo = new int[p.length + 1][capacidad + 1];
            for (int[] row : memo) Arrays.fill(row, -1);
            
            long t3 = System.nanoTime();
            int resTop = Mochila.topDown(p, p.length, capacidad, memo);
            long t4 = System.nanoTime();
            long tiempoTop = t4 - t3;

            // --- MEDICIÓN BOTTOM-UP ---
            long t5 = System.nanoTime();
            int resBottom = Mochila.bottomUp(p, capacidad);
            long t6 = System.nanoTime();
            long tiempoBottom = t6 - t5;
            // Mostrar Resultados de Beneficio (Deben coincidir)

            System.out.println("Beneficio Maximo Obtenido (Recursivo): " + resRec);
            System.out.println("Beneficio Maximo Obtenido (Top Down):  " + resTop);
            System.out.println("Beneficio Maximo Obtenido (Bottom Up): " + resBottom);
            System.out.println("-------------------------------------------------");
            
 // REQUISITO 4: Tabla de Rendimiento para Comparación Escrita
            System.out.println("\nTABLA COMPARATIVA DE TIEMPOS DE EJECUCIÓN:");
            System.out.printf("%-25s %-20s\n", "Enfoque de Solucion", "Tiempo Calculado");
            System.out.println("-------------------------------------------------");
            System.out.printf("%-25s %-15d ns\n", "1. Recursivo Puro", tiempoRec);
            System.out.printf("%-25s %-15d ns\n", "2. Top-Down (Memoización)", tiempoTop);
            System.out.printf("%-25s %-15d ns\n", "3. Bottom-Up (Tabulación)", tiempoBottom);
            System.out.println("-------------------------------------------------");

            // ANÁLISIS TEÓRICO ULTRA COMPACTO
            System.out.println("\nANÁLISIS TEÓRICO:");
            System.out.println("\n1. RECURSIVO:\nComplejidad exponencial O(2^n) debido a la repeticion de subproblemas.");
            System.out.println("\n2. TOP-DOWN:\nOptimiza con memoizacion reduciendo a O(n * W).");
            System.out.println("\n3. BOTTOM-UP:\nResuelve de forma iterativa con complejidad O(n * W), sin recursion.");
            System.out.println("=================================================");
            // OPCIONAL EXCELENTE: Bucle interactivo para repetir pruebas
            System.out.print("\n¿Desea probar otro conjunto de datos? (si/no): ");
            String respuesta = scanner.next();
            if (!respuesta.equalsIgnoreCase("si")) {
                continuar = false;
                System.out.println("\nPrograma finalizado. ¡Éxito en tu entrega!");
            }
        }
        scanner.close();
    }
}