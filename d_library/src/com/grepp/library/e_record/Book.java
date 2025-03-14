package com.grepp.library.e_record;

// NOTE E01 Record
// 도메인 객체 : 역할과 책임을 가지고 있는 객체
// 데이터 객체 : 데이터 전송이나 저장을 위한 객체
//     DTO : Data Transfer Object (mutable, setter가 다 있다.)
//     VO  : Value Object (immutable)

// record == vo
// 불변 데이터 클래스 (필드는 private final)
// 속성명으로 getter 자동 생성, getTitle(x) title(o)
// equals, hashcode, toString 자동 overriding
public record Book(
    String title,
    String author,
    Integer price,
    Boolean activated
) {

    // NOTE E02
    // 자동으로 생성되는 매개변수있는 생성자(canonical 생성자) 이외의 생성자를 사용할 때는
    // 다른 생성자에게 객체 생성을 위임해야 한다.
    public Book(){
        this("", "", null, null);
    }

    // NOTE E03 compact 생성자
    // 생성자로 전달된 인자에 대한 검증 로직 수행
    public Book{
        System.out.println("compact 생성자 : " + title);
        if(price == null || price < 0 ) throw new IllegalArgumentException();
    }

//    public void modifyTitle(String title){
//        // Cannot assign a value to final variable 'title'
//        this.title = title;
//    }
}
