# 기능목록

## 입력을 담당하는 클래스 ClassName : InputView
- [ ] 메인 기능 입력받기 - #insertMainFunctionInput()
- [ ] 과정, 레벨, 미션 입력받기 - #insertDetails()
- [ ] 재매칭 여부 입력받기 - #insertReMatchingOrNot()
---
## 출력을 담당하는 클래스 ClassName : OutputView
- [ ] 매칭 결과 출력 - #printMatcingResult()
- [ ] 메인 화면 출력 - #printMain()
- [ ] 매칭 조건 입력창 출력 - #printMatchingDetails()
- [ ] 재매칭 여부 화면 출력 - #askReMatching()
- [ ] 초기화 문구 출력 - #printInitMessage()
---
## 페어를 매칭한다 domain : Pair
- 멤버 : List<List<String>> names, Part part, Mission
- ### Controller : PairMatchingController
  - [ ] 메인기능 실행 - #run()
- ### Service : PairMatchingService
  - [ ] 페어 매칭 기능 - #createPairs()
  - [ ] 페어 조회 기능 - #findPair()
  - [ ] 페어 초기화 기능 - #initPair()
- ### Repository : PairMatchingRepository
  - [ ] 미션으로 매칭된 페어들 조회 - #getPairByMission()
  - [ ] 생성된 페어들 저장 - #save()
  - [ ] 페어 전체 삭제 - #deleteAll()
---
## 미션 매칭한 후 매칭된 미션을 저장 domain : Mission
- [ ] 미션의 이름을 받아오는 기능 - #getName()
- ### Service : MissionService
  - [x] 미션 매칭 - #createMission()
  - [x] 매칭된 미션 전체 삭제 - #deleteAll()
  - [x] 미션의 레벨로 미션들 조회 - #getMissionsByLevel()
  - [x] 미션의 이름으로 매칭된 미션 조회 - #getByName()
- ### Repository : MissionRepository
  - [x] 미션 저장 - #save()
  - [x] 매칭된 미션 전체 삭제 - #deleteAll()
  - [x] 미션의 레벨로 매칭된 미션들 조회 - #findAllMatchedByLevel()
  - [x] 미션의 이름으로 매칭된 미션 조회 - #findByName()
  - [x] 전체 미션 조회 - #findAllMissions()
  - [x] 저장소내의 map 멤버 초기화 기능 - #init()
  - [x] 매칭 기록 존재 여부 조회 - #isMatched()
---
## 프론트엔드 크루들의 이름을 저장하는 일급컬렉션 ClassName : FrontMember
- [ ] 프론트엔드 크루원들의 이름 받아오기 - getFrontNames()
---
## 백엔드 크루들의 이름을 저장하는 일급컬렉션 ClassName : BackMember
- [ ] 백엔드 크루원들의 이름 받아오기 - getBackNames()
---
## 파일을 읽어들이는 클래스 ClassName : FileReader
- [x] `backend-crew.md` 를 읽어들이는 기능 - #readBackCrew()
- [x] `frontend-crew.md` 를 읽어들이는 기능 - #readFrontCrew()
- [x] 파일 읽어오는 통합 로직 - #readFile()

## 메인 기능 enum Name : MainFunction
- MATCHING, SEARCHING, INIT, QUIT
- 입력값으로부터 변환하기 - #from()
## 미션 레벨 enum Name : Level
- ONE,TWO,THREE,FOUR,FIVE
- 입력값으로부터 변환하기 - #from()
## 파트 enum : Part
- FRONT_END , BACK_END
- 입력값으로부터 변환하기 - #from()
