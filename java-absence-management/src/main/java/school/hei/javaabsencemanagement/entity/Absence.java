package school.hei.javaabsencemanagement.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Absence {
    private int id;
    private int id_student;
    private int id_course;
}
