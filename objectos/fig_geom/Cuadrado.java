package fig_geom;
public class Cuadrado extends Figura {
    private Float Lado;
    public Float getLado() {
        return Lado;
    }
    public void setLado(Float lado) {
        Lado = lado;
    }
    public Cuadrado(Float lado) {
        Lado = lado;
    }
    public void calArea(){
        this.Area = Lado*Lado;
    }
    public void calPerimetro(){
        this.Perimetro = 4*Lado;
    }
    @Override
    public String toString() {
        return String.format("Cuadrado de Lado %.2f\n%s", Lado, super.toString());
    }
}