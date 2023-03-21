# BlogSearch


## :information_desk_person: 프로젝트 설명

<b> 오픈 API를 활용하여 블로그 검색 서비스를 만듭니다 </b> 

* 프로젝트 기간: 2023.03.18 ~ 2023.03.22

* [API 문서](https://www.notion.so/db9403a0f49d43cbbb70a8de9930415b?pvs=4)</b>

<br>

## 🛠 기능 구현 사항
  - 키워드를 통해 블로그를 검색할 수 있습니다.
  
  - requestBody릍 통해 넘기는 정렬방식에 따라 결과에서 Sorting(정확도순, 최신순) 기능을 지원 합니다.
  
  - 검색 결과는 Pagination 형태로 제공됩니다.
  
  - requestBody에 넘기는 검색소스 타입에 따라 카카오 API의 키워드로 블로그 검색 또는 네이버 블로그 검색 API를 통해 정보를 제공합니다.
  
  - 사용자들이 검색한 상위 10개의 키워드를 조회한 횟수와 함께 제공합니다. 



<br>

## :blue_book: 외부 라이브러리 및 기술 스택

사용된 외부 라이브러리 및 기술 스택은 다음과 같습니다.

- **SpringBoot : 2.7.9** 
- **springCloudVersion : 2021.0.5** - OpenFeign 사용하기 위한 dependency
- **springCloudAwsVersion : 2.4.2** - OpenFeign 사용하기 위한 dependency
- **lombokVersion : 1.18.24** - MapStruct 사용위한 dependency
- **lombokMapstructBindVersion : 0.2.0** - MapStruct 사용위한 dependency
- **mapStructVersion : 1.5.3.Final** - DTO 간 매핑을 위해 사용
- **OpenFeign : 4.10.0** - 외부 API 호출을 위해 사용
- **guava : 30.1.1-jre** - ImmutableMap 활용을 위해 추가
