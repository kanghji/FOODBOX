# :bento: FOODBOX </br>
### 개발 개요 </br>
현대인들의 바쁜 일상 속, 레시피와 함께 신선한 식재료를 주문하며 건강한 삶을 지향하는 사이트를 제공하고자 개발하였습니다.

### 팀 구성원 </br>
임현재(팀장), 강현지, 서이정, 이찬미, 탁연정

### 개발 환경
- **version** : java 11
- **IDE** : Intelij
- **Framework** : Springboot 2.7.13 , Spring Security
- **Database** : MySQL
- **개발언어 / library / Tool** : gradle, Mybatis, bcrypt암호화, Lombok, javascript, jQuery, BootStrap
- **web server** : Apache Tomcat9
- **API** : 카카오 주소API, 레시피API, kg이니시스 API, 카카오 결제 API, 카카오 로그인 API, 구글 이메일 인증

### 프로젝트 상세소개 
사용자가 원하는 레시피를 제공하고 레시피에 맞는 식재료를 구입할 수 있습니다. </br>
구입 후 별점과 댓글을 남길 수 있습니다. </br>
원하는 레시피는 찜하기를 눌러서 언제든지 볼 수 있도록 '책갈피한레시피'에서 확인이 가능합니다. </br>
검색창에 키워드를 입력하면 상품과 레시피 동시에 검색이 가능합니다.

- 테이블 기능명세 </br>
<https://docs.google.com/spreadsheets/d/16cfZ-7FTTPmlb0djrN9vKAgwdaXaeicsmYWm7aIQukk/edit?usp=sharing>

- ERD 설계

![ERD](https://github.com/kanghji/FOODBOX/assets/123557480/deab930f-2adc-487d-bb08-11a0d7f833aa)

### 주요 기능 
- 회원가입 및 로그인

![signup](https://github.com/kanghji/FOODBOX/assets/123557480/889adf55-6fe6-49c3-a719-14090212df24)
> 1. 아이디 중복확인
> 2. 메일 인증을 통한 이메일 인증
> 3. 카카오주소API를 이용한 주소 검색 기능 

</br>

- 상품 상세페이지

![store](https://github.com/kanghji/FOODBOX/assets/123557480/2c617abb-44c6-4252-9123-a5d8685e3373)
> 1. 상품 갯수를 선택하여 장바구니에 담거나 바로 구매할 수 있음
> 2. 로그인 후 별점과 상품리뷰 등록 및 삭제 기능
> 3. 추천순 / 낮은 가격순 / 높은 가격순으로 정렬 기능 

</br>

- 레시피 상세페이지

![recipe_best_new](https://github.com/kanghji/FOODBOX/assets/123557480/8927d21c-2971-4e9f-8de4-34b711fc0617)
> 1. 마음에 드는 레시피는 북마크를 통해 찜하기 가능
> 2. 로그인 후 별점과 레시피 리뷰 등록 및 삭제 기능

</br>

- 마이페이지
  
![mypage](https://github.com/kanghji/FOODBOX/assets/123557480/4d1fc66e-b0c6-4baf-aa6a-f516083b9140)
> 1. 주문내역조회 : 결제한 상품 내역을 보여주고 주문취소도 할 수 있음
> 2. 책갈피한 레시피 : 내가 찜한 레시피 확인 가능 및 삭제 기능
> 3. 회원정보수정 : 이름과 생년월일을 제외한 정보 수정 및 탈퇴 기능
> 4. 비밀번호 변경 : 보안을 위해 현재 비밀번호 재확인 후 비밀번호를 변경할 수 있음

</br>

- 장바구니 및 결제

![cart](https://github.com/kanghji/FOODBOX/assets/123557480/703c5ee4-d589-44ed-b5c8-e6ae11794814)
> 1. 장바구니 삭제 기능
> 2. 상품 수량 수정 기능
> 3. kg이니시스API와 카카오 결제API를 통한 결제 기능

</br>

- 검색

![search](https://github.com/kanghji/FOODBOX/assets/123557480/358c4776-9f37-40fa-98ce-ed4fda49833c)
> 1. 키워드 입력시 상품과 레시피 동시에 검색할 수 있음
> 2. 키워드 미입력 시 전체 상품/레시피가 검색됨
> 3. 빠른 로딩을 위해 무한 스크롤을 적용하여 상품/레시피가 더 보이게 구현

</br>

- 아이디/비밀번호 찾기

![find_idpw](https://github.com/kanghji/FOODBOX/assets/123557480/a6363eb5-77a3-46ed-a8e7-096c31464065)
> 1. 이름과 이메일을 통해 아이디 찾기
> 2. 이메일을 통해 임시 비밀번호 발송 기능

</br>

- 메인 페이지

![mainpage_1](https://github.com/kanghji/FOODBOX/assets/123557480/64110e07-9616-4394-b723-e97cff5f7d24)

![mainpage_2](https://github.com/kanghji/FOODBOX/assets/123557480/4193611a-ce5a-410c-ba75-4b0a538bdfa1)
> 1. 사용자의 편리성을 위해 심플하게 구성하여 직관적으로 보여줌
> 2. read more 버튼을 통해 베스트/레시피/신상품 페이지로 이동
> 3. 자동 슬라이드를 적용하여 추천상품을 보여주며 화살표를 클릭해도 옆으로 넘길 수 있음
> 4. 더보기 버튼을 클릭하면 더 많은 추천상품을 볼 수 있음

</br>
</br>



