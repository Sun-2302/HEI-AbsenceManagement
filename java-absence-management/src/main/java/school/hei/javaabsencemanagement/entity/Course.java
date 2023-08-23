package school.hei.javaabsencemanagement.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Course {
    private int id;
    private LocalDateTime date_time;
    private int id_teaching_units;
    private int id_group;
}
