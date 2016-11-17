package org.spirit.framework.core.http.request;

import java.io.IOException;

import org.spirit.framework.core.http.HttpHelper;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Request.Builder;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.http.request.DeleteRequest.java
 * @Description   : qiudequan 删除请求，由于是用于调用restful接口，传入参数无效，建议要删除的唯一标识在URL中传入
 * @Author        : qiudequan
 * @Creation Date : 2016年11月16日 上午11:12:42 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月16日        create
 */
public class DeleteRequest extends BaseRequest<DeleteRequest> {

  public DeleteRequest(String url) {
    super(url);
  }

  @Override
  public Request createRequest(RequestBody requestBody) {
    try {
      headers.put("Content-Length", String.valueOf(requestBody.contentLength()));
    } catch (IOException e) {
      logger.error("create delete request error", e);
    }
    Builder requestBuilder = HttpHelper.createRequestFromHeaders(headers);
    return requestBuilder.get().url(url).delete(requestBody).build();
  }

  @Override
  public RequestBody createRequestBody() {
    if(requestBody != null){
      return requestBody;
    }
    return HttpHelper.createRequestBody(params);
  }

}
