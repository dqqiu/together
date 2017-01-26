package org.spirit.together.dictionary.api.external.client;

import java.util.List;

import org.spirit.framework.core.http.OkHttpUtils;
import org.spirit.framework.core.http.callback.support.ComplexCallback;
import org.spirit.together.dictionary.api.external.DictStateHttpApi;
import org.spirit.together.dictionary.api.external.DictionaryHttpPath;
import org.spirit.together.dictionary.api.vo.DictStateVo;

public class DictStateHttpApiClient extends DictExplicitBaseHttpClient<DictStateVo> implements DictStateHttpApi {

  public DictStateHttpApiClient(DictionaryHttpPath getDictByCodePath,
      DictionaryHttpPath getDictByCodesPath) {
    super(DictionaryHttpPath.DICT_STATE_BY_CODE, getDictByCodesPath);
  }

  @Override
  protected ComplexCallback<DictStateVo> getComplexCallback() {
    return new ComplexCallback<DictStateVo>();
  }

  @Override
  protected ComplexCallback<List<DictStateVo>> getComplexListCallback() {
    return new ComplexCallback<List<DictStateVo>>();
  }

  public DictStateVo getStateByCd(String cd) {
    return OkHttpUtils.get(generatePath(getDictByCodePath, cd)).execute(getComplexCallback());
  }

}
