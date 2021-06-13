package fig_geom;

public abstract class Figura implements Comparable<Figura> {
    protected Float Area;
    protected Float Perimetro;

    public Float getArea() {
        return Area;
    }

    public void setArea(Float area) {
        Area = area;
    }

    public Float getPerimetro() {
        return Perimetro;
    }

    public void setPerimetro(Float perimetro) {
        Perimetro = perimetro;
    }

    public abstract void calArea();

    public abstract void calPerimetro();

    @Override
    public String toString() {
        return String.format("Area=%.2f\nPerimetro=%.2f", Area, Perimetro);
    }

    @Override
    public int compareTo(Figura o) {
        return this.Area.compareTo(o.Area);
    }
}