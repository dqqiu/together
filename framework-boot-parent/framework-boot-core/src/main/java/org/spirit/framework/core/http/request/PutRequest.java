package org.spirit.framework.core.http.request;

import java.io.IOException;

import org.spirit.framework.core.http.HttpHelper;
import org.spirit.framework.core.http.OkHttpUtils;
import org.spirit.framework.core.utils.StringUtils;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Request.Builder;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.http.request.PutRequest.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月16日 上午11:11:31 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月16日        create
 */
public class PutRequest extends BaseRequest<PutRequest> {

  protected MediaType mediaType;
  protected String json;

  public PutRequest(String url) {
    super(url);
  }

  public PutRequest sendJson(String json){
    this.json = json;
    this.mediaType = OkHttpUtils.MEDIA_TYPE_JSON;
    return this;
  }

  public PutRequest setMediaType(MediaType mediaType){
    this.mediaType = mediaType;
    return this;
  }

  @Override
  public Request createRequest(RequestBody requestBody) {
    try {
      headers.put("Content-Length", String.valueOf(requestBody.contentLength()));
    } catch (IOException e) {
      logger.error("create put request error", e);
    }
    Builder requestBuilder = HttpHelper.createRequestFromHeaders(headers);
    return requestBuilder.get().url(url).put(requestBody).build();
  }

  @Override
  public RequestBody createRequestBody() {
    if(this.requestBody != null){
      return requestBody;
    } else if(StringUtils.isNotEmpty(json) && mediaType != null) {
      return RequestBody.create(mediaType, json);
    }
    return HttpHelper.createRequestBody(params);
  }

}
