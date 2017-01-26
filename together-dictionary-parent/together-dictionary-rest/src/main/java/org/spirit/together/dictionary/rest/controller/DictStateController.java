package org.spirit.together.dictionary.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.spirit.together.dictionary.api.model.DictState;
import org.spirit.together.dictionary.api.service.DictStateService;
import org.spirit.together.dictionary.api.vo.DictStateVo;

/**
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@RestController
@RequestMapping(value = "/dict_state")
public class DictStateController {
  @Autowired
  private DictStateService dictStateService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<DictState> getStates(){
    return dictStateService.getByCondition(new DictStateVo());
  }
  
  @RequestMapping(value = "/cd/{cd}")
  public DictStateVo getStateByCd(@PathVariable("cd") String cd) {
    return dictStateService.getByPrimaryKey(cd);
  }
}