package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Menu;
import pairmatching.domain.Mission;
import pairmatching.service.CrewSaveService;
import pairmatching.service.MatchingInfoService;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class MainController {
    private CrewSaveService crewSaveService = new CrewSaveService();
    private MatchingService matchingService = new MatchingService();
    private MatchingInfoService matchingInfoService = new MatchingInfoService();
    private MatchingController matchingController = new MatchingController();

    public MainController() {
        List<String> backendCrew = crewSaveService.getBackendCrew();
        List<String> frontendCrew = crewSaveService.getFrontendCrew();
        crewSaveService.saveCrewNames(backendCrew, Course.BACKEND);
        crewSaveService.saveCrewNames(frontendCrew, Course.FRONTEND);
    }

    public void run() {
        Menu menu;
        do {
            menu = readMenu();
            runService(menu);
        } while(menu != Menu.QUIT);
    }

    private void runService(Menu menu) {
        if (menu == Menu.MATCHING) {
            matchingController.run();
        }
        if (menu == Menu.INFO) {
            // 페어 조회
        }
        if (menu == Menu.RESET) {
            // 페어 초기화
        }
    }

    public Menu readMenu() {
        try {
            return Menu.from(InputView.readMenu());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readMenu();
        }
    }
}