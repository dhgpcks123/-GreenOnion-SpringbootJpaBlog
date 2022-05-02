package com.example.springbootjpablog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 이 클래스를 DB랑 연결하는 엔티티 클래스로 사용하겠다는 뜻입니다
@Builder // Builder 패턴 사용
@NoArgsConstructor // 파라미터 없는 기본 생성자 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 생성
@Getter // Getter 메서드를 생성해줍니다
public class Category {

    @Id // 기본 키 PK 입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 데이터 입력 시 자동으로 값을 줍니다
    private Long id;

    @Column(nullable = false) // null값을 허용하지 않습니다
    private String name;

    @OneToMany(mappedBy = "category") // 연관관계를 설정해줍니다. mappedBy는 연관관계에서 주인이 아님을 나타냅니다
    private List<Board> boardList = new ArrayList<>();
}
