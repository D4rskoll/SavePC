
import java.util.*;

public class FraccionRacional {

    private int numerador;
    private int denominador;

    public FraccionRacional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public FraccionRacional sumar(FraccionRacional otra) {
        return new FraccionRacional(numerador * otra.denominador + otra.numerador * denominador,
                denominador * otra.denominador);
    }

    public FraccionRacional restar(FraccionRacional otra) {
        return new FraccionRacional(numerador * otra.denominador - otra.numerador * denominador,
                denominador * otra.denominador);
    }

    public FraccionRacional multiplicar(FraccionRacional otra) {
        return new FraccionRacional(numerador * otra.numerador, denominador * otra.denominador);
    }

    public FraccionRacional dividir(FraccionRacional otra) {
        return new FraccionRacional(numerador * otra.denominador, denominador * otra.numerador);
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    public static void main(String[] args) {
        FraccionRacional fraccion1 = new FraccionRacional(1, 2);
        FraccionRacional fraccion2 = new FraccionRacional(3, 4);

        System.out.println("Fracción 1: " + fraccion1);
        System.out.println("Fracción 2: " + fraccion2);
        System.out.println("Suma: " + fraccion1.sumar(fraccion2));
        System.out.println("Resta: " + fraccion1.restar(fraccion2));
        System.out.println("Producto: " + fraccion1.multiplicar(fraccion2));
        System.out.println("División: " + fraccion1.dividir(fraccion2));
    }
}