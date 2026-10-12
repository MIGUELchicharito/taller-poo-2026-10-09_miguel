class Mascota {
    private String nombre;
    private String especie;
    private double peso;
    private int edad;

    Mascota(String nombre, String especie, double peso, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.edad = edad;
    }
    String getNombre() { return nombre; }
    String getEspecie() { return especie; }
    double getPeso() { return peso; }
    int getEdad() { return edad; }

    void setPeso(double nuevoPeso) {
        if (nuevoPeso <= 0) {
            System.out.println("RECHAZADO EL PESO NO ES POSIBLE " + nuevoPeso + " kg");
            return;
        }
        this.peso = nuevoPeso;
    }
    void setEdad(int nuevaEdad) {
        if (nuevaEdad < 0) {
            System.out.println("RECHAZADO LA EDAD NO ES POSIBLE " + nuevaEdad);
            return;
        }
        this.edad = nuevaEdad;
    }
    int valorConsulta() {
        int valor = 35000;

        if (peso > 25) {
            valor = 55000;
        } else if (peso > 10) {
            valor = 45000;
        }

        if (edad >= 8) {
            valor = valor + 12000;
        }
        return valor;
    }
    String descripcion() {
        return nombre + " (" + especie + ", " + peso + " kg, " + edad + " anios)";
    }
}

public class veterinaria {
    public static void main(String[] args) {
        Mascota[] pacientes = new Mascota[4];
        pacientes[0] = new Mascota("Luna", "Perro", 28.5, 9);
        pacientes[1] = new Mascota("Michi", "Gato", 4.2, 3);
        pacientes[2] = new Mascota("Rocky", "Perro", 12.0, 5);
        pacientes[3] = new Mascota("Pepa", "Conejo", 2.1, 1);

        int totalRecaudado = 0;

        System.out.println("--- REPORTE DE PACIENTES ---");

        for (int i = 0; i < pacientes.length; i++) {
            Mascota m = pacientes[i];
            System.out.println(m.descripcion() + " - Valor consulta: $" + m.valorConsulta());
            totalRecaudado = totalRecaudado + m.valorConsulta();
        }
        System.out.println("----------------------------");
        System.out.println("TOTAL RECAUDADO: $" + totalRecaudado);
        System.out.println();
        System.out.println("--- PRUEBA DE VALIDACION ---");
        System.out.println("Intentando cambiar el peso de Michi a -3 kg...");
        pacientes[1].setPeso(-3);
        System.out.println("Descripcion final de Michi: " + pacientes[1].descripcion());
    }
}
