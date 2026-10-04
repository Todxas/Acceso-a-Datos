package Ejerciciosficherosbinarios;

import java.io.*;

public class EjercicioPDF7 {
    public static void main(String[] args) throws IOException {
        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/muchosdatos.bin"));
        DataOutputStream menores = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/menores.dat"));
        DataOutputStream adultos = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/adultos.dat"));
        DataOutputStream mayores = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/mayores.dat"));
        try {
            while (true) {
                String nombre = leer.readUTF();
                String apellidos = leer.readUTF();
                int edad = leer.readInt();
                String telefono = leer.readUTF();
                String email = leer.readUTF();
                String ciudad = leer.readUTF();
                String nacionalidad = leer.readUTF();
                String profesion = leer.readUTF();
                DataOutputStream fichero;
                if (edad < 18) {
                    fichero = menores;
                } else if (edad <= 65) {
                    fichero = adultos;
                } else {
                    fichero = mayores;
                }
                fichero.writeUTF(nombre);
                fichero.writeUTF(apellidos);
                fichero.writeInt(edad);
                fichero.writeUTF(telefono);
                fichero.writeUTF(email);
                fichero.writeUTF(ciudad);
                fichero.writeUTF(nacionalidad);
                fichero.writeUTF(profesion);
            }
        } catch (EOFException e) {
        }
        leer.close();
        menores.close();
        adultos.close();
        mayores.close();
        System.out.println("Ficheros creados.");
    }
}
