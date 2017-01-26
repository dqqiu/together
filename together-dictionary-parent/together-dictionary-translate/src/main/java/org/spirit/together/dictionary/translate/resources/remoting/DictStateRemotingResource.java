package org.spirit.together.dictionary.translate.resources.remoting;

import org.spirit.together.dictionary.api.external.client.DictExplicitBaseHttpClient;
import org.spirit.together.dictionary.api.vo.DictStateVo;
import org.spirit.together.dictionary.translate.resources.AbstractExplicitRemotingResourceWrapper;

public class DictStateRemotingResource extends AbstractExplicitRemotingResourceWrapper<DictStateVo> {

  @Override
  protected DictExplicitBaseHttpClient<DictStateVo> getDictExplicitBaseHttpClient() {
    return null;
  }

}
