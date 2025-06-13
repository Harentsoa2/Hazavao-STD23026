package shool.hei.hazavao.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import shool.hei.hazavao.PojaGenerated;

@PojaGenerated
public class EmailConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.ses.source", () -> "dummy-ses-source");
  }
}
