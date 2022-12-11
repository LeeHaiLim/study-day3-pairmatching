package pairmatching.controller;

import pairmatching.domain.Command;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.dto.MatchResultDto;
import pairmatching.service.MatchingService;
import pairmatching.view.InputMessage;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class MatchingController {
    private MatchingService matchingService = new MatchingService();

    public void run() {
        InputMessage.MissionInfoMessage();
        boolean isContinue = true;
        while(isContinue) {
            Mission mission = readMission();
            if (matchingService.hasPair(mission)) {
                isContinue = retryMatching();
            }
            if (isContinue) {
                matchPair(mission);
                isContinue = false;
            }
        }
    }

    public boolean retryMatching() {
        if (readCommend() == Command.NO) {
            return false;
        }
        return true;
    }

    public void runMatchingInfo() {
        InputMessage.MissionInfoMessage();
        Mission mission = readMission();
        try {
            List<Pair> matchResult = matchingService.getMatchResult(mission);
            OutputView.printMatchResult(MatchResultDto.from(matchResult));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    public void resetPairMatching() {
        matchingService.resetPairMatching();
    }

    private void matchPair(Mission mission) {
        try {
            matchingService.matchPair(mission);
            List<Pair> matchResult = matchingService.getMatchResult(mission);
            OutputView.printMatchResult(MatchResultDto.from(matchResult));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
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