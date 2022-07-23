package ru.netology.radio;

public class Radio {

    private int currentVolume;
    private int currentStation;
    private int numberOfStations;

    public Radio (int numberOfStation) {
        this.numberOfStations = numberOfStation;

    }

    public Radio () {
        numberOfStations = 10;
    }

    public int getNumberOfStations() {
        return numberOfStations;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0) {
            return;
        }
        if (newCurrentVolume > 100) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newStation) {
        if (newStation < 0) {
            return;
        }
        if (newStation > numberOfStations -1) {
            return;
        }
        currentStation = newStation;

    }

    // Для переключения громкости
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;

        }

    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        } else {
            currentVolume = 0;

        }
    }

// Для переключения радиостанций

    public void next() {
        if (currentStation < numberOfStations - 1) {
            currentStation++;
        } else {
            currentStation = 0;
        }

    }

    public void prev() {
        if (currentStation > 0) {
            currentStation = currentStation - 1;
        } else {
            currentStation = numberOfStations - 1;
        }
    }


}
