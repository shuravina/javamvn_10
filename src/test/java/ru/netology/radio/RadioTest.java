package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

// Тесты на переключение громкости

    @ParameterizedTest
    @CsvSource({
            "8,8",
            "-1,0",   //значения меньше минимального
            "11,0"    //значение больше максимального

    })

    public void shouldSetVolume(int volume , int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(volume);
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }


    @ParameterizedTest
    @CsvSource({
            "0,1",
            "9,10",
            "10,10"    //увеличение звука при текущем максимальном
    })
    public void shouldSetToIncreasePer1(int volume , int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(volume);

        radio.increaseVolume();
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({
            "10,9",
            "1,0",
            "0,0"    //уменьшение звука при текущем минимальном
    })

    public void shouldSetToDecreasePer1(int volume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(volume);

        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }


// Тесты на переключение радиостанций

    @ParameterizedTest
    @CsvSource({
            "9,9",
            "10,0",   // значение больше максимального
            "-1,0"    // значение меньше минимального
    })

    public void shouldSetStation(int station, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(station);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);

    }


    @ParameterizedTest
    @CsvSource({
            "0,1",
            "8,9",
            "9,0"   //переключение на следующую станцию при текущей максимальной
    })
    public void shouldSetNextStation(int station, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(station);

        radio.next();
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({
            "9,8",
            "1,0",
            "0,9"   //переключение на предыдущую станцию при текущей минимальной
    })
    public void shouldSetPrevStation(int station, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(station);

        radio.prev();
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);

    }

}