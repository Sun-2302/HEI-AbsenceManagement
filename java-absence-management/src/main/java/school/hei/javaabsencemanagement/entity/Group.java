package school.hei.javaabsencemanagement.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Group {
    private int id;
    private String ref;
    private LocalDate creation_date;
}
