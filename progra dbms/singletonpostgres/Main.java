package singletonpostgres;

public class Main {
    public static void main(String[] args) {
        Singleton app = new Singleton();
        app.connect();
    }
    
}
