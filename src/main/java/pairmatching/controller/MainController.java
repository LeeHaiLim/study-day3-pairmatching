package pairmatching.controller;

import pairmatching.domain.menu.Course;
import pairmatching.domain.menu.Menu;
import pairmatching.service.CrewSaveService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class MainController {
    private CrewSaveService crewSaveService = new CrewSaveService();
    private MatchingController matchingController = new MatchingController();

    public MainController() {
        List<String> backendCrew = crewSaveService.getBackendCrew();
        List<String> frontendCrew = crewSaveService.getFrontendCrew();
        crewSaveService.saveCrewNamesByCourse(backendCrew, Course.BACKEND);
        crewSaveService.saveCrewNamesByCourse(frontendCrew, Course.FRONTEND);
    }

    public void run() {
        Menu menu;
        do {
            menu = readMenu();
            runService(menu);
        } while (menu != Menu.QUIT);
    }

    private void runService(Menu menu) {
        try {
            if (menu == Menu.MATCHING) {
                matchingController.matchPairs();
            }
            if (menu == Menu.INFO) {
                matchingController.runMatchingInfo();
            }
            if (menu == Menu.RESET) {
                matchingController.clear();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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