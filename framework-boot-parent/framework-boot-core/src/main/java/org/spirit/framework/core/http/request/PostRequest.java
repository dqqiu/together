package org.spirit.framework.core.http.request;

import java.io.IOException;

import org.spirit.framework.core.http.HttpHelper;
import org.spirit.framework.core.http.OkHttpUtils;
import org.spirit.framework.core.utils.StringUtils;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.http.request.PostRequest.java
 * @Description   : qiudequan POST请求
 * @Author        : qiudequan
 * @Creation Date : 2016年11月15日 上午10:18:34 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月15日        create
 */
public class PostRequest extends BaseRequest<PostRequest> {

  protected MediaType mediaType;
  protected String text;
  protected String json;
  public PostRequest(String url) {
    super(url);
  }
  
  public PostRequest sendString(String text){
    this.text = text;
    this.mediaType = OkHttpUtils.MEDIA_TYPE_PLAIN;
    return this;
  }
  
  public PostRequest sendJson(String json){
    this.json = json;
    this.mediaType = OkHttpUtils.MEDIA_TYPE_JSON;
    return this;
  }
  
  public PostRequest setMediaType(MediaType mediaType){
    this.mediaType = mediaType;
    return this;
  }

  @Override
  public Request createRequest(RequestBody requestBody) {
    try {
      headers.put("Content-Length", String.valueOf(requestBody.contentLength()));
    } catch (IOException e) {
      logger.error("create post request error", e);
    }
    Builder requestBuilder = HttpHelper.createRequestFromHeaders(headers);
    return requestBuilder.get().url(url).post(requestBody).build();
  }

  @Override
  public RequestBody createRequestBody() {
    if(this.requestBody != null){
      return requestBody;
    } else if(StringUtils.isNotEmpty(text) && mediaType != null) {
      return RequestBody.create(mediaType, text);
    } else if(StringUtils.isNotEmpty(json) && mediaType != null) {
      return RequestBody.create(mediaType, json);
    }
    return HttpHelper.createRequestBody(params);
  }

}
