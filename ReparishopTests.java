import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class RepairshopTest {

    private Repairshop<Volvo240> volvoWorkshop;

    private Repairshop<Car> generalWorkshop;

    private Volvo240 volvo1;

    private Volvo240 volvo2;

    private Saab95 saab;



    @BeforeEach

    void setUp() {

        // Skapar instanser av verkstäder och bilar inför varje test

        volvoWorkshop = new Repairshop<Volvo240>(2); // Märkesverkstad för Volvo240

        generalWorkshop = new Repairshop<Car>(3); // Generisk verkstad för alla bilar

        volvo1 = new Volvo240();

        volvo2 = new Volvo240();

        saab = new Saab95();

    }



    @Test

    void testAddCarToWorkshop() {

        // Testar att en bil kan läggas till i verkstaden

        volvoWorkshop.loadCar(volvo1);

        assertEquals(1, volvoWorkshop.getCarCount());

    }


    @Test

    void testRetrieveCar() {

        // Testar att en bil kan hämtas ut från verkstaden

        volvoWorkshop.loadCar(volvo1);

        Car unloaded = volvoWorkshop.unloadCar(0);

        assertEquals(volvo1, unloaded);

        assertEquals(0, volvoWorkshop.getCarCount()); // Verkstaden ska nu vara tom

    }


    @Test

    void testGeneralWorkshopHandlesDifferentCars() {

        // Testar att en generisk verkstad kan hantera olika biltyper

        generalWorkshop.loadCar(volvo1);

        generalWorkshop.loadCar(saab);

        assertEquals(2, generalWorkshop.getCarCount());

    }



    @Test

    void testTypeSafetyInVolvoWorkshop() {

        // Testar att en VolvoWorkshop endast accepterar Volvo240

        // Följande rad skulle ge ett kompileringsfel om avkommenterad

        //volvoWorkshop.loadCar(saab); // Fel: Kan inte lägga till Saab95 i VolvoWorkshop

    }

}

