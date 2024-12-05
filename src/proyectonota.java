import java.util.ArrayList;
import java.util.List;

    class Estudiante {
        private int id;
        private String nombre;
        private List<Integer> listaCalificaciones;

        public Estudiante(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.listaCalificaciones = new ArrayList<>();
        }

        public void agregarCalificacion(int calificacion) {
            if (calificacion >= 0 && calificacion <= 100) {
                listaCalificaciones.add(calificacion);
            } else {
                System.out.println("Calificación no válida. Debe estar entre 0 y 100.");
            }
        }

        public double calcularPromedio() {
            if (listaCalificaciones.isEmpty()) {
                return 0;
            }
            int sum = 0;
            for (int calificacion : listaCalificaciones) {
                sum += calificacion;
            }
            return (double) sum / listaCalificaciones.size();
        }
    }