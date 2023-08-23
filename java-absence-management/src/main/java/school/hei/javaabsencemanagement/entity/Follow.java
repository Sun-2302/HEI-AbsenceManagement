package school.hei.javaabsencemanagement.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Follow {
    private int id;
    private int id_student;
    private int id_teaching_units;
}
