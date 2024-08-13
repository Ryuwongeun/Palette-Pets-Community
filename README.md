## 📅 프로젝트 일정
팀 프로젝트 기간 (20240513 ~ 20240627)
>

## <a name="section0" />🚀바로가기
### [1.💼프로젝트 산출물](#section1)
### [2.🧑🏻프로젝트 멤버](#section2)
### [3.👤역할 및 담당 업무](#section3)
### [4.📱기획 주제 선정](#section4)
### [5.🚨트러블 슈팅](#section5)
### [6.⚙️Stack & Tool](#section6)


### <a name="section1" />💼프로젝트 산출물
✔️ **프로젝트 산출물** 

[프로젝트 발표.pdf](https://drive.google.com/file/d/1GPaqxSfGh2auJNmV_4I6UD4JXhf7xc5V/view?usp=sharing)
>
[간단한 시스템 아키텍처](https://www.figma.com/board/I3S3GViSuWVW6f1XCSudlT/Final-Architecture?node-id=0-1&t=3LeZjxDonI4eDf9b-0)
>
[UI 설게](https://www.figma.com/design/TDAFaHkbFCa1sngiLppZ0Z/pets?node-id=0-1&t=EmBOSQWk0Ypl8dBf-1)



### <a name="section2" />🧑🏻 프로젝트 멤버 [🔝](#section0)

<table>
  <tr>
    <td align="center"><a href="https://github.com/Kim-soung-won"><b>승원</b></a></td>
    <td align="center"><a href="https://github.com/Ryuwongeun"><b>원근</b></a></td>
    <td align="center"><a href="https://github.com/gywls20"><b>혜경</b></a></td>
    <td align="center"><a href="https://github.com/dl11911"><b>승훈</b></a></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/gyuchanlee"><b>규찬</b></a></td>
    <td align="center"><a href="https://github.com/gywls20"><b>효진</b></a></td>
    <td align="center"><a href="https://github.com/jyc961020"><b>용철</b></a></td>
    <td align="center"><a href="https://github.com/cuscus8"><b>훈민</b></a></td>
  </tr>
</table>

## <a name="section3" />👤 역할 및 담당 업무 [🔝](#section0)


 
## <a name="section4" />📱기획 주제 선정 (20240215~202403) [🔝](#section0)

🧐 **선정 이유**

**커뮤니티, 채팅 플랫폼**

- 실제 서비스 운영, 배포 경험을 위한, 결제 기능이 없는 단순 커뮤니티 서비스 구현하고자 하는 목표를 이루기 위해
- 기존 API 통신이 아닌, 연결형 Socket 통신 서비스 구현 경험에 대한 학습
- NLP 기술을 통한 검색엔진, 금칙어 시스템 구현을 통한 질 좋은 서비스 구축

**MSA 패턴 도입**

- 채팅, 커뮤니티, 관리자로 기능이 명확하게 나뉘고, 분리해서 운영할 수 있을 것 같아서 별개의 서버에 배포, 관리
- 장애 발생시 전체 서비스가 마비되는 불상사 방지, 코드 관리 및 기능 테스트 효율화
- 별개의 서버에서 발생하는 데이터 관리 및 관련되는 기능을 통한 통신 경험

**Redis Cache를 포함한 NoSQL 추가**

- 많은 양의 실시간 데이터 조회 및 쓰기가 필요한 시스템에 RDBMS는 너무 느린 성능을 보일 것으로 예상
- 데이터 캐싱을 통한 조회 성능 개선 및, 일괄 쓰기를 통한 쓰기 비용 감소
- TTL 데이터를 활용한 조회수, 글쓰기 등의 횟수 제한을 통한 쓰기 작업 처리율 제한



## <a name="section5" />🚨트러블 슈팅 [🔝](#section0)

---

### 트러블1. [SSE 서버 분리를 통한 응답 성능 개선]

🚨 **문제 배경**



⭐️ **해결 방법**


🤩 **해당 경험을 통해 알게된 점**



---



## <a name="section6" />⚙️Stack & Tool [🔝](#section0)

### 프론트엔드
- JavaScript
- React
- Redux

### UI
- Figma
- MUI
- TailWinds

### 백엔드  
- Java, Kotlin
- Spring Boot3
- JPA
- QueryDSL
- JWT

### DBMS 
- MySQL8
- Redis

### DevOps
- NCP
- Docker
- Jenkins
- sonarqube

### 커뮤니케이션
- Notion
- Figma


