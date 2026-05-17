package scr.inventario;

public class Mochila {

    // 1. TAREA #1: Enfoque Recursivo Puro [cite: 33]
    public static int recursivo(Producto[] p, int n, int capacidad) {
        if (n == 0 || capacidad == 0) return 0;

        if (p[n - 1].peso > capacidad) {
            return recursivo(p, n - 1, capacidad);
        }

        return Math.max(
            p[n - 1].valor + recursivo(p, n - 1, capacidad - p[n - 1].peso),
            recursivo(p, n - 1, capacidad)
        );
    }

    // 2. TAREA #3: Enfoque Top-Down (Memoización) [cite: 35]
    public static int topDown(Producto[] p, int n, int capacidad, int[][] memo) {
        if (n == 0 || capacidad == 0) return 0;

        if (memo[n][capacidad] != -1) {
            return memo[n][capacidad];
        }

        if (p[n - 1].peso > capacidad) {
            return memo[n][capacidad] = topDown(p, n - 1, capacidad, memo);
        }

        return memo[n][capacidad] = Math.max(
            p[n - 1].valor + topDown(p, n - 1, capacidad - p[n - 1].peso, memo),
            topDown(p, n - 1, capacidad, memo)
        );
    }

    // 3. TAREA #2: Enfoque Bottom-Up con Rastreo de Productos Seleccionados
    public static int bottomUp(Producto[] p, int capacidad) {
        int n = p.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        // Llenado de la tabla
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacidad; w++) {
                if (p[i - 1].peso <= w) {
                    dp[i][w] = Math.max(
                        p[i - 1].valor + dp[i - 1][w - p[i - 1].peso],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // 🔥 UPGRADE: Rastreo de los productos seleccionados
        System.out.print("Productos seleccionados: ");
        int res = dp[n][capacidad];
        int w = capacidad;
        boolean primero = true;

        for (int i = n; i > 0 && res > 0; i--) {
            // Si el valor cambia respecto a la fila superior, significa que el producto fue incluido
            if (res != dp[i - 1][w]) {
                if (!primero) {
                    System.out.print(", ");
                }
                System.out.print(i); // Imprime el número del producto (1, 2, 3...)
                primero = false;
                
                // Descontamos el valor y el peso del producto actual
                res -= p[i - 1].valor;
                w -= p[i - 1].peso;
            }
        }
        System.out.println(); // Salto de línea estético

        return dp[n][capacidad];
            }
     }