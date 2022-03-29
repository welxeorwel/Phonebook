package models;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    String name;
    String lastName;
    String phone;
    String email;
    String address;
    String description;

}
