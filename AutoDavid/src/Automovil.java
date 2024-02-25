public class Automovil {
    private String marca;
    private int modelo;
    private double motor;
    private Combustible tipoCombustible;
    private TipoAutomovil tipoAutomovil;
    private int numeroPuertas;
    private int cantidadAsientos;
    private int velocidadMaxima;
    private Color color;
    private int velocidadActual;
    private boolean automatico;
    private int multas;
    public Automovil(String marca, int modelo, double motor, Combustible tipoCombustible, TipoAutomovil tipoAutomovil,
                     int numeroPuertas, int cantidadAsientos, int velocidadMaxima, Color color, boolean automatico) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.velocidadActual = 0;
        this.automatico = automatico;
        this.multas = 0;
    }
    public int getVelocidadActual() {
        return velocidadActual;
    }
    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }
    public void acelerar(int velocidad) {
        if (velocidadActual + velocidad > velocidadMaxima) {
            System.out.println("¡Cuidado! Superando la velocidad máxima. Multa generada.");
            multas++;
        } else {
            velocidadActual += velocidad;
        }
    }
    public void desacelerar(int velocidad) {
        if (velocidadActual - velocidad < 0) {
            System.out.println("Lavelocidad no puede ser negativa.");
        } else {
            velocidadActual -= velocidad;
        }
    }
    public void frenar() {
        velocidadActual = 0;
    }
    public double calcularTiempoEstimado(double distancia) {
        return distancia / velocidadActual;
    }
    public void mostrarInformacion() {
        System.out.println("Marc: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad Actual: " + velocidadActual);
    }
    public boolean isAutomatico() {
        return automatico;
    }
    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }
    public boolean tieneMultas() {
        return multas > 0;
    }
    public int getValorTotalMultas() {
        return multas * 100; 
    }
    public enum Combustible {
        GASOLINA, BIOETANOL, DIESEL, BIODIESEL, GAS_NATURAL
    }
    public enum TipoAutomovil {
        CARRO_CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR, EJECUTIVO, SUV
    }
    public enum Color {
        BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA
    }
    public static void main(String[] args) {
        Automovil automovil = new Automovil("Toyota", 2022, 2.0,
                Automovil.Combustible.GASOLINA, Automovil.TipoAutomovil.SUV,
                4, 5, 200, Automovil.Color.AZUL, true);

        automovil.setVelocidadActual(100);
        System.out.println("Velocidad actual: " + automovil.getVelocidadActual());

        automovil.acelerar(20);
        System.out.println("Velocidad  después de acelerar: " + automovil.getVelocidadActual());

        automovil.desacelerar(50);
        System.out.println("Velocidad  después de desacelerar: " + automovil.getVelocidadActual());

        automovil.frenar();
        System.out.println("Velocidad  después de frenar: " + automovil.getVelocidadActual());
    }
}
