/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner; // Importa la clase Scanner para leer entradas del usuario desde la consola

public class Logica {
    
    // Declaración de un arreglo fijo de 5 elementos tipo String
    String[] elementos = new String[5];

    // Contador para llevar el número actual de elementos en la lista
    int contador = 0;

    // Scanner para capturar entradas del usuario
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Se crea una instancia de la clase Logica
        Logica lista = new Logica();

        // Se llama al método iniciar para mostrar el menú principal
        lista.iniciar();
    }

    // Método que contiene el menú principal y la lógica de interacción
    public void iniciar() {
        int opcion = 0; // Variable para almacenar la opción seleccionada

        // Bucle que se repite hasta que el usuario elige salir (opción 5)
        do {
            // Muestra el menú de opciones
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Editar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");

            try {
                // Captura la opción del usuario
                opcion = sc.nextInt();
                sc.nextLine(); // Limpia el buffer para evitar errores con nextLine()

                // Ejecuta la acción correspondiente según la opción elegida
                switch (opcion) {
                    case 1:
                        agregarElemento(); // Llama al método para agregar un nuevo elemento
                        break;
                    case 2:
                        editarElemento(); // Llama al método para editar un elemento existente
                        break;
                    case 3:
                        eliminarElemento(); // Llama al método para eliminar un elemento
                        break;
                    case 4:
                        mostrarElementos(); // Muestra todos los elementos actuales
                        break;
                    case 5:
                        System.out.println("Saliendo del programa..."); // Mensaje de salida
                        break;
                    default:
                        System.out.println("Opcion no valida."); // Opción fuera del rango
                        break;
                }
            } catch (Exception e) {
                // Maneja errores si el usuario ingresa algo que no es un número
                System.out.println("Error: Ingresa un numero valido.");
                sc.nextLine(); // Limpia la entrada incorrecta
            }
        } while (opcion != 5); // Condición para continuar el bucle
    }

    // Método para agregar un nuevo elemento a la lista
    public void agregarElemento() {
        // Verifica si hay espacio disponible en el arreglo
        if (contador < elementos.length) {
            System.out.print("Ingresa el nuevo elemento: ");
            String nuevo = sc.nextLine(); // Captura el nuevo elemento
            elementos[contador] = nuevo; // Lo guarda en la posición actual
            contador++; // Incrementa el contador
            System.out.println("Elemento agregado correctamente.");
        } else {
            // Si el arreglo está lleno, muestra un mensaje
            System.out.println("La lista esta llena.");
        }
    }

    // Método para editar un elemento existente
    public void editarElemento() {
        mostrarElementos(); // Muestra la lista actual

        // Si no hay elementos, se sale del método
        if (contador == 0) return;

        try {
            System.out.print("Ingresa el indice del elemento a editar: ");
            int indice = sc.nextInt(); // Captura el índice
            sc.nextLine(); // Limpia el buffer

            // Verifica si el índice es válido
            if (indice >= 0 && indice < contador) {
                System.out.print("Ingresa el nuevo valor: ");
                elementos[indice] = sc.nextLine(); // Actualiza el valor
                System.out.println("Elemento editado correctamente.");
            } else {
                System.out.println("Indice invalido."); // Índice fuera de rango
            }
        } catch (Exception e) {
            // Maneja errores si el índice no es un número válido
            System.out.println("Error: Ingresa un numero valido.");
            sc.nextLine(); // Limpia la entrada incorrecta
        }
    }

    // Método para eliminar un elemento de la lista
    public void eliminarElemento() {
        mostrarElementos(); // Muestra la lista actual

        // Si no hay elementos, se sale del método
        if (contador == 0) return;

        try {
            System.out.print("Ingresa el Indice del elemento a eliminar: ");
            int indice = sc.nextInt(); // Captura el índice
            sc.nextLine(); // Limpia el buffer

            // Verifica si el índice es válido
            if (indice >= 0 && indice < contador) {
                // Desplaza los elementos hacia la izquierda para eliminar el seleccionado
                for (int i = indice; i < contador - 1; i++) {
                    elementos[i] = elementos[i + 1];
                }
                elementos[contador - 1] = null; // Borra el último elemento duplicado
                contador--; // Reduce el contador
                System.out.println("Elemento eliminado correctamente.");
            } else {
                System.out.println("Indice invalido."); // Índice fuera de rango
            }
        } catch (Exception e) {
            // Maneja errores si el índice no es un número válido
            System.out.println("Error: Ingresa un numero valido.");
            sc.nextLine(); // Limpia la entrada incorrecta
        }
    }

    // Método para mostrar todos los elementos actuales en la lista
    public void mostrarElementos() {
        System.out.println("\nLista de elementos:");

        // Si no hay elementos, muestra que la lista está vacía
        if (contador == 0) {
            System.out.println("La lista esta vacia.");
        } else {
            // Recorre el arreglo y muestra cada elemento con su índice
            for (int i = 0; i < contador; i++) {
                System.out.println(i + ". " + elementos[i]);
            }
        }
    }
}
