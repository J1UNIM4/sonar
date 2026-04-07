import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {

    // CODE SMELL: Campo estático que debería ser privado o final
    public static List<String> usuarios = new ArrayList<>();

    public void agregarUsuario(String nombre) {
        // BUG: Posible NullPointerException si 'nombre' es nulo
        if (nombre.equals("admin")) { 
            System.out.println("No se puede agregar al administrador nuevamente");
        } else {
            usuarios.add(nombre);
        }
    }

    public void mostrarUsuarios() {
        // CODE SMELL: Uso de System.out en lugar de un logger profesional
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("Usuario " + i + ": " + usuarios.get(i));
        }
    }

    public boolean validarAcceso(String pass) {
        // VULNERABILIDAD: Contraseña "hardcoded" (escrita directamente en el código)
        if (pass == "password123") {
            return true;
        }
        
        // CODE SMELL: Código muerto (nunca se alcanzará si la lógica cambia)
        String temporal = "variable_inutil"; 
        
        return false;
    }

    public static void main(String[] args) {
        GestionUsuarios gestion = new GestionUsuarios();
        gestion.agregarUsuario("Juan");
        gestion.mostrarUsuarios();
        
        // BUG: Llamada a método que podría fallar
        gestion.agregarUsuario(null); 
    }
}