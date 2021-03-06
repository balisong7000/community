package community.community.model;

import lombok.Data;

@Data
public class User {

  private Integer id;
  private String name;
  private String accountid;
  private String token;
  private long gmtcreate;
  private long gmtmodified;
  private String bio;
  private String avatarUrl;
}
