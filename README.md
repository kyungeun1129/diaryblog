# 나만의 블로그 만들기

**종류:** 교육노동부 주관 정부 교육 과정 (KG ITBANK)  

**개발기간:** 2024.11.11 ~ 2024.11.20  

**참여인원:** 3명  

**담당업무:** 아이디어 제안, 기획, 메인 페이지 설계, 일기 게시판 설계 및 제작  

**개발환경:** Windows  

**사용도구:** Eclipse, Oracle  

**사용기술:** Java  

---

## 프로젝트 개요
‘나만의 블로그 만들기’ 프로젝트는 사용자가 자신만의 독특한 공간을 창조하고, 다양한 주제에 대한 생각을 자유롭게 표현하고 공유할 수 있도록 설계되었습니다.

주요 기능:
- 회원가입, 인증, 로그인 및 person 데이터베이스 연동  
- **메인 게시판:** 닉네임 기반 이웃 설정, 랜덤 오늘의 운세, 음악 기능, 달력 기능  
- **맛집 게시판:** 맛집 리스트, 수정 기능, 지도 URL 연동, foodList 데이터베이스 연동  
- **일기 게시판:** 일기 작성, 저장, 열람, 삭제 기능  
- **CardLayout:** 화면 전환의 자연스러운 흐름 구성  

---

## 기획 의도 (동기)
이 프로젝트는 단순한 블로그 사용이 아닌, 사용자의 개성과 취향을 반영할 수 있는 맞춤형 블로그 경험을 제공하는 것을 목표로 했습니다.  

- **메인 게시판:** 멀티미디어 콘텐츠를 통해 개성을 표현  
- **맛집 게시판:** 사용자가 음식 정보를 자유롭게 수정하고 공유  
- **일기 게시판:** 개인적 감정과 생각을 기록하고 공유, 다른 사용자와 소통 가능  

---

## 담당 업무 상세

### 일기 게시판 설계 및 제작
목표: 사용자가 개인적 생각과 감정을 기록하고 공유할 수 있는 환경 구현

#### 1️⃣ 게시판 구현
- JTable과 Event 기반 설계  
- 글쓰기 버튼 클릭 → JTextField, JRadioButton, JTextArea를 활용한 일기 작성 화면 전환  
- 작성한 일기 저장, 게시판 리스트에서 삭제 가능  

#### 2️⃣ 저장 환경 구현
- 프로젝트 하위에 `DiarySaving` 폴더 없으면 자동 생성  
- FileOutputStream + OutputStreamWriter로 `.txt` 형식 저장  
- 파일명: `제목_시간.txt`  
- 게시판 진입 시 폴더 내 파일 검색 후 JTable로 로드  
<img width="600" height="400" src="https://github.com/user-attachments/assets/cafdb625-7b18-4bca-83f5-96fcdc4675ff" />
<img width="600" height="400" src="https://github.com/user-attachments/assets/094ce90c-97ad-41f2-97ce-78e3978ddc6b" />

- 우클릭 → JPopupMenu로 ‘삭제’ 선택 → 해당 파일 삭제  
<img width="600" height="400" src="https://github.com/user-attachments/assets/02328ad1-d277-4101-bbaf-41f2269bcefc" />

- 좌클릭 → FileInputStream, InputStreamReader, BufferedReader 활용해 파일 내용 열람  
<img width="600" height="400" src="https://github.com/user-attachments/assets/eccd4fa7-5f48-4a49-b110-dbff5038dc9a" />

#### 3️⃣ CardLayout 적용
- 화면 전환 시 정보 유지 및 자연스러운 전환 구현  

#### 4️⃣ 사용자 편의성 개선
- 날씨 아이콘 클릭으로 일기 작성  
- 다양한 알림창 활용  
<img width="600" height="400" src="https://github.com/user-attachments/assets/d651992f-e4cd-49ec-9ffd-7e4cda0b9bde" />

---

## 후기
- **기술적 성장:** Java 파일 시스템 연동, FileOutputStream/InputStreamReader/BufferedReader 활용 실습  
- **UI/UX 경험:** CardLayout을 활용하여 화면 전환 문제 해결, 직관적 버튼 배치 및 Event 설계  
- **개선 포인트:**  
  - 글 작성자만 삭제 가능하도록 권한 설정 미완  
  - 댓글 기능 구현 미완  
  → 추후 파일에 작성자 닉네임 정보 저장 및 권한 확인 기능 추가 가능  
- **팀워크 및 커뮤니케이션:**  
  - 초기 어색한 분위기 개선, 적극적 아이디어 공유  
  - 정기 회의와 작업 내용 공유를 통한 진척 관리  
  - 팀 내 도움 요청과 지원을 통해 협업 능력 향상  

이번 프로젝트는 기술적 성장뿐 아니라 **UI/UX 설계, 파일 시스템 활용, 팀워크, 문제 해결 능력**까지 고루 경험할 수 있었던 의미 있는 프로젝트였습니다.
