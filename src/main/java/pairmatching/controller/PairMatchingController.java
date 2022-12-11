package pairmatching.controller;

import pairmatching.domain.MainFunction;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.Part;
import pairmatching.service.MissionService;
import pairmatching.service.PairMatchingService;
import pairmatching.ui.InputView;
import pairmatching.ui.OutputView;

import java.util.List;

public class PairMatchingController {
    private final PairMatchingService pairMatchingService;
    private final MissionService missionService;

    public PairMatchingController(PairMatchingService pairMatchingService, MissionService missionService) {
        this.pairMatchingService = pairMatchingService;
        this.missionService = missionService;
    }

    public void run() {
        missionService.init();
        while (true) {
            OutputView.printMain();
            MainFunction func = InputView.repeat(InputView::insertMainFunctionInput);
            if (func.equals(MainFunction.QUIT)) {
                break;
            }
            navigate(func);
        }
    }

    private void navigate(MainFunction mainFunction) {
        if (mainFunction.equals(MainFunction.MATCHING)) {
            OutputView.printMatchingDetails();
            try {
                createMatching();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        if (mainFunction.equals(MainFunction.SEARCHING)) {
            OutputView.printMatchingResult(searchMatchResult());
        }
        if (mainFunction.equals(MainFunction.INIT)) {
            initMatching();
        }
    }

    private void createMatching() throws IllegalArgumentException{
        List<String> repeat = InputView.repeat(InputView::insertDetails);
        String part = repeat.get(0);
        String missionName = repeat.get(2);
        boolean matched = missionService.isMatched(missionService.getByName(Part.from(part), missionName));
        if (matched) {
            considerReMatch(Part.from(part),missionName);
            return;
        }
        Pair pairs = pairMatchingService.createPairs(Part.from(part), missionName);
        missionService.createMissionPairMatching(Part.from(part),missionName);
        OutputView.printMatchingResult(pairs.getNames());
    }

    private void considerReMatch(Part part, String missionName) {
        OutputView.askReMatching();
        boolean reMatch = InputView.repeat(InputView::insertReMatchingOrNot);
        if (reMatch) {
            OutputView.printMatchingResult(pairMatchingService.createPairs(part, missionName).getNames());
        }
    }

    private List<List<String>> searchMatchResult() {
        OutputView.printMatchingDetails();
        List<String> repeat = InputView.repeat(InputView::insertDetails);
        String part = repeat.get(0);
        String missionName = repeat.get(2);
        return pairMatchingService.findPair(Part.from(part), missionName).getNames();
    }

    private void initMatching() {
        pairMatchingService.deletePair();
        missionService.deleteAll();
        missionService.init();
        OutputView.printInitMessage();
    }
}
