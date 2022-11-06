/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4Ex;

public class StartGame {
    public static void main(String[] args) {
        new StartGame().run();
    }

    private void run() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.startGame();
    }
}
