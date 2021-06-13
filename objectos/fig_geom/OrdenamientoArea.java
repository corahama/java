package fig_geom;
import java.util.Comparator; // <- import respectivo para poder usar la interface
/**
 * Lo que nos permitir SIMULAR un herencia multiple son las Interface, lo cual
 * es un conjunto de métodos abstractos.
 * - Comparable
 * - Comparator
 * - Clonable
 * - Serializable
 * Para poder usar una interface no usamos la palabra extens, sino la palabra
 * implementes; y se puede implementar tantas interfaces en una clase como se
 * requieran
 */
public class OrdenamientoArea implements Comparator<Figura> {
    /**
     * @param o1
     * @param o2
     * @return
     * regresa la jerarquia entre objetos
     * Valor < 0 si o1<o2
     * Valor = 0 si o1==o2
     * Valor > 0 si o1>o2
     */
    @Override
    public int compare(Figura o1, Figura o2) {
        /*if (o1.Area==o2.Area)
            return 0;
        else if (o1.Area<o2.Area) {
            return -1;
        } else {
            return 1;
        }*/
        return o1.Area.compareTo(o2.Area);
    }
}