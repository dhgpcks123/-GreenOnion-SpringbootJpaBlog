package com.example.springbootjpablog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 150) // 1 ) length 지정할 수 있어요
    private String title;

    @Lob // 2 ) Large Object 큰 데이터 저장할 때 사용합니다
    @Column(nullable = false)
    private String content;

    @CreationTimestamp // 3 ) 데이터가 입력될 때 현재 시간을 채워 INSERT해줍니다
    private Timestamp createDate;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    // 4 ) CascadeType.REMOVE, board의 데이터가 imageList에 들어있는 데이터도 db에서 삭제됩니다
    private List<Image> imageList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CATEGORY_ID")
    private Category category;
}
