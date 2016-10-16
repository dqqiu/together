package org.spirit.together.dictionary.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dict_state")
public class DictStateController {
  
  @RequestMapping(value = "/desc")
  public String desc() {
    return "获取国家相关接口";
  }
}
