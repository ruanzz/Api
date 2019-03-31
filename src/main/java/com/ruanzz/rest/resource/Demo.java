package com.ruanzz.rest.resource;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * @author ZhenZhuo.Ruan
 */
@Data
@Builder
public class Demo {

  private Long id;
  private String name;
  private Date createTime;
}
