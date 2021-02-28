package me.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.study.study.StudyStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    private String name;

    @ManyToOne
    private Member owner;

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야 한다.");
        }
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }
}
