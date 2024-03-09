
import java.util.*;

public class Soldado {
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private boolean vive;
    private int ubicacionX;
    private String actitud;
    private char ubicacionY;
    private int vida;

    public Soldado(String n, int nivelAtaque, int nivelDefensa, int nivelVida, boolean vive) {
        this.nombre = n;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vive = vive;
    }

    public Soldado(String n, int vida, int ubicacionX, char ubicacionY) {
        this.nombre = nombre;
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;
        this.vida = vida;
    }

    public Soldado() {
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setUbicacion(int x, char y) {
        ubicacionX = x;
        ubicacionY = y;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacionX + "," + ubicacionY;

    }

    public int getUbicacionX() {
        return ubicacionX;
    }

    public char getUbicacionY() {
        return ubicacionY;
    }

    public void setUbicacionX(int n) {
        this.ubicacionX = n;
    }

    public void setUbicacionY(char y) {
        this.ubicacionY = y;
    }

    // ----------------------------------------------------------------

    public void atacar() {
        this.actitud = "Ofensiva";
        this.velocidad = +1;
    }

    public void defender() {
        this.actitud = "Defensiva";
        this.velocidad = 0;
    }

    public void huir() {
        this.actitud = "Fuga";
        this.velocidad = +2;
    }

    public void avanzar(int actitud) {
        this.velocidad = +3;
    }

    public void retroceder() {
        if (this.velocidad > 0) {
            this.velocidad = 0;
            this.actitud = "Defensiva";
        }
        if (this.velocidad == 0) {
            this.velocidad = -1;
        }
    }

    public void serAtacado(int daño) {
        if (this.nivelDefensa >= 0) {
            this.nivelDefensa = -daño;
            if (this.nivelDefensa <= 0) {
                this.vida = +nivelDefensa;
            }
        } else {
            this.vida = -daño;
        }
        if (this.vida <= 0) {
            morir();
        }
    }

    public void morir() {
        this.vive = false;
        this.vidaActual = 0;

    }

    public void setVidaActual(int life) {
        vida = life;
    }

    public int getVidaActual() {
        return vida;
    }

    // ---------------Adicionales--------------------------------
    public void setNivelDefensa(int defensa) {
        this.nivelDefensa = defensa;
    }

    public void setNivelAtaque(int ataque) {
        this.nivelAtaque = ataque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }
}
