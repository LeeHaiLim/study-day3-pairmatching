package pairmatching.controller;

import pairmatching.domain.menu.Command;
import pairmatching.domain.MissionGroup;
import pairmatching.domain.Pair;
import pairmatching.dto.MatchResultDto;
import pairmatching.service.MatchingService;
import pairmatching.view.InputMessage;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MatchingController {
    private MatchingService matchingService = new MatchingService();

    public void matchPairs() {
        InputMessage.MissionInfoMessage();
        boolean retry = true;
        MissionGroup missionGroup;
        do {
            missionGroup = read(MissionGroup::of, InputView::readMission);
            if (matchingService.getMatchResult(missionGroup).isPresent()) {
                retry = read(Command::from, InputView::readCommend) == Command.YES;
            }
        } while (!retry);
        saveMatchingPairs(missionGroup);
    }

    private void saveMatchingPairs(MissionGroup missionGroup) {
        List<Pair> matchResult = matchingService.matchPairs(missionGroup);
        matchingService.saveMatchResult(missionGroup, matchResult);
        OutputView.printMatchResult(MatchResultDto.from(matchResult));
    }

    public void runMatchingInfo() {
        InputMessage.MissionInfoMessage();
        MissionGroup missionGroup = read(MissionGroup::of, InputView::readMission);
        List<Pair> matchResult = matchingService.getMatchResult(missionGroup)
                .orElseThrow(() -> new IllegalArgumentException("매칭 이력이 없습니다."));
        OutputView.printMatchResult(MatchResultDto.from(matchResult));
    }

    public void clear() {
        matchingService.clear();
        OutputView.printMessage("초기화 되었습니다.");
    }

    private <T, R> R read(Function<T, R> object, Supplier<T> input) {
        try {
            return object.apply(input.get());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return read(object, input);
        }
    }
}