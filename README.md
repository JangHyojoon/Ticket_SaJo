# 티켓사조
![바탕화면](https://user-images.githubusercontent.com/103159709/184810334-a816ed71-3eb4-4f15-bc84-ca7898fe1de0.png)

팀명: 티켓 사조  
<img src= https://user-images.githubusercontent.com/103159709/184799023-c1061898-d659-42ed-8f74-a01ffe5fd1b9.png width=350px, height=400px, align='right'>

팀장: 김민식

팀원: 안원영, 장효준, 정세연

## 프로젝트 정보

### 1. 프로젝트 주제
Spring boot를 활용한 클래식 영화관 티켓팅 서비스 및 NCP AI 플랫폼을 활용한 고객편의기능 구현

### 2. 프로젝트 목적

1. 클라우드 환경 사용
2. 자리 예매 기능 구현
3. AI Platform(CLOVA OCR)을 활용한 영수증사지을 이용한 적립금 기능 구현
4. AI Platform(CLOVA CFR)을 활용한 닮은 꼴 배우 찾기 이벤트 페이지 구현
5. 네이버, 구글, 페이스북 등 다양한 로그인 API를 활용한 로그인 기능 구현

### 3. 프로젝트 기능 구현
1. 영화 좌석 선택 및 예약
2. AI를 활용한 영수증 인식 후 포인트 적립, 적립 내역 조회 기능
3. 로그인 API(OAuth) 사용해 로그인 및 회원가입 기능
4. 결제 API 기능 
5. 영화 필터 검색 기능
6. 성별, 나이 정보를 바탕으로 통계표 기능
7. 리뷰, 평점 기능
8. CLOVA Face Recognition(CFR)을 이용한 닮은 꼴 배루 찾지 이벤트 페이지 구현

### 4. 프로젝트 역할 분담 
| 이름 | 역할 |
|------------|-----------|
| 김민식 |영화 상세 페이지(통계차트), 영화리스트 페이지, CHATBOT, Contact Us 페이지(구글맵, 문의사항 메일로 전송), CLOVA Face Recognition (CFR), Admin 페이지 (고객/영화/스케줄/쿠폰/포인트 관리, 예매내역 조회, 로그인, 회원가입) &nbsp; &nbsp;  &nbsp; &nbsp; |
| 안원영 |로그인 API(**OAuth**), NCP AI CLOVA OCR* (쿠폰 or 적립), 리뷰 순위 페이지, 포인트 적립, 메인 페이지(서치 기능), Admin 페이지(메인 페이지에 차트), &nbsp; 쿠폰|
| 장효준 | 예매(좌석선택, 극장선택, 시간선택), 결제 API, Admin 페이지(스케줄 관리)|
| 정세연 |회원가입, 일반 로그인, MyPage(나의 예매내역, 내 포인트 내역 조회, 내 쿠폰 내역 조회, 회원탈퇴, 회원정보변경, 비밀번호 변경)|

### 5. 프로젝트 개발 환경 및 수행 도구
![화면 캡처 2022-08-01 114948](https://user-images.githubusercontent.com/103159709/182062696-fb7c4078-a73f-46af-97bc-cb2e0dcefc03.png)

언어 | 웹 | 개발도구 | DataBase | 협업도구 | FrameWork
---- | ---- | ---- | ---- | ---- | ---- |
JAVA, SQL &nbsp; &nbsp; &nbsp;| HTML5, CSS3, JS, jQuery, Ajax, Bootstrap, Thymeleaf | Eclipse, NCP &nbsp; &nbsp; &nbsp;| Mysql | Zoom, Google Docs, Github, ERD Cloud,Padlet, Notion | Spring Boot, Mybatis |

### 6. 데이터베이스 설계
ERD: [티켓사조](https://www.erdcloud.com/d/Gb6vzq6LdsJjFpduL)

![image](https://user-images.githubusercontent.com/103159709/184797326-65c2fdbf-d780-4300-92f2-82b4862eb04b.png)

### 7. UI 설계
![ui](https://user-images.githubusercontent.com/103159709/184812812-b5a0ff9e-75f3-4f1f-9a9f-d7f16a952bf0.png)

---- 
## 프로젝트 결과 
### 1. 회원가입 화면

* 어느 한 칸이라도 빈칸일 시 '필수황목입니다.' 메세지 띄우기
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184588880-29ea09d4-cfc3-466e-848f-b8bc7b8feef8.png></p>

* Ajax를 이용해 데이터베이스에 동일한 아이디가 존재하는지 비교
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184589002-c80c26bd-6c9c-4dc3-a74f-1ee2141f0560.png></p>

* 비밀번호 조건 미충족 시 '보안에 취약합니다. 5자리 이상이어야 합니다.' 메세지 띄우기
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184589156-f0efc88c-cc86-4211-a7d9-1932b155fffa.png></p>

* 비밀번호 확인: 위 비밀번호와 일치하지 않을 시 '일치하지 않습니다. 비밀번호를 다시 입력해주세요.' 메세지 띄우기
 <p align="center"><img src= https://user-images.githubusercontent.com/103159709/184589362-0eacb31c-ea22-45c7-b38c-cb2f8c03ad15.png></p>

* 어느 한 조건이라도 미충족 시 회원가입 불가
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184760219-bd68774e-0b20-482f-8555-91dcf2e6568c.png></p>
<p align="center><img src= https://user-images.githubusercontent.com/103159709/184760297-f6981d67-44bb-4f9f-88c2-919dcfcd3897.png></p>

### 2. 로그인 화면 

#### 로그인 성공 전 메인 화면
 <p align="center"><img src= https://user-images.githubusercontent.com/103159709/184587001-baaed115-59d8-4e4e-8124-9526465136d4.png></p>

#### 로그인 실패 시 화면 
* 데이터베이스에 저장된 아이디와 비밀번호 값과 일치하면 로그인 성공 후 메인 페이지로 이동 / 일치하지 않을 시 하단에 '아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.' 메세지 띄우기
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184592866-08a3b2cd-30a8-42ad-a89e-fe404d2816f2.png></p>

#### 로그인 성공 시 메인 화면 
 <p align="center"><img src= https://user-images.githubusercontent.com/103159709/184587306-a4b96cc2-fa53-469d-b7b4-a25f4fd4b4df.png></p>

### 3. 마이페이지

* 로그인 성공 시에만 화면에 보여짐
* 로그인한 아이디값에 따른 정보 불러옴(쿠폰내역, 포인트 내역, 예매내역, 회원정보)

<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184587770-8cf97d89-0dd1-4ff6-89f6-ad2fc66b738b.png></p>

#### 포인트 내역
* 사용 가능한 포인트 정보 띄우기
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184595968-e627815a-412c-48db-b3a5-d48bd0528aec.png></p>

#### 쿠폰 내역
* 발급 받은 쿠폰 정보 띄우기(사용한 쿠폰일 경우 사용한 날짜 표시)
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184596083-4617f312-9d24-414b-b6d3-09a962682b7f.png></p>

#### 예매 내역
* 예매 내역에 따른 정보 띄우기
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184596605-065fa7eb-465e-428c-9793-e7f4a037ecd8.png></p>

* 마이페이지에서 예매번호 누르면 예매 정보 화면으로 간편하게 넘어감
<p align="center"><im src= https://user-images.githubusercontent.com/103159709/184600810-59bbd238-0341-4345-bd61-9738070a071b.png></p>

* 마이페이지에서 영화제목(ex싸이코) 누르면 티켓이 나옴
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184601356-d75746c2-6539-4a90-8299-e07aa5c8029c.png></p>

#### 회원수정
* 회원정보 수정(아이디는 readonly로 수정 불가 / 이름만 변경 가능)
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184606779-b6c7dfee-b872-4dab-81f6-64ca158dc24d.png></p>

* 수정 완료 시 확인창 띄우기

<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184603639-24e37648-b21a-49ba-9a12-ee0ee9e75aab.png></p>

#### 비밀번호 변경
* 빈칸이 있을 시 submit불가

<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184757308-9b5dca19-4b83-41d6-b3db-92fe5c322e2b.png></p>

* 현재 사용중인 비밀번호와 같은 비밀번호로 바꿀 시 '사용불가: 비밀번호 재작성이 필요합니다.' 메세지 띄우기
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184757134-746fbf45-6c71-4426-8e20-3d8c70e046ea.png></p>

* 새 비밀번호와 새 비밀번호 확인이 불일치 시 alert창 띄우기

<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184757465-499668ef-deb9-4f82-aa23-6bb433971f93.png></p>

#### 회원탈퇴
* 비밀번호 입력 안하고 탈퇴 버튼 누를 시 '비밀번호를 다시 확인해주세요' 메세지 띄우기
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184588051-364001e8-ad64-4b91-9625-012369aa7c5d.png></p>

* 현재 사용중인 비밀번호와 일치하지 않을 시 회원탈퇴 불가 / 오류 메세지 띄우기
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184606049-c357f2f1-57c4-4ce1-87ec-8242f6640e36.png></p>

* 회원탈퇴 성공 시 'used'필드 값 변경(완전 삭제 ×/ 0: 탈퇴한 계정, 1: 사용 중인 계정) 
<p align="center"><img src= https://user-images.githubusercontent.com/103159709/184588283-c7794aaf-8c7e-4fde-a7ba-b9c5cd2fda95.png></p>







# 안
## 메인 Page

### 상단 슬라이드

- 영화관에서 필요한 규칙이나 현재 상영하고 있는 인기있는 영화들의 포스터와 영상을 이용해 손쉽게 흥미를 가질 수 있도록 구현했습니다. 

  <p align="center"><img src= https://user-images.githubusercontent.com/103159709/185009011-8d5de0a7-22c3-40e8-bfa0-e3b626435146.png></p>

  <p align="center"><img src= https://user-images.githubusercontent.com/103159709/185009103-b6e67171-0fcd-4be8-b4b9-ed19a16fb38d.png></p>

### 평점 높은영화 순 정렬 6개. 

- 평점순으로 영화를 정렬하여 상위 6개의 영화를 추려 보여줍니다. 

  - 평점과 간단한 영화 정보를 볼 수 있으며 해당 포스터를 클릭했을 경우 해당 영화의 상세 페이지로 연결됩니다. 

- 반응형 웹이 적용되어있어 화면의 크기에 따라 보여지는 영화 포스터의 갯수와 형태가 달라집니다. 

- "오늘의 상영작 확인하러가기" 를 누르게되면 포커스가 "오늘 상영 영화"로 이동합니다. 

  <img src= https://user-images.githubusercontent.com/103159709/185009156-c509dd9d-5c01-4e03-8405-db73d7f52f11.png>

  <img src= https://user-images.githubusercontent.com/103159709/185009168-fd3303ea-e791-45e8-a214-ab8d60ca95e8.png>

  <img src= https://user-images.githubusercontent.com/103159709/185009173-30cd1730-0780-4459-a88a-dd09f58e4bb8.png width="400" height="600">

### 영화 검색기능

- 장르, 배우, 감독, 국가 별 검색기능을 제공합니다.

  - 각 검색기능에 따라 이미지, 추천 키워드, 버튼내용을 다르게 적용하였습니다. 
  - 검색을 누르게 되면 동적 SQL 문을 이용하여 선택한 태마에 따른 검색 결과를 보여줍니다. 

- 장르 선택했을 경우 

  <img src= https://user-images.githubusercontent.com/103159709/185009448-55d2d0e7-8952-4d19-8669-f7682d1490b4.png">

  <img src= https://user-images.githubusercontent.com/103159709/185009455-6f9a56ba-07f8-4191-a995-e383dffef0b0.png>

- 나라 선택했을 경우 

  <img src= https://user-images.githubusercontent.com/103159709/185009461-bf0a4a46-0121-40cb-83ff-bc5a7561963f.png>

  <img src= https://user-images.githubusercontent.com/103159709/185009463-7360b3a8-3042-4144-967c-57ccb3220ae9.png>

- 만약 아무런 정보가 없을경우 정보없다고 띄워주는 페이지

  <img src= https://user-images.githubusercontent.com/103159709/185009610-cb92f866-259f-45c1-ac3c-138150d6376e.png>

### 오늘의 상영작

- 해당 요일에 상영되는 영화정보를 가져와 출력

  - 상영 영화가 없으면 없다고 표시.
  - 상영 영화가 있다면  간단한 영화 정보,별점과 포스터를 표시해 직관적으로 볼 수 있도록 함

- 영화 포스터나 제목을 눌렀을 경우 해당 영화의 상세 페이지로 넘어감 

- 반응형 웹을 이용해 포스터를 표시. -> 모바일 말고 화면 줄이는것도 다른화면됨

- 오늘 상영 영화가 없는 경우 

  <img src= https://user-images.githubusercontent.com/103159709/185009651-51d2db94-5a0a-4459-b964-34246d254ed8.png>

- 오늘 상영영화가 있는 경우 

  <img src= https://user-images.githubusercontent.com/103159709/185009655-7132871c-c241-4ea3-8d1e-ab992485c55a.png>

- 영화 상세 페이지 이동

  <img src= https://user-images.githubusercontent.com/103159709/185009656-60469e37-8616-4667-894c-06a9686c562b.png>

- 반응형 웹 적용

  <img src= https://user-images.githubusercontent.com/103159709/185009756-ae330481-17d4-499e-b009-2f1ec6081bbf.png>

  <img src= https://user-images.githubusercontent.com/103159709/185009661-94da6b13-3c1e-4ee1-bd48-1020fe252df5.png>

### 영화에 대해 궁금한 것 검색

- google search를 통해 movie에 대한 정보를 검색합니다.

- 새창을 띄워 검색한 키워드를 google에 서치해줍니다.

  <img src= https://user-images.githubusercontent.com/103159709/185009814-bd79a949-f1e4-48ad-bca9-91387cc0bdc9.png>

  <img src= https://user-images.githubusercontent.com/103159709/185009817-b220e094-0541-48bd-b30b-ec87cbe43f50.png>



## 영화  - 평점 랭킹 Page

### 영화 순위 정렬

- sql 문을 이용해 평점 랭킹 순으로 모든 영화를 정렬하여 정보를 가져옵니다.

- 영화를 클릭하면 해당 영화 detail 페이지로 넘어갈 수 있습니다.

  <img src= https://user-images.githubusercontent.com/103159709/185009891-57a65569-6905-44b8-9c8e-115b2de3f1c0.png>

### 페이징 기법 사용

- sql문의 limit을이용한 paging 기법을 통해 평점순으로 5개씩 나눠서 보여줍니다.

- 첫번째 페이지에서는 "이전" 버튼이 활성화되지 않도록 하였고, 마지막 페이지에서도 "다음" 버튼의 활성화를 막았습니다.

  <img src= https://user-images.githubusercontent.com/103159709/185009892-5273f7f8-d0af-4a79-aaff-2aea81674dcf.png>

  <img src= https://user-images.githubusercontent.com/103159709/185009896-4b489197-1937-430d-abb1-53a6a6c408b6.png>



## 이벤트 - 쿠폰발급 Page

### 로그인 전

- 현재 날짜를 기준으로 진행중인 쿠폰만 볼 수 있도록 만들었다.

  - 쿠폰은 보기 쉽도록 할인 가격이 높은 순으로 정렬했다. 

- 쿠폰 발급을 누르면 모달을 이용해 "발급받겠습니까? " 를 물어보고 발급버튼을 누르면 로그인이 되어있는지 체크한다. 

  - 로그인이 되어있으면 해당 아이디로 쿠폰발급을 진행하고 만약 비로그인이라면 로그인을 할것인지 물어보는 모달창을 띄운다. 
  - 로그인 버튼을 누르면 로그인 페이지로 넘어가게 되고, 이때 **_request.getHeader("Referer")_**  를 이용하여 모든 페이지에서 로그인페이지로 들어갔을 경우 이전 페이지를 기억하여 돌아갈 수 있도록 구현했다. 

  <img src= https://user-images.githubusercontent.com/103159709/185010057-658c5ea0-7a44-42f9-9873-362c98680923.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010062-c9f13cc7-ff07-427c-b531-5fdd1c624daa.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010020-06251a55-afc2-4963-a7e5-e3a3813bbb32.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010025-bbaa007f-0e56-410d-83ea-9d8fd9d4cb62.png>

### 로그인 후 

- 로그인이 완료되면 "보유중 or 발급가능" 문구를 통해 로그인한 아이디에서 발급받을 수 있는 쿠폰을 직관적으로 구분할 수 있도록 제작하였다. 

  - 만약 보유중 쿠폰을 다시 발급받았다면 "발급실패" 모달을 통해 요청을 취소한다. "발급가능" 쿠폰을 클릭했을 경우 정상적으로 발급되고 "close " 버튼을 누르면 페이지를 리로드 시킨다. 

- 반응형 웹으로 제작했다. 

  <img src= https://user-images.githubusercontent.com/103159709/185010026-8f677e88-925a-4620-aef1-ec52c39804a5.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010027-81cfff2f-b954-460e-86fd-e5e47607bcad.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010029-ffa6318c-3ade-4519-af8d-abd529d5f6be.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010032-97ba5ae0-cee3-4354-a6aa-1ad90a15706c.png>

  

## 이벤트 - 포인트 적립 Page

### NCP OCR 

- 표를 현장발권했을 경우 추가적으로 적립할 수 있도록 영수증 적립 이벤트를 구현했다. 

- 해당 페이지에서는 NCP 에서 제공하는 CLOVE OCR 기능을 이용했다. 

  <img src= https://user-images.githubusercontent.com/103159709/185010324-e7c83b51-2eb8-4da2-ac75-8a53ea414066.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010277-243bfb0b-ce99-42ee-b2b1-b0332d3cc0be.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010280-610b5d8e-3de3-4235-b600-4df997289867.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010553-f1bb103c-4d89-44c6-9054-6fc1bd0eb913.png width="200px" hight="500">

### 영수증 검사

- 영수증 검사 버튼을 눌러 OCR 기능을 이용해 업로드된 사진의 영수증 텍스트들을 인식하여 이용할 수 있는 영수증인지 판별한다. 

- 이때 판별이 끝나면 결과를 알려주는 텍스트로 자동 스크롤 되도록 구현하였다. 

- 이용할 수 있는 영수증이라면 적립가능하도록 하였고, 만약 조건에 맞지않는 영수증 ( 영수증 상단 이름, 발급일이 7일이상 지난 날짜) 이라면 적립버튼을 활성화 하지 않는다. 

  <img src= https://user-images.githubusercontent.com/103159709/185010294-f48b9c9b-4597-4db8-b65d-96bba0414c75.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010260-38d5d478-c29f-4eea-874b-6c321f1b8ed8.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010269-c80b142b-8c5a-4f2c-ab45-8e7207bb03c9.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010271-49d4ce0a-ae64-43b2-9d27-bd3bbcbb63cf.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010273-53fa136e-f9e1-4eab-b86f-f29b7da17c6e.png>

  

### 포인트 지급 

- 만약 조건에 만족하는 영수증이라면 영수증 금액의 5% 를 포인트로 지급한다. 

- 또한 같은 영수증을 연속적으로 사용할 수 있는 문제를 방지하여 바코드 번호를 관리하는 테이블을 만들어 중복 적립을 피할 수 있다. 

  <img src= https://user-images.githubusercontent.com/103159709/185010604-631dd809-35f9-4ba2-8ba9-a524a65fa21b.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010609-d2dc491f-5412-48eb-9441-a197c217dd82.png>



## 로그인 - 플랫폼 로그인 Page

> [Spring boot OAuth 2 모든 내용 정리](https://github.com/wonyoung0207/Spring-boot-Security-OAuth-2.0)

### 참고 강의 

1. [Spring boot Security 구현 강의](https://www.inflearn.com/course/스프링부트-시큐리티/dashboard)
   - [깃허브 자료](https://github.com/codingspecialist/-Springboot-Security-OAuth2.0-V3)
2. [유튜브 강의-나도코딩](https://opentutorials.org/course/2473/16571)
3. [생활코딩 OAuth ](https://www.inflearn.com/course/web2-oauth2/unit/36283?tab=curriculum) 
4. [참고 유튜브 강의](https://www.youtube.com/watch?v=9ui2i-SgBpk)
5. [내용 참고 ](https://deeplify.dev/back-end/spring/oauth2-social-login)

- 플랫폼 로그인 구현은 Spring boot 에서 제공하고 있는 OAuth2.0 기능을 이용했다. 
- Spring boot 에서 제공하는 OAuth 를 사용하여 각종 소셜 플랫폼에 등록되어있는 로그인 API 기능들을 이용하여 플랫폼 아이디로 로그인 할 수 있도록 만들었다. 
- OAuth 를 이용하면서 가장 어려움이 컸던것은 보안문제 였다. 보안으로 인해 8번의 과정을 거처 사용자 정보들을 받아올 수 있었다.
- 자세한 내용은 [Spring boot OAuth 2.0 정리](https://github.com/wonyoung0207/Spring-boot-Security-OAuth-2.0) 이곳에서 볼 수 있다. 

### Spring boot Security 구조

<img src= https://user-images.githubusercontent.com/103159709/185010683-078b8b8a-c0f4-4594-9427-b80bb8a0147c.png>

1. **_사용자( Owner )_** 가 client 와 연결된다.
   - client는 내가 개발하는 web, app 이다. 
2. 플랫폼 로그인 진행시 **_Client_** 의 화면에서 사용자에게 Resorce Server 로 요청하기 위한 **계정 동의** 를 구한다. -> 동의 버튼은 **_Resorce Server_** 로 연결되어 있어 바로 3번이 진행된다. 
   - Resorce Server 는 신뢰할 수 있는 기업인 google, naver, Kakao 같은 server 를 뜻한다. 
   - 계정 동의는 해당 플랫폼의 id, password로 로그인하는것을 뜻한다. 
3. 동의를 구하면 Resorce Server 로 계정 인증 내용을 보낸다. 
4. Resorce Server 가 인증요청을 받고 **_Client에서 필요로 하는 정보 ( Scope List )_** 가 무엇인지 사용자에게 보여준다. 사용할 정보 리스트( Scope List ) 를 가지고 Client가 이용할 수 있도록 허락하는지 사용자에게 물어본다. 
   - scope List 의 내용을 사용자가 허락할 것인지 창으로 보여준다. 
5. 이때 동의 버튼을 클릭하면  Resorce Server 가 Client에게 사용자의 정보 ( Scope List ) 를 볼 수 있도록 허락하는  **_비밀번호 ( Code )_** 를 보낸다. 
   - 따라서 Code에는 사용자가 자신의 정보를 볼 수 있도록 Client에게 권한을 줬다는 것을 뜻한다. 
6. Client가 Resorce Server 로부터 받은 Code를 **_Client id, Client secretKey_** 와 함께 묶어 다시 Resorce Server 로 보낸다. 
   - Resorce Server 는 전달받은 3가지의 정보 ( Code와 해당 클라이언트 id. SecretKey) 가 맞는지 판단한다.
7. Resorce Server 가 판단을 통해 Client에게 **_Access Token_** 을 보내준다. 
   - Access Token을 가지고 Client는 해당 사용자가 허락한 범위 내에서 정보를 열람할 수있다. 
8. Client 는 Access Token을 가지고 API를 사용할 수 있다.

### 결과화면 

- 로그인은 **"google 로그인 버튼 클릭 -> 계정 선택 -> 데이터 정보 요구 동의 -> 로그인"**  순서로 진행된다. 

  <img src= https://user-images.githubusercontent.com/103159709/185010724-fe27b407-0b5d-4700-aa55-4b5fee720a69.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010726-9aaa8b2a-3002-4991-93a9-9f415352f6b3.png>

  <img src= https://user-images.githubusercontent.com/103159709/185010730-98bb987b-8483-42a7-bb88-641540594f3f.png>

- 소셜 API 콘솔에 들어가면 만든 TicketSajo 어플리케이션이 존재한다. 

  <img src="../images/FinalProject/login_social4.png">

  <img src="../images/FinalProject/login_social5.png">

  <img src="../images/FinalProject/login_social6.png">

- 로그인이 완료되면 다음 데이터를 받아와 세션에 사용자 정보를 저장한다. 

  ```java
  google 로그인 요청
  getAttributes : {sub=xxx, name=안원영, given_name=원영, family_name=안, picture=https://xxx, email=xxx@gmail.com, email_verified=true, locale=ko}
  principalDetails : CustVO(id=xxx@gmail.com, pwd=0000, name=안원영, birth=Wed Feb 07 00:00:00 KST 1996, point=0, sex=men, used=true, usepoint=0)
  ```
