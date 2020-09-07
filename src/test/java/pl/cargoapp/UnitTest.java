package pl.cargoapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    private Coordinates coordinates;
    private Unit unit;

    @BeforeEach
    void initializeParameters(){
        coordinates = new Coordinates(0,0);
        unit = new Unit(coordinates, 100, 100);
    }

    @DisplayName("Load of new created unit should equal 0")
    @Test
    void unitLoadAfterCreateShouldEqual0(){
        //given
        //when
        //then
        assertEquals(unit.getLoad(), 0);
    }

    @DisplayName("Coordinates and level of fuel should change after move")
    @Test
    void coordinatesAndFuelLevelShouldChange(){
        //given
        //when
        Coordinates newCoordinates = unit.move(2,5);
        //then
        assertAll(
                () -> assertThat(unit.getFuel(), lessThan(100)),
                () -> assertThat(newCoordinates.getX(), equalTo(2)),
                () -> assertThat(newCoordinates.getY(), equalTo(5))
        );
    }

    @DisplayName("Newly created unit should not be able to increase fuel level without move")
    @Test
    void fuelLevelShouldNotIncreaseAfterCreateNewUnit(){
        //given
        Unit unit2 = new Unit(coordinates, 100, 100);
        //when
        unit.tankUp();

        //then
        assertThat(unit.getFuel(), equalTo(unit2.getFuel()));
    }
}