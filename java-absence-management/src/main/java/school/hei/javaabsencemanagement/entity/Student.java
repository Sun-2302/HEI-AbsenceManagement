package school.hei.javaabsencemanagement.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private String ref;
    private String email;
    private String phone;

}
