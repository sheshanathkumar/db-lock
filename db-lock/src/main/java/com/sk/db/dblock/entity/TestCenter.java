package com.sk.db.dblock.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "test_center")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class TestCenter {

    @Id
    @Column(name = "test_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_desc")
    private String testDesc;

    @Override
    public String toString() {
        return "TestCenter\n{" +
                " testId=" + testId +
                ", testName='" + testName + '\'' +
                ", testDesc='" + testDesc + '\'' +
                '}';
    }
}
