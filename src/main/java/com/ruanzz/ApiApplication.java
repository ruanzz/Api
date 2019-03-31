package com.ruanzz;

import java.net.URI;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author ZhenZhuo.Ruan
 */
public class ApiApplication extends ResourceConfig {

  private static final String PACKAGE_NAME = "com.ruanzz.rest.api";

  private static final String BASE_URI = "http://127.0.0.1:8080/";

  public ApiApplication() {
    // 扫描包，发布为REST资源
    this.packages(PACKAGE_NAME);
  }

  public static void main(String[] args) {
    JettyHttpContainerFactory.createServer(URI.create(BASE_URI), new ApiApplication());
  }
}
