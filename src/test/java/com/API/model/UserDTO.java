package com.API.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  public long id;
  public String email;
  public String password;
  public String firstName;
  public String lastName;
  public String avatar;
  public String name;
  public String job;
}
