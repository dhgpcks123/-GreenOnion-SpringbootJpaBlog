package com.example.springbootjpablog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 파일은 크기가 커서 db에 직접저장하면 부담이 많이 되기떄문에
    // 대체로 폴더에 따로 저장해두고, 파일 이름만 db에 저장해서 가져오도록 합니다.
    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String saveName;


    // @ManyToOne(fetch = FetchType.EAGER) // 매핑 된 테이블을 조인해서 가져온다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BOARD_ID") // 외래키 매핑할 때 사용합니다. name은 필드명_ 참조하는 테이블 기본키 컬럼명을 사용해주세요
    private Board board;

}