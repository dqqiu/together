package org.spirit.together.dictionary.rest.controller;

import java.util.List;

import org.spirit.together.dictionary.api.model.DictData;
import org.spirit.together.dictionary.api.service.DictDataService;
import org.spirit.together.dictionary.api.vo.DictDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@RestController
@RequestMapping(value = "/dict_data")
public class DictDataController {
  @Autowired
  private DictDataService dictDataService;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<DictData> datas(){
    return dictDataService.getByCondition(new DictDataVo());
  }
  
  @RequestMapping(value = "/dictDataTypeCd/{dict_data_type_cd}/cd/{cd}", method = RequestMethod.GET)
  public DictDataVo detail(@PathVariable("cd") String cd, @PathVariable("dict_data_type_cd") String dictDataTypeCd){
    return dictDataService.getByPrimaryKey(cd, dictDataTypeCd);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public void insert(@RequestBody DictData dictData){
    dictDataService.insertBySelective(dictData);
  }
  
  @RequestMapping(value = "/{cd}/dictDataTypeCd/{dict_data_type_cd}/", method = RequestMethod.DELETE)
  public void delete(@PathVariable("cd") String cd, @PathVariable("dict_data_type_cd") String dictDataTypeCd){
    dictDataService.deleteByPrimaryKey(cd, dictDataTypeCd);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.PUT)
  public void update(@RequestBody DictData dictData){
    dictDataService.updateByPrimaryKey(dictData);
  }
}