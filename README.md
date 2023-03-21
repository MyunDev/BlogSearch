# BlogSearch


## :information_desk_person: 프로젝트 설명

<b> 오픈 API를 활용하여 블로그 검색 서비스를 만듭니다 </b> 

* 프로젝트 기간: 2023.03.18 ~ 2023.03.22

* [API 문서](https://www.notion.so/db9403a0f49d43cbbb70a8de9930415b?pvs=4)</b>

<br>

## 기능 구현 사항
  - 키워드를 통해 블로그를 검색할 수 있습니다.
  
  - requestBody릍 통해 넘기는 정렬방식에 따라 결과에서 Sorting(정확도순, 최신순) 기능을 지원 합니다.
  
  - 검색 결과는 Pagination 형태로 제공됩니다.
  
  - requestBody에 넘기는 검색소스 타입에 따라 카카오 API의 키워드로 블로그 검색 또는 네이버 블로그 검색 API를 통해 정보를 제공합니다.
  
  - 사용자들이 검색한 상위 10개의 키워드를 조회한 횟수와 함께 제공합니다. 



<br>

## :blue_book: Package

사용한 외부 라이브러리는 다음과 같습니다.

- **nodemailer** - 회원 가입 시 이메일 인증을 위한 이메일 전송
- **jsonwebtoken** - JWT(Json Web Token) 생성 및 인증
- **rand-token** - 랜덤으로 Token 생성
- **pbkdf2** - 솔트를 적용한 후 해시 함수의 반복 횟수를 임의로 선택
- **mongoose** - 몽고DB ODM 문서를 DB에서 조회할 때 자바스크립트 객체로 바꿔주는 역할
- **qrcode** - QR코드 생성
- **aws-sdk** - AWS에 API를 제공
- **multer** - 이미지 업로드
- **multer-s3** - 이미지 S3에 업로드
- **moment** - 출석체크, 피드백 제출 날짜 포맷
- **socket.io** - websocket 프로토콜을 지원하는 네트워킹 라이브러리
- **connect** - RESTful Web Services를 쉽게 사용
