package org.spirit.together.dictionary.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.spirit.together.dictionary.api.service.DictTypeService;

/**
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@RestController
@RequestMapping(value = "/dict_type")
public class DictTypeController {
  @Autowired
  private DictTypeService dictTypeService;

}