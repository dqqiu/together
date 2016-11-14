package org.spirit.framework.core.utils.http.request;

import org.spirit.framework.core.utils.http.URLHelper;

import okhttp3.Request;
import okhttp3.Request.Builder;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.http.request.GetRequest.java
 * @Description   : qiudequan GET请求
 * @Author        : qiudequan
 * @Creation Date : 2016年11月14日 下午4:25:21 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月14日        create
 */
public class GetRequest extends BaseRequest<GetRequest> {
  
  public GetRequest(String url) {
    super(url);
  }

  @Override
  public Request createRequest() {
    Builder requestBuilder = URLHelper.createRequestFromHeaders(headers);
    String urls = URLHelper.createUrlParams(url, params);
    return requestBuilder.get().url(urls).build();
  }

}
