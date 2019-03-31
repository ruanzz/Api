package com.ruanzz.rest.api;

import com.ruanzz.rest.resource.Demo;
import com.ruanzz.utils.JSONUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author ZhenZhuo.Ruan
 */
@Path("/demos")
public class DemoRestService {

  private static List<Demo> demoList = new ArrayList<>();

  static {
    demoList.add(Demo.builder().id(1L).name("demo1").createTime(Calendar.getInstance().getTime())
        .build());
    demoList.add(Demo.builder().id(2L).name("demo2").createTime(Calendar.getInstance().getTime())
        .build());
    demoList.add(Demo.builder().id(3L).name("demo3").createTime(Calendar.getInstance().getTime())
        .build());
    demoList.add(Demo.builder().id(4L).name("demo4").createTime(Calendar.getInstance().getTime())
        .build());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String list() {
    return JSONUtil.toJSON(JSONUtil.toJSON(demoList));
  }

  @GET
  @Path("{id:\\d+}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String get(@PathParam("id") Long id) {
    List<Demo> list = demoList.stream().filter(t -> t.getId() == id)
        .collect(Collectors.toList());
    if (list.isEmpty()) {
      return JSONUtil.toJSON("not exit");
    }
    return JSONUtil.toJSON(list.get(0));
  }

  @DELETE
  @Path("/{id:\\d+}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String delete(@PathParam("id") Long id) {
    Demo demo = demoList.stream().filter(t -> t.getId() == id)
        .collect(Collectors.toList()).get(0);
    if (Objects.isNull(demo)) {
      return JSONUtil.toJSON("error");
    }
    demoList.remove(demo);
    return JSONUtil.toJSON("sucess");
  }


  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String create(String body) {
    Demo demo = JSONUtil.fromJSON(body, Demo.class);
    if (Objects.isNull(demo)) {
      return JSONUtil.toJSON("bad request");
    }
    demoList.add(demo);
    return JSONUtil.toJSON(demo);
  }

  @PUT
  @Path("/{id:\\d+}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String update(@PathParam("id") Long id, String body)
      throws Exception {
    Demo demo = demoList.stream().filter(t -> t.getId() == id)
        .collect(Collectors.toList()).get(0);
    if (Objects.isNull(demo)) {
      return JSONUtil.toJSON("error");
    }
    demoList.remove(demo);
    Demo toUpdate = JSONUtil.fromJSON(body, Demo.class);
    copy(demo, toUpdate);
    demoList.add(demo);
    return JSONUtil.toJSON(demo);
  }


  /**
   * 不采用beanutil来拷贝，自己控制可以修改哪些属性
   */
  private void copy(Demo demo, Demo toUpdate) {
    if (!Objects.isNull(toUpdate.getName())) {
      demo.setName(toUpdate.getName());
    }
  }


}
