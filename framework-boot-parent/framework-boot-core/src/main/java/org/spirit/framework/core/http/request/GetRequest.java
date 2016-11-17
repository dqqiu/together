package org.spirit.framework.core.http.request;


import org.spirit.framework.core.http.HttpHelper;

import okhttp3.Request;
import okhttp3.RequestBody;
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
  public Request createRequest(RequestBody requestBody) {
    Builder requestBuilder = HttpHelper.createRequestFromHeaders(headers);
    String urls = HttpHelper.createUrlParams(url, params);
    return requestBuilder.get().url(urls).build();
  }

  @Override
  public RequestBody createRequestBody() {
    return null;
  }


}
