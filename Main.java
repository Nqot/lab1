public class Main {
    public static void main(String[] args) {
        // Skapa och testa en Volvo240
        Volvo240 volvo = new Volvo240();
        System.out.println("Created a Volvo 240 with speed: " + volvo.getCurrentSpeed());

        volvo.startEngine();
        System.out.println("Started Volvo 240 engine. Current speed: " + volvo.getCurrentSpeed());

        volvo.gas(0.5);
        System.out.println("Speed after gas: " + volvo.getCurrentSpeed());

        volvo.brake(0.3);
        System.out.println("Speed after brake: " + volvo.getCurrentSpeed());

        // Skapa och testa en Saab95
        Saab95 saab = new Saab95();
        System.out.println("Created a Saab 95 with speed: " + saab.getCurrentSpeed());

        saab.setTurboOn();
        saab.startEngine();
        System.out.println("Started Saab 95 engine with turbo. Current speed: " + saab.getCurrentSpeed());

        saab.gas(0.7);
        System.out.println("Speed after gas with turbo: " + saab.getCurrentSpeed());

        saab.setTurboOff();
        saab.brake(0.5);
        System.out.println("Speed after brake without turbo: " + saab.getCurrentSpeed());

        // Flytta Volvo
        volvo.startEngine();
        volvo.gas(0.5);
        volvo.move();
        System.out.println("Volvo position: (" + volvo.getX() + ", " + volvo.getY() + ")");

        volvo.turnLeft();
        volvo.move();
        System.out.println("Volvo position after turning left: (" + volvo.getX() + ", " + volvo.getY() + ")");

        // Flytta Saab
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(0.7);
        saab.move();
        System.out.println("Saab position: (" + saab.getX() + ", " + saab.getY() + ")");

        saab.turnRight();
        saab.move();
        System.out.println("Saab position after turning right: (" + saab.getX() + ", " + saab.getY() + ")");
    }

}
