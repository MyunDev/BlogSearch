# BlogSearch


## :information_desk_person: 프로젝트 설명

<b> 오픈 API를 활용하여 블로그 검색 서비스를 만듭니다 </b> 

* 프로젝트 기간: 2023.03.18 ~ 2023.03.22

* [API 명세서](https://www.notion.so/db9403a0f49d43cbbb70a8de9930415b?pvs=4)</b>

<br>

## 🛠 기능 구현 사항

  - 블로그 검색 API 
    - 키워드를 통해 블로그를 검색할 수 있습니다.
  
    - requestBody릍 통해 넘기는 정렬방식에 따라 결과에서 Sorting(정확도순, 최신순) 기능을 지원 합니다.
  
    - 검색 결과는 Pagination 형태로 제공됩니다.
  
    - requestBody에 넘기는 검색소스 타입에 따라 카카오 API의 키워드로 블로그 검색 또는 네이버 블로그 검색 API를 통해 정보를 제공합니다.
  
 - 인기 검색어 목록 조회 API
    - 사용자들이 검색한 상위 10개의 키워드를 조회한 횟수와 함께 제공합니다. 



<br>

## 📚 사용한 라이브러리 및 기술 스택

사용된 라이브러리 및 기술 스택은 다음과 같습니다.

- **SpringBoot : 2.7.9** 
- **springCloudVersion : 2021.0.5** - OpenFeign 사용하기 위한 dependency
- **springCloudAwsVersion : 2.4.2** - OpenFeign 사용하기 위한 dependency
- **lombokVersion : 1.18.24** - MapStruct 사용위한 dependency
- **lombokMapstructBindVersion : 0.2.0** - MapStruct 사용위한 dependency
- **mapStructVersion : 1.5.3.Final** - DTO 간 매핑을 위해 사용
- **OpenFeign : 4.10.0** - 외부 API 호출을 위해 사용
- **guava : 30.1.1-jre** - ImmutableMap 활용을 위해 추가

<br>

🙋‍♂️ Feign Client  사용 이유

- 개발해야 하는 블로그 검색 API는 외부 서비스의 응답이 비즈니스 로직에 포함되어 반드시 응답을 받아야 API를 성공 처리 할 수 있는 경우에 해당됩니다.
- 따라서 동기 통신 방식에서 주로 사용되며 상대적으로 간편하게 interface와 annotation 선언만하면 구현체가 생성되는 **Feign Client**방식을 사용했습니다.

🙋‍ MapStruct 사용 이유 

- 도메인 서비스에서 View로 부터 입출력 값을 받거나 외부 연동서비스로부터 입출력 값을 받을 때, 의존성을 줄이고 필요한 값들 만을 사용하기 위해 DTO로 변환했습니다.
- 이 때 많은 필드 값들을 일일히 매핑하기보다 해당 작업을 자동화해주는 MapStruct를 사용했습니다.
- MapStruct는 리플렉션을 사용하지 않고 컴파일 타임(어노테이션 프로세서)에 처리하므로 애플리케이션 성능에 영향을 주지 않는 장점이 있습니다.
