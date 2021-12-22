import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Dataset {
    private LinkedList<String> etiqueta;
    private HashMap<Integer, LinkedList<Float[]>> patrones;
    
    public Dataset(String rutaArchivo) throws FileNotFoundException, IOException{
        BufferedReader lector = new BufferedReader(new FileReader(new File(rutaArchivo)));
        String linea = "";
        this.etiqueta = new LinkedList<>();
        this.patrones =  new HashMap<>();

        while((linea = lector.readLine()) != null){
            String[] sPatron = linea.split(",");
            
            if(!this.etiqueta.contains(sPatron[sPatron.length -1])){
                this.etiqueta.add(sPatron[sPatron.length -1]);
                this.patrones.put(this.etiqueta.indexOf(sPatron[sPatron.length -1]), new LinkedList<>());                
            }

            Float[] tmp = new Float[sPatron.length - 1];
            for(Integer i = 0; i < sPatron.length - 1; i++)
                tmp[i] = Float.valueOf(sPatron[i]);            
            this.patrones.get(this.etiqueta.indexOf(sPatron[sPatron.length -1])).add(tmp);
        }           
    }
    
    public LinkedList<String> getEtiquetas(){
        return this.etiqueta;
    }
    
    public HashMap<Integer, LinkedList<Float[]>> getPatrones(){        
        return this.patrones;        
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Dataset ds = new Dataset("iris.data");
    }
}
