package pairmatching.controller;

import pairmatching.domain.Command;
import pairmatching.domain.Mission;
import pairmatching.service.MatchingService;
import pairmatching.util.RandomShuffle;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class MatchingController {
    private MatchingService matchingService = new MatchingService();
    public void run() {
        Mission mission = readMission();
        if (matchingService.hasPair(mission)) {
            if (readCommend()==Command.NO) {
                return;
            }
        }
        matchingService.matchPair(mission);
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

    public Command readCommend() {
        try {
            return Command.from(InputView.readCommend());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readCommend();
        }
    }
}