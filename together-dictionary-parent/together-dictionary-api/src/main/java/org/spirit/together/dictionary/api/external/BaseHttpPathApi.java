package org.spirit.together.dictionary.api.external;

import java.util.List;

public interface BaseHttpPathApi {
  /**
   *  @Description	: qiudequan 获取http路径
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 下午1:23:29 
   *  @Author         : qiudequan
   */
  String getPath();

  /**
   *  @Description	: qiudequan http路径中的参数
   *  @param          : @return
   *  @return         : List<String>
   *  @Creation Date  : 2016年12月11日 下午1:23:40 
   *  @Author         : qiudequan
   */
  List<String> getParams();

  /**
   *  @Description	: qiudequan 获取API描述
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 下午1:23:50 
   *  @Author         : qiudequan
   */
  String getDesc();
}
