## 구현할 기능 목록

- Application 초기화 기능
  - 파일에서 크루 이름을 불러와 Repository 에 저장하는 기능

- 페어 매칭하는 기능
  - 매칭 정보가 있다면, 다시 메칭할지 물어봄
  - 주어진 방법 (`camp.nextstep.edu.missionutils.Randoms`의 shuffle 메서드를 활용 ...) 을 통해 페어 매칭 실시
  - 같은 레벨에서 매칭이 된 크루가 있었는지 확인 (있을 경우 3번까지 재실행)
    - 3번이 넘어갈 경우, 에러를 발생시킴
  - 페어 매칭이 되었다면 Repository에 저장함

- 페어 메칭 조회
  - Repository에 있는 정보를 가져와서 보여줌


## Class별 구현 기능 조회

- InputView : 입력 담당
  - [ ] 특정 기능을 선택하여 입력 #readFuntion()
    - 1,2,3,Q 가 아닌 경우 에러를 발생함
  - [ ] 과정, 레벨, 미션을 입력하는 기능 #readMission()
    - 형식에 맞지 않을 경우, 에러를 발생함
    - 형식 : 백엔드, 레벨1, 자동차경주
  - [ ] 매칭 정보가 있을 경우, 다시 매칭할 지 입력하는 기능 #readRetryMatching()
    - 네, 아니오 가 아닌 경우 에러를 발생함
  
- OutputView : 출력 담당
  - [ ] 현재 가지고 있는 과정을 보여주는 기능 #printFunctions()
  - [ ] 페어 매칭 결과를 보여주는 기능 #printMatchingResult()

- CrewReader : md 파일에 있는 Crew 정보를 읽어오는 기능
  - [x] 백엔드 크루를 읽어오는 기능 #readBackendCrews
  - [x] 프론트엔드 크루를 읽어오는 기능 #readFrontendCrews

- CrewRepository : Crew 정보를 저장
  - [x] 초기 정보를 통해 Repository를 설정
  - [ ] 정보를 호출하는 기능

- MatchingRepository : 매칭 정보를 저장하는 역할
  - [ ] 매칭 정보를 저장함
  - [ ] 매칭 정보를 조회하는 역할

- CrewSuffler : Crew를 섞어주는 역할
  - [ ] Crew들을 입력 받아 섞음

- CrewMatcher : Crew를 매칭해주는 역할
  - [ ] Crew들을 입력 받아 매칭을 해줌

- Crew : 회원의 정보를 가지고 있음
  - [x] equals()
  - [x] getName()

- Matching : 매칭 정보를 가지고 있음
  - [ ] 