package pairmatching.controller;

import pairmatching.domain.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class MatchingController {
    public void run() {
        Mission mission = readMission();
    }
    public Mission readMission() {
        try {
            List<String> missions = InputView.readMission();
            return Mission.of(missions.get(0), missions.get(1), missions.get(2));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readMission();
        }
    }
}